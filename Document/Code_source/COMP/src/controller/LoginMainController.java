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
import model.DealerVO;

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

	private DealerVO dVO = new DealerVO();

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

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

	public void btnLogin(ActionEvent event) {
		if (txtLoginId.getText().equals(dVO.getdId()) && pwLoginPasswd.getText().equals(dVO.getdPasswd())) {
			try {
				Parent root = null;
				if (groupChoice.getSelectedToggle().getUserData().toString().equals("salesLogin")) {
					root = FXMLLoader.load(getClass().getResource("/view/salesMain.fxml"));
				} else if (groupChoice.getSelectedToggle().getUserData().toString().equals("managerLogin")) {
					root = FXMLLoader.load(getClass().getResource("/view/manageMain.fxml"));
				}

				Scene scene = new Scene(root);
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				System.out.println("btnLogin() error = " + e.getMessage());
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("로그인 결과");

			alert.setContentText("ID 또는 PW가 맞지 않습니다.\n다시 입력해주세요.");
			alert.showAndWait();
		}
	}

	public void btnIdFindPopup(ActionEvent event) {
		Object btn = event.getSource();
		// StageStyle.UTILITY : 배경이 흰색이고, 제목줄에 타이틀, 종료버튼만 존재.
		Stage dialog = new Stage(StageStyle.UTILITY);
		// 모달 다이얼로그는 다이얼로그를 닫기 전까지 소유자 윈도우 사용 불가
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("삭제 여부 확인");

		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("/view/loginSub.fxml"));
			Button btnIdSearch = (Button) parent.lookup("#btnIdSearch");
			btnIdSearch.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					(new LoginSubController()).btnIdSearch(event);
				}
			});
			
		} catch (Exception e) {
			System.out.println("btnIdFindPopup() error = " + e.getMessage());
		}

		Scene scene = new Scene(parent);
		dialog.setScene(scene);
		dialog.setResizable(false);
		dialog.show();
	}
}
