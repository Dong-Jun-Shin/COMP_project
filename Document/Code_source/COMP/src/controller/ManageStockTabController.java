package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.DataUtil;
import model.ProductDAO;
import model.ProductVO;

public class ManageStockTabController implements Initializable {
	@FXML
	private TextField txtPNum;
	@FXML
	private ComboBox<String> cmbPSort;
	@FXML
	private TextField txtPName;
	@FXML
	private TextField txtPQty;
	@FXML
	private TextField txtPPrice;
	@FXML
	private TextField txtPSize;
	@FXML
	private TextField txtPGrt;
	@FXML
	private TextField txtPDate;
	@FXML
	private TextField txtPImg;
	@FXML
	private Button btnImgChoice;
	@FXML
	private Button btnPInsert;
	@FXML
	private Button btnPUpdate;
	@FXML
	private Button btnPDelete;
	@FXML
	private ComboBox<String> cmbPSearchKey;
	@FXML
	private TextField txtPSearchValue;
	@FXML
	private Button btnPSearch;
	@FXML
	private Button btnWHPopup;
	@FXML
	private TableView<ProductVO> productTableView;

	private ProductDAO pddao;
	
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		reset();
		//TODO 전체 리스트 조회
		
		
		
	}

	public void btnImgChoice(ActionEvent event) {
		
		FileChooser fc = new FileChooser();
		fc.setTitle("이미지 선택");
		fc.setInitialDirectory(new File("C://"));
		ExtensionFilter imgType = new ExtensionFilter("imageFile", "*.jpg","*.jpeg","*.png","*.gif");
		fc.getExtensionFilters().add(imgType);
		File selectedFile = fc.showOpenDialog(null);
		txtPImg.setText(selectedFile.toString());
		
		
	}

	public void btnPInsert(ActionEvent event) {
		if(DataUtil.validityCheck(txtPNum.getText(), "제품번호")) {return;
		}else if(DataUtil.validityCheck(txtPName.getText(), "제품명")) {return;
		}else if(DataUtil.validityCheck(txtPQty.getText(), "수량")) {return;
		}else if(DataUtil.validityCheck(txtPPrice.getText(), "단가")) {return;
		}else if(DataUtil.validityCheck(txtPDate.getText(), "출시일")) {return;
		}else if(DataUtil.validityCheck(txtPImg.getText(), "이미지 파일")) {return;
		}else {
		
			ProductVO pvo = new ProductVO();
			pvo.setP_num(txtPNum.getText());
			pvo.setP_name(txtPName.getText());
			pvo.setP_qty(Integer.parseInt(txtPQty.getText()));
			pvo.setP_price(Integer.parseInt(txtPPrice.getText()));
			pvo.setP_size(txtPSize.getText());
			pvo.setP_grt(txtPGrt.getText());
			pvo.setP_date(txtPDate.getText());
			pvo.setP_img(txtPImg.getText());
		
		pddao.productInsert(pvo);
		}
		
	}

	public void btnPUpdate(ActionEvent event) {
		
		if(DataUtil.validityCheck(txtPNum.getText(), "제품번호")) {return;
		}else if(DataUtil.validityCheck(txtPName.getText(), "제품명")) {return;
		}else if(DataUtil.validityCheck(txtPQty.getText(), "수량")) {return;
		}else if(DataUtil.validityCheck(txtPPrice.getText(), "단가")) {return;
		}else if(DataUtil.validityCheck(txtPDate.getText(), "출시일")) {return;
		}else if(DataUtil.validityCheck(txtPImg.getText(), "이미지 파일")) {return;
		}else {
		
			ProductVO pvo = new ProductVO();
			pvo.setP_num(txtPNum.getText());
			pvo.setP_name(txtPName.getText());
			pvo.setP_qty(Integer.parseInt(txtPQty.getText()));
			pvo.setP_price(Integer.parseInt(txtPPrice.getText()));
			pvo.setP_size(txtPSize.getText());
			pvo.setP_grt(txtPGrt.getText());
			pvo.setP_date(txtPDate.getText());
			pvo.setP_img(txtPImg.getText());
		
			pddao.productUpdate(pvo);
			
		}
		
	}

	public void btnPDelete(ActionEvent event) {
		if(DataUtil.validityCheck(txtPNum.getText(), "제품번호")) {return;
//		}else if(DataUtil.validityCheck(txtPName.getText(), "제품명")) {return;
//		}else if(DataUtil.validityCheck(txtPQty.getText(), "수량")) {return;
//		}else if(DataUtil.validityCheck(txtPPrice.getText(), "단가")) {return;
//		}else if(DataUtil.validityCheck(txtPDate.getText(), "출시일")) {return;
//		}else if(DataUtil.validityCheck(txtPImg.getText(), "이미지 파일")) {return;
		}else {
			
			ProductVO pvo = new ProductVO();
			pvo.setP_num(txtPNum.getText());
			pddao.productDelete(pvo);
			
		}
	}
	
	public void btnPSearch(ActionEvent event) {
		
		switch(cmbPSearchKey.getValue().toString()) {
		case "제품번호" :
			pddao.getProductSelected("p_num",txtPSearchValue.getText());
			break;
	
		case "제품구분" :
			//TODO 입력받은 제품의 종류를 가져오도록 함
			switch(txtPSearchValue.getText()) {
				case "CPU" :
					pddao.getProductSelected("p_num", "CP_");
					break;
				case "" :
					
					break;
					
				default :
					
			}
			
			break;
		
		case "제품명" :
			
			pddao.getProductSelected("p_name",txtPSearchValue.getText());
			break;
			
		default :
			pddao.getProductTotalList();
			
			break;
			
			
			
	}
	
		
	}

	public void btnWHPopup(ActionEvent event) throws Exception {
		
		//TODO manageStockSub 띄우기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/manageStockSub.fxml"));
		Parent parent = loader.load();
		
		
		
		
	}

	public void productTableView(MouseEvent event) {
		ObservableList<ProductVO> list = FXCollections.observableArrayList();
		
		
		productTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount() > 1) {
					//TODO list.get(int a) <- 선택한 값 가져오도록 설정, int값을 String값으로 가져오도록 함
					/*
					txtPNum.setText(list.get().getP_num());
					txtPName.setText(list.get().getP_name());
					txtPQty.setText(list.get().getP_qty());
					txtPPrice.setText(list.get().getP_price());
					txtPSize.setText(list.get().getP_size());
					txtPGrt.setText(list.get().getP_grt());
					txtPDate.setText(list.get().getP_date());
					txtPImg.setText(list.get().getP_img());
					*/
				}
			}
			
		});
		
		
	}
	
	public void reset() {
		txtPDate.clear();
		txtPGrt.clear();
		txtPImg.clear();
		txtPName.clear();
		txtPNum.clear();
		txtPPrice.clear();
		txtPQty.clear();
		txtPSearchValue.clear();
		txtPSize.clear();
	}
	
	
	
	
	
}
