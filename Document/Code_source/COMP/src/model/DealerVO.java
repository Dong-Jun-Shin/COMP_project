package model;

import java.io.Serializable;

public class DealerVO implements Serializable {
	private static final long serialVersionUID = -1576767060432378767L;
	private String dName;
//	private String dId = "infinityCM88";
//	private String dPasswd = "unli88mite";
	private String dId;
	private String dPasswd;
	private String dPhone;
	private String dAddress;
//	private String dBOwner = "김명진";
//	private String dBNum = "213215-04-235225";
	private String dBOwner;
	private String dBNum;
	private String dBName;

//	private String dName = "명륜컴퓨터";
////	private String dId = "infinityCM88";
////	private String dPasswd = "unli88mite";
//	private String dId = "a1234";
//	private String dPasswd = "1234";
//	private String dPhone = "02-5587-4523";
//	private String dAddress = "서울특별시 동대문구";
////	private String dBOwner = "김명진";
////	private String dBNum = "213215-04-235225";
//	private String dBOwner = "김길동";
//	private String dBNum = "000000-00-000000";
//	private String dBName = "국민은행";

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

	public String getDName() {
		return dName;
	}

	public void setDName(String dName) {
		this.dName = dName;
	}

	public String getDId() {
		return dId;
	}

	public void setDId(String dId) {
		this.dId = dId;
	}

	public String getDPasswd() {
		return dPasswd;
	}

	public void setDPasswd(String dPasswd) {
		this.dPasswd = dPasswd;
	}

	public String getDPhone() {
		return dPhone;
	}

	public void setDPhone(String dPhone) {
		this.dPhone = dPhone;
	}

	public String getDAddress() {
		return dAddress;
	}

	public void setDAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public String getDBOwner() {
		return dBOwner;
	}

	public void setDBOwner(String dBOwner) {
		this.dBOwner = dBOwner;
	}

	public String getDBNum() {
		return dBNum;
	}

	public void setDBNum(String dBNum) {
		this.dBNum = dBNum;
	}

	public String getDBName() {
		return dBName;
	}

	public void setDBName(String dBName) {
		this.dBName = dBName;
	}

	public static void setInstance(DealerVO instance) {
		DealerVO.instance = instance;
	}

	@Override
	public int hashCode() {
		return dId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DealerVO) {
			DealerVO other = (DealerVO) obj;
			if (dId.compareTo(other.dId) == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "DealerVO [dName=" + dName + ", dId=" + dId + ", dPasswd=" + dPasswd + ", dPhone=" + dPhone
				+ ", dAddress=" + dAddress + ", dBOwner=" + dBOwner + ", dBNum=" + dBNum + ", dBName=" + dBName + "]";
	}

}
