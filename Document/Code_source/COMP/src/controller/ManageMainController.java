package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class ManageMainController implements Initializable {
	@FXML
	private TabPane manageMainPane;
	@FXML
	private Tab stock;
	@FXML
	private ManageStockTabController manageStockTabController;
	@FXML
	private Tab result;
	@FXML
	private ManageResultTabController manageResultTabController;
	@FXML
	private Tab customer;
	@FXML
	private ManageCustomerTabController manageCustomerTabController;
	@FXML
	private Tab order;
	@FXML
	private ManageOrderTabController manageOrderTabController;
	@FXML
	private Tab myInfo;
	@FXML
	private ManageMyInfoTabController manageMyInfoTabController;
	@FXML
	private Tab trader;
	@FXML
	private ManageTraderTabController manageTraderTabController;
	
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void menuClose(ActionEvent event) {
		MenuController.menuClose();
	}

	public void menuConnectInfo(ActionEvent event) {
		MenuController.menuConnectInfo();
	}

	public void menuProgramInfo(ActionEvent event) {
		MenuController.menuProgramInfo();
	}
	
	
}
