package model;

import java.sql.Connection;
import java.sql.Date;
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
	 * 
	 * @return Connection
	 * @throws Exception
	 */
	private Connection getConnection() throws Exception {
		Connection con = DBUtill.getConnection();
		return con;
	}

	/**
	 * getInstance() : 인스턴스 생성 메소드
	 * 
	 * @return CustomerDAO
	 */
	public static CustomerDAO getInstance() {
		if (instance == null) {
			instance = new CustomerDAO();
		}
		return instance;
	}

	/**
	 * getCustomerCount() : 다음 부여될 고유번호를 반환한다.
	 * 
	 * @return serialNumber 고유번호 부여를 반환
	 */
	public String getCustomerCount() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT NVL(LPAD(MAX(TO_NUMBER(LTRIM(SUBSTR(c_num, ");
		sql.append("3, 3), '0')))+1, 3, '0'), '001') AS customerCount ");
		sql.append("FROM customer ORDER BY c_num");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String serialNumber = "";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				serialNumber = rs.getString("customerCount");
			}
		} catch (SQLException e) {
			System.out.println("쿼리 getCustomerCount() error = [" + e + " ]");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("error = [" + e + " ]");
			e.printStackTrace();
		} finally {
			try {
				// 생성의 역순으로 닫기
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("DB 연동 해제 error = [" + e + " ]");
			}
		}

		return serialNumber;
	}

	/**
	 * customerLoginOverlap() : ID 조회 메소드
	 * 
	 * @param c_id (String) : 입력한 ID
	 * @return boolean
	 * @throws SQLException, Exception
	 */
	public boolean customerLoginOverlap(String c_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c_num ,c_name ,c_id ,c_pw ,c_phone ,c_add ,c_birth ,c_email ,c_reg ");
		sql.append("FROM customer ");
		sql.append("WHERE c_id = ?");
		sql.append("ORDER BY c_num");

		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, c_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
			}
		} catch (SQLException sqle) {
			System.out.println("[  CustomerLogin(String c_id)  ]    [ SQLException ]");
			sqle.printStackTrace();
			return false;
		} catch (Exception e) {
			System.out.println("[  CustomerLogin(String c_id)  ]    [ Unknown Exception ]");
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				System.out.println("[  CustomerLogin(String c_id)  ]    [ Connect Closed Exception ]");
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * getCustomerTotalList() : 고객 정보 전체 조회 메소드
	 * 
	 * @return ArrayList<CustomerVO>
	 */
	public ArrayList<CustomerVO> getCustomerTotalList() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c_num ,c_name ,c_id, c_pw, c_phone ,c_add ,c_birth ,c_email ,c_reg ");
		sql.append("FROM customer ");
		sql.append("ORDER BY c_num ");
		
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		CustomerVO cvo = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String s_birth = rs.getString("c_birth").substring(0, 10);
				
				cvo = new CustomerVO();
				cvo.setC_num(rs.getString("c_num"));
				cvo.setC_name(rs.getString("c_name"));
				cvo.setC_id(rs.getString("c_id"));
				cvo.setC_pw(rs.getString("c_pw"));
				cvo.setC_phone(rs.getString("c_phone"));
				cvo.setC_add(rs.getString("c_add"));
				cvo.setC_birth(s_birth);
				cvo.setC_email(rs.getString("c_email"));
				cvo.setC_reg(rs.getString("c_reg"));
				list.add(cvo);
			}
		} catch (SQLException sqle) {
			System.out.println("[  getCustomerTotalList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[  getCustomerTotalList()  ]    [ Unknown Exception ]");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				System.out.println("[ getCustomerTotalList()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * getCustomerSelected(String category, String searchWord) : 특정 고객 정보 조회 메소드
	 * 
	 * @param category   (String) : 검색 구분
	 * @param searchWord (String) : 검색 키워드
	 * @return ArrayList<CustomerVO>
	 */
	public ArrayList<CustomerVO> getCustomerSelected(String category, String searchWord) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c_num, c_name, c_id, c_pw, c_phone, c_add, c_birth, c_email, c_reg ");
		sql.append("FROM customer WHERE " + category + " LIKE ? ");
		sql.append("ORDER BY c_num");

		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		CustomerVO cvo = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + searchWord + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cvo = new CustomerVO();
				cvo.setC_num(rs.getString("c_num"));
				cvo.setC_name(rs.getString("c_name"));
				cvo.setC_id(rs.getString("c_id"));
				cvo.setC_pw(rs.getString("c_pw"));
				cvo.setC_phone(rs.getString("c_phone"));
				cvo.setC_add(rs.getString("c_add"));
				cvo.setC_birth(rs.getDate("c_birth").toString());
				cvo.setC_email(rs.getString("c_email"));
				cvo.setC_reg(rs.getDate("c_reg").toString());
				list.add(cvo);
			}
		} catch (SQLException sqle) {
			System.out.println("[  getCustomerList(String category, String searchWord)  ]    [ SQLException ]");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[  getCustomerList(String category, String searchWord)  ]    [ Unknown Exception ]");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				System.out.println("[  getCustomerList(String category, String searchWord)  ]    [ Closed Error ]");
				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * customerInsert(CustomerVO cvo) : 계정 정보 등록 메소드
	 * 
	 * @param cvo (CustomerVO) : 등록할 계정
	 * @return boolean
	 */
	public boolean customerInsert(CustomerVO cvo) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO customer (c_num, c_name, c_id, c_pw, c_phone, c_add, c_birth, c_email) ");
		// 번호, 이름, ID, PW, 전화번호, 주소, 생년월일, 이메일
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

		boolean success = false;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, cvo.getC_num());
			pstmt.setString(2, cvo.getC_name());
			pstmt.setString(3, cvo.getC_id());
			pstmt.setString(4, cvo.getC_pw());
			pstmt.setString(5, cvo.getC_phone());
			pstmt.setString(6, cvo.getC_add());
			pstmt.setDate(7, Date.valueOf(cvo.getC_birth()));
			pstmt.setString(8, cvo.getC_email());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				success = true;
			}
		} catch (SQLException sqle) {
			System.out.println("[  CustomerInsert(CustomerVO cvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[  CustomerInsert(CustomerVO cvo)  ] [  Exception  ]");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("[  CustomerInsert(CustomerVO cvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
		}

		return success;
	}

	/**
	 * customerUpdate(CustomerVO cvo) : 계정 정보 수정 메소드
	 * 
	 * @param cvo (CustomerVO) : 수정할 계정
	 * @return boolean
	 */
	public boolean customerUpdate(CustomerVO cvo) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE customer ");
		sql.append("SET c_pw = ?, c_phone = ?, ");
		sql.append("c_add = ?, c_email = ? WHERE c_num = ? ");
		
		boolean success = false;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, cvo.getC_pw());
			pstmt.setString(2, cvo.getC_phone());
			pstmt.setString(3, cvo.getC_add());
			pstmt.setString(4, cvo.getC_email());
			pstmt.setString(5, cvo.getC_num());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				success = true;
			}
		} catch (SQLException sqle) {
			System.out.println("[  CustomerUpdate(CustomerVO cvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			success = false;
		} catch (Exception e) {
			System.out.println("[  CustomerUpdate(CustomerVO cvo)  ] [  Exception  ]");
			e.printStackTrace();
			success = false;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("[  CustomerUpdate(CustomerVO cvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
		}
		
		return success;
	}

	/**
	 * customerDelete(CustomerVO cvo) : 계정 정보 삭제 메소드
	 * 
	 * @param cvo (CustomerVO) : 삭제할 계정
	 * @return boolean
	 */
	public boolean customerDelete(CustomerVO cvo) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM customer WHERE c_num = ? ");

		boolean success = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, cvo.getC_num());
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				success = true;
			}
		} catch (SQLException sqle) {
			System.out.println("[  CustomerDelete(CustomerVO cvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[  CustomerDelete(CustomerVO cvo)  ] [  Exception  ]");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("[  CustomerDelete(CustomerVO cvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
		}
		
		return success;
	}
}
