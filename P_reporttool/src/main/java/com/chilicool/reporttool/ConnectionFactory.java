package com.chilicool.reporttool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	
	public static void main(String[] args) {
		Connection conn = null;  
	    ResultSet rs = null;  
	    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";  
	    String username = "test";  
	    String password = "test";  
	    PreparedStatement ps1 = null;  
	    PreparedStatement ps2 = null;  
	    try {  
	        Class.forName("oracle.jdbc.OracleDriver");  
	        conn = DriverManager.getConnection(url, username, password);  
	        String sql1 = "select t1.usercode,t2.usertype from app_userchangerecord t1 left join base_user t2 on t1.usercode = t2.code";  
	        String sql2 = "update app_userchangerecord t set t.usertype = ? where usercode = ?";  
	        ps1 = conn.prepareStatement(sql1);  
	        ps2 = conn.prepareStatement(sql2);  
	        String code;  
	        String usertype;  
	        rs = ps1.executeQuery();  
	        while (rs.next()) {  
	            code = rs.getString(1);  
	            usertype = rs.getString(2);  
	            ps2.setString(1, usertype);  
	            ps2.setString(2, code);  
	            ps2.executeUpdate();  
	        }
	    }catch (Exception exp){
	    	
	    }
	}
}
