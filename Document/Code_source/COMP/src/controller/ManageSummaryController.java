package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class ManageSummaryController implements Initializable {
	@FXML
	private Label lblLoginDate;
	@FXML
	private Label lblDId;
	@FXML
	private Label lblDName;
	@FXML
	private TextArea txtNoticeArea;
	@FXML
	private Label lblOrderDate;
	@FXML
	private Label lblOrderCount;
	@FXML
	private TableView orderSummaryView;
	@FXML
	private Button btnManageMove;
	@FXML
	private BarChart mSalesBarChart;
	@FXML
	private LineChart ySalesLineChart;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void orderSummaryView(MouseEvent event) {

	}
	
	public void btnManageMove(ActionEvent event) {

	}
	
}
