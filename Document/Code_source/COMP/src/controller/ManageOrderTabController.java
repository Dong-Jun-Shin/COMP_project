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
import model.DataUtil;

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

	String selectedCdChartIndex;

	private static ObservableList<CdChartVO> progressDataList = FXCollections.observableArrayList();
	private static ObservableList<CdChartVO> historyDataList = FXCollections.observableArrayList();

	private CdOrderDAO codao = CdOrderDAO.getInstance();
	private CdChartDAO ccdao = CdChartDAO.getInstance();

	@SuppressWarnings("unused")
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

		setBtn(false);
		progressTotalList();
		historyTotalList();
	}

	public void btnOrderComplete(ActionEvent event) {
		boolean success = false;
		try {
			if (!DataUtil.valLimitCheck(lblCDNum.getText(), 10) || lblCDNum.getText().equals("(주문번호)")) {
				DataUtil.showAlert("주문 선택", "수정할 주문건을 더블클릭해주세요.");
				return;
			} else {
				CdOrderVO covo = new CdOrderVO();
				covo.setCd_num(lblCDNum.getText().trim());
				covo.setCd_sort("거래완료");

				success = codao.cd_orderUpdate(covo);

				if (success == true) {
					DataUtil.showInfoAlert("주문 처리 결과", "[" + lblCDNum.getText() + "]의 처리를 완료하였습니다.");
					reset();
				} else {
					DataUtil.showInfoAlert("주문 처리 결과", "주문의 처리에 문제가 있어 완료하지 못하였습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void btnOrderCancel(ActionEvent event) {
		boolean success = false;
		try {
			if (!DataUtil.valLimitCheck(lblCDNum.getText(), 10) || lblCDNum.getText().equals("(주문번호)")) {
				DataUtil.showAlert("주문 선택", "수정할 주문건을 더블클릭해주세요.");
				return;
			} else {
				CdOrderVO covo = new CdOrderVO();
				covo.setCd_num(lblCDNum.getText().trim());
				covo.setCd_sort("거래취소");

				success = codao.cd_orderUpdate(covo);

				if (success == true) {
					DataUtil.showInfoAlert("주문 처리 결과", "[" + lblCDNum.getText() + "]의 처리를 완료하였습니다.");
					reset();
				} else {
					DataUtil.showInfoAlert("주문 처리 결과", "주문의 처리에 문제가 있어 완료하지 못하였습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO 이메일 전송 구현하기
		/*
		 * 이메일 전송 (판매자 이메일 -> 고객 이메일) 제목 : '구매자명'님, 주문이 취소되었습니다. 본문 : 고객 - 성함, 연락처, 주소
		 * 제품 - 제품명, 개수, 금액 ------------------- 환불 금액
		 */
	}

	public void orderProgressView(MouseEvent event) {
		if (event.getClickCount() == 2) {
			CdChartVO selectCdChart = orderProgressView.getSelectionModel().getSelectedItem();
			if (selectCdChart != null) {
				selectedCdChartIndex = selectCdChart.getCd_num();

				lblCDNum.setText(selectCdChart.getCd_num());

				setBtn(true);
			}
		}
	}

	public void progressTotalList() {
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

	public void historyTotalList() {
		historyDataList.removeAll(historyDataList);
		CdChartVO ccvo = null;
		ArrayList<CdChartVO> list;

		try {
			list = ccdao.getHistoryOrderList();

			for (int index = 0; index < list.size(); index++) {
				// 결과 리스트에서 한 행을 가져다가 svo에 대입
				ccvo = list.get(index);
				// 한 행을 추가
				historyDataList.add(ccvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("historyTotalList() = [" + e.getMessage() + "]");
		}
	}

	private void setBtn(boolean bool) {
		btnOrderComplete.setDisable(!bool);
		btnOrderCancel.setDisable(!bool);
	}

	private void reset() {
		lblCDNum.setText("(주문번호)");
		selectedCdChartIndex = null;
		setBtn(false);
		progressTotalList();
		historyTotalList();
	}
}
