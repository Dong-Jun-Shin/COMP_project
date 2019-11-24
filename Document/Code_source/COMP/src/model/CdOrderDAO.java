package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CdOrderDAO {

	private static CdOrderDAO instance = null;
	
	private CdOrderDAO() {
		
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
	public static CdOrderDAO getInstance() {
		if(instance ==null) {
			instance = new CdOrderDAO();
		}
		return instance;
	}
	
	/**
	 * getProceedingOrderList() : 거래 중인 주문 리스트 조회 메소드
	 * @return ArrayList<Order_ChartVO>
	 */
	public ArrayList<CdOrderVO> getProgressOrderList(){
		ArrayList<CdOrderVO> list = new ArrayList<CdOrderVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT cd_num, cd_sort, cd_reg, cd_price, c_num");
		sql.append("FROM cd_order WHERE cd_sort like '거래중' ");
		CdOrderVO cvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				cvo = new CdOrderVO();
				
				cvo.setCd_num(rs.getString("cd_num"));
				cvo.setCd_sort(rs.getString("cd_sort"));
				cvo.setCd_reg(rs.getString("cd_reg"));
				cvo.setCd_price(rs.getInt("cd_price"));
				cvo.setC_num(rs.getString("cd_num"));
				list.add(cvo);
				
			}
			
			
		}catch(SQLException sqle) {
			System.out.println("[  getProgressOrderList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getProgressOrderList()  ]    [ Unknown Exception ]");
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
				System.out.println("[ getProgressOrderList()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		
		
		
		return list;
	}
	
	/**
	 *  getCompletedOrderList() : 완료된 주문 리스트 조회 메소드
	 * @return ArrayList<Order_ChartVO>
	 */
	public ArrayList<CdOrderVO> getHistoryOrderList(){
		ArrayList<CdOrderVO> list = new ArrayList<CdOrderVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT cd_num, cd_sort, cd_reg, cd_price, c_num");
		sql.append("FROM cd_order WHERE cd_sort like '거래완료' OR cd_sort like '거래취소' ");	
		CdOrderVO cvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			cvo = new CdOrderVO();
			
			while(rs.next()) {
				cvo.setCd_num(rs.getString("cd_num"));
				cvo.setCd_sort(rs.getString("cd_sort"));
				cvo.setCd_reg(rs.getString("cd_reg"));
				cvo.setCd_price(rs.getInt("cd_price"));
				cvo.setC_num(rs.getString("cd_num"));
				list.add(cvo);
			}
			
			
			
		}catch(SQLException sqle) {
			System.out.println("[  getHistoryOrderList()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getHistoryOrderList()  ]    [ Unknown Exception ]");
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
				System.out.println("[  getHistoryOrderList()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	/**
	 * cd_orderUpdate(CD_OrderVO cvo) : 거래 완료 상태 업데이트 메소드
	 * @param cvo		(CD_OrderVO) : 수정할 주문
	 * @return boolean
	 */
	public boolean cd_orderUpdate(CdOrderVO cvo) {
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE cd_order SET cd_sort = ?");
		sql.append(" WHERE cd_num = ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, cvo.getCd_sort());
			pstmt.setString(2, cvo.getCd_num());
			
			int i = pstmt.executeUpdate();
			if(i ==1) {
				result = true;
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  cd_orderUpdate(CD_OrderVO cvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		}catch(Exception e) {
			System.out.println("[  cd_orderUpdate(CD_OrderVO cvo)  ] [  Exception  ]");
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
				System.out.println("[  cd_orderUpdate(CD_OrderVO cvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	/**
	 * cd_orderInsert(CD_OrderVO cvo) : 주문 등록 메소드
	 * @param covo		(CD_OrderVO) : 등록할 주문
	 * @return boolean
	 */
	public boolean cd_orderInsert(CdOrderVO covo) {
		boolean result = false;
		String proc = "{call reset_seq('ch_num_seq')}";
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO cd_order (cd_num, cd_price, c_num) ");
		sql.append("VALUES (?, ?, ?) ");
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		try {
			con = getConnection();
			cstmt = con.prepareCall(proc);
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, covo.getCd_num());
			pstmt.setInt(2, covo.getCd_price());
			pstmt.setString(3, covo.getC_num());
			
			int i = cstmt.executeUpdate();
			int j = pstmt.executeUpdate();
			
			if(i == 1 && j == 1) {
				result = true;
			}
		}catch(SQLException sqle) {
			System.out.println("[  cd_orderInsert(CD_OrderVO cvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		}catch(Exception e) {
			System.out.println("[  cd_orderInsert(CD_OrderVO cvo)  ] [  Exception  ]");
			e.printStackTrace();
			result = false;
		}finally {
			try {				
				if(cstmt != null) {
					cstmt.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				System.out.println("[  cd_orderInsert(CD_OrderVO cvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * getOrderCount(String date) : 입력된 일자를 선별하여 조회된 카운트 리턴 메소드
	 * @param date 
	 * @return String
	 */
	public String getOrderCount(String date) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT NVL(LPAD(MAX(TO_NUMBER(LTRIM( ");
		sql.append("SUBSTR(cd_num, 7, 4), '0')))+1, 4, '0'), '0001')  ");
		sql.append("AS cdOrderCount FROM cd_order ");
		sql.append("WHERE cd_num like ? ORDER BY cd_num ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String serialNumber = "";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, date+"%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				serialNumber = rs.getString("cdOrderCount");
			}
		} catch (SQLException e) {
			System.out.println("[   getOrderCount(String date)  ]  [  SQLException  ]");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[   getOrderCount(String date)  ]  [  Exception  ]");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println("[   getOrderCount(String date)  ]  [  DB연동 해제 에러  ]");
			}
		}

		return serialNumber;
		
	}
	
	/**
	 * getChartMonthPrice() : 주차별 월간 총 주문 금액 합산 값 리턴 메소드 -테스트 필요-
	 * @param month
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> getChartMonthPrice() {
		Map<String,Integer> resultMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT (SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND  TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '1') AS w1, ");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '2') AS w2, ");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '3') AS w3, ");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '4') AS w4, ");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '5') AS w5 ");
		sql.append("FROM cd_order GROUP BY TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W')");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			if(rs.next()) {
				for(int i = 1; i<=rsmd.getColumnCount();i++) {
					resultMap.put(rsmd.getColumnName(i),rs.getInt(i));
				}
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  getChartMonthPrice()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getChartMonthPrice()  ]    [ Unknown Exception ]");
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
				System.out.println("[  getChartMonthPrice()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		
		return resultMap;
	}
	
	
	/**
	 * getChartMonthOrder() : 주차별 월간 총 판매량 합산 값 리턴 메소드 -테스트 필요-
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> getChartMonthOrder() {
		Map<String,Integer> resultMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT (SELECT COUNT(DISTINCT(cd_num)) FROM cd_order ");
		sql.append(" WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '1') AS w1, ");
		sql.append(" (SELECT COUNT(DISTINCT(cd_num)) FROM cd_order  ");
		sql.append(" WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '2') AS w2, ");
		sql.append(" (SELECT COUNT(DISTINCT(cd_num)) FROM cd_order ");
		sql.append(" WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '3') AS w3, ");
		sql.append(" (SELECT COUNT(DISTINCT(cd_num)) FROM cd_order ");
		sql.append(" WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '4') AS w4, ");
		sql.append(" (SELECT COUNT(DISTINCT(cd_num)) FROM cd_order ");
		sql.append(" WHERE cd_sort like '거래완료' AND TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W') = '5') AS w5 ");
		sql.append(" FROM cd_order GROUP BY TO_CHAR(TO_DATE(SUBSTR(cd_num,1,6),'yymmdd'),'W')");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			if(rs.next()) {
				for(int i = 1; i<=rsmd.getColumnCount();i++) {
					resultMap.put(rsmd.getColumnName(i),rs.getInt(i));
				}
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  getChartMonthOrder()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getChartMonthOrder()  ]    [ Unknown Exception ]");
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
				System.out.println("[  getChartMonthOrder()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		
		return resultMap;
		
		
		
	}
	
	/**
	 * getChartYearPrice() : 월별 연간 총 주문 금액 합산 값 리턴 메소드 -테스트 필요-
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> getChartYearPrice(){
		Map<String,Integer> resultMap = new HashMap<>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT (SELECT  NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '1') AS m1 , ");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '2') AS m2 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '3') AS m3 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '4') AS m4 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '5') AS m5 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '6') AS m6 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '7') AS m7 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '8') AS m8 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '9') AS m9 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '10') AS m10 ,");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '11') AS m11 , ");
		sql.append("(SELECT NVL(SUM(cd_price),0) FROM cd_order WHERE cd_sort like '거래완료' AND SUBSTR(cd_num,3,2) = '12') AS m12 ");
		sql.append("FROM cd_order GROUP BY SUBSTR(cd_num,3,2) ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			if(rs.next()) {
				for(int i = 1; i<=rsmd.getColumnCount();i++) {
					resultMap.put(rsmd.getColumnName(i),rs.getInt(i));
				}
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  getChartYearPrice()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getChartYearPrice()  ]    [ Unknown Exception ]");
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
				System.out.println("[  getChartYearPrice()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		return resultMap;
	}
	
	/**
	 * getCountRank() : 제품 종류별 랭크 조회 메소드 -테스트 필요-
	 * @return
	 */
	public ArrayList<RankVO> getCountRank() {
		//TODO 금액 ',' 넣기
		ArrayList<RankVO> list = new ArrayList<RankVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT oc.p_num AS productSort, p.p_name AS p_name, ");
		sql.append("SUM(oc.ch_qty) AS count, p.p_price AS p_price, p.p_price*SUM(oc.ch_qty) AS priceResult, ");
		sql.append("RANK() OVER (ORDER BY p.p_price*SUM(oc.ch_qty) desc) AS rank ");
		sql.append("FROM order_chart oc, product p, cd_order c ");
		sql.append("WHERE oc.p_num = p.p_num AND c.cd_num = oc.cd_num AND c.cd_sort = '거래완료' ");
		sql.append("GROUP BY oc.p_num, p.p_name, p.p_price ");
		sql.append("ORDER BY oc.p_num, p.p_price*SUM(oc.ch_qty) DESC");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		RankVO rvo = null;
		String temp = "";
		String pSort = "";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				rvo = new RankVO();
				
				//제품 코드를 제품 구분 코드로 가공
				pSort = rs.getString("productSort");
				pSort = pSort.substring(0, pSort.indexOf("_"));
				
				if(!pSort.equals(temp)) {
					rvo.setProductSort(pSort);
					rvo.setP_name(rs.getString("p_name"));
					rvo.setCount(rs.getInt("count"));
					rvo.setP_price(rs.getInt("p_price"));
					rvo.setPriceResult(rs.getInt("priceResult"));
					
					list.add(rvo);
					
					temp = pSort;
				}
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  getCountRank()  ]    [ SQLException ]");
			sqle.printStackTrace();
		}catch(Exception e) {
			System.out.println("[  getCountRank()  ]    [ Unknown Exception ]");
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
				System.out.println("[  getCountRank()  ]    [ Closed Error ]");
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	
	
	
}
