package controller;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private Button btnOrderClr;

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
//		for (int i = 0; i < pvoList.length; i++) {
//			pvoList[i] = new ProductVO();
//		}

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
			//
			CustomerVO cvo = cdao.getCustomerSelected("c_id", txtCId.getText()).get(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			String cdnumYear = sdf.format(new Date());
			String serialNo = codao.getOrderCount(cdnumYear);

			txtCDNum.setText(cdnumYear + serialNo);
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

	public void btnOrderClr(ActionEvent event) {
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

	/**
	 * btnOrderInsert(ActionEvent event) : 주문 입력 이벤트
	 */
	@SuppressWarnings("unchecked")
	public void btnOrderInsert(ActionEvent event) {
		boolean success = false;
		int[] chQtyArr = new int[pvoList.length]; 
		
		for (int i = 0, j = 0; i < pvoList.length; i++) {
			chQtyArr[i] = ((Spinner<Integer>) spinQtyList[i]).getValue();
			if(chQtyArr[i] == 0 && ++j == 14) {
					DataUtil.showAlert("수량 선택", "주문할 제품의 수량을 정해주세요.");
					return;
			}
		}
		
		// 주문 테이블에 주문행 생성
		success = codao.cd_orderInsert(covo);

		// 주문 내역 테이블에 각 제품의 주문 행 생성
		if (success == true) {
			OrderChartVO ocvo;
			for (int i = 0, j = 0; i < pvoList.length; i++) {
				if (pvoList[i] != null) {
					if (chQtyArr[i] != 0) {
						ocvo = new OrderChartVO();
						ocvo.setP_num(pvoList[i].getP_num());
						ocvo.setCh_qty(chQtyArr[i]);
						ocvo.setCd_num(covo.getCd_num());
						ocdao.order_ChartInsert(ocvo);
					}
				}
			}
		}

		if (success == true) {
			DataUtil.showInfoAlert("주문신청 결과", "[" + txtCName.getText() + "님]의 주문이 등록되었습니다.");
			// TODO 이메일 전송 구현하기
			/*
			 * 이메일 전송 (판매자 이메일 -> 고객 이메일) 제목 : '구매자명'님, 주문하신 내역입니다. 본문 : 고객 - 성함, 연락처, 주소 제품
			 * - 제품명, 개수, 금액 ------------------- 총금액 판매자 - 계좌주, 계좌번호, 계좌 번호
			 */
		} else {
			DataUtil.showInfoAlert("주문신청 결과", "주문신청에 문제가 있어 완료하지 못하였습니다.");
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

		txtCDNum.clear();
		txtCId.clear();
		txtCName.clear();
		txtCPhone.clear();
		txtCAddress.clear();
		txtCEmail.clear();

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
			if (spinVal == 1 && pvoList[keyIdx] == null) {
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