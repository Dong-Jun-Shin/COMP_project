package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataUtil extends NumberFormatException {
	private static final long serialVersionUID = -598464327373022988L;

	/**
	 * fieldName(Object obj) : 파일 유효성 검사 메소드
	 * 
	 * @param obj (Object) : 검사 대상
	 * @return List<String>
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<String> fieldName(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		List<String> result = new ArrayList();
		for (int i = 0; i < fields.length; i++) {
			try {
				result.add(fields[i].getName());
			} catch (Exception e) {
				System.out.println("[   fieldName(Object obj)  ]");
				e.printStackTrace();
				return null;
			}
		}
		return result;
	}

	/**
	 * validityCheck(String value, String data) : 값 입력 체크 메소드
	 * 
	 * @param value (String) : 입력 대상
	 * @param data  (String) : 출력문
	 * @return boolean
	 */
	public static boolean validityCheck(String value, String data) {
		boolean result = true;
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("입력 여부 확인");
		// 입력값 공백 여부 확인
		if (isBlank(value)) {
			alert.setHeaderText(data + " 입력 또는 선택필요.");
			alert.setContentText("공백 입력 불가.");
			alert.showAndWait();
			result = false;
		}
		return result;
	}

	/**
	 * isBlank(String str) : 공백 여부 확인 메소드
	 * 
	 * @param str (String) : 확인 대상
	 * @return boolean
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * valLimitCheck() : 각 자리의 데이터 범위 유효여부를 체크 (name, id, pw, phone, address, email,
	 * bNum)
	 * 
	 * @param value     확인할 데이터 문자열
	 * @param fieldName 데이터 범위의 기준 (이름, id, 전화번호...)
	 * @return result 이상 없으면 true
	 */
	public static boolean valLimitCheck(String value, int size) {
		Alert alert = new Alert(AlertType.WARNING);
		boolean result = true;
		byte limit = 0;

		limit = (byte) size;

		// 유효하지 않으면 경고
		if (value.getBytes().length > limit) {
			result = false;
			alert.setHeaderText("입력 오류");
			alert.setContentText("입력된 내용의 글자 수가 너무 큽니다.\n좀 더 짧게 해주세요.");
			alert.showAndWait();
		}

		return result;
	}

	/**
	 * dateCheck() : Date형식 체크 및 변환
	 * 
	 * @param date 체크할 날짜를 받는다.
	 * @return sb "YYYY-MM-DD"로 변환된 StringBuffer를 반환
	 * @throws NumberFormatException 받은 문자열이 공백을 포함하거나, 형식에 맞지 않으면 발생
	 */
	public static StringBuffer dateCheck(String date) {
		StringBuffer sb = new StringBuffer();
		
		try {
			if (DataUtil.validityCheck(date, "생일")) {
				String s_birth = date.trim();
				String s_year = s_birth.substring(0, 4);
				String s_month = s_birth.substring(5, 7);
				String s_day = s_birth.substring(8, 10);

				// 유효한 날짜인지 범위 체크
				if (!(Integer.parseInt(s_year) < 10000 && Integer.parseInt(s_year) > 0)) {
					throw new NumberFormatException();
				} else if (!(Integer.parseInt(s_month) < 13 && Integer.parseInt(s_month) > 0)) {
					throw new NumberFormatException();
				} else if (!(Integer.parseInt(s_day) < 32 && Integer.parseInt(s_day) > 0)) {
					throw new NumberFormatException();
				}

				sb.append(s_year);
				sb.append("-");
				sb.append(s_month);
				sb.append("-");
				sb.append(s_day);
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException nfe) {
			DataUtil.showAlert("날짜 입력 오류", "날짜를 'YYYY-MM-DD'의 형식으로 쓰고, 년월일의 범위 안으로 입력해주세요.\n월(1~12), 일(1~31)");
			return null;
		}
		
		return sb;
	}

	public static String[] getKey(String sel) {
		String key[];
		switch (sel) {
		case "id":
			key = new String[] { "CP", "R", "MB", "G", "SS", "H", "PO", "CA", "CO", "SW", "K", "MO", "SP", "MN" };
			break;
		case "pSort":
			key = new String[] { "CPU", "RAM", "MB", "GPU", "SSD", "HDD", "파워", "케이스", "쿨러", "SW", "키보드", "마우스", "스피커",
					"모니터" };
			break;
		default:
			key = null;
			break;
		}

		return key;
	}

	public static Integer[] getIdxVal() {
		Integer idxVal[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		return idxVal;
	}

	/**
	 * showAlert() : 경고창을 보여준다.
	 * 
	 * @param head    제목
	 * @param content 내용
	 */
	public static void showAlert(String head, String content) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText(head);
		alert.setContentText(content);
		alert.showAndWait();
	}

	/**
	 * showInfoAlert() : 알림창을 보여준다.
	 * 
	 * @param head    제목
	 * @param content 내용
	 */
	public static void showInfoAlert(String head, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(head);
		alert.setContentText(content);
		alert.showAndWait();
	}
}
