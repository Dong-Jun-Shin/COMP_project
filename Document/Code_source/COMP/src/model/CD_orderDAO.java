package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	/**
	 * getProceedingOrderList() : 거래 중인 주문내역 조회 메소드
	 * @return ArrayList<Order_ChartVO>
	 */
	public ArrayList<CD_OrderVO> getProceedingOrderList(){
		ArrayList<CD_OrderVO> list = new ArrayList<CD_OrderVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT cd_num, cd_sort, cd_reg, cd_price, c_num");
		sql.append("FROM cd_order WHERE cd_sort like '거래중' ");
		CD_OrderVO cvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			cvo = new CD_OrderVO();
			
			
			while(rs.next()) {
				cvo.setCd_num(rs.getString("cd_num"));
				cvo.setCd_sort(rs.getString("cd_sort"));
				cvo.setCd_reg(rs.getString("cd_reg"));
				cvo.setCd_price(rs.getInt("cd_price"));
				cvo.setC_num(rs.getString("cd_num"));
				list.add(cvo);
			}
			
			
		}catch(SQLException sqle) {
			System.out.println("[  getProceedingOrderList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getProceedingOrderList()  ]    [ Unknown Exception ]");
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
				System.out.println("[ getProceedingOrderList()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		
		
		
		return list;
	}
	
	/**
	 *  getCompletedOrderList() : 완료된 주문내역 리스트 조회 메소드
	 * @return
	 */
	public ArrayList<CD_OrderVO> getCompletedOrderList(){
		ArrayList<CD_OrderVO> list = new ArrayList<CD_OrderVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT cd_num, cd_sort, cd_reg, cd_price, c_num");
		sql.append("FROM cd_order WHERE cd_sort like '거래완료' OR cd_sort like '거래취소' ");	
		CD_OrderVO cvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			cvo = new CD_OrderVO();
			
			while(rs.next()) {
				cvo.setCd_num(rs.getString("cd_num"));
				cvo.setCd_sort(rs.getString("cd_sort"));
				cvo.setCd_reg(rs.getString("cd_reg"));
				cvo.setCd_price(rs.getInt("cd_price"));
				cvo.setC_num(rs.getString("cd_num"));
				list.add(cvo);
			}
			
			
			
		}catch(SQLException sqle) {
			System.out.println("[  getCompletedOrderList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getCompletedOrderList()  ]    [ Unknown Exception ]");
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
				System.out.println("[  getCompletedChartList()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	
	//TODO 진행중
	
	
	
	
	
	
	
}
