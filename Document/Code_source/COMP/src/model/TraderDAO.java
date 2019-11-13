package model;

import java.sql.Connection;

public class TraderDAO {

	private static TraderDAO instance = null;
	
	private TraderDAO() {
		
	}
	
	/**
	 * getConnection() : DB 연동 메소드
	 * @return Connection
	 * @throws Exception
	 */
	private Connection getConnection() throws Exception{
		Connection con = DBUtill.getConnection();
		return con;
	}
	
	/**
	 * getInstance() : 인스턴스 생성 메소드
	 * @return TraderDAO
	 */
	public static TraderDAO getInstance() {
		if(instance == null) {
			instance = new TraderDAO();
		}
		return instance;
	}
	
	
	
	
	
	
}
