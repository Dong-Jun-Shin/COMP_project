package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.TraderDAO;
import model.TraderVO;

public class ManageWHSubController implements Initializable {
	@FXML
	private TableView<TraderVO> wareTableList;

	private TraderDAO tdao = TraderDAO.getInstance();

	private ManageStockSubController mssController; 
	
	private Stage stage;
	private Stage primaryStage;
	private ObservableList<TraderVO> wareDataList = FXCollections.observableArrayList();

	public void setMssController(ManageStockSubController mssController) {
		this.mssController = mssController;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TableColumn<TraderVO, ?> columnName = wareTableList.getColumns().get(0);
		columnName.setCellValueFactory(new PropertyValueFactory<>("tr_name"));
		
		wareTableList.setItems(wareDataList);

		tableViewData();
	}

	public void wareTabelList(MouseEvent event) {
		if (event.getClickCount() == 2) {
			TraderVO selectTrader = wareTableList.getSelectionModel().getSelectedItem();
			if (selectTrader != null) {
				mssController.getTxtTRNum().setText(selectTrader.getTr_num());
				stage.close();
			}
		}
	}
	
	/**
	 * 테이블뷰에 보여줄 레코드 설정
	 * 
	 * @param searchWord
	 */
	private void tableViewData() {
		TraderVO tvo = null;
		ArrayList<TraderVO> list;
		//다른 결과가 있을수도 있는 DB결과를 담는 변수를 비워준다.
		wareDataList.removeAll(wareDataList);
		
		try {
			list = tdao.getTraderTotalList();
			
			int rowCount = list.size();
			for (int index = 0; index < rowCount; index++) {
				tvo = list.get(index);
				wareDataList.add(tvo);
			}
		} catch (Exception e) {
			System.out.println("e TableViewData() = [ " + e.getMessage() + "]");
		}
	}
	
	public void showWindow(Parent parent) {
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
