package controller;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.CdOrderDAO;
import model.CdOrderVO;
import model.CustomerDAO;
import model.CustomerVO;
import model.DataUtil;
import model.OrderChartDAO;
import model.OrderChartVO;
import model.ProductVO;
import javafx.stage.Stage;

public class SalesTradeTabController implements Initializable {
	@FXML
	private TextField txtCDNum;
	@FXML
	private TextField txtCId;
	@FXML
	private TextField txtCName;
	@FXML
	private TextField txtCPhone;
	@FXML
	private TextField txtCAddress;
	@FXML
	private TextField txtCEmail;
	@FXML
	private TextField txtCPName;
	@FXML
	private TextField txtCPPrice;
	@FXML
	private TextField txtRName;
	@FXML
	private TextField txtRPrice;
	@FXML
	private TextField txtMBName;
	@FXML
	private TextField txtMBPrice;
	@FXML
	private TextField txtGName;
	@FXML
	private TextField txtGPrice;
	@FXML
	private TextField txtSSName;
	@FXML
	private TextField txtSSPrice;
	@FXML
	private TextField txtHName;
	@FXML
	private TextField txtHPrice;
	@FXML
	private TextField txtPOName;
	@FXML
	private TextField txtPOPrice;
	@FXML
	private TextField txtCAName;
	@FXML
	private TextField txtCAPrice;
	@FXML
	private TextField txtCOName;
	@FXML
	private TextField txtCOPrice;
	@FXML
	private TextField txtSWName;
	@FXML
	private TextField txtSWPrice;
	@FXML
	private TextField txtKName;
	@FXML
	private TextField txtKPrice;
	@FXML
	private TextField txtMOName;
	@FXML
	private TextField txtMOPrice;
	@FXML
	private TextField txtSPName;
	@FXML
	private TextField txtSPPrice;
	@FXML
	private TextField txtMNName;
	@FXML
	private TextField txtMNPrice;
	@FXML
	private TextField txtTotalPrice;

	@FXML
	private Button btnOrderInsert;
	@FXML
	private Button btnIdChk;

	@FXML
	private Spinner<Integer> spinCPQty;
	@FXML
	private Spinner<Integer> spinRQty;
	@FXML
	private Spinner<Integer> spinMBQty;
	@FXML
	private Spinner<Integer> spinGQty;
	@FXML
	private Spinner<Integer> spinSSQty;
	@FXML
	private Spinner<Integer> spinHQty;
	@FXML
	private Spinner<Integer> spinPOQty;
	@FXML
	private Spinner<Integer> spinCAQty;
	@FXML
	private Spinner<Integer> spinCOQty;
	@FXML
	private Spinner<Integer> spinSWQty;
	@FXML
	private Spinner<Integer> spinKQty;
	@FXML
	private Spinner<Integer> spinMOQty;
	@FXML
	private Spinner<Integer> spinSPQty;
	@FXML
	private Spinner<Integer> spinMNQty;

	@FXML
	private Button btnCP;
	@FXML
	private Button btnR;
	@FXML
	private Button btnMB;
	@FXML
	private Button btnG;
	@FXML
	private Button btnSS;
	@FXML
	private Button btnH;
	@FXML
	private Button btnPO;
	@FXML
	private Button btnCA;
	@FXML
	private Button btnCO;
	@FXML
	private Button btnSW;
	@FXML
	private Button btnK;
	@FXML
	private Button btnMO;
	@FXML
	private Button btnSP;
	@FXML
	private Button btnMN;
	@FXML
	private Button btnAll;

	private HashMap<String, Integer> dicKey = new HashMap<String, Integer>();
	private HashMap<Button, Integer> btnKey = new HashMap<Button, Integer>();
	private TextField[] txtNameList;
	private TextField[] txtPriceList;
	private Object[] spinQtyList;

	private int keyIdx;
	private ProductVO[] pvoList;
	private CustomerDAO cdao = CustomerDAO.getInstance();
	private CdOrderDAO codao = CdOrderDAO.getInstance();
	private OrderChartDAO ocdao = OrderChartDAO.getInstance();
	private CdOrderVO covo = new CdOrderVO();
	private OrderChartVO[] ocvo;

	private Stage primaryStage;

	public void setPvo(ProductVO pvo) {
		String key = pvo.getP_num().substring(0, pvo.getP_num().indexOf("_"));
		keyIdx = dicKey.get(key);

		this.pvoList[keyIdx] = pvo;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setList();
		editable();
		reset();
	}

	/**
	 * setList() : Map을 생성하고 각 txtName의 필드들과 txtPrice의 필드들, spinQty의 필드들을 배열로 만든다.
	 */
	private void setList() {
		// Map<key, value> 설정
		String idKey[] = DataUtil.getKey("id");
		Integer idxVal[] = DataUtil.getIdxVal();
		Button[] btnCancelList = new Button[] { btnCP, btnR, btnMB, btnG, btnSS, btnH, btnPO, btnCA, btnCO, btnSW, btnK,
				btnMO, btnSP, btnMN };

		for (int i = 0; i < idKey.length; i++) {
			dicKey.put(idKey[i], idxVal[i]);
			btnKey.put(btnCancelList[i], idxVal[i]);
		}

		// 각 필드 배열 생성
		txtNameList = new TextField[] { txtCPName, txtRName, txtMBName, txtGName, txtSSName, txtHName, txtPOName,
				txtCAName, txtCOName, txtSWName, txtKName, txtMOName, txtSPName, txtMNName };
		txtPriceList = new TextField[] { txtCPPrice, txtRPrice, txtMBPrice, txtGPrice, txtSSPrice, txtHPrice,
				txtPOPrice, txtCAPrice, txtCOPrice, txtSWPrice, txtKPrice, txtMOPrice, txtSPPrice, txtMNPrice };
		spinQtyList = new Object[] { spinCPQty, spinRQty, spinMBQty, spinGQty, spinSSQty, spinHQty, spinPOQty,
				spinCAQty, spinCOQty, spinSWQty, spinKQty, spinMOQty, spinSPQty, spinMNQty };

		// 각 제품에 해당하는 pvo 배열 생성
		pvoList = new ProductVO[txtNameList.length];
		for (int i = 0; i < pvoList.length; i++) {
			pvoList[i] = new ProductVO();
		}

		// 가격의 기본 값으로 0을 설정
		for (int i = 0; i < txtPriceList.length; i++) {
			txtPriceList[i].setText(0 + "");
		}
	}

	/**
	 * btnIdChk() : ID를 체크한다.
	 * 
	 * @param event
	 */
	public void btnIdChk(ActionEvent event) {
		if (!DataUtil.validityCheck(txtCId.getText(), "ID")) {
			return;
		} else if (cdao.customerLoginOverlap(txtCId.getText())) {
			CustomerVO cvo = cdao.getCustomerSelected("c_id", txtCId.getText()).get(0);

			txtCName.setText(cvo.getC_name());
			txtCPhone.setText(cvo.getC_phone());
			txtCAddress.setText(cvo.getC_add());
			txtCEmail.setText(cvo.getC_email());

			covo.setC_num(cvo.getC_num());
			covo.setCd_num(txtCDNum.getText());
			covo.setCd_price(Integer.parseInt(txtTotalPrice.getText()));

			btnIdChk.setDisable(true);
			btnOrderInsert.setDisable(false);
		} else {
			DataUtil.showAlert("ID 체크", "일치하는 ID가 없습니다.");
		}
	}

	public void btnAllCancel(ActionEvent event) {
		txtCId.clear();
		txtCName.clear();
		txtCPhone.clear();
		txtCAddress.clear();
		txtCEmail.clear();
		
		covo = new CdOrderVO();
		reset();
	}

	/**
	 * btnCancel() : 선택된 제품을 취소한다.
	 * 
	 * @param event
	 */
	@SuppressWarnings("unchecked")
	public void btnCancel(ActionEvent event) {
		int keyIdx = btnKey.get(event.getSource());

		// 위치값에 해당하는 각 리스트의 값 초기화
		((Spinner<Integer>) spinQtyList[keyIdx]).setValueFactory(new IntegerSpinnerValueFactory(0, 999));
		txtNameList[keyIdx].clear();
		txtPriceList[keyIdx].setText("0");
		pvoList[keyIdx] = null;

		// 합계 새로고침
		setTotalPrice();
	}

	/*
	 * btnOrderInsert(ActionEvent event) : 주문 입력 이벤트
	 */
	public void btnOrderInsert(ActionEvent event) {
		// TODO order_ChartVO로 인서트 여러번 수행하도록 구현
			
//			covo의 설정까지 완료, Id 입력 시, 주문번호 자동 생성 만들기 
//			if (txtCPName.getText() != null) {
//				insertCvoSetting(txtCPName.getText(), Integer.parseInt(txtCPPrice.getText()));
//			}
//			;
//
//			if (txtRName.getText() != null) {
//				insertCvoSetting(txtRName.getText(), Integer.parseInt(txtRPrice.getText()));
//			}
//			;
//
//			if (txtMBName.getText() != null) {
//				insertCvoSetting(txtMBName.getText(), Integer.parseInt(txtMBPrice.getText()));
//			}
//			;
//
//			if (txtGName.getText() != null) {
//				insertCvoSetting(txtGName.getText(), Integer.parseInt(txtGPrice.getText()));
//			}
//			;
//
//			if (txtSSName.getText() != null) {
//				insertCvoSetting(txtSSName.getText(), Integer.parseInt(txtSSPrice.getText()));
//			}
//			;
//
//			if (txtHName.getText() != null) {
//				insertCvoSetting(txtHName.getText(), Integer.parseInt(txtHPrice.getText()));
//			}
//			;
//
//			if (txtPOName.getText() != null) {
//				insertCvoSetting(txtPOName.getText(), Integer.parseInt(txtPOPrice.getText()));
//			}
//			;
//
//			if (txtCAName.getText() != null) {
//				insertCvoSetting(txtCAName.getText(), Integer.parseInt(txtCAPrice.getText()));
//			}
//			;
//
//			if (txtCOName.getText() != null) {
//				insertCvoSetting(txtCOName.getText(), Integer.parseInt(txtCOPrice.getText()));
//			}
//			;
//
//			if (txtSWName.getText() != null) {
//				insertCvoSetting(txtSWName.getText(), Integer.parseInt(txtSWPrice.getText()));
//			}
//			;
//
//			if (txtKName.getText() != null) {
//				insertCvoSetting(txtKName.getText(), Integer.parseInt(txtKPrice.getText()));
//			}
//			;
//
//			if (txtMOName.getText() != null) {
//				insertCvoSetting(txtMOName.getText(), Integer.parseInt(txtMOPrice.getText()));
//			}
//			;
//
//			if (txtSPName.getText() != null) {
//				insertCvoSetting(txtSPName.getText(), Integer.parseInt(txtSPPrice.getText()));
//			}
//			;
//
//			if (txtMNName.getText() != null) {
//				insertCvoSetting(txtMNName.getText(), Integer.parseInt(txtMNPrice.getText()));
//			}
//			;

//		reset();
	}

	/**
	 * editable() : 필드 입력 불가 지정 메소드
	 */
	@SuppressWarnings("unchecked")
	public void editable() {
		for (int i = 0; i < txtNameList.length; i++) {
			txtNameList[i].setEditable(false);
		}

		for (int i = 0; i < txtPriceList.length; i++) {
			txtPriceList[i].setEditable(false);
		}

		for (int i = 0; i < spinQtyList.length; i++) {
			((Spinner<Integer>) spinQtyList[i]).setEditable(false);
		}

		txtCDNum.setEditable(false);
		txtCName.setEditable(false);
		txtCPhone.setEditable(false);
		txtCAddress.setEditable(false);
		txtCEmail.setEditable(false);
		txtTotalPrice.setEditable(false);
	}

	/**
	 * reset() : 전체 데이터 리셋 메소드
	 */
	public void reset() {
		for (int i = 0; i < txtNameList.length; i++) {
			txtNameList[i].clear();
		}

		for (int i = 0; i < txtPriceList.length; i++) {
			txtPriceList[i].setText("0");
		}

		btnIdChk.setDisable(false);
		btnOrderInsert.setDisable(true);
		txtTotalPrice.setText("0");
		setSpineerDefaultValue();
	}

	/**
	 * setSpineerDefaultValue() : 스피너 값 설정 메소드
	 */
	@SuppressWarnings("unchecked")
	public void setSpineerDefaultValue() {
		IntegerSpinnerValueFactory[] defQtyList = new IntegerSpinnerValueFactory[spinQtyList.length];
		for (int i = 0; i < spinQtyList.length; i++) {
			defQtyList[i] = new IntegerSpinnerValueFactory(0, 999);
			((Spinner<Integer>) spinQtyList[i]).setValueFactory(defQtyList[i]);
		}
	}

	/*
	 * setTotalPrice() : 총 금액 자동입력 메소드
	 */
	public void setTotalPrice() {
		int resultPrice = 0;

		for (int i = 0; i < txtPriceList.length; i++) {
			resultPrice += Integer.parseInt((txtPriceList[i].getText()));
		}

		String resultSet = resultPrice + "";
		txtTotalPrice.setText(resultSet);

	}

	/*
	 * setProductPriceAction(MouseEvent event) 제품별 가격 변동 메소드
	 */
	@SuppressWarnings("unchecked")
	public void setProductPriceAction(MouseEvent event) {
		// 눌린 버튼의 객체에 해당하는 위치 값을 가져온다.
		int keyIdx = 0;

		for (int i = 0; i < spinQtyList.length; i++) {
			if (event.getSource() == spinQtyList[i]) {
				keyIdx = i;
				break;
			}
		}

		// pvo를 받으면 각 텍스트에 단가 설정
		for (int i = 0; i < pvoList.length; i++) {
			// 스핀에 입력되어 있는 값을 가져온다.
			int spinVal = ((Spinner<Integer>) spinQtyList[i]).getValue();

			// 해당 위치의 제품이 비어있으면 경고창 출력, 아니면 가격 계산
			if (spinVal == 1 && pvoList[keyIdx].getP_price() == 0) {
				((Spinner<Integer>) spinQtyList[keyIdx]).setValueFactory(new IntegerSpinnerValueFactory(0, 999));
				DataUtil.showAlert("제품 선택", "제품을 선택해주세요.");
			} else if (spinVal > 0) {
				txtPriceList[i].setText(pvoList[i].getP_price() + "");
			}
		}

		// 입력된 값 * 스핀값
		for (int i = 0; i < txtPriceList.length; i++) {
			txtPriceList[i].setText(
					(Integer.parseInt(txtPriceList[i].getText())) * (((Spinner<Integer>) spinQtyList[i]).getValue())
							+ "");
		}

		setTotalPrice();
	}

	public void setField() {
		txtNameList[keyIdx].setText(pvoList[keyIdx].getP_name());
	}
}