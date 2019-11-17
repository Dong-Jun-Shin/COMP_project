package controller;

import java.net.URL;
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
	
	private ProductVO pvo;
	private CD_orderDAO cddao;
	private CD_OrderVO cvo;
	private Stage primaryStage;

	public void setPvo(ProductVO pvo) {
		this.pvo = pvo;
	}



	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		editable();
		reset();
	}
	
	/*
	 * 		btnOrderInsert(ActionEvent event) : 주문 입력 이벤트
	 */
	public void btnOrderInsert(ActionEvent event) {
		//TODO 작동여부 미확인상태
		
		if(!DataUtil.validityCheck(txtCDNum.getText(), "주문번호")) {
			return;
		}else if(!DataUtil.validityCheck(txtCId.getText(), "ID")) {
			return;
		}else if(!DataUtil.validityCheck(txtCName.getText(), "고객명")) {
			return;
		}else if(!DataUtil.validityCheck(txtCPhone.getText(), "전화번호")) {
			return;
		}else if(!DataUtil.validityCheck(txtCAddress.getText(), "주소")) {
			return;
		}else if(!DataUtil.validityCheck(txtCEmail.getText(), "이메일")) {
			return;
		}else {
			cvo = new CD_OrderVO();
			
			
			if(txtCPName.getText() !=null) {
				insertCvoSetting(txtCPName.getText(),Integer.parseInt(txtCPPrice.getText()));
			};
			
			if(txtRName.getText() !=null) {
				insertCvoSetting(txtRName.getText(),Integer.parseInt(txtRPrice.getText()));
			};
			
			if(txtMBName.getText() !=null) {
				insertCvoSetting(txtMBName.getText(),Integer.parseInt(txtMBPrice.getText()));
			};
			
			if(txtGName.getText() !=null) {
				insertCvoSetting(txtGName.getText(),Integer.parseInt(txtGPrice.getText()));
			};
			
			if(txtSSName.getText() !=null) {
				insertCvoSetting(txtSSName.getText(),Integer.parseInt(txtSSPrice.getText()));
			};
			
			if(txtHName.getText() !=null) {
				insertCvoSetting(txtHName.getText(),Integer.parseInt(txtHPrice.getText()));
			};
			
			if(txtPOName.getText() !=null) {
				insertCvoSetting(txtPOName.getText(),Integer.parseInt(txtPOPrice.getText()));
			};
			
			if(txtCAName.getText() !=null) {
				insertCvoSetting(txtCAName.getText(),Integer.parseInt(txtCAPrice.getText()));
			};
			
			if (txtCOName.getText() !=null) {
				insertCvoSetting(txtCOName.getText(),Integer.parseInt(txtCOPrice.getText()));
			};
			
			if(txtSWName.getText() !=null) {
				insertCvoSetting(txtSWName.getText(),Integer.parseInt(txtSWPrice.getText()));
			};
			
			if(txtKName.getText() !=null) {
				insertCvoSetting(txtKName.getText(),Integer.parseInt(txtKPrice.getText()));
			};
			
			if(txtMOName.getText() !=null) {
				insertCvoSetting(txtMOName.getText(),Integer.parseInt(txtMOPrice.getText()));
			};
			
			if(txtSPName.getText() !=null) {
				insertCvoSetting(txtSPName.getText(),Integer.parseInt(txtSPPrice.getText()));
			};
			
			if(txtMNName.getText() !=null) {
				insertCvoSetting(txtMNName.getText(),Integer.parseInt(txtMNPrice.getText()));
			};
			
		}
		
		reset();
	}
	
	
	/**
	 * editable() : 필드 입력 불가 지정 메소드
	 */
	public void editable() {
		txtCPName.setEditable(false);
		txtRName.setEditable(false);
		txtMBName.setEditable(false);
		txtGName.setEditable(false);
		txtSSName.setEditable(false);
		txtHName.setEditable(false);
		txtPOName.setEditable(false);
		txtCAName.setEditable(false);
		txtCOName.setEditable(false);
		txtSWName.setEditable(false);
		txtKName.setEditable(false);
		txtMOName.setEditable(false);
		txtSPName.setEditable(false);
		txtMNName.setEditable(false);
		txtCPPrice.setEditable(false);
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
		txtTotalPrice.setEditable(false);
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
	
	/*
	 * setTotalPrice() : 총 금액 자동입력 메소드
	 */
	public void setTotalPrice() {
		int resultPrice = 0;
		
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
		
		String resultSet = resultPrice+"";
		txtTotalPrice.setText(resultSet);
		
	}
	
	
	/*
	 * setProductPriceAction(MouseEvent event) 제품별 가격 변동 메소드
	 */
	public void setProductPriceAction(MouseEvent event) {
		//TODO ProductVO 연동하지않음.
		//테스트용
				//pvo = new ProductVO();
				//pvo.setP_price(50000);
				//txtCPPrice.setText(pvo.getP_price()+"");
		//값 설정
		if(spinCPQty.getValue()>0) {
			txtCPPrice.setText(50000+"");
		};
		
		if(spinCAQty.getValue()>0) {
			txtCAPrice.setText(20000+"");
		};
		
		if(spinCOQty.getValue()>0) {
			txtCOPrice.setText(40000+"");
		};
		
		if(spinGQty.getValue()>0) {
			txtGPrice.setText(56000+"");
		};
		if(spinHQty.getValue()>0) {
			txtHPrice.setText(42000+"");
		};
		if(spinKQty.getValue()>0) {
			txtKPrice.setText(63020+"");	
		};
		if(spinMBQty.getValue()>0) {
			txtMBPrice.setText(107700+"");
		};
		if(spinMNQty.getValue()>0) {
			txtMNPrice.setText(60310+"");
		};
		if(spinPOQty.getValue()>0) {
			txtPOPrice.setText(21340+"");
		};
		if(spinRQty.getValue()>0) {
			txtRPrice.setText(78600+"");
		};
		if(spinSPQty.getValue()>0) {
			txtSPPrice.setText(56800+"");
		};
		if(spinSSQty.getValue()>0) {
			txtSSPrice.setText(354100+"");
		};
		if(spinSWQty.getValue()>0) {
			txtSWPrice.setText(351000+"");
		};
		if(spinMOQty.getValue()>0) {
			txtMOPrice.setText(217000+"");
		};
		
		//입력된 값 * 스핀값
		txtCPPrice.setText((Integer.parseInt(txtCPPrice.getText()))*(spinCPQty.getValue())+"");
		txtRPrice.setText((Integer.parseInt(txtRPrice.getText()))*spinRQty.getValue()+"");
		txtMBPrice.setText((Integer.parseInt(txtMBPrice.getText()))*spinMBQty.getValue()+"");
		txtGPrice.setText((Integer.parseInt(txtGPrice.getText()))*spinGQty.getValue()+"");
		txtSSPrice.setText((Integer.parseInt(txtSSPrice.getText()))*spinSSQty.getValue()+"");
		txtHPrice.setText((Integer.parseInt(txtHPrice.getText()))*spinHQty.getValue()+"");
		txtPOPrice.setText((Integer.parseInt(txtPOPrice.getText()))*spinPOQty.getValue()+"");
		txtCAPrice.setText((Integer.parseInt(txtCAPrice.getText()))*spinCAQty.getValue()+"");
		txtCOPrice.setText((Integer.parseInt(txtCOPrice.getText()))*spinCOQty.getValue()+"");
		txtSWPrice.setText((Integer.parseInt(txtSWPrice.getText()))*spinSWQty.getValue()+"");
		txtKPrice.setText((Integer.parseInt(txtKPrice.getText()))*spinKQty.getValue()+"");
		txtMOPrice.setText((Integer.parseInt(txtMOPrice.getText()))*spinMOQty.getValue()+"");
		txtSPPrice.setText((Integer.parseInt(txtSPPrice.getText()))*spinSPQty.getValue()+"");
		txtMNPrice.setText((Integer.parseInt(txtMNPrice.getText()))*spinMNQty.getValue()+"");
		
		setTotalPrice();
		
	}
	
	
	public void insertCvoSetting(String p_num, int cd_price) {
		cvo.setC_num(p_num);
		cvo.setCd_price(cd_price);
		cddao.cd_orderInsert(cvo);
	}
	
	public void setField() {
		String key = pvo.getP_num().substring(0, pvo.getP_num().indexOf("_"));
		switch (key) {
		case "CP":
			txtCPName.setText(pvo.getP_name());
			txtCPPrice.setText(pvo.getP_price()+"");
			break;
		case "R":
			txtRName.setText(pvo.getP_name());
			txtRPrice.setText(pvo.getP_price()+"");
			break;
		case "MB":
			txtMBName.setText(pvo.getP_name());
			txtMBPrice.setText(pvo.getP_price()+"");
			break;
		case "G":
			txtGName.setText(pvo.getP_name());
			txtGPrice.setText(pvo.getP_price()+"");
			break;
		case "SS":
			txtSSName.setText(pvo.getP_name());
			txtSSPrice.setText(pvo.getP_price()+"");
			break;
		case "H":
			txtHName.setText(pvo.getP_name());
			txtHPrice.setText(pvo.getP_price()+"");
			break;
		case "PO":
			txtPOName.setText(pvo.getP_name());
			txtPOPrice.setText(pvo.getP_price()+"");
			break;
		case "CA":
			txtCAName.setText(pvo.getP_name());
			txtCAPrice.setText(pvo.getP_price()+"");
			break;
		case "CO":
			txtCOName.setText(pvo.getP_name());
			txtCOPrice.setText(pvo.getP_price()+"");
			break;
		case "SW":
			txtSWName.setText(pvo.getP_name());
			txtSWPrice.setText(pvo.getP_price()+"");
			break;
		case "K":
			txtKName.setText(pvo.getP_name());
			txtKPrice.setText(pvo.getP_price()+"");
			break;
		case "MO":
			txtMOName.setText(pvo.getP_name());
			txtMOPrice.setText(pvo.getP_price()+"");
			break;
		case "SP":
			txtSPName.setText(pvo.getP_name());
			txtSPPrice.setText(pvo.getP_price()+"");
			break;
		case "MN":
			txtMNName.setText(pvo.getP_name());
			txtMNPrice.setText(pvo.getP_price()+"");
			break;
		}
	}
}

//TODO order_ChartVO로 인서트 여러번 수행하도록 구현
//TODO 전달받은 pvo로 각 p_num과 단가를 보관해두는 방법 찾기 
// PVO pvoList 배열, TextField txtNameList 배열, TextField txtPriceList, 
// String keyMap(key, int), Spinner spinQtyList(배열 내 원소의 순서를 맞춰서 작성 후 반복문으로 변경)
