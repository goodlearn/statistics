package statistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import statistics.utils.StatisticsConstants;

public class DBFactory {

	//连接Access数据库
	private Connection getConnect() throws Exception{
		Connection conn = null;
		Class.forName(StatisticsConstants.ClassName);
        String conStr = StatisticsConstants.ConnPath;
        conn = DriverManager.getConnection(conStr, StatisticsConstants.DBUser, StatisticsConstants.DBPassword);  
		return conn;
	}
	
	//全表查询(daily)
	public void queryAllDaily() throws Exception{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = getConnect();
		if(null!=conn) {
			stmt = conn.createStatement();  
	        rs = stmt.executeQuery("select * from daily"); 
	        while (rs.next()) {  
	            System.out.println(rs.getString(1)); 
	            System.out.println(rs.getString(2));
	        }  
		}
		if(null!=rs) {
			rs.close(); 
		}
		if(null!=stmt) {
			stmt.close(); 
		}
		if(null!=conn) {
			conn.close(); 
		}
	}
}
