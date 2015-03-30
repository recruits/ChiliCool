package com.chilicool.reporttool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

public class CreateDbCfgData {

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "approval_dev",
					"approval_dev");// 获取连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String qryMaxId(String modelType){
		Connection conn = getConnection();
		String sql = "select max(template_id) from cfg_print_template where busi_type like ?";
		if(StringUtils.isEmpty(modelType)){
			sql = "select max(template_id) from cfg_print_template";
		}
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, modelType+"%");
			ResultSet result = pre.executeQuery();
			String templateId = "";
			while (result.next()) {  
				templateId = result.getString(1);
            } 
			conn.close();
			return templateId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "100000";
	}
	
	public void addTemplateInfo(){
		
	}
}
