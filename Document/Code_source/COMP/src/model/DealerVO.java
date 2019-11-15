package model;

public class DealerVO {
	private String dName = "명륜컴퓨터";
//	private String dId = "infinityCM88";
//	private String dPasswd = "unli88mite";
	private String dId = "a1234";
	private String dPasswd = "1234";
	private String dPhone = "02-5587-4523";
	private String dAddress = "서울특별시 동대문구";
//	private String dBOwner = "김명진";
//	private String dBNum = "213215-04-235225";
	private String dBOwner = "김길동";
	private String dBNum = "000000-00-000000";
	private String dBName = "국민은행";

	private DealerVO() {
	}

	private static DealerVO instance = null;

	/**
	 * getInstance() : 싱글톤 구현
	 * 
	 * @return
	 */
	public static final DealerVO getInstance() {
		if (instance == null) {
			instance = new DealerVO();
		}
		return instance;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public String getdPasswd() {
		return dPasswd;
	}

	public void setdPasswd(String dPasswd) {
		this.dPasswd = dPasswd;
	}

	public String getdPhone() {
		return dPhone;
	}

	public void setdPhone(String dPhone) {
		this.dPhone = dPhone;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public String getdBOwner() {
		return dBOwner;
	}

	public void setdBOwner(String dBOwner) {
		this.dBOwner = dBOwner;
	}

	public String getdBNum() {
		return dBNum;
	}

	public void setdBNum(String dBNum) {
		this.dBNum = dBNum;
	}

	public String getdBName() {
		return dBName;
	}

	public void setdBName(String dBName) {
		this.dBName = dBName;
	}

	public static void setInstance(DealerVO instance) {
		DealerVO.instance = instance;
	}

}
