package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.CdOrderDAO;
import model.DataUtil;
import model.RankVO;

public class ManageResultTabController implements Initializable {
	@FXML
	private BarChart mOrderBarChart;
	@FXML
	private PieChart mSalesPieChart;
	@FXML
	private TableView<RankVO> mComponentRank;
	@FXML
	private BarChart<String , Integer> mSalesBarChart;
	@FXML
	private LineChart ySalesLineChart;
	
	private CdOrderDAO codao = CdOrderDAO.getInstance();
	private static ObservableList<RankVO> rankDataList = FXCollections.observableArrayList();
	
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setMComponentRank();
		List<String> title = DataUtil.fieldName(new RankVO());
		
		for(int i = 0; i < title.size(); i++) {
			TableColumn<RankVO, ?> columnName = mComponentRank.getColumns().get(i);
			columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}
		mComponentRank.setItems(rankDataList);
		
		
		
		
		setMSalesPieChart();
		
	}

	public void mComponentRank(MouseEvent event){
		
	}
	
	public void setMSalesPieChart() {
		Map<String, Integer> resultMap = codao.getChartMonthPrice();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
				
		for(Map.Entry<String, Integer> result : resultMap.entrySet()) {
			pieChartData.add(new PieChart.Data(result.getKey(), result.getValue()));	
		}
		
		mSalesPieChart.setData(pieChartData);
		
	}
	
	public void setMOrderBarChart() {
		
		
		
	}
	
	public void setMComponentRank() {
		rankDataList.removeAll(rankDataList);
		RankVO rvo = null;
		ArrayList<RankVO> list;
		
		try {
			list = codao.getCountRank();
			for (int index = 0; index < list.size(); index++) {
				rvo = list.get(index);
				rankDataList.add(rvo);
			}
			
		}catch(Exception e) {
			System.out.println("[  setMComponentRank()  ]  [  Exception  ]");
		}
		
	}
	
	
	public void setMSalesBarChart() {
		
		
	}
	
	public void setYSalesLineChart() {
		
		
	}
	
	
	
	
	
	
	
}
