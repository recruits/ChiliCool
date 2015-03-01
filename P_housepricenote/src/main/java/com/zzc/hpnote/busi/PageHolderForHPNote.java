package com.zzc.hpnote.busi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.zzc.hpnote.domain.BaseInfo;
import com.zzc.hpnote.domain.PriceInfo;

/**
 * 房源信息解析类. <br>
 *  解析关注的内容信息，并且封装到两个类中.
 * @author zhangzechen@cttic.cn
 * @date 2014-5-15 下午7:25:27 <br>
 * Copyright: Copyright (c) 2014 CTTIC
 */
public class PageHolderForHPNote extends PageHolder{
	private String hpId;
	private BaseInfo baseInfo;
	private PriceInfo priceInfo;
	/**
	 * @param pageUrl
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public PageHolderForHPNote(String pageUrl) throws MalformedURLException,
			IOException {
		super(pageUrl);
	}
	public String getHpId() {
		hpId = PageParserForHPNote.buildHPNoteId(super.getPageContent());
		return hpId;
	}
	public BaseInfo getBaseInfo() {
		try {
			baseInfo = PageParserForHPNote.buildHPNoteBaseInfo(super.getPageContent());
			baseInfo.sethId(hpId);
		} catch (Exception e) {
			e.printStackTrace();
			baseInfo = null;
		}
		return baseInfo;
	}
	public PriceInfo getPriceInfo() {
		try {
			priceInfo = PageParserForHPNote.buildHPNotePriceInfo(super.getPageContent());
			priceInfo.sethId(hpId);
		} catch (Exception e) {
			e.printStackTrace();
			priceInfo = null;
		}
		return priceInfo;
	}
	
	static class PageParserForHPNote{
		public static String buildHPNoteId(String pageContent){
			// 房源号 -- <span class="mr10">房源编号：178615808</span>
			String hpId = null;
			Pattern hpIdReg = Pattern.compile("<span class=\"mr10\">房源编号：(\\d+?)</span>");
			Matcher matcher = hpIdReg.matcher(pageContent);
			while (matcher.find()) {
				hpId = matcher.group(1);
			}
			return hpId;
		}
		
		public static BaseInfo buildHPNoteBaseInfo(String pageContent) throws Exception{
			BaseInfo baseInfo = new BaseInfo();
			// 房源标题 -- <h1 class="icon_tag20120517 mt8">【我爱我家 全优房源】 朝阳重点学区 南北通透大二居 豪华装修<img
			String roomTitle = null;
			Pattern roomTitleReg = Pattern.compile("<h1 class=\"icon_tag20120517 mt8\">([^<]+?)<");
			Matcher roomTitleMatcher = roomTitleReg.matcher(pageContent);
			while (roomTitleMatcher.find()) {
				roomTitle = roomTitleMatcher.group(1);
			}
			if(StringUtils.isEmpty(roomTitle)){
				return null;
			}
			baseInfo.setRoomTitle(roomTitle.trim());
			
			// 发布时间 -- 发布时间：2014/5/15 14:12:29(<span id="Time">25秒前更新</span>)
			String releaseTime = null;
			Pattern releaseTimeReg = Pattern.compile("发布时间：(\\d{4}[-/]\\d{1,2}[-/]\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2})");
			Matcher releaseTimeMatcher = releaseTimeReg.matcher(pageContent);
			while (releaseTimeMatcher.find()) {
				releaseTime = releaseTimeMatcher.group(1);
			}
			try {
				if(StringUtils.isNotEmpty(releaseTime)){
					baseInfo.setReleaseTime(DateUtils.parseDate(releaseTime, new String[]{"yyyy-MM-dd HH:mm:ss","yyyy/MM/dd HH:mm:ss"}));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			// 房源特点 -- <span class='colorGreen'>房产证满五年</span><span class='colorRed'>满五唯一</span><span class='colorBlue'>学区房</span>
			String roomFeature = null;
			Pattern roomFeatureReg = Pattern.compile("<span class=\'colorgreen\'>([\u4E00-\u9FA5]+?)</span>(<span class=\'colorred\'>([\u4E00-\u9FA5]+?)</span>)?(<span class=\'colorblue\'>([\u4E00-\u9FA5]+?)</span>)?");
			Matcher roomFeatureMatcher = roomFeatureReg.matcher(pageContent);
			while (roomFeatureMatcher.find()) {
				roomFeature = roomFeatureMatcher.group(1) + ',' + roomFeatureMatcher.group(3) + ',' + roomFeatureMatcher.group(5) ;
			}
			if(StringUtils.isNotEmpty(roomFeature)){
				roomFeature = roomFeature.replaceAll("null", "");
				while (roomFeature.substring(roomFeature.length()-1).equals(",")) {
					roomFeature = StringUtils.removeEnd(roomFeature, ",");
				}
			}
			baseInfo.setRoomFeature(roomFeature);
			
			// 户型 -- <dd class="gray6"><span class="gray6">户<span class="padl27"></span>型：</span>2室1厅1厨1卫</dd>
			String htRoom = null;
			String htHall = null;
			String htKitchen = null;
			String htBathroom = null;
			Pattern roomReg = Pattern.compile("<dd class=\"gray6\"><span class=\"gray6\">户<span class=\"padl27\"></span>型：</span>(\\d{1,2})室(\\d{1,2})厅(\\d{1,2})厨(\\d{1,2})卫</dd>");
			Matcher roomMatcher = roomReg.matcher(pageContent);
			while (roomMatcher.find()) {
				htRoom = roomMatcher.group(1);
				htHall = roomMatcher.group(2);
				htKitchen = roomMatcher.group(3);
				htBathroom = roomMatcher.group(4);
			}
			baseInfo.sethTRoom(Integer.valueOf(htRoom));
			baseInfo.sethTHall(Integer.valueOf(htHall));
			baseInfo.sethTKitchen(Integer.valueOf(htKitchen));
			baseInfo.sethTBathroom(Integer.valueOf(htBathroom));
			
			// 建筑面积 -- <dd class="gray6">            建筑面积：<span class="black ">101㎡</span></dd>
			String roomSize = null;
			Pattern roomSizeReg = Pattern.compile("建筑面积：<span class=\"black\\s?\">([0-9\\.]{1,8})�</span>");
			Matcher roomSizeMatcher = roomSizeReg.matcher(pageContent);
			while (roomSizeMatcher.find()) {
				roomSize = roomSizeMatcher.group(1);
			}
			baseInfo.setRoomSize(Float.parseFloat(roomSize));

			// 年代 -- <dd>            <span class="gray6">年<span class="padl27"></span>代：</span>2004年</dd>
			String roomAge = null;
			Pattern roomAgeReg = Pattern.compile("<span class=\"gray6\">年<span class=\"padl27\"></span>代：</span>(\\d{2,4})年</dd>");
			Matcher roomAgeMatcher = roomAgeReg.matcher(pageContent);
			while (roomAgeMatcher.find()) {
				roomAge = roomAgeMatcher.group(1);
			}
			baseInfo.setRoomAge(Integer.parseInt(roomAge));
			
			// 朝向 -- <dd>            <span class="gray6">朝<span class="padl27"></span>向：</span>南北</dd>
			String roomTowards = null;
			Pattern roomTowardsReg = Pattern.compile("<span class=\"gray6\">朝<span class=\"padl27\"></span>向：</span>([\u4E00-\u9FA5]+?)</dd>" );
			Matcher roomTowardsMatcher = roomTowardsReg.matcher(pageContent);
			while (roomTowardsMatcher.find()) {
				roomTowards = roomTowardsMatcher.group(1);
			}
			baseInfo.setRoomTowards(roomTowards);
			
			// 楼层、楼层总数 --         <dd>            <span class="gray6">楼<span class="padl27"></span>层：</span>第12层(共24层)</dd>
			String roomFloor = null;
			String roomFloorTotal = null;
			Pattern roomFloorReg = Pattern.compile("<span class=\"gray6\">楼<span class=\"padl27\"></span>层：</span>第(\\d{1,4})层\\(共(\\d{1,4})层\\)</dd>");
			Matcher roomFloorMatcher = roomFloorReg.matcher(pageContent);
			while (roomFloorMatcher.find()) {
				roomFloor = roomFloorMatcher.group(1);
				roomFloorTotal = roomFloorMatcher.group(2);
			}
			baseInfo.setRoomFloor(Integer.parseInt(roomFloor));
			baseInfo.setRoomFloorTotal(Integer.parseInt(roomFloorTotal));
			
			// 楼层结构 --         <dd>            <span class="gray6 ">结<span class="padl27"></span>构：</span>平层</dd>
			String roomStructure = null;
			Pattern roomStructureReg = Pattern.compile("<span class=\"gray6 \">结<span class=\"padl27\"></span>构：</span>([\u4E00-\u9FA5]+?)</dd>");
			Matcher roomStructureMatcher = roomStructureReg.matcher(pageContent);
			while (roomStructureMatcher.find()) {
				roomStructure = roomStructureMatcher.group(1);
			}
			baseInfo.setRoomStructure(roomStructure);
			
			// 楼层装修 --         <dd>            <span class="gray6">装<span class="padl27"></span>修：</span>豪华装修</dd>
			String roomDecorate = null;
			Pattern roomDecorateReg = Pattern.compile("<span class=\"gray6\">装<span class=\"padl27\"></span>修：</span>([\u4E00-\u9FA5]+?)</dd>");
			Matcher roomDecorateMatcher = roomDecorateReg.matcher(pageContent);
			while (roomDecorateMatcher.find()) {
				roomDecorate = roomDecorateMatcher.group(1);
			}
			baseInfo.setRoomDecorate(roomDecorate);
			
			// 住宅类型 --         <dd>            <span class="gray6">住宅类别：</span>普通住宅</dd>
			String roomType = null;
			Pattern roomTypeReg = Pattern.compile("<span class=\"gray6\">住宅类别：</span>([\u4E00-\u9FA5]+?)</dd>");
			Matcher roomTypeMatcher = roomTypeReg.matcher(pageContent);
			while (roomTypeMatcher.find()) {
				roomType = roomTypeMatcher.group(1);
			}
			baseInfo.setRoomType(roomType);
			
			// 产权性质 --         <dd>            <span class="gray6 ">产权性质：</span>个人产权</dd>
			String roomProperty = null;
			Pattern roomPropertyReg = Pattern.compile("<span class=\"gray6\\s?\">产权性质：</span>([\u4E00-\u9FA5]+?)</dd>");
			Matcher roomPropertyMatcher = roomPropertyReg.matcher(pageContent);
			while (roomPropertyMatcher.find()) {
				roomProperty = roomPropertyMatcher.group(1);
			}
			baseInfo.setRoomProperty(roomProperty);
			
			// 看房时间 --         <dd>            <span class="gray6 ">看房时间：</span>随时看房</dd>
			String viewTime = null;
			Pattern viewTimeReg = Pattern.compile("<span class=\"gray6\\s?\">看房时间：</span>([\u4E00-\u9FA5]+?)</dd>");
			Matcher viewTimeMatcher = viewTimeReg.matcher(pageContent);
			while (viewTimeMatcher.find()) {
				viewTime = viewTimeMatcher.group(1);
			}
			baseInfo.setViewTime(viewTime);
			
			// 建筑类别 --         <dd>            <span class="gray6">建筑类别：</span>板楼</dd>
			String projectType = null;
			Pattern projectTypeReg = Pattern.compile("<span class=\"gray6\">建筑类别：</span>([\u4E00-\u9FA5]+?)</dd>");
			Matcher projectTypeMatcher = projectTypeReg.matcher(pageContent);
			while (projectTypeMatcher.find()) {
				projectType = projectTypeMatcher.group(1);
			}
			baseInfo.setProjectType(projectType);
			
			// 楼盘名称、区域、子区域 -- <span class="gray6 ">楼盘名称：</span><a href="http://shaoyaojubeili.soufun.com/" target="_blank" title="查看此楼盘的更多二手房房源" id="esfbjxq_11">芍药居北里</a>( <a href="/house-a01/" target="_blank" id="esfbjxq_12">
	        //朝阳
			//</a><a href="/house-a01-b01125/" target="_blank" id="esfbjxq_13">
	        //芍药居</a>)
			String projectName = null;
			String projectRegionCode = null;
			Pattern projectNameReg = Pattern.compile("<span class=\"gray6\\s?\">楼盘名称：</span><a href=\"http://[a-z0-9]+?\\.soufun\\.com/\" target=\"_blank\" title=\"查看此楼盘的更多二手房房源\" id=\"[a-z]+?_[0-9]+?\">(.+?)</a>\\(\\s?<a href=\"/house-[a-z0-9]+?/\" target=\"_blank\" id=\"[a-z]+?_([0-9]+?)\">\\s+?([\u4E00-\u9FA5]+?)\\s+?</a><a href=\"/house-[a-z0-9]+?-([a-z0-9]+?)/\" target=\"_blank\" id=\"[a-z]+?_[0-9]+?\">\\s+?([\u4E00-\u9FA5]+?)\\s+?</a>\\)");
			Matcher projectNameMatcher = projectNameReg.matcher(pageContent);
			while (projectNameMatcher.find()) {
				projectName = projectNameMatcher.group(1);
				projectRegionCode = projectNameMatcher.group(5);
			}
			baseInfo.setProjectName(projectName);
			baseInfo.setProjectRegionCode(projectRegionCode);
			
			// 房源中介 -- <input name="agentcompanyname" type="hidden" id="agentcompanyname"  value="我爱我家" />
			String roomAgent = null;
			Pattern roomAgentReg = Pattern.compile("<input name=\"agentcompanyname\" type=\"hidden\" id=\"agentcompanyname\"  value=\"([\u4E00-\u9FA5]+?)\" />");
			Matcher roomAgentMatcher = roomAgentReg.matcher(pageContent);
			while (roomAgentMatcher.find()) {
				roomAgent = roomAgentMatcher.group(1);
			}
			baseInfo.setRoomAgent(roomAgent);
			
			// 配套设施 -- <span class="gray6 floatl">配套设施：</span><span class="sheshi">煤气/天然气,暖气,电梯,车位/车库</span>
			String projectEquipment = null;
			Pattern projectEquipmentReg = Pattern.compile("<span class=\"gray6 floatl\">配套设施：</span><span class=\"sheshi\">([\u4E00-\u9FA5,/]+?)</span>");
			Matcher projectEquipmentMatcher = projectEquipmentReg.matcher(pageContent);
			while (projectEquipmentMatcher.find()) {
				projectEquipment = projectEquipmentMatcher.group(1);
			}
			baseInfo.setProjectEquipment(projectEquipment);
			
			return baseInfo;
		}
		
		public static PriceInfo buildHPNotePriceInfo(String pageContent) throws Exception{
			PriceInfo priceInfo = new PriceInfo();
			// 总价、均价  -- <dt class="gray6 zongjia1">总<span class="padl27"></span>价：<span class="red20b">439</span><span
	        // class="black">万</span>(43466元/㎡)<img title="税费自理价" alt="税费自理价" src="http://img.soufun.com/secondhouse/image/esfnew/imagesdetail/icon_help.gif">
			String totalPrice = null;
			Pattern totalPriceReg = Pattern.compile("<dt class=\"gray6 zongjia1\">总<span class=\"padl27\"></span>价：<span class=\"red20b\">(\\d+?)</span>");
			Matcher totalPriceMatcher = totalPriceReg.matcher(pageContent);
			while (totalPriceMatcher.find()) {
				totalPrice = totalPriceMatcher.group(1);
			}
			priceInfo.setTotalPrice(Float.parseFloat(totalPrice));
			
			String averagePrice = null;
			Pattern averagePriceReg = Pattern.compile("class=\"black\">万</span>\\((\\d+?)元/�\\)");
			Matcher averagePriceMatcher = averagePriceReg.matcher(pageContent);
			while (averagePriceMatcher.find()) {
				averagePrice = averagePriceMatcher.group(1);
			}
			priceInfo.setAveragePrice(Float.parseFloat(averagePrice));
			
			// 首付、月供? -- <dd class="gray6">参考首付：<span class="black ">131.7万</span></dd>
			String downPayment = null;
//			String monthPayment = null;
			Pattern downPaymentReg = Pattern.compile("<dd class=\"gray6\">参考首付：<span class=\"black \">(\\d{1,10}(\\.\\d{1,4})?)万</span></dd>");
			Matcher downPaymentMatcher = downPaymentReg.matcher(pageContent);
			while (downPaymentMatcher.find()) {
				downPayment = downPaymentMatcher.group(1);
			}
			priceInfo.setDownPayment(Float.parseFloat(downPayment));
			
			return priceInfo;
		}
		//本息还款的月还款额(参数: 年利率/贷款总额/贷款总月份)
//		private static double getMonthMoney1(double rate, double totalMoney,
//				int month) {
//			double rateMonth = rate / 12; // 月利率
//			return totalMoney * rateMonth * Math.pow(1 + rateMonth, month)
//					/ (Math.pow(1 + rateMonth, month) - 1);
//		}
	}
}
