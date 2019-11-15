package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SalesWatchTabController implements Initializable {
	@FXML
	private TreeView<String> productTreeView;
	@FXML
	private ImageView productImageView00;
	@FXML
	private ImageView productImageView10;
	@FXML
	private ImageView productImageView20;
	@FXML
	private ImageView productImageView30;
	@FXML
	private ImageView productImageView01;
	@FXML
	private ImageView productImageView11;
	@FXML
	private ImageView productImageView21;
	@FXML
	private ImageView productImageView31;
	@FXML
	private ImageView productImageView02;
	@FXML
	private ImageView productImageView12;
	@FXML
	private ImageView productImageView22;
	@FXML
	private ImageView productImageView32;
	@FXML
	private ImageView productImageView03;
	@FXML
	private ImageView productImageView13;
	@FXML
	private ImageView productImageView23;
	@FXML
	private ImageView productImageView33;
	@FXML
	private Button btnLast;
	@FXML
	private Button btnNext;
	
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void imageSel(MouseEvent event) {
		// TODO Auto-generated method stub

	}
	
	public void btnPageMove(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}
