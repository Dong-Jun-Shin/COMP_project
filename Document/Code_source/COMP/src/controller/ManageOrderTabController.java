package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.CustomerVO;
import model.DataUtil;

public class ManageOrderTabController implements Initializable {
	@FXML
	private Label lblCDNum;
	@FXML
	private Button btnOrderComplete;
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
		// 테이블뷰의 컬럼이름이 될 필드명을 가져온다.
		ArrayList<String> colList = new ArrayList<String>();
		colList.add("cd_sort");
		colList.add("cd_num");
		colList.add("c_id");
		colList.add("c_name");
		colList.add("c_phone");
		colList.add("c_add");
		colList.add("c_email");
		colList.add("cd_num");
		colList.add("cd_num");
		colList.add("cd_num");
		colList.add("cd_num");
		colList.add("cd_num");
		colList.add("cd_num");
		colList.add("cd_num");
		colList.add("cd_num");
		colList.add("cd_num");
		
		List<String> title = DataUtil.fieldName(new CustomerVO());

		// 설정을 받을 Table의 열
		for (int i = 0; i < title.size(); i++) {
			TableColumn<CustomerVO, ?> columnName = customerTableView.getColumns().get(i);
			columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}

		// 테이블에 항목 설정
		customerTableView.setItems(customerDataList);
	}

	public void btnOrderComplete(ActionEvent event) {

	}

	public void btnOrderCancel(ActionEvent event) {
		// TODO 이메일 전송 구현하기
		/*
		 * 이메일 전송 (판매자 이메일 -> 고객 이메일) 제목 : '구매자명'님, 주문이 취소되었습니다. 본문 : 고객 - 성함, 연락처, 주소
		 * 제품 - 제품명, 개수, 금액 ------------------- 환불 금액
		 */
	}

	public void orderProgressView(MouseEvent event) {

	}

	public void orderHistoryView(MouseEvent event) {

	}
}
