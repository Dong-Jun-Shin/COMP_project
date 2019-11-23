package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DataUtil;
import model.DealerVO;

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

	private DealerVO dvo = DealerVO.getInstance();

	@SuppressWarnings("unused")
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 판매업체 정보 읽기
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/properties_file/DealerVO.dat"))) {
			while (true) {
				dvo = (DealerVO) ois.readObject();
				// 자료가 들어갔으면 멈춘다.
				if (dvo != null) {
					break;
				} else {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			DataUtil.showAlert("정보 읽기 실패", "정보를 읽는 중 문제가 생겼습니다.");
			e.printStackTrace();
		}

		// 각 필드에 판매업체 정보를 설정
		txtDName.setText(dvo.getDName());
		txtDId.setText(dvo.getDId());
		txtDPhone.setText(dvo.getDPhone());
		txtDAddress.setText(dvo.getDAddress());
		txtDBOwner.setText(dvo.getDBOwner());
		txtDBNum.setText(dvo.getDBNum());
		txtDBName.setText(dvo.getDBName());
	}

	/**
	 * btnDUpdate() : 판매업체의 정보가 파일을 통해 수정 및 기록된다.
	 * 
	 * @param event
	 */
	public void btnDUpdate(ActionEvent event) {
		// 각 필드의 유효성 체크
		if (!DataUtil.validityCheck(txtDName.getText(), "업체명")
				|| !DataUtil.valLimitCheck(txtDName.getText(), 30)) {
			return;
		} else if (!DataUtil.validityCheck(txtDPhone.getText(), "전화번호")
				|| !DataUtil.valLimitCheck(txtDPhone.getText(), 13)) {
			return;
		} else if (txtDAddress.getText().equals("") && !DataUtil.valLimitCheck(txtDAddress.getText(), 60)) {
			DataUtil.validityCheck("", "주소를");
		} else if (!DataUtil.validityCheck(txtDBOwner.getText(), "계좌주")
				|| !DataUtil.valLimitCheck(txtDBOwner.getText(), 12)) {
			return;
		} else if (!DataUtil.validityCheck(txtDBNum.getText(), "계좌번호")
				|| !DataUtil.valLimitCheck(txtDBNum.getText(), 16)) {
			return;
		} else if (!DataUtil.validityCheck(txtDBName.getText(), "계좌주")
				|| !DataUtil.valLimitCheck(txtDBName.getText(), 30)) {
			return;
		} else if (pwDPasswd.getText().equals(dvo.getDPasswd())) {
			// 각 필드의 내용을 dvo에 설정
			dvo.setDName(txtDName.getText());
			dvo.setDPhone(txtDPhone.getText());
			dvo.setDAddress(txtDAddress.getText());
			dvo.setDBOwner(txtDBOwner.getText());
			dvo.setDBNum(txtDBNum.getText());
			dvo.setDBName(txtDBName.getText());

			// 판매없체의 정보를 파일로 쓰기
			try (ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("src/properties_file/DealerVO.dat"))) {
				// 판매업체 정보 쓰기
				DealerVO dvoVal = dvo;
				oos.writeObject(dvoVal);
				DataUtil.showInfoAlert("정보 변경 성공", "정보가 변경되었습니다.");
			} catch (IOException io) {
				io.printStackTrace();
			}
		} else {
			DataUtil.showAlert("정보 변경 실패", "비밀번호가 일치하지 않습니다.");
		}
	}
}
