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

//		manageMainPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
//			// Tab이 바뀔 때를 인지하는 것이기 떄문에 타입은 Tab
//			// 기존 값과 바뀐 값을 매개변수로 받아준다.
//			@Override
//			public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
//				if (newValue == stock) {
//					// 해당 탭의 내용을 새로고침
//					try {
//
//					} catch (Exception e) {
//						System.out.println("changed() error = " + e.getMessage());
//					}
//
//				} else if (newValue == result) {
//					// 해당 탭의 내용을 새로고침
//					try {
//
//					} catch (Exception e) {
//						System.out.println("changed() error = " + e.getMessage());
//					}
//
//				} else if (newValue == customer) {
//					// 해당 탭의 내용을 새로고침
//					try {
//
//					} catch (Exception e) {
//						System.out.println("changed() error = " + e.getMessage());
//					}
//
//				} else if (newValue == order) {
//					// 해당 탭의 내용을 새로고침
//					try {
//
//					} catch (Exception e) {
//						System.out.println("changed() error = " + e.getMessage());
//					}
//
//				} else if (newValue == myInfo) {
//					// 해당 탭의 내용을 새로고침
//					try {
//
//					} catch (Exception e) {
//						System.out.println("changed() error = " + e.getMessage());
//					}
//
//				} else if (newValue == trader) {
//					// 해당 탭의 내용을 새로고침
//					try {
//
//					} catch (Exception e) {
//						System.out.println("changed() error = " + e.getMessage());
//					}
//
//				}
//			}
//
//		});
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
