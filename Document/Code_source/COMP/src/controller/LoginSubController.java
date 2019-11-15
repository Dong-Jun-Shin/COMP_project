package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import model.DataUtil;
import model.DealerVO;

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
	
	private DealerVO dVO = DealerVO.getInstance();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
	}

	/**
	 * idPwSearch() : 라디오버튼에 따른 ID 텍스트 필드 숨기기
	 * @param event
	 */
	public void idPwSearch(ActionEvent event) {
		if (groupSearch.getSelectedToggle().getUserData().toString().equals("pwSearch")) {
			idBox.setVisible(true);
		}else if(groupSearch.getSelectedToggle().getUserData().toString().equals("idSearch")) {
			idBox.setVisible(false);
		}
	}
	
	/**
	 * btnIdSearch() : ID & PW 찾기
	 * @param parent
	 * @return success 찾기 결과
	 */
	public boolean btnIdSearch(Parent parent) {
		TextField txtBOwner = (TextField) parent.lookup("#txtBOwner");
		TextField txtBNum = (TextField) parent.lookup("#txtBNum");
		TextField txtSearchID = (TextField) parent.lookup("#txtSearchID");
		HBox idBox = (HBox)parent.lookup("#idBox");
		boolean success = false;
		
		//유효성검사
		if (!DataUtil.validityCheck(txtBOwner.getText(), "계좌주를 "))
			return success;
		else if (!DataUtil.validityCheck(txtBNum.getText(), "계좌번호를 "))
			return success;
		else if (idBox.isVisible() && !DataUtil.validityCheck(txtSearchID.getText(), "ID를 "))
			return success;
		
		//입력 정보를 판단 후, 결과 출력
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("ID & PW 결과");
		StringBuffer sb = new StringBuffer();

		if (txtBOwner.getText().equals(dVO.getdBOwner()) && txtBNum.getText().equals(dVO.getdBNum())) {
			sb.append("ID : ");
			sb.append(dVO.getdId());
			if(txtSearchID.getText().equals(dVO.getdId())) {
				sb.append("\nPW : ");
				sb.append(dVO.getdPasswd());
				success = true;
			}else if(idBox.isVisible()){
				sb = new StringBuffer();
				sb.append("ID가 잘못되었습니다.\n");
				sb.append("다시 입력해주세요.\n");
			}
		}else{
			sb.append("계좌주 또는 계좌번호가 잘못되었습니다.\n");
			sb.append("다시 입력해주세요.\n");
		}
		
		alert.setContentText(sb.toString());
		alert.showAndWait();

		return success;
	}
}
