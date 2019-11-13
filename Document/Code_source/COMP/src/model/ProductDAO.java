package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

	private static ProductDAO instance = null;
	
	private ProductDAO() {
		
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
	 * @return ProductDAO
	 */
	public static ProductDAO getInstance() {
		if(instance ==null) {
			instance = new ProductDAO();
		}
		return instance;
	}
	
	/**
	 * getProductTotalList() : 전체 제품 리스트 조회 메소드
	 * @return ArrayList<ProductVO> 
	 */
	public ArrayList<ProductVO> getProductTotalList() {
		
		StringBuffer sql = new StringBuffer();
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		sql.append("SELECT p_name ,p_price ,p_size ,p_grt ,p_date ,p_img ,p_qty ,p_num ,p_reg ");
		sql.append("FROM product");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO pvo = null;
		Connection con =null;
		
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pvo = new ProductVO();
				
				pvo.setP_name(rs.getString("p_name"));
				pvo.setP_price(rs.getInt("p_price"));
				pvo.setP_size(rs.getString("p_size"));
				pvo.setP_grt(rs.getString("p_grt"));
				pvo.setP_date(rs.getDate("p_date").toString());
				pvo.setP_img(rs.getString("p_img"));
				pvo.setP_qty(rs.getInt("p_qty"));
				pvo.setP_num(rs.getString("p_num"));
				pvo.setP_reg(rs.getDate("p_reg").toString());
				
				list.add(pvo);
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  public ArrayList<ProductVO> getProductTotalList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  public ArrayList<ProductVO> getProductTotalList()  ]    [ Unknown Exception ]");
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
				System.out.println("[  public ArrayList<ProductVO> getProductTotalList()  ]    [ Connect Closed Exception ]");
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	/**
	 * getProductSelected(String p_num) : 선택한 제품 조회 메소드
	 * @param p_num
	 * @return ArrayList<ProductVO>
	 * @throws SQLException, Exception
	 */
	public ArrayList<ProductVO> getProductSelected(String p_num){
		
		StringBuffer sql = new StringBuffer();
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		sql.append("SELECT p_name ,p_price ,p_size ,p_grt ,p_date ,p_img ,p_qty ,p_num ,p_reg ");
		sql.append("FROM product");
		sql.append("where p_num = ?");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO pvo = null;
		Connection con =null;
		
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,p_num);
			rs = pstmt.executeQuery();
				
			pvo = new ProductVO();
				
			pvo.setP_name(rs.getString("p_name"));
			pvo.setP_price(rs.getInt("p_price"));
			pvo.setP_size(rs.getString("p_size"));
			pvo.setP_grt(rs.getString("p_grt"));
			pvo.setP_date(rs.getDate("p_date").toString());
			pvo.setP_img(rs.getString("p_img"));
			pvo.setP_qty(rs.getInt("p_qty"));
			pvo.setP_num(rs.getString("p_num"));
			pvo.setP_reg(rs.getDate("p_reg").toString());
				
			list.add(pvo);
			
		}catch(SQLException sqle) {
			System.out.println("[  public ArrayList<ProductVO> getProductSelected(String p_num)  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  public ArrayList<ProductVO> getProductSelected(String p_num)  ]    [ Unknown Exception ]");
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
				System.out.println("[  public ArrayList<ProductVO> getProductSelected(String p_num)  ]    [ Connect Closed Exception ]");
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
