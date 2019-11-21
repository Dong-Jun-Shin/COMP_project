package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManageOrderTabController implements Initializable {
	@FXML
	private Label lblCDNum;
	@FXML
	private Button btnOrderCancel;
	@FXML
	private TableView orderProgressView;
	@FXML
	private TableView orderHistoryView;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void btnOrderCancel(ActionEvent event) {
		//TODO 이메일 전송 구현하기 
		/* 이메일 전송 (판매자 이메일 -> 고객 이메일)
		 * 제목 : '구매자명'님, 주문이 취소되었습니다.
		 * 본문 : 고객 - 성함, 연락처, 주소
		 * 		제품 - 제품명, 개수, 금액
		 * 		------------------- 
		 * 			환불 금액
		 */
	}

	public void orderProgressView(MouseEvent event) {

	}

	public void orderHistoryView(MouseEvent event) {

	}
}
