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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.DataUtil;
import model.ProductVO;
import model.WarehouseDAO;
import model.WarehouseVO;

public class ManageStockSubController implements Initializable {
	@FXML
	private TextField txtWHNum;
	@FXML
	private TextField txtTRNum;
	@FXML
	private TextField txtPNum;
	@FXML
	private TextField txtWHQty;
	@FXML
	private Button btnWHInsert;
	@FXML
	private Button btnWHDelete;
	@FXML
	private Button btnWHClear;
	@FXML
	private TableView<WarehouseVO> whTableView;
	private WarehouseDAO whdao;
	private ProductVO pvo;
	private Stage stage;
	private Popup popup;
	private ManageStockTabController mstController;
	private Stage primaryStage;
	private ObservableList<WarehouseVO> whDataList
	= FXCollections.observableArrayList();
	
	
	public void setPvo(ProductVO pvo) {
		this.pvo = pvo;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setPopup(Popup popup) {
		this.popup = popup;
	}
	
	public void setMstController(ManageStockTabController mstController) {
		this.mstController = mstController;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int number = 1;
//		if(!whdao.getWarehouseTotalList().isEmpty()) {
//		 number = whdao.getWarehouseTotalList().size()+1;
//		}
		String whSet = String.format("%03d",number );
		//TODO ManageStockTabController에서 p_num값 받도록 하기
		txtWHNum.setText("WH_"+whSet);
//		setPvo(pvo);
//		txtPNum.setText(pvo.getP_num());
		
		
		txtWHNum.setEditable(false);
		txtPNum.setEditable(false);
		
		List<String> title = DataUtil.fieldName(new WarehouseVO());
		for(int i = 0; i<title.size()-1; i++) {
			TableColumn<WarehouseVO,?> columnName = whTableView.getColumns().get(i);
			columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}
		
		whTableView.setItems(whDataList);
		
		
	
	}
	
	public void btnWHInsert(ActionEvent event) {
		if(!DataUtil.validityCheck(txtWHNum.getText(), "입고 번호")) {return;
		}else if(!DataUtil.validityCheck(txtTRNum.getText(), "거래처 번호")) {return;
		}else if(!DataUtil.validityCheck(txtPNum.getText(), "제품 번호")) {return;
		}else if(!DataUtil.validityCheck(txtWHQty.getText(), "입고 수량")) {return;
		}else {
			WarehouseVO wvo = new WarehouseVO();
			wvo.setWh_num(txtWHNum.getText());
			wvo.setTr_num(txtTRNum.getText());
			wvo.setP_num(txtPNum.getText());
			wvo.setWh_qty(Integer.parseInt(txtWHQty.getText()));
			whdao.warehouseInsert(wvo);
			
			
		}
		
	}

	public void btnWHDelete(ActionEvent event) {
		if(!DataUtil.validityCheck(txtWHNum.getText(), "입고 번호")) {return;
		}else if(!DataUtil.validityCheck(txtTRNum.getText(), "거래처 번호")) {return;
		}else if(!DataUtil.validityCheck(txtPNum.getText(), "제품 번호")) {return;
		}else {
			
			WarehouseVO wvo = new WarehouseVO();
			wvo.setWh_num(txtWHNum.getText());
			
			whdao.warehouseDelete(wvo);
			
		}
		
	
	}

	public void btnWHClear(ActionEvent event) {
		txtTRNum.clear();
		txtWHQty.clear();
	}
	
	public void whTableView(MouseEvent event) {

		if(event.getClickCount() == 2) {
			WarehouseVO wvo = whTableView.getSelectionModel().getSelectedItem();
			if(wvo != null) {
				txtWHNum.setText(wvo.getWh_num());
				txtTRNum.setText(wvo.getTr_num());
				txtPNum.setText(wvo.getP_num());
				txtWHQty.setText(Integer.toString(wvo.getWh_qty()));
			}
			
			
		}
		
		
	}
	
	
	
	
	
}