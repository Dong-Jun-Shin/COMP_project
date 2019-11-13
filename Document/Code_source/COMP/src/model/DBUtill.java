package model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtill {

	public static Connection getConnection() throws Exception {
		InputStream fis = DBUtill.class.getResourceAsStream("/properties_file/jdbc.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
}
