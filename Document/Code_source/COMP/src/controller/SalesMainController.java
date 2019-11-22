package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class SalesMainController implements Initializable {
	@FXML
	private TabPane salesMainPane;
	@FXML
	private Tab watch;
	@FXML
	private SalesWatchTabController salesWatchTabController;
	@FXML
	private Tab trade;
	@FXML
	private SalesTradeTabController salesTradeTabController;
		
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		salesWatchTabController.setSttController(salesTradeTabController);
		salesWatchTabController.setPrimaryStage(primaryStage);
		salesTradeTabController.setPrimaryStage(primaryStage);
		
//		salesMainPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
//			// Tab이 바뀔 때를 인지하는 것이기 떄문에 타입은 Tab
//			// 기존 값과 바뀐 값을 매개변수로 받아준다.
//			@Override
//			public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
//				if (newValue == watch) {
//					// 해당 탭의 내용을 새로고침
//					try {
//						
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//
//				} else if (newValue == trade) {
//					// 해당 탭의 내용을 새로고침
//					try {
//						
//					} catch (Exception e) {
//						e.printStackTrace();
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
