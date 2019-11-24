package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	 * btnLogin() : 선택한 라디오 버튼에 따라 해당 화면으로 전환
	 * 
	 * @param event
	 */
	public void btnLogin(ActionEvent event) {
		// 유효성검사
		if (!DataUtil.validityCheck(txtLoginId.getText(), "ID를 "))
			return;
		else if (!DataUtil.validityCheck(pwLoginPasswd.getText(), "PW를 "))
			return;

		if (txtLoginId.getText().equals(dVO.getDId()) && pwLoginPasswd.getText().equals(dVO.getDPasswd())) {
			try {
				FXMLLoader loader = null;
				Parent root = null;
				
				SalesMainController sController = null;
				ManageMainController mController = null;
				
				// 라디오 버튼에 따른 창을 로드
				if (groupChoice.getSelectedToggle().getUserData().toString().equals("salesLogin")) {
					loader = new FXMLLoader(getClass().getResource("/view/salesMain.fxml"));
					root = loader.load();
					sController = loader.getController();
					sController.setPrimaryStage(primaryStage);
				} else if (groupChoice.getSelectedToggle().getUserData().toString().equals("managerLogin")) {
					loader = new FXMLLoader(getClass().getResource("/view/manageMain.fxml"));
					root = loader.load();
					mController = loader.getController();
					mController.setPrimaryStage(primaryStage);
				}

				Scene scene = new Scene(root);

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
	 * btnIdFindPopup() : 'ID & PW 찾기' Modal을 띄운다. 
	 * 
	 * @param event
	 */
	public void btnIdFindPopup(ActionEvent event) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("ID & PW 찾기");

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/loginSub.fxml"));
			Parent parent = loader.load();

			LoginSubController lsController = loader.getController();
			lsController.setDialog(dialog);

			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		} catch (Exception e) {
			System.out.println("btnIdFindPopup() error = " + e.getMessage());
		}
	}
}
