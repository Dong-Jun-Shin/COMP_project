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
import model.CD_OrderVO;
import model.CD_orderDAO;
import model.DataUtil;
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

	private HashMap<String, Integer> dicKey = new HashMap<String, Integer>();
	private TextField[] txtNameList;
	private TextField[] txtPriceList;
	private Object[] spinQtyList;

	private int keyIdx;
	private ProductVO[] pvoList;
	private CD_orderDAO cddao;
	private CD_OrderVO cvo;
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
		String idKey[] = { "CP", "R", "MB", "G", "SS", "H", "PO", "CA", "CO", "SW", "K", "MO", "SP", "MN" };
		Integer idVal[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		for (int i = 0; i < idKey.length; i++) {
			dicKey.put(idKey[i], idVal[i]);
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

		// 가격의 기본 값으로 0을 설정
		for (int i = 0; i < idVal.length; i++) {
			txtPriceList[i].setText(0 + "");
		}
	}

	/*
	 * btnOrderInsert(ActionEvent event) : 주문 입력 이벤트
	 */
	public void btnOrderInsert(ActionEvent event) {
		//TODO order_ChartVO로 인서트 여러번 수행하도록 구현

		if (!DataUtil.validityCheck(txtCDNum.getText(), "주문번호")) {
			return;
		} else if (!DataUtil.validityCheck(txtCId.getText(), "ID")) {
			return;
		} else if (!DataUtil.validityCheck(txtCName.getText(), "고객명")) {
			return;
		} else if (!DataUtil.validityCheck(txtCPhone.getText(), "전화번호")) {
			return;
		} else if (!DataUtil.validityCheck(txtCAddress.getText(), "주소")) {
			return;
		} else if (!DataUtil.validityCheck(txtCEmail.getText(), "이메일")) {
			return;
		} else {
			cvo = new CD_OrderVO();

			if (txtCPName.getText() != null) {
				insertCvoSetting(txtCPName.getText(), Integer.parseInt(txtCPPrice.getText()));
			}
			;

			if (txtRName.getText() != null) {
				insertCvoSetting(txtRName.getText(), Integer.parseInt(txtRPrice.getText()));
			}
			;

			if (txtMBName.getText() != null) {
				insertCvoSetting(txtMBName.getText(), Integer.parseInt(txtMBPrice.getText()));
			}
			;

			if (txtGName.getText() != null) {
				insertCvoSetting(txtGName.getText(), Integer.parseInt(txtGPrice.getText()));
			}
			;

			if (txtSSName.getText() != null) {
				insertCvoSetting(txtSSName.getText(), Integer.parseInt(txtSSPrice.getText()));
			}
			;

			if (txtHName.getText() != null) {
				insertCvoSetting(txtHName.getText(), Integer.parseInt(txtHPrice.getText()));
			}
			;

			if (txtPOName.getText() != null) {
				insertCvoSetting(txtPOName.getText(), Integer.parseInt(txtPOPrice.getText()));
			}
			;

			if (txtCAName.getText() != null) {
				insertCvoSetting(txtCAName.getText(), Integer.parseInt(txtCAPrice.getText()));
			}
			;

			if (txtCOName.getText() != null) {
				insertCvoSetting(txtCOName.getText(), Integer.parseInt(txtCOPrice.getText()));
			}
			;

			if (txtSWName.getText() != null) {
				insertCvoSetting(txtSWName.getText(), Integer.parseInt(txtSWPrice.getText()));
			}
			;

			if (txtKName.getText() != null) {
				insertCvoSetting(txtKName.getText(), Integer.parseInt(txtKPrice.getText()));
			}
			;

			if (txtMOName.getText() != null) {
				insertCvoSetting(txtMOName.getText(), Integer.parseInt(txtMOPrice.getText()));
			}
			;

			if (txtSPName.getText() != null) {
				insertCvoSetting(txtSPName.getText(), Integer.parseInt(txtSPPrice.getText()));
			}
			;

			if (txtMNName.getText() != null) {
				insertCvoSetting(txtMNName.getText(), Integer.parseInt(txtMNPrice.getText()));
			}
			;

		}

		reset();
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

		txtTotalPrice.setText("0");
		setSpineerDefaultValue();
	}

	/**
	 * setSpineerDefaultValue() : 스피너 값 설정 메소드
	 */
	@SuppressWarnings("unchecked")
	public void setSpineerDefaultValue() {
		IntegerSpinnerValueFactory[] defQtyList = new IntegerSpinnerValueFactory[spinQtyList.length];
		for (int i = 0; i < defQtyList.length; i++) {
			defQtyList[i] = new IntegerSpinnerValueFactory(0, 999);
		}

		for (int i = 0; i < spinQtyList.length; i++) {
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
		// pvo를 받으면 각 텍스트에 단가 설정
		for (int i = 0; i < pvoList.length; i++) {
			if (((Spinner<Integer>) spinQtyList[i]).getValue() > 0) {
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

	public void insertCvoSetting(String p_num, int cd_price) {
		cvo.setC_num(p_num);
		cvo.setCd_price(cd_price);
		cddao.cd_orderInsert(cvo);
	}

	public void setField() {
		txtNameList[keyIdx].setText(pvoList[keyIdx].getP_name());
	}
}