package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LoginMainController implements Initializable{
	@FXML
	private ToggleGroup groupChoice;
	@FXML
	private TextField txtLoginId;
	@FXML
	private PasswordField pwLoginPasswd;
	@FXML
	private Button btnLogin;
	@FXML
	private Button btnIdFindPopup;
	
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	private void salesLogin() {
		// TODO Auto-generated method stub

	}
	
	private void managerLogin() {
		// TODO Auto-generated method stub

	}
	
	public void btnLogin(ActionEvent event) {
		// TODO Auto-generated method stub

	}
	
	public void btnIdFindPopup(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}
