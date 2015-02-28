package com.zzc.netcrawler.busidealv0;

public interface ConstHolder {
	public interface TNumber{
		int T_LIMIT_NBR = 47;
		int T_SLEEP_NBR = 5;
	}
	
	public interface DNumber{
		int D_LIMIT_NBR = 100;
		int D_MIN_NBR = 5;
	}
	
	public class StrTool{
		public static final String SUF_DOT = " ...";
		public static final String SUF_EXC = " !";
		public static final String LOG_PREFIX = "----->";
		public static final String INIT_PREFIX = "start initialize ";
		public static final String INIT_SUFFIX = "finish initialize ";
		public static final String INIT_EXECTION = "exception when initialize ";
		public static final String DEAL_PREFIX = "start ";
		public static final String DEAL_SUFFIX = "finish ";
		public static final String DEAL_EXECTION = "exception when ";
		
		public static String initPrefix(String str){
			return INIT_PREFIX + str + SUF_DOT;
		}
		public static String initSuffix(String str){
			return INIT_SUFFIX + str + SUF_EXC;
		}
		public static String initExcetion(String str){
			return INIT_EXECTION + str + SUF_EXC;
		}
		
		public static String dealPrefix(String str){
			return DEAL_PREFIX + str + SUF_DOT;
		}
		public static String dealSuffix(String str){
			return DEAL_SUFFIX + str + SUF_DOT;
		}
		public static String dealException(String str){
			return DEAL_EXECTION + str + SUF_DOT;
		}
	}
	
	public enum NetAddrSts{
		INIT(10, "初始"),ADD(11, "新增"),DEAL(12, "处理"),DONE(13, "完成"),EXEC(21, "异常");
		private NetAddrSts(Integer keyCode, String keyName){
			this.keyCode = keyCode;
			this.keyName = keyName;
		}
		private Integer keyCode;
		private String keyName;
		public Integer getKeyCode() {
			return keyCode;
		}
		public void setKeyCode(Integer keyCode) {
			this.keyCode = keyCode;
		}
		public String getKeyName() {
			return keyName;
		}
		public void setKeyName(String keyName) {
			this.keyName = keyName;
		}
	}
}
