package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class LoginSubController implements Initializable {
	@FXML
	private ToggleGroup groupSearch;
	@FXML
	private TextField txtBOwner;
	@FXML
	private TextField txtBNum;
	@FXML
	private TextField txtSearchID;
	@FXML
	private Button btnIdSearch;
	@FXML
	private HBox idBox; 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			try {
				if (groupSearch.getSelectedToggle().getUserData().toString().equals("pwSearch")) {
					idBox.setVisible(true);
				}


			} catch (Exception e) {
				System.out.println("btnLogin() error = " + e.getMessage());
			}
			
//			Alert alert = new Alert(AlertType.WARNING);
//			alert.setHeaderText("로그인 결과");
//
//			alert.setContentText("ID 또는 PW가 맞지 않습니다.\n다시 입력해주세요.");
//			alert.showAndWait();
	}

	private void idSearch() {
		// TODO Auto-generated method stub

	}
	
	private void pwSearch() {
		// TODO Auto-generated method stub

	}
	
	public void btnIdSearch(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}
