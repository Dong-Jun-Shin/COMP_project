package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ManageOrderTabController implements Initializable {
	@FXML
	private Label lblCDNum;
	@FXML
	private Button btnOrderCancel;
	@FXML
	private TableView orderProgressView;
	@FXML
	private TableView orderHistoryView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void btnOrderCancel(ActionEvent event) {

	}

	public void orderProgressView(MouseEvent event) {

	}

	public void orderHistoryView(MouseEvent event) {

	}
}
