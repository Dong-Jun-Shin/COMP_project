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

public class ManageStockTabController implements Initializable {
	@FXML
	private TextField txtPNum;
	@FXML
	private ComboBox cmbPSort;
	@FXML
	private TextField txtPName;
	@FXML
	private TextField txtPQty;
	@FXML
	private TextField txtPPrice;
	@FXML
	private TextField txtPSize;
	@FXML
	private TextField txtPGrt;
	@FXML
	private TextField txtPDate;
	@FXML
	private TextField txtPImg;
	@FXML
	private Button btnImgChoice;
	@FXML
	private Button btnPInsert;
	@FXML
	private Button btnPUpdate;
	@FXML
	private Button btnPDelete;
	@FXML
	private ComboBox cmbPSearchKey;
	@FXML
	private TextField txtPSearchValue;
	@FXML
	private Button btnPSearch;
	@FXML
	private Button btnWHPopup;
	@FXML
	private TableView productTableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void btnImgChoice(ActionEvent event) {

	}

	public void btnPInsert(ActionEvent event) {

	}

	public void btnPUpdate(ActionEvent event) {

	}

	public void btnPDelete(ActionEvent event) {

	}

	public void btnPSearch(ActionEvent event) {

	}

	public void btnWHPopup(ActionEvent event) {

	}

	public void productTableView(MouseEvent event) {

	}
}
