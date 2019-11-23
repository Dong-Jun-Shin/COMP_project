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
		manageStockTabController.setMstController(manageStockTabController);
		manageStockTabController.setPrimaryStage(primaryStage);
		manageResultTabController.setPrimaryStage(primaryStage);
		manageCustomerTabController.setPrimaryStage(primaryStage);
		manageOrderTabController.setPrimaryStage(primaryStage);
		manageMyInfoTabController.setPrimaryStage(primaryStage);
		manageTraderTabController.setPrimaryStage(primaryStage);

		manageMainPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == stock) {
				try {
					manageStockTabController.productTotalList();
				} catch (Exception e) {
					System.out.println("changed() error = " + e.getMessage());
				}
			} else if (newValue == customer) {
				try {
					manageCustomerTabController.customerTotalList();
					;
				} catch (Exception e) {
					System.out.println("changed() error = " + e.getMessage());
				}
			} else if (newValue == order) {
				try {
					manageOrderTabController.progressTotalList();
					manageOrderTabController.historyTotalList();
				} catch (Exception e) {
					System.out.println("changed() error = " + e.getMessage());
				}
			} else if (newValue == myInfo) {
				try {
					manageMyInfoTabController.initialize(location, resources);
				} catch (Exception e) {
					System.out.println("changed() error = " + e.getMessage());
				}
			} else if (newValue == trader) {
				try {
					manageTraderTabController.traderTotalList();
				} catch (Exception e) {
					System.out.println("changed() error = " + e.getMessage());
				}
			}
		});
	}

	public void menuLogout(ActionEvent event) {
		new MenuController().menuLogout(primaryStage);
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