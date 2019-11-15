package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image comChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/COM.png"), 10, 10, false, false);
		Image cpChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/CP.png"), 10, 10, false, false);
		Image rChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/R.png"), 10, 10, false, false);
		Image mbChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/MB.png"), 10, 10, false, false);
		Image gChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/G.png"), 10, 10, false, false);
		Image ssChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/SS.png"), 10, 10, false, false);
		Image hChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/H.png"), 10, 10, false, false);
		Image poChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/PO.png"), 10, 10, false, false);
		Image caChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/CA.png"), 10, 10, false, false);
		Image coChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/CO.png"), 10, 10, false, false);
		Image swChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/SW.png"), 10, 10, false, false);
		Image kChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/K.png"), 10, 10, false, false);
		Image moChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/MO.png"), 10, 10, false, false);
		Image spChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/SP.png"), 10, 10, false, false);
		Image mnChildIcon = new Image(getClass().getResourceAsStream("/image/TreeView/MN.png"), 10, 10, false, false);

		productTreeView.getStylesheets().add("/application/treeView.css");
		productTreeView.getStyleClass().add("my-tree-view");

		TreeItem<String> root = new TreeItem("제품구성", new ImageView(comChildIcon));
		Object[] subRoot = { new TreeItem<String>("CPU", new ImageView(cpChildIcon)),
				new TreeItem<String>("RAM", new ImageView(rChildIcon)),
				new TreeItem<String>("MB", new ImageView(mbChildIcon)),
				new TreeItem<String>("GPU", new ImageView(gChildIcon)),
				new TreeItem<String>("SSD", new ImageView(ssChildIcon)),
				new TreeItem<String>("HDD", new ImageView(hChildIcon)),
				new TreeItem<String>("파워", new ImageView(poChildIcon)),
				new TreeItem<String>("케이스", new ImageView(caChildIcon)),
				new TreeItem<String>("쿨러", new ImageView(coChildIcon)),
				new TreeItem<String>("SW", new ImageView(swChildIcon)),
				new TreeItem<String>("키보드", new ImageView(kChildIcon)),
				new TreeItem<String>("마우스", new ImageView(moChildIcon)),
				new TreeItem<String>("스피커", new ImageView(spChildIcon)),
				new TreeItem<String>("모니터", new ImageView(mnChildIcon)), };

		root.setExpanded(true);
		for (int i = 0; i < subRoot.length; i++) {
			TreeItem<String> item = (TreeItem<String>) subRoot[i];
			item.setExpanded(true);
			root.getChildren().add(item);
		}

		// productTreeView.setCellFactory(treeView -> new MyTreeCell());
		productTreeView.setRoot(root);

		productTreeView.getSelectionModel().select(0);
	}

	public void imageSel(MouseEvent event) {

	}

	public void btnPageMove(ActionEvent event) {

	}
}

//TODO 트리뷰 이벤트 적용 
//class MyTreeCell extends TreeCell<String> {
//
//	public MyTreeCell() {
//
//		// 이벤트 처리..
//
//	}
//
//	@Override
//	protected void updateItem(String item, boolean empty) {
//		super.updateItem(item, empty);
//		if (!empty) {
//			setText(item);
//			MyTreeItem treeItem = (MyTreeItem) getTreeItem();
//			setGraphic(new ImageView(treeItem.getNormalIcon()));
//		} else {
//			setText(null);
//			setGraphic(null);
//		}
//	}
//}
