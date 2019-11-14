package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
	private TableView whTableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void btnWHInsert(ActionEvent event) {

	}

	public void btnWHDelete(ActionEvent event) {

	}

	public void whTableView(MouseEvent event) {

	}
}