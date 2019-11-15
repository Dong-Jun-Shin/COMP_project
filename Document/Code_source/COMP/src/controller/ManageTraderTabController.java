package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
	private TableView traderTableView;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void btnTRInsert(ActionEvent event) {

	}

	public void btnTRUpdate(ActionEvent event) {

	}

	public void btnTRDelete(ActionEvent event) {

	}

	public void btnTRSearch(ActionEvent event) {

	}

	public void traderTableView(MouseEvent event) {

	}
}
