package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TraderDAO {

	private static TraderDAO instance = null;
	
	private TraderDAO() {
		
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
	 * @return TraderDAO
	 */
	public static TraderDAO getInstance() {
		if(instance == null) {
			instance = new TraderDAO();
		}
		return instance;
	}
	
	/**
	 * getTraderTotalList() : 거래처 전체 조회 메소드
	 * @return ArrayList<TraderVO>
	 */
	public ArrayList<TraderVO> getTraderTotalList(){
		ArrayList<TraderVO> list = new ArrayList<TraderVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT tr_num, tr_name,tr_phone, tr_add, tr_bowner, tr_bnum, tr_bname, tr_reg FROM trader");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con =null;
		TraderVO tvo = null;
		
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			tvo = new TraderVO();
			
			while(rs.next()) {
				tvo.setTr_num(rs.getString("tr_num"));
				tvo.setTr_name(rs.getString("tr_name"));
				tvo.setTr_phone(rs.getString("tr_phone"));
				tvo.setTr_add(rs.getString("tr_add"));
				tvo.setTr_reg(rs.getDate("tr_reg").toString());
				tvo.setTr_bowner(rs.getString("tr_bowner"));
				tvo.setTr_bnum(rs.getString("tr_bnum"));;
				tvo.setTr_bname(rs.getString("tr_bname"));
				list.add(tvo);
			}
			
			}catch(SQLException sqle) {
				System.out.println("[  getTraderTotalList()  ]    [ SQLException ]");
				sqle.printStackTrace();
			}catch(Exception e) {
				System.out.println("[  getTraderTotalList()  ]    [ Unknown Exception ]");
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
					System.out.println("[ getTraderTotalList()  ]    [ Closed Error ]");
					e.printStackTrace();
				}
				
			}
		
		return list;
	}
	
	/**
	 * getTraderSelected(String category, String searchWord) : 특정 거래처 정보 조회 메소드
	 * @param (String) category : 검색 구분
	 * @param (String) searchWord : 검색 키워드
	 * @returnArrayList<TraderVO>
	 */
	public ArrayList<TraderVO> getTraderSelected(String category, String searchWord){
		ArrayList<TraderVO> list = new ArrayList<TraderVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT tr_num, tr_name,tr_phone, tr_add, tr_bowner, tr_bnum, tr_bname, tr_reg ");
		sql.append("FROM trader WHERE "+category+" like "+searchWord);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con =null;
		TraderVO tvo = null;
		
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			tvo = new TraderVO();
			
			while(rs.next()) {
				tvo.setTr_num(rs.getString("tr_num"));
				tvo.setTr_name(rs.getString("tr_name"));
				tvo.setTr_phone(rs.getString("tr_phone"));
				tvo.setTr_add(rs.getString("tr_add"));
				tvo.setTr_reg(rs.getDate("tr_reg").toString());
				tvo.setTr_bowner(rs.getString("tr_bowner"));
				tvo.setTr_bnum(rs.getString("tr_bnum"));;
				tvo.setTr_bname(rs.getString("tr_bname"));
				list.add(tvo);
			}
			
			}catch(SQLException sqle) {
				System.out.println("[  getTraderSelected(String category, String searchWord)  ]    [ SQLException ]");
				sqle.printStackTrace();
			}catch(Exception e) {
				System.out.println("[  getTraderSelected(String category, String searchWord)  ]    [ Unknown Exception ]");
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
					System.out.println("[ getTraderSelected(String category, String searchWord)  ]    [ Closed Error ]");
					e.printStackTrace();
				}
				
			}
		
		return list;
	}
	
	/**
	 * traderInsert(TraderVO tvo) : 거래처 정보 등록 메소드
	 * @param tvo (TraderVO) : 등록할 거래처
	 * @return boolean
	 */
	public boolean traderInsert(TraderVO tvo) {
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO trader ");
		sql.append("(tr_num, tr_name, tr_phone, tr_add, tr_bowner, tr_bnum, tr_bname)");
		//번호
		sql.append("'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),");
		//거래처명, 전화번호, 주소, 계좌주, 계좌번호, 계좌은행 
		sql.append("? , ? , ? , ? , ? , ? )");
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, tvo.getTr_name());
			pstmt.setString(2, tvo.getTr_phone());
			pstmt.setString(3, tvo.getTr_add());
			pstmt.setString(4, tvo.getTr_bowner());
			pstmt.setString(5, tvo.getTr_bnum());
			pstmt.setString(6, tvo.getTr_bname());
			int i = pstmt.executeUpdate();
			if(i ==1) {
				result = true;
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  traderInsert(TraderVO tvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		}catch(Exception e) {
			System.out.println("[  traderInsert(TraderVO tvo)  ] [  Exception  ]");
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
				System.out.println("[  traderInsert(TraderVO tvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	/**
	 * traderUpdate(TraderVO tvo) : 거래처 정보 수정 메소드
	 * @param tvo (TraderVO) : 수정할 거래처
	 * @return boolean
	 */
	public boolean traderUpdate(TraderVO tvo) {
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE trader SET tr_name = ?, tr_phone = ?, tr_add = ?, ");
		sql.append("tr_bowner = ? ,tr_bnum = ?, tr_bname = ?");
		sql.append("WHERE tr_num = ?");
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, tvo.getTr_name());
			pstmt.setString(2, tvo.getTr_phone());
			pstmt.setString(3, tvo.getTr_add());
			pstmt.setString(4, tvo.getTr_bowner());
			pstmt.setString(5, tvo.getTr_bnum());
			pstmt.setString(6, tvo.getTr_bname());
			pstmt.setString(7, tvo.getTr_num());
			int i = pstmt.executeUpdate();
			if(i ==1) {
				result = true;
			}
			
		}catch(SQLException sqle) {
			System.out.println("[  traderUpdate(TraderVO tvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		}catch(Exception e) {
			System.out.println("[  traderUpdate(TraderVO tvo)  ] [  Exception  ]");
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
				System.out.println("[  traderUpdate(TraderVO tvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
		
	/**
	 * traderDelete(TraderVO tvo) : 거래처 정보 삭제 메소드
	 * @param tvo (TraderVO) : 삭제할 거래처
	 * @return boolean
	 */
	public boolean traderDelete(TraderVO tvo) {
		boolean result = false;
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM trader WHERE tr_num = ? ");
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, tvo.getTr_num());
			int i = pstmt.executeUpdate();
			if(i ==1) {
				result = true;
			}
			
		}catch(SQLException sqle) {
			System.out.println("[   traderDelete(TraderVO cvo)  ] [  SQLException  ]");
			sqle.printStackTrace();
			result = false;
		}catch(Exception e) {
			System.out.println("[   traderDelete(TraderVO cvo)  ] [  Exception  ]");
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
				System.out.println("[   traderDelete(TraderVO cvo)  ] [  closed Error  ]");
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
}
