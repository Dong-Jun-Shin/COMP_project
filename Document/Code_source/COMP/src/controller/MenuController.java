package controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MenuController {
	public static void menuClose() {
		Platform.exit();
	}

	public static void menuConnectInfo() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("문의하기");

		StringBuffer sb = new StringBuffer();
		sb.append("업체명\t: (주)훈민\n");
		sb.append("전화번호\t: 02-3333-1144\n");
		sb.append("이메일\t: progDev@dev2.com\n");
		sb.append("영업시간\t: 오전 9시 ~ 오후 6시");
		
		alert.setContentText(sb.toString());
		alert.showAndWait();
	}

	public static void menuProgramInfo() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("프로그램 정보");

		StringBuffer sb = new StringBuffer();
		sb.append("프로그램명\t: Component Order Management Program\n");
		sb.append("버전\t: Ver.1.0\n");
		
		alert.setContentText(sb.toString());
		alert.showAndWait();
	}
}
