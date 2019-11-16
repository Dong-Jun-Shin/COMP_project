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
	 * @return ProductDAO
	 */
	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}

	/**
	 * getProductTotalList() : 전체 제품 리스트 조회 메소드
	 * 
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
		Connection con = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
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

		} catch (SQLException sqle) {
			System.out.println("[  public ArrayList<ProductVO> getProductTotalList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[  public ArrayList<ProductVO> getProductTotalList()  ]    [ Unknown Exception ]");
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
				System.out.println(
						"[  public ArrayList<ProductVO> getProductTotalList()  ]    [ Connect Closed Exception ]");
				e.printStackTrace();
			}

		}

		return list;
	}

	/**
	 * getProductSelected(String p_num) : 선택한 제품 조회 메소드
	 * 
	 * @param p_num (String) : 조회할 제품 번호
	 * @return ArrayList<ProductVO>
	 * @throws SQLException, Exception
	 */
	public ArrayList<ProductVO> getProductSelected(String p_num) {

		StringBuffer sql = new StringBuffer();
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		sql.append("SELECT p_name ,p_price ,p_size ,p_grt ,p_date ,p_img ,p_qty ,p_num ,p_reg ");
		sql.append("FROM product ");
		sql.append("WHERE p_num = ?");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO pvo = null;
		Connection con = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, p_num);

			rs = pstmt.executeQuery();

			pvo = new ProductVO();

			while (rs.next()) {
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

		} catch (SQLException sqle) {
			System.out
					.println("[  public ArrayList<ProductVO> getProductSelected(String p_num)  ]    [ SQLException ]");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println(
					"[  public ArrayList<ProductVO> getProductSelected(String p_num)  ]    [ Unknown Exception ]");
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
				System.out.println(
						"[  public ArrayList<ProductVO> getProductSelected(String p_num)  ]    [ Connect Closed Exception ]");
				e.printStackTrace();
			}

		}

		return list;
	}

	/**
	 * productInsert(ProductVO pvo) : 제품 등록 메소드
	 * 
	 * @param pvo (ProductVO) : 등록할 제품
	 * @return boolean;
	 */
	public boolean productInsert(ProductVO pvo) {
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		// 제품 구분
		String sort = pvo.getP_num().substring(0, 2);
		if (sort.contains("_")) {
			sort = pvo.getP_num().substring(0, 1);
		}
		sql.append("INSERT INTO product");
		sql.append("(p_name ,p_price ,p_size ,p_grt ,p_date ,p_img ,p_qty ,p_num)");
		sql.append("VALUES");
		// 제품명, 값, 크기, 보증기간, 출시일, 이미지명, 제품갯수
		sql.append("(? , ? , ?, ? , ? , ? , ? ");
		// 제품코드 앞글자, 제품코드 시퀀스 구분
		sql.append(sort + "_ ||LPAD(TO_CHAR(p_" + sort + "_num_seq.nextval), 3 ,'0') )");
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pvo.getP_name());
			pstmt.setInt(2, pvo.getP_price());
			pstmt.setString(3, pvo.getP_size());
			pstmt.setString(4, pvo.getP_grt());
			pstmt.setString(5, pvo.getP_date());
			pstmt.setString(6, pvo.getP_img());
			pstmt.setInt(7, pvo.getP_qty());

			int i = pstmt.executeUpdate();
			if (i == 1) {
				result = true;
			}

		} catch (SQLException sqle) {
			System.out.println("[   productInsert(ProductVO pvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		} catch (Exception e) {
			System.out.println("[   productInsert(ProductVO pvo)  ] [  Exception  ]");
			e.printStackTrace();
			result = false;
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("[   productInsert(ProductVO pvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}

		}

		return result;
	}

	/**
	 * productUpdate(ProductVO pvo) : 제품 수정 메소드
	 * 
	 * @param pvo (ProductVO) : 수정할 제품
	 * @return boolean
	 */
	public boolean productUpdate(ProductVO pvo) {
		boolean result = false;
		StringBuffer sql = new StringBuffer();

		sql.append("UPDATE product SET");
		sql.append("p_name = ?,"); // 제품명
		sql.append("p_price = ? ,"); // 가격
		sql.append("p_size = ?,"); // 크기
		sql.append("p_grt = ?,"); // 보증기간
		sql.append("p_date = ?,"); // 출시일
		sql.append("p_img = ?,"); // 이미지명
		sql.append("p_qty = ? "); // 개수
		sql.append("where p_num = ? "); // 제품번호 구분
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pvo.getP_name());
			pstmt.setInt(2, pvo.getP_price());
			pstmt.setString(3, pvo.getP_size());
			pstmt.setString(4, pvo.getP_grt());
			pstmt.setString(5, pvo.getP_date());
			pstmt.setString(6, pvo.getP_img());
			pstmt.setInt(7, pvo.getP_qty());
			pstmt.setString(8, pvo.getP_num());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				result = true;
			}

		} catch (SQLException sqle) {
			System.out.println("[  productUpdate(ProductVO pvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		} catch (Exception e) {
			System.out.println("[  productUpdate(ProductVO pvo)  ] [  Exception  ]");
			e.printStackTrace();
			result = false;
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("[  productUpdate(ProductVO pvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}

		}

		return result;
	}

	/**
	 * productDelete(ProductVO pvo) : 제품 삭제 메소드
	 * 
	 * @param pvo (ProductVO) : 삭제할 제품
	 * @return boolean
	 */
	public boolean productDelete(ProductVO pvo) {
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM product WHERE p_num = ?");

		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pvo.getP_num());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				result = true;
			}

		} catch (SQLException sqle) {
			System.out.println("[  productDelete(ProductVO pvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		} catch (Exception e) {
			System.out.println("[  productDelete(ProductVO pvo)  ] [  Exception  ]");
			e.printStackTrace();
			result = false;
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("[  productDelete(ProductVO pvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}

		}

		return result;
	}

}
