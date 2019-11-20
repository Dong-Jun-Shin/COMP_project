package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.DataUtil;
import model.ProductVO;

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
	private TableView whTableView;
	
	private ProductVO pvo;
	private Stage stage;
	private Popup popup;
	private ManageStockTabController mstController;
	private Stage primaryStage;

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
				
	}
	
	public void btnWHInsert(ActionEvent event) {

	}

	public void btnWHDelete(ActionEvent event) {

	}

	public void btnWHClear(ActionEvent event) {
		
	}
	
	public void whTableView(MouseEvent event) {

	}
	
	
	
	
	
}