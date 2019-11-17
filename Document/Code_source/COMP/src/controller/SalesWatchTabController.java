package controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.DataUtil;
import model.ProductDAO;
import model.ProductVO;

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

	private SalesTradeTabController sttController;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setSttController(SalesTradeTabController sttController) {
		this.sttController = sttController;
	}

	private ProductDAO pdDao = ProductDAO.getInstance();

	// 선택된 제품 종류
	private String key = null;

	// 제품 페이지 카운트
	private int pPageNum = 0;

	// 이미지 파일명
	private String selectFileName[] = new String[16];
	// 이미지 파일 경로
	private String localUrl = "";
	private Image localImage;

	// 제품조회 서브창 팝업
	private Popup popup = new Popup();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TreeItem에 사용할 이미지와 TreeItem 객체 생성
		Image comChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/COM.png"), 10, 10, false, false);
		Image cpChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/CP.png"), 16, 16, false, false);
		Image rChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/R.png"), 16, 16, false, false);
		Image mbChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/MB.png"), 16, 16, false, false);
		Image gChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/G.png"), 16, 16, false, false);
		Image ssChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/SS.png"), 16, 16, false, false);
		Image hChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/H.png"), 16, 16, false, false);
		Image poChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/PO.png"), 16, 16, false, false);
		Image caChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/CA.png"), 16, 16, false, false);
		Image coChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/CO.png"), 16, 16, false, false);
		Image swChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/SW.png"), 16, 16, false, false);
		Image kChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/K.png"), 16, 16, false, false);
		Image moChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/MO.png"), 16, 16, false, false);
		Image spChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/SP.png"), 16, 16, false, false);
		Image mnChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/MN.png"), 16, 16, false, false);

		TreeItem<String> CP = new TreeItem<String>("CPU", new ImageView(cpChildIcon));
		TreeItem<String> R = new TreeItem<String>("RAM", new ImageView(rChildIcon));
		TreeItem<String> MB = new TreeItem<String>("MB", new ImageView(mbChildIcon));
		TreeItem<String> G = new TreeItem<String>("GPU", new ImageView(gChildIcon));
		TreeItem<String> SS = new TreeItem<String>("SSD", new ImageView(ssChildIcon));
		TreeItem<String> H = new TreeItem<String>("HDD", new ImageView(hChildIcon));
		TreeItem<String> PO = new TreeItem<String>("파워", new ImageView(poChildIcon));
		TreeItem<String> CA = new TreeItem<String>("케이스", new ImageView(caChildIcon));
		TreeItem<String> CO = new TreeItem<String>("쿨러", new ImageView(coChildIcon));
		TreeItem<String> SW = new TreeItem<String>("SW", new ImageView(swChildIcon));
		TreeItem<String> K = new TreeItem<String>("키보드", new ImageView(kChildIcon));
		TreeItem<String> MO = new TreeItem<String>("마우스", new ImageView(moChildIcon));
		TreeItem<String> SP = new TreeItem<String>("스피커", new ImageView(spChildIcon));
		TreeItem<String> MN = new TreeItem<String>("모니터", new ImageView(mnChildIcon));

		// CSS 적용
		productTreeView.getStylesheets().add("/application/treeView.css");
		productTreeView.getStyleClass().add("my-tree-view");

		// TreeView 생성
		TreeItem<String> root = new TreeItem("제품구성", new ImageView(comChildIcon));
		Object[] subRoot = { CP, R, MB, G, SS, H, PO, CA, CO, SW, K, MO, SP, MN };

		root.setExpanded(true);
		for (int i = 0; i < subRoot.length; i++) {
			TreeItem<String> item = (TreeItem<String>) subRoot[i];
			root.getChildren().add(item);
		}

		productTreeView.setCellFactory(treeView -> new MyTreeCell());
		productTreeView.setRoot(root);

		productTreeView.getSelectionModel().select(1);

		btnLast.setDisable(true);
	}

	/**
	 * imageSel() : 이미지 선택 시, 제품조회 서브창 호출
	 * 
	 * @param event
	 */
	public void imageSel(MouseEvent event) {
		ImageView selImg = (ImageView) event.getSource();

		if (!(selImg.getImage() == null)) {
			Stage stage = (Stage) selImg.getScene().getWindow();
			try {
				// 파일명이 저장된 배열의 인덱스로 변환
				String viewName = selImg.getId();
				int row = Integer.parseInt(viewName.substring(viewName.length() - 1, viewName.length()));
				int col = Integer.parseInt(viewName.substring(viewName.length() - 2, viewName.length() - 1));
				int imgIdx = (col) + (row * 4);

				// pvo 값 호출
//				ArrayList<ProductVO> list = pdDao.getProductSelected(key + "_" + selectFileName[imgIdx]); 
				ArrayList<ProductVO> list = pdDao.getProductSelected("p_num","SW_002");
				ProductVO pvo = new ProductVO();

				if (list.size() > 0) {
					pvo = list.get(0);
				}
				pvo.setP_num(key + "_001");
				// 팝업의 FXML 로드
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/salesWatchSub.fxml"));
				Parent parent = loader.load();

				// Popup의 배경색, 테두리 설정
				parent.setStyle("-fx-background-color:white;" + "-fx-border-color: skyblue;" + "-fx-border-width:2;"
						+ "-fx-border-radius:3;" + "-fx-hgap:3;-fx-vgap:5;");

				// 로드된 FXML의 Controller 연결
				SalesWatchSubController swsController = loader.getController();
				swsController.setSttController(sttController);
				swsController.setStage(stage);
				swsController.setPopup(popup);
				swsController.setPvo(pvo);
				swsController.setPInfo();
				swsController.handlePopup(parent);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * btnPageMove() : 페이지 이동
	 * 
	 * @param event
	 */
	public void btnPageMove(ActionEvent event) {
		// ImageView 갯수
		int imgViewCnt = 16;
		// 이전으로 넘어갈 페이지의 제품시작 번호가 0보다 크면 실행.
		boolean sPage = 0 < (pPageNum - 1) * imgViewCnt + 1;
		// 다음으로 넘어갈 페이지의 제품시작 번호가 파일개수보다 작으면 실행
		boolean ePage = getFileCount() > (pPageNum + 1) * imgViewCnt + 1;

		// 이전이나 다음버튼이 눌리면 실행
		if (event.getSource() == btnLast) {
			// 첫 페이지 확인. false = 첫 페이지
			if (sPage) {
				setImgView(-1);
			}
		} else if (event.getSource() == btnNext) {
			// 끝 페이지 확인. false = 끝 페이지
			if (ePage) {
				setImgView(1);
			}
		}
		setPageBtn();
	}

	/**
	 * setPageBtn() : 첫 페이지거나 끝 페이지에 따른 버튼 제어
	 * 
	 * @param bool    페이지가 처음이거나 끝인지 판단. false면 처음이거나 끝.
	 * @param selFunc 이전버튼으로 인한 앞으로 이동인지, 다음버튼으로 인한 뒤로 이동인지 판단.
	 */
	private void setPageBtn() {
		// 첫 페이지면 이전버튼 비활성화
		if (0 == pPageNum) {
			btnLast.setDisable(true);
		}else {
			btnLast.setDisable(false);
		}
		
		// 끝 페이지면 다음버튼 비활성화
		if (pPageNum == getFileCount() / 16) {
			btnNext.setDisable(true);
		}else {
			btnNext.setDisable(false);
		}
	}

	/**
	 * setKey() : 각 TreeItem에 따른 고유값 부여
	 * 
	 * @param id 판단할 ID
	 */
	private void setKey(String id) {
		String idKey[] = {"CPU", "RAM", "MB", "GPU", "SSD", "HDD", "파워", "케이스", "쿨러", "SW", "키보드", "마우스", "스피커", "모니터"};
		String idVal[] = {"CP", "R", "MB", "G", "SS", "H", "PO", "CA", "CO", "SW", "K", "MO", "SP", "MN"};
		
		HashMap<String, String> dicKey = new HashMap<String, String>();
		
		for (int i = 0; i < idKey.length; i++) {
			dicKey.put(idKey[i], idVal[i]);
		}
	
		key = dicKey.get(id);
	}

	/**
	 * setImgView() : ImageView에 목록사진을 보여준다.
	 * 
	 * @param selFunc 1이면 다음 페이지, -1이면 이전 페이지
	 */
	private void setImgView(int selFunc) {
		if (selFunc <= 1 && selFunc >= -1) {

			// 페이지 변동
			pPageNum += selFunc;
			localUrl = "/image/" + key + "/";

			// 폴더의 존재 여부 확인

			// 설정할 ImageView 배열
			ImageView[] imgViewArr = { productImageView00, productImageView10, productImageView20, productImageView30,
					productImageView01, productImageView11, productImageView21, productImageView31, productImageView02,
					productImageView12, productImageView22, productImageView32, productImageView03, productImageView13,
					productImageView23, productImageView33, };

			// ImageView 새로고침시, 초기화
			for (int i = 0; i < imgViewArr.length; i++) {
				imgViewArr[i].setImage(null);
			}

			// 시작 인덱스 설정
			int sIdx = pPageNum * 16 + 1;

			// 끝 인덱스 설정
			int eIdx = 0;

			// 페이지 제품의 마지막 인덱스가 파일개수보다 크면 파일개수로 설정
			if (!((eIdx = getFileCount()) < (pPageNum + 1) * 16)) {
				eIdx = (pPageNum + 1) * 16;
			}

			// ImageView에 이미지 설정
			for (int i = sIdx, j = 0; i <= eIdx; i++, j++) {
				selectFileName[j] = String.format("%03d", i);

				if (new File("src" + localUrl + selectFileName[j] + ".jpg").isFile()) {
					localImage = new Image(getClass().getResourceAsStream(localUrl + selectFileName[j] + ".jpg"), 170,
							170, false, false);
					imgViewArr[j].setImage(localImage);
				} else {
					DataUtil.showAlert("이미지 읽기 오류", "\"" + key + selectFileName[j] + ".jpg\"" + " 파일이 없습니다.");
					eIdx += 1;
					j--;
				}
			}
		}
	}

	/**
	 * getFileCount() : 폴더 내 jpg의 개수를 센다.
	 * 
	 * @return count jpg의 개수를 반환
	 */
	private int getFileCount() {
		File dir = new File("src" + localUrl);
		int count = 0;

		if (dir.exists()) {
			File[] files = dir.listFiles();
			for (File item : files) {
				if (item.getName().endsWith(".jpg")) {
					count++;
				}
			}
		} else {
			DataUtil.showAlert("이미지 읽기 오류", "이미지 폴더가 없습니다.");
		}

		return count;
	}

	/**
	 * TreeView 이벤트 적용을 위한 내부 클래스
	 */
	class MyTreeCell extends TreeCell<String> {
		public MyTreeCell() {
			selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					// Root 선택시 기능제어
					if (newValue && !getTreeItem().getValue().equals("제품구성")) {
						// 페이지번호 초기화
						pPageNum = 0;
						// 현재 선택된 TreeItem에 따른 고유값 부여
						setKey(getTreeItem().getValue());
						// ImageView에 첫 페이지 이미지 설정
						setImgView(0);
						// 이동에 따른 첫 페이지 초기화
						setPageBtn();
					}
				}
			});
		}

		@Override
		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			if (!empty) {
				setText(item);
				setGraphic(getTreeItem().getGraphic());
			} else {
				setText(null);
				setGraphic(null);
			}
		}
	}
}
