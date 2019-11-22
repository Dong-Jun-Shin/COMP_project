package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.CdChartDAO;
import model.CdChartVO;
import model.CdOrderDAO;
import model.CdOrderVO;
import model.CustomerDAO;
import model.CustomerVO;
import model.DataUtil;
import model.ProductDAO;

public class ManageOrderTabController implements Initializable {
	@FXML
	private Label lblCDNum;
	@FXML
	private Button btnOrderComplete;
	@FXML
	private Button btnOrderCancel;
	@FXML
	private TableView<CdChartVO> orderProgressView;
	@FXML
	private TableView<CdChartVO> orderHistoryView;

	String selectedCdOrderIndex;

	private static ObservableList<CdChartVO> progressDataList = FXCollections.observableArrayList();
	private static ObservableList<CdChartVO> historyDataList = FXCollections.observableArrayList();

	private CdOrderDAO cddao = CdOrderDAO.getInstance();
	private CdChartDAO ccdao = CdChartDAO.getInstance(); 
	
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 테이블뷰의 컬럼이름이 될 필드명을 가져온다.
		List<String> title = DataUtil.fieldName(new CdChartVO());

		// 설정을 받을 Table의 열
		for (int i = 0; i < title.size(); i++) {
			TableColumn<CdChartVO, ?> columnPName = orderProgressView.getColumns().get(i);
			columnPName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
			
			TableColumn<CdChartVO, ?> columnHName = orderHistoryView.getColumns().get(i);
			columnHName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}

		// 테이블에 항목 설정
		orderProgressView.setItems(progressDataList);
		orderHistoryView.setItems(historyDataList);
		
		progressTotalList();
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
	
	private void progressTotalList() {
		progressDataList.removeAll(progressDataList);
		CdChartVO ccvo = null;
		ArrayList<CdChartVO> list;

		try {
			list = ccdao.getProgressOrderList();

			for (int index = 0; index < list.size(); index++) {
				// 결과 리스트에서 한 행을 가져다가 svo에 대입
				ccvo = list.get(index);
				// 한 행을 추가
				progressDataList.add(ccvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("progressTotalList() = [" + e.getMessage() + "]");
		}
	}

	private void historyTotalList() {
		
	}
}
