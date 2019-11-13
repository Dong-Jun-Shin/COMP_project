package model;

import java.sql.Connection;

public class Order_chartDAO {

	private static Order_chartDAO instance = null;
	
	private Order_chartDAO() {
		
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
	 * @return Order_chartDAO
	 */
	public static Order_chartDAO getInstance() {
		if(instance == null) {
			instance = new Order_chartDAO();
		}
		return instance;
	}
	
	
	
	
	
	
}
