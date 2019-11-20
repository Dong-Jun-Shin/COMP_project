package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DataUtil;
import model.DealerVO;

public class LoginMainController implements Initializable {
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

	private DealerVO dVO = DealerVO.getInstance();

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void menuClose(ActionEvent event) {
		MenuController.menuClose();
	}

	public void menuConnectInfo(ActionEvent event) {
		MenuController.menuConnectInfo();
	}

	public void menuProgramInfo(ActionEvent event) {
		MenuController.menuProgramInfo();
	}

	/**
	 * btnLogin() : 로그인
	 * 
	 * @param event
	 */
	public void btnLogin(ActionEvent event) {
		// 유효성검사
		if (!DataUtil.validityCheck(txtLoginId.getText(), "ID를 "))
			return;
		else if (!DataUtil.validityCheck(pwLoginPasswd.getText(), "PW를 "))
			return;
		
		// 로그인
		if (txtLoginId.getText().equals(dVO.getDId()) && pwLoginPasswd.getText().equals(dVO.getDPasswd())) {
			try {
				Parent root = null;
				// 라디오 버튼에 따른 창을 로드
				if (groupChoice.getSelectedToggle().getUserData().toString().equals("salesLogin")) {
					root = FXMLLoader.load(getClass().getResource("/view/salesMain.fxml"));
				} else if (groupChoice.getSelectedToggle().getUserData().toString().equals("managerLogin")) {
					root = FXMLLoader.load(getClass().getResource("/view/manageMain.fxml"));
				}

				Scene scene = new Scene(root);
//            	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				System.out.println("btnLogin() error = " + e.getMessage());
			}
		} else {
			DataUtil.showAlert("로그인 결과", "ID 또는 PW가 맞지 않습니다.\n다시 입력해주세요.");
		}
	}

	/**
	 * btnIdFindPopup() : ID & PW 찾기
	 * 
	 * @param event
	 */
	public void btnIdFindPopup(ActionEvent event) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("ID & PW 찾기");

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/loginSub.fxml"));
			Button btnIdSearch = (Button) parent.lookup("#btnIdSearch");
			btnIdSearch.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					LoginSubController lsController = new LoginSubController();
					if (lsController.btnIdSearch(parent) == true) {
						dialog.close();
					}
				}
			});

			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			System.out.println("btnIdFindPopup() error = " + e.getMessage());
		}
	}
}
