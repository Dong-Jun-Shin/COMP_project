package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManageResultTabController implements Initializable {
	@FXML
	private BarChart mOrderBarChart;
	@FXML
	private PieChart mSalesPieChart;
	@FXML
	private TableView mComponentRank;
	@FXML
	private BarChart mSalesBarChart;
	@FXML
	private LineChart ySalesLineChart;
	
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void mComponentRank(MouseEvent event){
		
	}
}
