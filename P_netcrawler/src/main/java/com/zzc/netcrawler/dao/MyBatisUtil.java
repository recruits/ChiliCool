package com.zzc.netcrawler.dao;

import java.io.Reader;

import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisUtil {
//	private final static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "mybatis-config.xml";
		Reader reader = null;
//		try {
//			reader = Resources.getResourceAsReader(resource);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//
//		}
//		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
//		return sqlSessionFactory;
		return null;
	}
}
