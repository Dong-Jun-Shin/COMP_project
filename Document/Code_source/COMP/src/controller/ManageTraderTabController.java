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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.DataUtil;
import model.TraderDAO;
import model.TraderVO;

public class ManageTraderTabController implements Initializable {
	@FXML
	private TextField txtTRNum;
	@FXML
	private TextField txtTRName;
	@FXML
	private TextField txtTRPhone;
	@FXML
	private TextField txtTRAddress;
	@FXML
	private TextField txtTRBOwner;
	@FXML
	private TextField txtTRBNum;
	@FXML
	private TextField txtTRBName;
	@FXML
	private Button btnTRInsert;
	@FXML
	private Button btnTRUpdate;
	@FXML
	private Button btnTRDelete;
	@FXML
	private Button btnTRClear;
	@FXML
	private ComboBox<String> cbxTRSearchKey;
	@FXML
	private TextField txtTRSearchValue;
	@FXML
	private Button btnTRSearch;
	@FXML
	private TableView<TraderVO> traderTableView;

	String selectedTraderIndex;

	private static ObservableList<TraderVO> traderDataList = FXCollections.observableArrayList();

	private TraderDAO trdao = TraderDAO.getInstance();

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setTRNum(MouseEvent event) {
		StringBuffer sb = new StringBuffer();
		sb.append("TR_");
		sb.append(trdao.getTraderCount());
		txtTRNum.setText(sb.toString());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		reset();
		setInsertBtn(true);

		//// 테이블뷰 컬럼이름 설정
		List<String> title = DataUtil.fieldName(new TraderVO());

		// 설정을 받을 Table의 열
		for (int i = 0; i < title.size(); i++) {
			TableColumn<TraderVO, ?> columnName = traderTableView.getColumns().get(i);
			// setCellValueFactory(obj) : objdp 있는 열로 테이블의 열을 설정해준다.
			// new PropertyValueFactory<>() : 값을 가질 수 있는 열로 만든다.
			columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}

		// 테이블에 항목 설정
		traderTableView.setItems(traderDataList);

		// 콤보박스 설정
		setCbxList();

		// 학과 전체 목록
		traderTotalList();
	}

	public void btnTRInsert(ActionEvent event) {
		boolean success = false;

		try {
			if (!DataUtil.validityCheck(txtTRNum.getText(), "거래처번호")) {
				return;
			} else if (!DataUtil.validityCheck(txtTRName.getText(), "거래처명")) {
				return;
			} else if (!DataUtil.validityCheck(txtTRPhone.getText(), "전화번호")) {
				return;
			} else if (txtTRAddress.getText().equals("")) {
				DataUtil.validityCheck("", "주소를");
			} else if (!DataUtil.validityCheck(txtTRBOwner.getText(), "계좌주")) {
				return;
			} else if (!DataUtil.bankNumCheck(txtTRBNum.getText(), "계좌번호")) {
				return;
			} else if (!DataUtil.validityCheck(txtTRBName.getText(), "계좌은행")) {
				return;
			} else {
				TraderVO tvo = new TraderVO();
				tvo.setTr_num(txtTRNum.getText().trim());
				tvo.setTr_name(txtTRName.getText().trim());
				tvo.setTr_phone(txtTRPhone.getText().trim());
				tvo.setTr_add(txtTRAddress.getText().trim());
				tvo.setTr_bowner(txtTRBOwner.getText().trim());
				tvo.setTr_bnum(txtTRBNum.getText().trim());
				tvo.setTr_bname(txtTRBName.getText().trim());

				success = trdao.traderInsert(tvo);

				if (success == true) {
					DataUtil.showInfoAlert("거래처 등록 결과", "[" + txtTRName.getText() + "]의 수정을 성공하였습니다.");
					traderTotalList();
					reset();
					editable(true);
					setInsertBtn(true);
				} else {
					DataUtil.showInfoAlert("거래처 등록 결과", "거래처의 정보 등록에 문제가 있어 완료하지 못하였습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void btnTRUpdate(ActionEvent event) {
		boolean success = false;
		try {
			if (!DataUtil.validityCheck(txtTRNum.getText(), "거래처번호")) {
				return;
			} else if (!DataUtil.validityCheck(txtTRName.getText(), "거래처명")) {
				return;
			} else if (!DataUtil.validityCheck(txtTRPhone.getText(), "전화번호")) {
				return;
			} else if (txtTRAddress.getText().equals("")) {
				DataUtil.validityCheck("", "주소를");
			} else if (!DataUtil.validityCheck(txtTRBOwner.getText(), "계좌주")) {
				return;
			} else if (!DataUtil.bankNumCheck(txtTRBNum.getText(), "계좌번호")) {
				return;
			} else if (!DataUtil.validityCheck(txtTRBName.getText(), "계좌은행")) {
				return;
			} else {

				TraderVO tvo = new TraderVO();
				tvo.setTr_num(txtTRNum.getText());
				tvo.setTr_name(txtTRName.getText());
				tvo.setTr_phone(txtTRPhone.getText());
				tvo.setTr_add(txtTRAddress.getText());
				tvo.setTr_bowner(txtTRBOwner.getText());
				tvo.setTr_bnum(txtTRBNum.getText());
				tvo.setTr_bname(txtTRBName.getText());

				success = trdao.traderUpdate(tvo);

				if (success == true) {
					DataUtil.showInfoAlert("거래처 수정 결과", "[" + txtTRName.getText() + "]의 수정을 성공하였습니다.");
					traderTotalList();
					reset();
					editable(true);
					setInsertBtn(true);
				} else {
					DataUtil.showInfoAlert("거래처 수정 결과", "거래처의 정보 등록에 문제가 있어 수정을 완료하지 못하였습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void btnTRDelete(ActionEvent event) {
		boolean success = false;
		try {
			TraderVO tvo = new TraderVO();
			tvo.setTr_num(selectedTraderIndex);
			success = trdao.traderDelete(tvo);
		} catch (Exception e) {
			System.out.println("btnDelete() = [ " + e + " ]");
			e.printStackTrace();
		}

		if (success == true) {
			DataUtil.showInfoAlert("거래처 삭제 결과", "[" + txtTRName.getText() + "]의 삭제를 성공하였습니다.");
			traderTotalList();
			reset();
			editable(true);
			setInsertBtn(true);
		} else {
			DataUtil.showInfoAlert("거래처 삭제 결과", "문제가 있어 삭제를 완료하지 못하였습니다.");
		}
	}

	public void btnTRClear(ActionEvent event) {
		//콤보박스 초기화
		cbxTRSearchKey.getSelectionModel().clearSelection();
		
		//테이블 인덱스 초기화
		traderTableView.getSelectionModel().select(null);
		selectedTraderIndex = null;
		
		//필드 초기화
		txtTRSearchValue.setText("");
		reset();
		
		//버튼 제어 초기화
		editable(true);
		setInsertBtn(true);
		
		//테이블 뷰 전체 리스트 출력
		traderTotalList();
	}
	
	public void btnTRSearch(ActionEvent event) {
		traderDataList.removeAll(traderDataList);
		TraderVO tvo = null;
		ArrayList<TraderVO> list;

		try {
			switch (cbxTRSearchKey.getValue().toString()) {
			case "거래처번호":
				list = trdao.getTraderSelected("tr_num", txtTRSearchValue.getText());
				break;

			case "거래처명":
				list = trdao.getTraderSelected("tr_name", txtTRSearchValue.getText());
				break;

			case "계좌주":
				list = trdao.getTraderSelected("tr_bowner", txtTRSearchValue.getText());
				break;

			default:
				list = trdao.getTraderTotalList();
				break;
			}

			for (int index = 0; index < list.size(); index++) {
				// 결과 리스트에서 한 행을 가져다가 tvo에 대입
				tvo = list.get(index);
				// 한 행을 추가
				traderDataList.add(tvo);
			}
		} catch (Exception e) {
			System.out.println("traderTotalList() = [" + e.getMessage() + "]");
		}
	}

	public void traderTableView(MouseEvent event) {
		if (event.getClickCount() == 2) {
			TraderVO selectTrader = traderTableView.getSelectionModel().getSelectedItem();
			if (selectTrader != null) {
				selectedTraderIndex = selectTrader.getTr_num();

				txtTRNum.setText(selectTrader.getTr_num());
				txtTRName.setText(selectTrader.getTr_name());
				txtTRPhone.setText(selectTrader.getTr_phone());
				txtTRAddress.setText(selectTrader.getTr_add());
				txtTRBOwner.setText(selectTrader.getTr_bowner());
				txtTRBNum.setText(selectTrader.getTr_bnum());
				txtTRBName.setText(selectTrader.getTr_bname());

				setInsertBtn(false);
				txtTRNum.setEditable(false);
				txtTRName.setEditable(false);
			}
		}
	}

	private void editable(boolean bool) {
		txtTRNum.setEditable(bool);
		txtTRName.setEditable(bool);
		txtTRPhone.setEditable(bool);
		txtTRAddress.setEditable(bool);
		txtTRBOwner.setEditable(bool);
		txtTRBNum.setEditable(bool);
		txtTRBName.setEditable(bool);
	}

	/**
	 * reset() : 각 필드값 지우기
	 */
	private void reset() {
		txtTRNum.clear();
		txtTRName.clear();
		txtTRPhone.clear();
		txtTRAddress.clear();
		txtTRBOwner.clear();
		txtTRBNum.clear();
		txtTRBName.clear();
	}

	/**
	 * setInsertBtn() : 버튼의 활성화를 제어
	 * 
	 * @param bool true면 등록 활성화, false면 수정과 삭제 활성화
	 */
	private void setInsertBtn(boolean bool) {
		btnTRInsert.setDisable(!bool);
		btnTRUpdate.setDisable(bool);
		btnTRDelete.setDisable(bool);
	}

	/**
	 * traderTotalList() : 테이블뷰 레코드 출력(거래처 전체 리스트)
	 * 
	 */
	private void traderTotalList() {
		traderDataList.removeAll(traderDataList);
		TraderVO svo = null;
		ArrayList<TraderVO> list;

		try {
			list = trdao.getTraderTotalList();

			for (int index = 0; index < list.size(); index++) {
				// 결과 리스트에서 한 행을 가져다가 svo에 대입
				svo = list.get(index);
				// 한 행을 추가
				traderDataList.add(svo);
			}
		} catch (Exception e) {
			System.out.println("traderTotalList() = [" + e.getMessage() + "]");
		}
	}

	public void setCbxList() {
		cbxTRSearchKey.setItems(FXCollections.observableArrayList("거래처번호", "거래처명", "계좌주"));
	}
}
