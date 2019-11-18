package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import model.ProductVO;
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
	private ComboBox cmbTRSearchKey;
	@FXML
	private TextField txtTRSearchValue;
	@FXML
	private Button btnTRSearch;
	@FXML
	private TableView<TraderVO> traderTableView;

	private static ObservableList<TraderVO> traderDataList = FXCollections.observableArrayList();

	private TraderDAO trdao = TraderDAO.getInstance();

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
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

		// 학과 전체 목록
		traderTotalList();
	}

	public void btnTRInsert(ActionEvent event) {
//		if(DataUtil.validityCheck(txtPNum.getText(), "제품번호")) {return;
//		}else if(DataUtil.validityCheck(txtPName.getText(), "제품명")) {return;
//		}else if(DataUtil.validityCheck(txtPQty.getText(), "수량")) {return;
//		}else if(DataUtil.validityCheck(txtPPrice.getText(), "단가")) {return;
//		}else if(DataUtil.validityCheck(txtPDate.getText(), "출시일")) {return;
//		}else if(DataUtil.validityCheck(txtPImg.getText(), "이미지 파일")) {return;
//		}else {
//		
//			ProductVO pvo = new ProductVO();
//			pvo.setP_num(txtPNum.getText());
//			pvo.setP_name(txtPName.getText());
//			pvo.setP_qty(Integer.parseInt(txtPQty.getText()));
//			pvo.setP_price(Integer.parseInt(txtPPrice.getText()));
//			pvo.setP_size(txtPSize.getText());
//			pvo.setP_grt(txtPGrt.getText());
//			pvo.setP_date(txtPDate.getText());
//			pvo.setP_img(txtPImg.getText());
//		
//		pddao.productInsert(pvo);
//		}
//		

	}

	public void btnTRUpdate(ActionEvent event) {

//		if(DataUtil.validityCheck(txtPNum.getText(), "제품번호")) {return;
//		}else if(DataUtil.validityCheck(txtPName.getText(), "제품명")) {return;
//		}else if(DataUtil.validityCheck(txtPQty.getText(), "수량")) {return;
//		}else if(DataUtil.validityCheck(txtPPrice.getText(), "단가")) {return;
//		}else if(DataUtil.validityCheck(txtPDate.getText(), "출시일")) {return;
//		}else if(DataUtil.validityCheck(txtPImg.getText(), "이미지 파일")) {return;
//		}else {
//		
//			ProductVO pvo = new ProductVO();
//			pvo.setP_num(txtPNum.getText());
//			pvo.setP_name(txtPName.getText());
//			pvo.setP_qty(Integer.parseInt(txtPQty.getText()));
//			pvo.setP_price(Integer.parseInt(txtPPrice.getText()));
//			pvo.setP_size(txtPSize.getText());
//			pvo.setP_grt(txtPGrt.getText());
//			pvo.setP_date(txtPDate.getText());
//			pvo.setP_img(txtPImg.getText());
//		
//			pddao.productUpdate(pvo);
//			
//		}

	}

	public void btnTRDelete(ActionEvent event) {
//		if(DataUtil.validityCheck(txtPNum.getText(), "제품번호")) {return;
////		}else if(DataUtil.validityCheck(txtPName.getText(), "제품명")) {return;
////		}else if(DataUtil.validityCheck(txtPQty.getText(), "수량")) {return;
////		}else if(DataUtil.validityCheck(txtPPrice.getText(), "단가")) {return;
////		}else if(DataUtil.validityCheck(txtPDate.getText(), "출시일")) {return;
////		}else if(DataUtil.validityCheck(txtPImg.getText(), "이미지 파일")) {return;
//		}else {
//			
//			ProductVO pvo = new ProductVO();
//			pvo.setP_num(txtPNum.getText());
//			pddao.productDelete(pvo);
//		}
	}

	public void btnTRSearch(ActionEvent event) {
//		switch(cmbPSearchKey.getValue().toString()) {
//		case "제품번호" :
//			pddao.getProductSelected("p_num",txtPSearchValue.getText());
//			break;
//	
//		case "제품구분" :
//			//TODO 입력받은 제품의 종류를 가져오도록 함
//			switch(txtPSearchValue.getText()) {
//				case "CPU" :
//					pddao.getProductSelected("p_num", "CP_");
//					break;
//				case "" :
//					
//					break;
//					
//				default :
//					
//			}
//			
//			break;
//		
//		case "제품명" :
//			
//			pddao.getProductSelected("p_name",txtPSearchValue.getText());
//			break;
//			
//		default :
//			pddao.getProductTotalList();
//			
//			break;
//			
//			
//			
//		}
	}

	public void traderTableView(MouseEvent event) {
//		ObservableList<ProductVO> list = FXCollections.observableArrayList();
//		
//		
//		productTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				if(event.getClickCount() > 1) {
//					//TODO list.get(int a) <- 선택한 값 가져오도록 설정, int값을 String값으로 가져오도록 함
//					/*
//					txtPNum.setText(list.get().getP_num());
//					txtPName.setText(list.get().getP_name());
//					txtPQty.setText(list.get().getP_qty());
//					txtPPrice.setText(list.get().getP_price());
//					txtPSize.setText(list.get().getP_size());
//					txtPGrt.setText(list.get().getP_grt());
//					txtPDate.setText(list.get().getP_date());
//					txtPImg.setText(list.get().getP_img());
//					*/
//				}
//			}
//			
//		});
//		

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
	public void traderTotalList() {
		traderDataList.removeAll(traderDataList);
		TraderVO svo = null;
		ArrayList<TraderVO> list;

		try {
			list = trdao.getTraderTotalList();
			int rowCount = list.size();

			for (int index = 0; index < rowCount; index++) {
				// 결과 리스트에서 한 행을 가져다가 svo에 대입
				svo = list.get(index);
				// 한 행을 추가
				traderDataList.add(svo);
			}
		} catch (Exception e) {
			System.out.println("traderTotalList() = [" + e.getMessage() + "]");
		}
	}
}
