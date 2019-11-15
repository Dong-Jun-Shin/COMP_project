package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextField;
import model.DataUtil;
import model.ProductVO;

@SuppressWarnings("rawtypes")
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
	
	private ProductVO pvo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtTotalPrice.setEditable(false);
		editable();
		reset();
		setProductPrice();
		
	}
	
	public void btnOrderInsert(ActionEvent event) {
		if(!DataUtil.validityCheck(txtCDNum.getText(), "주문번호")) {return;
		}else if(!DataUtil.validityCheck(txtCId.getText(), "ID")) {
		}else if(!DataUtil.validityCheck(txtCName.getText(), "고객명")) {
		}else if(!DataUtil.validityCheck(txtCPhone.getText(), "전화번호")) {
		}else if(!DataUtil.validityCheck(txtCAddress.getText(), "주소")) {
		}else if(!DataUtil.validityCheck(txtCEmail.getText(), "이메일")) {
		}else {
			
			
			
			
			
			
			
			
			
		}
		
		
		reset();
	}
	
	
	/**
	 * editable() : 필드 입력 불가 지정 메소드
	 */
	public void editable() {
		//txtCPPrice.setEditable(false);
		txtRPrice.setEditable(false);
		txtMBPrice.setEditable(false);
		txtGPrice.setEditable(false);
		txtSSPrice.setEditable(false);
		txtHPrice.setEditable(false);
		txtPOPrice.setEditable(false);
		txtCAPrice.setEditable(false);
		txtCOPrice.setEditable(false);
		txtSWPrice.setEditable(false);
		txtKPrice.setEditable(false);
		txtMOPrice.setEditable(false);
		txtSPPrice.setEditable(false);
		txtMNPrice.setEditable(false);
		txtTotalPrice.setEditable(false);
		spinCAQty.setEditable(false);
		spinCOQty.setEditable(false);
		spinCPQty.setEditable(false);
		spinGQty.setEditable(false);
		spinHQty.setEditable(false);
		spinKQty.setEditable(false);
		spinMBQty.setEditable(false);
		spinMNQty.setEditable(false);
		spinMOQty.setEditable(false);
		spinPOQty.setEditable(false);
		spinRQty.setEditable(false);
		spinSPQty.setEditable(false);
		spinSWQty.setEditable(false);
		
	}
	
	/**
	 * reset() : 전체 데이터 리셋 메소드
	 */
	public void reset() {
		txtCPName.clear();
		txtCPPrice.setText("0");
		txtRName.clear();
		txtRPrice.setText("0");
		txtMBName.clear();
		txtMBPrice.setText("0");
		txtGName.clear();
		txtGPrice.setText("0");
		txtSSName.clear();
		txtSSPrice.setText("0");
		txtHName.clear();
		txtHPrice.setText("0");
		txtPOName.clear();
		txtPOPrice.setText("0");
		txtCAName.clear();
		txtCAPrice.setText("0");
		txtCOName.clear();
		txtCOPrice.setText("0");
		txtSWName.clear();
		txtSWPrice.setText("0");
		txtKName.clear();
		txtKPrice.setText("0");
		txtMOName.clear();
		txtMOPrice.setText("0");
		txtSPName.clear();
		txtSPPrice.setText("0");
		txtMNName.clear();
		txtMNPrice.setText("0");
		txtTotalPrice.clear();
		setSpineerDefaultValue();
	}
	
	/**
	 * setSpineerDefaultValue() : 스피너 값 설정 메소드
	 */
	public void setSpineerDefaultValue() {
		IntegerSpinnerValueFactory defqtyca = new IntegerSpinnerValueFactory(0, 999);
		spinCAQty.setValueFactory(defqtyca);
		IntegerSpinnerValueFactory defqtyco = new IntegerSpinnerValueFactory(0, 999);
		spinCOQty.setValueFactory(defqtyco);
		IntegerSpinnerValueFactory defqtycp = new IntegerSpinnerValueFactory(0, 999);
		spinCPQty.setValueFactory(defqtycp);
		IntegerSpinnerValueFactory defqtyg = new IntegerSpinnerValueFactory(0, 999);
		spinGQty.setValueFactory(defqtyg);
		IntegerSpinnerValueFactory defqtyh = new IntegerSpinnerValueFactory(0, 999);
		spinHQty.setValueFactory(defqtyh);
		IntegerSpinnerValueFactory defqtyk = new IntegerSpinnerValueFactory(0, 999);
		spinKQty.setValueFactory(defqtyk);
		IntegerSpinnerValueFactory defqtymb = new IntegerSpinnerValueFactory(0, 999);
		spinMBQty.setValueFactory(defqtymb);
		IntegerSpinnerValueFactory defqtymn = new IntegerSpinnerValueFactory(0, 999);
		spinMNQty.setValueFactory(defqtymn);
		IntegerSpinnerValueFactory defqtymo = new IntegerSpinnerValueFactory(0, 999);
		spinMOQty.setValueFactory(defqtymo);
		IntegerSpinnerValueFactory defqtypo = new IntegerSpinnerValueFactory(0, 999);
		spinPOQty.setValueFactory(defqtypo);
		IntegerSpinnerValueFactory defqtyro = new IntegerSpinnerValueFactory(0, 999);
		spinRQty.setValueFactory(defqtyro);
		IntegerSpinnerValueFactory defqtysp = new IntegerSpinnerValueFactory(0, 999);
		spinSPQty.setValueFactory(defqtysp);
		IntegerSpinnerValueFactory defqtyss = new IntegerSpinnerValueFactory(0, 999);
		spinSSQty.setValueFactory(defqtyss);
		IntegerSpinnerValueFactory defqtysw = new IntegerSpinnerValueFactory(0, 999);
		spinSWQty.setValueFactory(defqtysw);
		
		
	}
	
	
	public void setTotalPrice() {
		int resultPrice = 50;
		resultPrice += Integer.parseInt((txtCPPrice.getText()));
		resultPrice += Integer.parseInt((txtCAPrice.getText()));
		resultPrice += Integer.parseInt((txtCOPrice.getText()));
		resultPrice += Integer.parseInt((txtGPrice.getText()));
		resultPrice += Integer.parseInt((txtHPrice.getText()));
		resultPrice += Integer.parseInt((txtKPrice.getText()));
		resultPrice += Integer.parseInt((txtMBPrice.getText()));
		resultPrice += Integer.parseInt((txtMNPrice.getText()));
		resultPrice += Integer.parseInt((txtMOPrice.getText()));
		resultPrice += Integer.parseInt((txtPOPrice.getText()));
		resultPrice += Integer.parseInt((txtSPPrice.getText()));
		resultPrice += Integer.parseInt((txtRPrice.getText()));
		resultPrice += Integer.parseInt((txtSSPrice.getText()));
		resultPrice += Integer.parseInt((txtSWPrice.getText()));
		String resultSet = String.valueOf(resultPrice);
		txtTotalPrice.setText(resultSet);
		
	}
	
	
	
	public void setProductPrice() {
		txtCPPrice.setText(String.valueOf( pvo.getP_price()*spinCPQty.getValue()));
		txtRPrice.setText(String.valueOf( pvo.getP_price()*spinRQty.getValue()));
		txtMBPrice.setText(String.valueOf( pvo.getP_price()*spinMBQty.getValue()));
		txtGPrice.setText(String.valueOf( pvo.getP_price()*spinGQty.getValue()));
		txtSSPrice.setText(String.valueOf( pvo.getP_price()*spinSSQty.getValue()));
		txtHPrice.setText(String.valueOf( pvo.getP_price()*spinHQty.getValue()));
		txtPOPrice.setText(String.valueOf( pvo.getP_price()*spinPOQty.getValue()));
		txtCAPrice.setText(String.valueOf( pvo.getP_price()*spinCAQty.getValue()));
		txtCOPrice.setText(String.valueOf( pvo.getP_price()*spinCOQty.getValue()));
		txtSWPrice.setText(String.valueOf( pvo.getP_price()*spinSWQty.getValue()));
		txtKPrice.setText(String.valueOf( pvo.getP_price()*spinKQty.getValue()));
		txtMOPrice.setText(String.valueOf( pvo.getP_price()*spinMOQty.getValue()));
		txtSPPrice.setText(String.valueOf( pvo.getP_price()*spinSPQty.getValue()));
		txtMNPrice.setText(String.valueOf( pvo.getP_price()*spinMNQty.getValue()));
		setTotalPrice();

	}
	
	
	
}
