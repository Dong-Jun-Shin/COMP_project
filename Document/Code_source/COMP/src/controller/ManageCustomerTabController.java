package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ManageCustomerTabController implements Initializable {
	@FXML
	private TextField txtCNum;
	@FXML
	private TextField txtCName;
	@FXML
	private TextField txtCId;
	@FXML
	private PasswordField pwCPasswd;
	@FXML
	private TextField txtCPhone;
	@FXML
	private TextField txtCAddress;
	@FXML
	private TextField txtCBrith;
	@FXML
	private TextField txtCEmail;
	@FXML
	private Button btnCInsert;
	@FXML
	private Button btnCUpdate;
	@FXML
	private Button btnCDelete;
	@FXML
	private ComboBox cmbCSearchKey;
	@FXML
	private TextField txtCSearchValue;
	@FXML
	private Button btnCSearch;
	@FXML
	private TableView customerTableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void btnCInsert(ActionEvent event) {

	}

	public void btnCUpdate(ActionEvent event) {

	}

	public void btnCDelete(ActionEvent event) {

	}

	public void btnCSearch(ActionEvent event) {

	}

	public void customerTableView(MouseEvent event) {

	}
}
