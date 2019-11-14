package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SalesWatchSubController implements Initializable {
	@FXML
	private TextField txtPNum;
	@FXML
	private TextField txtPName;
	@FXML
	private TextField txtPPrice;
	@FXML
	private TextField txtPSize;
	@FXML
	private TextField txtPGrt;
	@FXML
	private TextField txtPDate;
	@FXML
	private Button btnSelProduct;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void btnSelProduct(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}
