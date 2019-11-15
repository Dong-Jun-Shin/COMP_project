package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	/**
	 * getWarehouseTotalList() : 입고 내역 전체 조회 메소드
	 * @return ArrayList<WarehouseVO>
	 */
	public ArrayList<WarehouseVO> getWarehouseTotalList(){
		ArrayList<WarehouseVO> list = new ArrayList<WarehouseVO>();
		WarehouseVO wvo = new WarehouseVO();
		StringBuffer sql = new StringBuffer();
		sql.append("");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			wvo = new WarehouseVO();
			
			while(rs.next()){
				wvo.setWh_num(rs.getString("wh_num"));
				wvo.setWh_qty(rs.getInt("wh_qty"));
				wvo.setWh_reg(rs.getString("wh_reg"));
				wvo.setTr_num(rs.getString("tr_num"));
				wvo.setP_num(rs.getString("p_num"));
				list.add(wvo);
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  getCustomerTotalList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getCustomerTotalList()  ]    [ Unknown Exception ]");
			e.printStackTrace();
			
		}finally {
			try {
				if(con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				
			}catch(Exception e) {
				System.out.println("[  getCustomerTotalList()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		
		
		
		return list;
	}
	
	/**
	 * warehouseInsert(WarehouseVO wvo) : 입고 내역 등록 메소드
	 * @param wvo 	(WarehouseVO) : 등록할 입고 내역
	 * @return boolean
	 */
	public boolean warehouseInsert(WarehouseVO wvo) {
		Boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO warehouse (wh_num, wh_qty,tr_num, p_num)");
		sql.append("VALUES ( 'WH_'||LPAD(TO_CHAR(wh_num_seq.NEXTVAL),4,'0')");
		sql.append(", ? , ? , ?  )");
		PreparedStatement pstmt = null;
		Connection con = null;
		
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, wvo.getWh_qty());
			pstmt.setString(2, wvo.getTr_num());
			pstmt.setString(3, wvo.getP_num());
			int i = pstmt.executeUpdate();
			if(i ==1) {
				result = true;
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  warehouseInsert(WarehouseVO wvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		}catch(Exception e) {
			System.out.println("[  warehouseInsert(WarehouseVO wvo)  ] [  Exception  ]");
			e.printStackTrace();
			result = false;
		}finally {
			
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				System.out.println("[  warehouseInsert(WarehouseVO wvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
			
		}
			
		
		
		return result;
	}
	
	/**
	 * warehouseDelete(WarehouseVO wvo) : 입고 내역 삭제 메소드
	 * @param wvo		(WarehouseVO) : 삭제할 입고 내역
	 * @return boolean
	 */
	public boolean warehouseDelete(WarehouseVO wvo) {
		
		Boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM warehouse WHERE wh_num = ?;");
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, wvo.getWh_num());
			
			int i = pstmt.executeUpdate();
			if(i ==1) {
				result = true;
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  warehouseDelete(WarehouseVO wvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		}catch(Exception e) {
			System.out.println("[  warehouseDelete(WarehouseVO wvo)  ] [  Exception  ]");
			e.printStackTrace();
			result = false;
		}finally {
			
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				System.out.println("[  warehouseDelete(WarehouseVO wvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
			
		}
			
		return result;
	}
	
}
