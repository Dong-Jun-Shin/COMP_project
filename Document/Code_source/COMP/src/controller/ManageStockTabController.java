package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private ComboBox<String> cbxPSort;
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
	private ComboBox<String> cbxPSearchKey;
	@FXML
	private TextField txtPSearchValue;
	@FXML
	private Button btnPSearch;
	@FXML
	private Button btnWHPopup;
	@FXML
	private Button btnPClear;
	@FXML
	private TableView<ProductVO> productTableView;
	private ManageStockTabController mstc;
	
	private ProductDAO pddao;
	private static ObservableList<ProductVO> productDataList
	= FXCollections.observableArrayList();
	
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCbxList();
		reset();
		TableColumn<ProductVO, ?> colSort = productTableView.getColumns().get(0);
		colSort.setCellValueFactory(new PropertyValueFactory<>("p_sort"));
		TableColumn<ProductVO, ?> colNum =productTableView.getColumns().get(0);
		colNum.setCellValueFactory(new PropertyValueFactory<>("p_num"));
		TableColumn<ProductVO, ?> colName=productTableView.getColumns().get(0);
		colName.setCellValueFactory(new PropertyValueFactory<>("p_name"));
		TableColumn<ProductVO, ?> colQty=productTableView.getColumns().get(0);
		colQty.setCellValueFactory(new PropertyValueFactory<>("p_qty"));
		TableColumn<ProductVO, ?> colPrice=productTableView.getColumns().get(0);
		colPrice.setCellValueFactory(new PropertyValueFactory<>("p_price"));
		
		productTableView.setItems(productDataList);
		
	}
/**
 * btnImgChoice(ActionEvent event) : 이미지 선택 메소드 -미완성-
 * @param event
 */
	public void btnImgChoice(ActionEvent event) {
		//TODO 각 이미지를 image폴더 내에 있는 제품별 이미지 폴더에 맞게 등록되도록 할것
		FileChooser fc = new FileChooser();
		fc.setTitle("이미지 선택");
		fc.setInitialDirectory(new File("C://"));
		ExtensionFilter imgType = new ExtensionFilter("imageFile", "*.jpg","*.jpeg","*.png","*.gif");
		fc.getExtensionFilters().add(imgType);
		File selectedFile = fc.showOpenDialog(null);
		txtPImg.setText(selectedFile.toString());
		
		
	}
/**
 * btnPInsert(ActionEvent event) : 제품 등록 메소드
 * @param event
 */
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
		reset();
	}
/**
 * btnPUpdate(ActionEvent event) : 제품 업데이트 메소드
 * @param event
 */
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
		reset();
	}

	/**
	 * 
	 * @param event
	 */
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
		reset();
	}
	
	public void btnPSearch(ActionEvent event) {
		
		if(!DataUtil.validityCheck(txtPSearchValue.getText(), "찾을 대상")) {return;
		}else {
		
			switch(cbxPSearchKey.getValue().toString()) {
				case "제품번호" :
					pddao.getProductSelected("p_num",txtPSearchValue.getText());
					break;	
				case "제품명" :
					String result = productSort(txtPSearchValue.getText());
					pddao.getProductSelected("p_name",result);
					break;
				default :
					pddao.getProductTotalList();
					break;
				
			}
		}
		
	}

	public void btnWHPopup(ActionEvent event) throws Exception {
		
		//TODO manageStockSub 띄우기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/manageStockSub.fxml"));
		Parent parent = loader.load();
		
		ManageStockSubController mssc = loader.getController();
		Scene scene = new Scene(parent);
		
		
		
		
	}

	public void productTableView(MouseEvent event) {
		ProductVO pvo = null;
		
			if(event.getClickCount() == 2) {
				pvo = productTableView.getSelectionModel().getSelectedItem();
				
				if(pvo !=null) {
					//TODO cbxPSort값 자동 설정 할지 안할지 선택, 할경우 방법 찾기
					txtPNum.setText(pvo.getP_num());
					txtPName.setText(pvo.getP_name());
					txtPQty.setText(Integer.toString(pvo.getP_qty()));
					txtPPrice.setText(Integer.toString(pvo.getP_price()));
					txtPSize.setText(pvo.getP_size());
					txtPGrt.setText(pvo.getP_grt());
					txtPDate.setText(pvo.getP_date());
					txtPImg.setText(pvo.getP_img());
					
					editable(true);
				}
				
			}
			
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
		editable(false);
	}
	
	public void setCbxList() {
		ObservableList<String> cbxPsortList = FXCollections.observableArrayList
				("CPU","RAM","MainBoard","GPU","SSD","HDD","Power","Case","Cooler","SoftWare","KeyBoard","Mouse","Speaker","Monitor");
		cbxPSort.setItems(cbxPsortList);
		ObservableList<String> searchList = FXCollections.observableArrayList("제품번호","제품명");
		cbxPSearchKey.setItems(searchList);
	}
	
	public void editable(Boolean b) {
		btnImgChoice.setVisible(b);
		btnPInsert.setVisible(!b);
		btnPUpdate.setVisible(b);
		btnPDelete.setVisible(b);
		
	}
	
	public void btnPClear(ActionEvent event) {
		reset();
	}
	
	
	//TODO 제품 구분용(임시)
	public String productSort(String value) {
		String result = "";
		value = value.trim().toUpperCase();
		
		switch(value){
		case "CPU"  :
			
		case "RAM":
			
		case "MAINBOARD":
			
		case "GPU":
			
		case "SSD":
			
		case "HDD":
			
		case "POWER":
			
		case "CASE":
			
		case "SOFTWARE":
			
		case "KEYBOARD":
			
		case "MOUSE":
			
		case "SPEAKER":
			
		case "MONITOR":
			
					
		}
		
		return result;
	}
	
	
}
