package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.CustomerDAO;
import model.CustomerVO;
import model.DataUtil;
import model.TraderVO;

public class ManageCustomerTabController implements Initializable {
	@FXML
	private TextField txtCNum;
	@FXML
	private TextField txtCName;
	@FXML
	private TextField txtCId;
	@FXML
	private PasswordField pwCPasswd;
	@FXML
	private TextField txtCPhone;
	@FXML
	private TextField txtCAddress;
	@FXML
	private TextField txtCBrith;
	@FXML
	private TextField txtCEmail;
	@FXML
	private Button btnCInsert;
	@FXML
	private Button btnCUpdate;
	@FXML
	private Button btnCDelete;
	@FXML
	private Button btnCClear;
	@FXML
	private ComboBox<String> cmbCSearchKey;
	@FXML
	private TextField txtCSearchValue;
	@FXML
	private Button btnCSearch;
	@FXML
	private TableView<CustomerVO> customerTableView;

	String selectedTraderIndex;

	private static ObservableList<CustomerVO> traderDataList = FXCollections.observableArrayList();

	private CustomerDAO cdao = CustomerDAO.getInstance();

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setCNum(MouseEvent event) {
		StringBuffer sb = new StringBuffer();
		sb.append("C_");
		sb.append(cdao.getCustomerCount());
		txtCNum.setText(sb.toString());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		reset();
		setInsertBtn(true);

		//// 테이블뷰 컬럼이름 설정
		List<String> title = DataUtil.fieldName(new TraderVO());

		// 설정을 받을 Table의 열
		for (int i = 0; i < title.size(); i++) {
			TableColumn<CustomerVO, ?> columnName = customerTableView.getColumns().get(i);
			// setCellValueFactory(obj) : objdp 있는 열로 테이블의 열을 설정해준다.
			// new PropertyValueFactory<>() : 값을 가질 수 있는 열로 만든다.
			columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}

		// 테이블에 항목 설정
		customerTableView.setItems(traderDataList);

		// 콤보박스 설정
		setCbxList();

		// 거래처 전체 목록
		customerTotalList();
	}

	public void btnCInsert(ActionEvent event) {
		boolean success = false;
		StringBuffer sb = new StringBuffer();

		// Date형식으로 변환
		if (DataUtil.validityCheck(txtCBrith.getText(), "생일")) {
			String s_birth = txtCBrith.getText().trim();
			sb.append(s_birth.substring(0, 4));
			sb.append("-");
			sb.append(s_birth.substring(4, 6));
			sb.append("-");
			sb.append(s_birth.substring(6, 8));
		}else {
			DataUtil.showAlert("생일 입력 또는 선택필요.", "공백 입력 불가.");
		}

		try {
			if (!DataUtil.validityCheck(txtCNum.getText(), "고객번호")) {
				return;
			} else if (!DataUtil.validityCheck(txtCName.getText(), "고객명")
					|| !DataUtil.valLimitCheck(txtCName.getText(), 12)) {
				return;
			} else if (!DataUtil.validityCheck(txtCId.getText(), "ID")
					|| !DataUtil.valLimitCheck(txtCId.getText(), 30)) {
				return;
			} else if (!DataUtil.validityCheck(pwCPasswd.getText(), "PW")
					|| !DataUtil.valLimitCheck(pwCPasswd.getText(), 30)) {
				return;
			} else if (!DataUtil.validityCheck(txtCPhone.getText(), "전화번호")
					|| !DataUtil.valLimitCheck(txtCPhone.getText(), 13)) {
				return;
			} else if (txtCAddress.getText().equals("") && !DataUtil.valLimitCheck(txtCAddress.getText(), 60)) {
				DataUtil.validityCheck("", "주소");
			} else if (!DataUtil.validityCheck(txtCEmail.getText(), "이메일")
					|| !DataUtil.valLimitCheck(txtCEmail.getText(), 30)) {
				return;
			} else {
				CustomerVO cvo = new CustomerVO();
				cvo.setC_num(txtCNum.getText().trim());
				cvo.setC_name(txtCName.getText().trim());
				cvo.setC_id(txtCId.getText().trim());
				cvo.setC_pw(pwCPasswd.getText().trim());
				cvo.setC_phone(txtCPhone.getText().trim());
				cvo.setC_add(txtCAddress.getText().trim());
				cvo.setC_birth(sb.toString());
				cvo.setC_email(txtCEmail.getText().trim());

				success = cdao.customerInsert(cvo);

				if (success == true) {
					DataUtil.showInfoAlert("거래처 등록 결과", "[" + txtCName.getText() + "]의 수정을 성공하였습니다.");
					customerTotalList();
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

	public void btnCUpdate(ActionEvent event) {
		boolean success = false;
		try {
			if (!DataUtil.validityCheck(txtCNum.getText(), "고객번호")) {
				return;
			} else if (!DataUtil.validityCheck(txtCName.getText(), "고객명")
					|| !DataUtil.valLimitCheck(txtCName.getText(), 12)) {
				return;
			} else if (!DataUtil.validityCheck(txtCId.getText(), "ID")
					|| !DataUtil.valLimitCheck(txtCId.getText(), 30)) {
				return;
			} else if (!DataUtil.validityCheck(pwCPasswd.getText(), "PW")
					|| !DataUtil.valLimitCheck(pwCPasswd.getText(), 30)) {
				return;
			} else if (!DataUtil.validityCheck(txtCPhone.getText(), "전화번호")
					|| !DataUtil.valLimitCheck(txtCPhone.getText(), 13)) {
				return;
			} else if (txtCAddress.getText().equals("") && !DataUtil.valLimitCheck(txtCAddress.getText(), 60)) {
				DataUtil.validityCheck("", "주소");
			} else if (!DataUtil.validityCheck(txtCEmail.getText(), "이메일")
					|| !DataUtil.valLimitCheck(txtCEmail.getText(), 30)) {
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

	public void btnCDelete(ActionEvent event) {
		
	}

	public void btnCClear(ActionEvent event) {
		
	}

	public void btnCSearch(ActionEvent event) {

	}

	public void customerTableView(MouseEvent event) {

	}
}
