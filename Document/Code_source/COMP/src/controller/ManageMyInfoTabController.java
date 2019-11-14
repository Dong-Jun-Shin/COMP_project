package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ManageMyInfoTabController implements Initializable {
	@FXML
	private TextField txtDName;
	@FXML
	private TextField txtDId;
	@FXML
	private PasswordField pwDPasswd;
	@FXML
	private TextField txtDPhone;
	@FXML
	private TextField txtDAddress;
	@FXML
	private TextField txtDBOwner;
	@FXML
	private TextField txtDBNum;
	@FXML
	private TextField txtDBName;
	@FXML
	private Button btnDUpdate;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void btnDUpdate(ActionEvent event){
		
	}
}
