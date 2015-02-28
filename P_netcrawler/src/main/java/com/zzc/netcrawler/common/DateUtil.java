package com.zzc.netcrawler.common;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {
	public static final String YYYYMMDDHHMMSS = "yyyy/MM/dd HH:mm:ss";

	public static Timestamp getTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
}
