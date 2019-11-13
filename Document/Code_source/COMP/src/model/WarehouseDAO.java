package model;

import java.sql.Connection;

public class WarehouseDAO {

	private static WarehouseDAO instance = null;
	
	private WarehouseDAO() {
		
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
	 * @return WarehouseDAO
	 */
	public static WarehouseDAO getInstance() {
		if(instance == null) {
			instance = new WarehouseDAO();
		}
		return instance;
	}
	
	
	
	
	
	
}
