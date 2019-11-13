package model;

import java.sql.Connection;

public class CD_orderDAO {

	private static CD_orderDAO instance = null;
	
	private CD_orderDAO() {
		
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
	 * @return CD_orderDAO
	 */
	public static CD_orderDAO getInstance() {
		if(instance ==null) {
			instance = new CD_orderDAO();
		}
		return instance;
	}
	
	
	
	
	
	
}
