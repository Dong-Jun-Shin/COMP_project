package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
	
	private ManageStockSubController mssController;

	private WarehouseDAO whdao = WarehouseDAO.getInstance();
	private ProductVO pvo;

	private Stage stage;
	private Stage primaryStage;
	
	private ObservableList<WarehouseVO> whDataList = FXCollections.observableArrayList();

	public TextField getTxtTRNum() {
		return txtTRNum;
	}

	public void setMssController(ManageStockSubController mssController) {
		this.mssController = mssController;
	}

	public void setPvo(ProductVO pvo) {
		this.pvo = pvo;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> title = DataUtil.fieldName(new WarehouseVO());
		for (int i = 0; i < title.size() - 1; i++) {
			TableColumn<WarehouseVO, ?> columnName = whTableView.getColumns().get(i);
			columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}
		whTableView.setItems(whDataList);
		
		setWHNum();
		wareTotalList();
	}
	
	public void txtTRPopup(MouseEvent event) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("거래처 목록");
		
		try {
			// 팝업의 FXML 로드
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/manageWareHouseSub.fxml"));
			Parent parent = loader.load();
			
			ManageWHSubController mwsController = loader.getController();
			mwsController.setPrimaryStage(primaryStage);
			mwsController.setMssController(mssController);
			mwsController.setStage(dialog);
			mwsController.showWindow(parent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void btnWHInsert(ActionEvent event) {
		if (!DataUtil.validityCheck(txtWHNum.getText(), "입고 번호")) {
			return;
		} else if (!DataUtil.validityCheck(txtTRNum.getText(), "거래처 번호")) {
			return;
		} else if (!DataUtil.validityCheck(txtPNum.getText(), "제품 번호")) {
			return;
		} else if (!DataUtil.validityCheck(txtWHQty.getText(), "입고 수량")) {
			return;
		} else {
			WarehouseVO wvo = new WarehouseVO();
			wvo.setWh_num(txtWHNum.getText());
			wvo.setTr_num(txtTRNum.getText());
			wvo.setP_num(txtPNum.getText());
			wvo.setWh_qty(Integer.parseInt(txtWHQty.getText()));
			whdao.warehouseInsert(wvo);
		}
	}

	public void btnWHDelete(ActionEvent event) {
		if (!DataUtil.validityCheck(txtWHNum.getText(), "입고 번호")) {
			return;
		} else if (!DataUtil.validityCheck(txtTRNum.getText(), "거래처 번호")) {
			return;
		} else if (!DataUtil.validityCheck(txtPNum.getText(), "제품 번호")) {
			return;
		} else {
			WarehouseVO wvo = new WarehouseVO();
			wvo.setWh_num(txtWHNum.getText());

			whdao.warehouseDelete(wvo);
		}
	}

	/**
	 * setWHNum() : 새로운 거래처에게 부여될 다음 번호를 가져온다.
	 * 
	 */
	public void setWHNum() {
		StringBuffer sb = new StringBuffer();
		sb.append("WH_");
		sb.append(whdao.getWareHouseCount());
		txtWHNum.setText(sb.toString());
	}
	
	public void btnWHClear(ActionEvent event) {
		setWHNum();
		txtTRNum.clear();
		txtPNum.setText(pvo.getP_num());
		txtWHQty.clear();
		
	}

	public void whTableView(MouseEvent event) {
		if (event.getClickCount() == 2) {
			WarehouseVO wvo = whTableView.getSelectionModel().getSelectedItem();
			if (wvo != null) {
				txtWHNum.setText(wvo.getWh_num());
				txtTRNum.setText(wvo.getTr_num());
				txtPNum.setText(wvo.getP_num());
				txtWHQty.setText(Integer.toString(wvo.getWh_qty()));
			}
		}
	}

	/**
	 * wareTotalList() : 테이블뷰 레코드 출력(전체 리스트)
	 * 
	 */
	private void wareTotalList() {
		whDataList.removeAll(whDataList);
		WarehouseVO wvo = null;
		ArrayList<WarehouseVO> list;

		try {
			list = whdao.getWarehouseTotalList();

			for (int index = 0; index < list.size(); index++) {
				// 결과 리스트에서 한 행을 가져다가 wvo에 대입
				wvo = list.get(index);
				// 한 행을 추가
				whDataList.add(wvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("wareTotalList() = [" + e.getMessage() + "]");
		}
	}
	
	public void setWHInfo() {
		txtPNum.setText(pvo.getP_num());
	}
	
	public void showWindow(Parent parent) {
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}