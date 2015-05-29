package com.chilicool.common.utils;

import java.io.UnsupportedEncodingException;

public class StringUtils {
	public static String getStrEncoding(String arg)
			throws UnsupportedEncodingException {
		String returnEncoding = CharsetCode.CC_UTF_8;
		if (null != arg && !"".equals(arg)) {
			if (arg.equals(new String(arg.getBytes(CharsetCode.CC_ISO8859_1), CharsetCode.CC_ISO8859_1))) {
				returnEncoding = CharsetCode.CC_ISO8859_1;
			} else if (arg.equals(new String(arg .getBytes(CharsetCode.CC_GB2312), CharsetCode.CC_GB2312))) {
				returnEncoding = CharsetCode.CC_GB2312;
			} else if (arg.equals(new String(arg.getBytes(CharsetCode.CC_GBK), CharsetCode.CC_GBK))) {
				returnEncoding = CharsetCode.CC_GBK;
			} else if (arg.equals(new String( arg.getBytes(CharsetCode.CC_UTF_8), CharsetCode.CC_UTF_8))) {
				returnEncoding = CharsetCode.CC_UTF_8;
			}
		}
		return returnEncoding;
	}

	public static interface CharsetCode {
		String CC_UTF_8 = "UTF-8";
		String CC_GBK = "GBk";
		String CC_GB2312 = "GB2312";
		String CC_ISO8859_1 = "ISO8859-1";
	}
}
