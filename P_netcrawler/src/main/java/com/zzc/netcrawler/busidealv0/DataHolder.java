package com.zzc.netcrawler.busidealv0;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.zzc.netcrawler.beanset.NetAddr;
import com.zzc.netcrawler.beanset.NetAddrCompare;
import com.zzc.netcrawler.beanset.NetAddrCompareExample;
import com.zzc.netcrawler.beanset.NetAddrExample;
import com.zzc.netcrawler.beanset.NetAddrExt;
import com.zzc.netcrawler.beanset.NetAddrExtExample;
import com.zzc.netcrawler.beanset.NetLogOld;
import com.zzc.netcrawler.common.DateUtil;
import com.zzc.netcrawler.dao.MyBatisUtil;
import com.zzc.netcrawler.dao.NetAddrCompareMapper;
import com.zzc.netcrawler.dao.NetAddrExtMapper;
import com.zzc.netcrawler.dao.NetAddrMapper;
import com.zzc.netcrawler.dao.NetLogMapper;
import com.zzc.netcrawler.service.PageHolder;
import com.zzc.netcrawler.service.PageHolderUrl;

public class DataHolder {
	private static Logger log = Logger.getLogger(DataHolder.class);
	// 数据库连接
	private SqlSessionFactory sqlSessionFactory;
	// 根据线程个数，产生对应长度的队列数组
	private LinkedList<NetAddr>[] taskReadQueue;
	// 待保存数据队列
	private LinkedBlockingQueue<PageHolderUrl> taskWriteQueue;
	
	// 初始化数据保存
	private boolean wqEmptyFlag = true;
	private final Map<String, Integer> dataCntHolder = new HashMap<String, Integer>();
	
	public boolean initQueue(){
		log.info(ConstHolder.StrTool.initPrefix("data-dao object"));
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		log.info(ConstHolder.StrTool.initSuffix("data-dao object"));
		
		log.info(ConstHolder.StrTool.initPrefix("read-task-queue array"));
		taskWriteQueue = new LinkedBlockingQueue<PageHolderUrl>();
		log.info(ConstHolder.StrTool.initSuffix("read-task-queue array"));
		
		log.info(ConstHolder.StrTool.initPrefix("write-task-queue"));
		initReadQueue();
		log.info(ConstHolder.StrTool.initSuffix("write-task-queue"));
		
		log.info(ConstHolder.StrTool.dealPrefix("reset net-addr status"));
		reSetDataSts();
		log.info(ConstHolder.StrTool.dealSuffix("reset net-addr status"));
		//initLogData();
		
		return true;
	}
	/**
	 * DEAL -> ADD
	 */
	private void reSetDataSts(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
        	NetAddrMapper netAddrMapper = sqlSession.getMapper(NetAddrMapper.class);
            NetAddrExample netAddrExample = new NetAddrExample();
            netAddrExample.createCriteria().andStsIdEqualTo(ConstHolder.NetAddrSts.DEAL.getKeyCode());

            NetAddr netAddr = new NetAddr();
            netAddr.setStsId(ConstHolder.NetAddrSts.ADD.getKeyCode());
            netAddrMapper.updateByExampleSelective(netAddr, netAddrExample);
            
//            netAddrExample.createCriteria().andStsIdEqualTo(ConstHolder.NetAddrSts.DEAL.getKeyCode());
//            List<NetAddr> dealStsData = netAddrMapper.selectByExample(netAddrExample);
//            for(NetAddr netAddr : dealStsData){
//            	netAddr.setStsId(ConstHolder.NetAddrSts.ADD.getKeyCode());
//            	netAddr.setUpdateTime(DateUtil.getTimestamp(new Date()));
//            	netAddrMapper.updateByPrimaryKey(netAddr);
//            }
            sqlSession.commit();
            log.info(ConstHolder.StrTool.dealSuffix("reset data status"));
        } catch(Exception e){
        	log.info(ConstHolder.StrTool.dealException("reset data status"));
        	log.debug(e);
        	log.error(e.getMessage());
        } finally {
            sqlSession.close();
        }
	}
	@SuppressWarnings("unchecked")
	private void initReadQueue(){
		taskReadQueue = new LinkedList[ConstHolder.TNumber.T_LIMIT_NBR];
		for(int i=0; i<taskReadQueue.length; i++){
			taskReadQueue[i] = new LinkedList<NetAddr>();
		}
	}
	
	// 向线程归属的任务队列中增加任务数据
	private boolean addTaskToQueue(final int tId){
		// 不存在与线程号对应的任务队列
		if(taskReadQueue.length <= tId){
			log.error("thread id is out of read-task-queue array length");
			return false;
		}
		
		boolean returnFlag = true;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
        	NetAddrMapper netAddrMapper = sqlSession.getMapper(NetAddrMapper.class);
            NetAddrExample netAddrExample = new NetAddrExample();
            netAddrExample.setLimitClause(ConstHolder.DNumber.D_LIMIT_NBR);
            netAddrExample.setOrderByClause("net_id");
            NetAddrExample.Criteria criteria = netAddrExample.createCriteria();
            if(ConstHolder.TNumber.T_LIMIT_NBR > 1){
            	criteria.andNetIdModEquals(ConstHolder.TNumber.T_LIMIT_NBR, tId);
            }
            criteria.andStsIdEqualTo(ConstHolder.NetAddrSts.ADD.getKeyCode());
            List<NetAddr> taskList= netAddrMapper.selectByExample(netAddrExample);
            
            if(null != taskList && taskList.size() > 0){
            	log.info("get data from database for thread-" + tId + " successful!");
            	
            	// 数据状态回写  ADD -> DEAL
            	for(NetAddr netAddrMod : taskList){
            		netAddrMod.setStsId(ConstHolder.NetAddrSts.DEAL.getKeyCode());
            		netAddrMod.setUpdateTime(DateUtil.getTimestamp(new Date()));
            		netAddrMapper.updateByPrimaryKey(netAddrMod);
            	}
//            	NetAddr netAddrChgSts = new NetAddr();
//            	netAddrChgSts.setStsId(ConstHolder.NetAddrSts.DEAL.getKeyCode());
//            	netAddrMapper.updateByExampleSelective(netAddrChgSts, netAddrExample);
            	log.info("update data-status to database for thread-" + tId + " successful!");
            	
            	// 统计数据
            	rqAppdAmt += taskList.size();
            	taskReadQueue[tId].addAll(taskList);
            	
            	returnFlag = true;
            } else {
            	log.error("didn't found data from database for thread-" + tId + "!");
            	returnFlag = false;
            }
            
            sqlSession.commit();
            return returnFlag;
        } catch(Exception e){
        	log.info("get data from database for thread-" + tId + " exception!");
        	log.error(e);
        	return false;
        } finally {
            sqlSession.close();
        }
	}
	
	public NetAddr getOneTask(final int threadId){
		// 任务队列未初始化，直接返回空
		if(taskReadQueue.length <= threadId || null == taskReadQueue[threadId]){
			return null;
		}
		// 任务队列为空，进行首次初始化
		if(taskReadQueue[threadId].size() == 0 && !addTaskToQueue(threadId)){
			return null;
		}
		// 任务数量低于阀值，启动后台线程增量更新
		if(taskReadQueue[threadId].size() <= ConstHolder.DNumber.D_MIN_NBR){
			Thread appendTask=new Thread(new Runnable(){
					@Override
					public void run() {
						addTaskToQueue(threadId);
					}
				});
			appendTask.start();
		}
		if(taskReadQueue[threadId].size() > 0){
			return taskReadQueue[threadId].pop();
		} else {
			return null;
		}
	}
	
	public void addOneTask(PageHolderUrl writeData){
		wqParsAmt ++;
		try {
			taskWriteQueue.put(writeData);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 数据写线程未启动，且任务队列存在数据，就启动线程
		if(wqEmptyFlag && taskWriteQueue.size() > 0){
			wqEmptyFlag = false;
			readTaskFromQueus();
		}
	}
	
	/**
	 * 数据入库线程，目前是针对一条数据，执行一次提交;
	 * 后续可以修改为一批数据提交一次。
	 */
	private void readTaskFromQueus(){
		Thread appendTask=new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					if(taskWriteQueue.size() > 0){
						try {
							PageHolderUrl wData = taskWriteQueue.take();
							parsAmt ++;
							if(null != wData){
								SqlSession sqlSession = sqlSessionFactory.openSession();
								
								Timestamp currTime = DateUtil.getTimestamp(new Date());
								NetAddr netAddr = null ;//wData.getNetAddr();
								String errorMsg = wData.getPageErrorMsg();
								boolean errorMsgEmpty = StringUtils.isEmpty(errorMsg);
								try {
									updateBase(netAddr, sqlSession, currTime, errorMsg, errorMsgEmpty);
									
									if(errorMsgEmpty){
										if(wData.getPageRespCode().equals("200")){
											saveOrUpdateExt(wData, netAddr.getNetId(), sqlSession, currTime);
										}
										
										saveAppendData(wData.getPageUrlSet(), sqlSession);
									}
									
									sqlSession.commit();
								} catch (Exception e) {
									e.printStackTrace();
								} finally {
									sqlSession.close();
								}
							}
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					} else {
						try {
							Thread.sleep(5 * 60 * 1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				// 数据写完，结束线程
				//wqEmptyFlag = true;
			}
			private NetAddr buildNetAddr(String netUrl){
				Timestamp currTime = DateUtil.getTimestamp(new Date());
				NetAddr netAddr = new NetAddr();
				netAddr.setNetUrl(netUrl);
				netAddr.setStsId(ConstHolder.NetAddrSts.ADD.getKeyCode());
				netAddr.setCreateTime(currTime);
				netAddr.setUpdateTime(currTime);
				return netAddr;
			}
			private NetAddrExt buildNetAddrExt(PageHolder wData, Timestamp currTime){
				NetAddrExt netAddrExt = new NetAddrExt();
				netAddrExt.setCreateTime(currTime);
				netAddrExt.setResCode(wData.getPageRespCode());
				netAddrExt.setEncode(wData.getPageEncoding());
				netAddrExt.setNetDesc(wData.getPageDescription());
				netAddrExt.setNetKey(wData.getPageLabel());
				netAddrExt.setNetTitle(wData.getPageTitle());
				netAddrExt.setParseTime((int)wData.getTotTime());
				return netAddrExt;
			}
			private void updateBase(NetAddr netAddr, SqlSession sqlSession, Timestamp currTime, String errorMsg, boolean errorMsgEmpty){
				// 状态变更，[DEAL -> DONE || DEAL -> EXEC]
				if (errorMsgEmpty) {
					netAddr.setStsId(ConstHolder.NetAddrSts.DONE.getKeyCode());
				} else {
					netAddr.setStsId(ConstHolder.NetAddrSts.EXEC.getKeyCode());
					netAddr.setExecMsg(errorMsg.length() > 100 ? errorMsg.substring(0, 100) : errorMsg);
				}
				netAddr.setUpdateTime(currTime);
				NetAddrMapper netAddrMapper = sqlSession.getMapper(NetAddrMapper.class);
				netAddrMapper.updateByPrimaryKey(netAddr);
				
//				NetAddrExample netAddrExample = new NetAddrExample();
//				NetAddrExample.Criteria netAddrCriteria = netAddrExample.createCriteria();
//				netAddrCriteria.andNetIdEqualTo(netAddr.getNetId());
//				netAddrCriteria.andStsIdEqualTo(ConstHolder.NetAddrSts.DEAL.getKeyCode());
//				int ifExist = netAddrMapper.countByExample(netAddrExample);
//				
//				if(ifExist == 0){
//				}
			}
			/**
			 * 检查EXT表是否存在数据，不存在就插入
			 * @param wData
			 * @param netId
			 * @param sqlSession
			 * @param currTime
			 */
			private void saveOrUpdateExt(PageHolderUrl wData, Integer netId, SqlSession sqlSession, Timestamp currTime){
				NetAddrExtMapper netAddrExtMapper = sqlSession.getMapper(NetAddrExtMapper.class);
				
				NetAddrExtExample naeExample = new NetAddrExtExample();
				naeExample.createCriteria().andNetIdEqualTo(netId);
				
				int naeCnt = netAddrExtMapper.countByExample(naeExample);
				// 暂时只做插入，不进行二次更新
				if(naeCnt == 0){
					NetAddrExt netAddrExt = buildNetAddrExt(wData, currTime);
					netAddrExt.setNetId(netId);
					netAddrExtMapper.insert(netAddrExt);
				}
			}
			/**
			 * 检查并插入增量数据
			 * @param netUrls
			 * @param sqlSession
			 * @param currTime
			 */
			private void saveAppendData(Set<String> netUrls, SqlSession sqlSession){
				NetAddrCompareMapper netAddrCompareMapper = sqlSession.getMapper(NetAddrCompareMapper.class);
				// 清空临时表
				NetAddrCompareExample nacExampleDel = new NetAddrCompareExample();
				netAddrCompareMapper.deleteByExample(nacExampleDel);
				
				// 数据入临时表
				for(String netUrl : netUrls){
					NetAddrCompare netAddrCompare = new NetAddrCompare(netUrl);
					netAddrCompareMapper.insert(netAddrCompare);
				}
				
				// 查询增量数据
				NetAddrCompareExample nacExample = new NetAddrCompareExample();
	        	nacExample.setLeftJoinClause("");
	        	List<NetAddrCompare> netUrlFinal = netAddrCompareMapper.selectByExample(nacExample);
				
				// 保存增量数据
				NetAddrMapper netAddrMapper = sqlSession.getMapper(NetAddrMapper.class);
				for(NetAddrCompare nac : netUrlFinal){
					NetAddr netAddr = buildNetAddr(nac.getNetUrlCmp());
					netAddrMapper.insert(netAddr);
				}
				appdAmt += netUrlFinal.size();
			}
		});
		appendTask.start();
	}
	
	// 附加统计操作,为日志记录准备数据
	private static int rqAppdAmt = 0; // 数据读取队列中增量数据
	private static int wqParsAmt = 0; // 数据写入队列中增量数据
	private static int appdAmt = 0;   // 新增11数据
	private static int parsAmt = 0;   // 新增13数据
	
//	private void initLogData(){
//		log.info(ConstHolder.StrTool.initPrefix("log-record"));
//		
//		reCollectData();
//		
//		saveNetLog();
//	}
	public void netLogController(){
		final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		final int fixMin = 5;
		Calendar cTime = buildSchedul(fixMin);
        
        log.info("log-record timer will be run on :" + sdf1.format(cTime.getTime()) );
        
        // 启动定时器  
        Timer logTimer = new Timer();  
        TimerTask logTask = new TimerTask() {  
            @Override
			public void run() { 
            	reCollectData();
            	
            	saveNetLog();
            	
            	// 初始化数据
            	rqAppdAmt = 0;
            	wqParsAmt = 0;
            	appdAmt = 0;
            	parsAmt = 0;
            }  
        }; 
        // 指定任务在整点、半点执行,且在当前时间后的第一个整点或者半点执行。
        logTimer.schedule(logTask, cTime.getTime(), fixMin * 60 * 1000);  
	}
	private Calendar buildSchedul(int fixMin){
        Calendar c = Calendar.getInstance();  
        // 整分钟已过秒  
        int tmp1 = c.get(Calendar.SECOND);  
        // 过5分钟的分钟  
        int tmp2 = c.get(Calendar.MINUTE) % fixMin;  
        // 存放到达5分钟整点秒  
        int seconds = (fixMin - tmp2) * 60 - tmp1;  
        // 调整启动时间  
        c.add(Calendar.SECOND, seconds);  
        return c;
	}
	private void reCollectData(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
        	NetAddrMapper netAddrMapper = sqlSession.getMapper(NetAddrMapper.class);
        	
        	NetAddrExample naStsCnt = new NetAddrExample();
        	int allStsCnt = netAddrMapper.countByExample(naStsCnt);
        	
        	NetAddrExample naSts10 = new NetAddrExample();
        	naSts10.createCriteria().andStsIdEqualTo(ConstHolder.NetAddrSts.INIT.getKeyCode());
        	int allSts10Cnt = netAddrMapper.countByExample(naSts10);
        	
        	NetAddrExample naSts11 = new NetAddrExample();
        	naSts11.createCriteria().andStsIdEqualTo(ConstHolder.NetAddrSts.ADD.getKeyCode());
        	int allSts11Cnt = netAddrMapper.countByExample(naSts11);
        	
        	NetAddrExample naSts12 = new NetAddrExample();
        	naSts12.createCriteria().andStsIdEqualTo(ConstHolder.NetAddrSts.DEAL.getKeyCode());
        	int allSts12Cnt = netAddrMapper.countByExample(naSts12);
        	
        	NetAddrExample naSts13 = new NetAddrExample();
        	naSts13.createCriteria().andStsIdEqualTo(ConstHolder.NetAddrSts.DONE.getKeyCode());
        	int allSts13Cnt = netAddrMapper.countByExample(naSts13);
        	
        	NetAddrExample naSts21 = new NetAddrExample();
        	naSts21.createCriteria().andStsIdEqualTo(ConstHolder.NetAddrSts.EXEC.getKeyCode());
        	int allSts21Cnt = netAddrMapper.countByExample(naSts21);
        	
        	NetAddrExtMapper netAddrExtMapper = sqlSession.getMapper(NetAddrExtMapper.class);
        	NetAddrExtExample naExtStsCnt = new NetAddrExtExample();
        	int allExtCnt = netAddrExtMapper.countByExample(naExtStsCnt);
            
            sqlSession.commit();
            
            dataCntHolder.clear();
            dataCntHolder.put("allStsCnt", allStsCnt);
            dataCntHolder.put("allSts10Cnt", allSts10Cnt);
            dataCntHolder.put("allSts11Cnt", allSts11Cnt);
            dataCntHolder.put("allSts12Cnt", allSts12Cnt);
            dataCntHolder.put("allSts13Cnt", allSts13Cnt);
            dataCntHolder.put("allSts21Cnt", allSts21Cnt);
            dataCntHolder.put("allExtCnt", allExtCnt);
        } catch(Exception e){
        	log.info("collect data-cnt failed!");
        	log.error(e);
        } finally {
            sqlSession.close();
        }
	}
	private void saveNetLog(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
        	NetLogMapper netLogMapper = sqlSession.getMapper(NetLogMapper.class);
        	NetLogOld netLog = new NetLogOld();
        	netLog.setCreateTime(DateUtil.getTimestamp(new Date()));
        	netLog.setAllAmt(dataCntHolder.get("allStsCnt"));
        	netLog.setAllExtAmt(dataCntHolder.get("allExtCnt"));
        	netLog.setSts10Amt(dataCntHolder.get("allSts10Cnt"));
        	netLog.setSts11Amt(dataCntHolder.get("allSts11Cnt"));
        	netLog.setSts12Amt(dataCntHolder.get("allSts12Cnt"));
        	netLog.setSts13Amt(dataCntHolder.get("allSts13Cnt"));
        	netLog.setSts21Amt(dataCntHolder.get("allSts21Cnt"));
        	netLog.setTimeSegm(5 * 60);
        	netLog.setTimeUnit(2);
        	netLog.setAppdAmt(appdAmt);
        	netLog.setParsAmt(parsAmt);
        	netLog.setRqAppdAmt(rqAppdAmt);
        	netLog.setWqParsAmt(wqParsAmt);
//        	netLogMapper.insert(netLog);
        	sqlSession.commit();
        } catch(Exception e){
        	log.info("log-record failed!");
        	log.error(e);
        } finally {
            sqlSession.close();
        }
	}
}
