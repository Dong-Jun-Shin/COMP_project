package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {

	private static CustomerDAO instance = null;
	
	private CustomerDAO() {
		
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
	 * @return CustomerDAO
	 */
	public static CustomerDAO getInstance() {
		if(instance ==null) {
			instance = new CustomerDAO();
		}
		return instance;
	}
	
	/**
	 *  getCustomerList() : 계정 조회를 하기 위한 메소드 
	 * @param c_id, c_pw
	 * @return ArrayList<CustomerVO>
	 * @throws SQLException, Exception
	 */
	public ArrayList<CustomerVO> CustomerLogin(String c_id, String c_pw){
		//TODO 미완성
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<CustomerVO> list = null;
		CustomerVO cvo = null;
		
		sql.append("SELECT c_num ,c_name ,c_id ,c_pw ,c_phone ,c_add ,c_birth ,c_email ,c_reg");
		sql.append("FROM customer");
		
		//로그인시 조회용
		sql.append("where c_id = ? , c_pw = ?");
		
		try {
			
			cvo = new CustomerVO();
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			//로그인시 조회용
			pstmt.setString(1, c_id);
			pstmt.setString(2, c_pw);
			
			
			rs = pstmt.executeQuery();
			
			//계정정보 조회용
			while(rs.next()) {
				cvo.setC_num(rs.getString("c_num"));
				cvo.setC_name(rs.getString("c_name"));
				cvo.setC_id(rs.getString("c_id"));
				cvo.setC_pw(rs.getString("c_pw"));
				cvo.setC_phone(rs.getString("c_phone"));
				cvo.setC_add(rs.getString("c_add"));
				cvo.setC_birth(rs.getString("c_birth"));
				cvo.setC_email(rs.getString("c_email"));
				list.add(cvo);
			}
			
			
			
			if(list.size() <1) {
				//list에 값이 없을때.(계정 정보 없음)
			}else {
				//list에 값이 있을때.(계정 정보 있음)
			}
			
			
			
		}catch(SQLException sqle) {
			System.out.println("[  public ArrayList<ProductVO>  getCustomerList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  public ArrayList<ProductVO>  getCustomerList()  ]    [ Unknown Exception ]");
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
				System.out.println("[  public ArrayList<ProductVO>  getCustomerList()  ]    [ Connect Closed Exception ]");
				e.printStackTrace();
			}
			
		}
		
		
		return list;
	}
	
	
	
	
	
	
}
