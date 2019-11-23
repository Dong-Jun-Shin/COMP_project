package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
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
	private BarChart<String, Integer> mOrderBarChart;
	@FXML
	private PieChart mSalesPieChart;
	@FXML
	private TableView<RankVO> mComponentRank;
	@FXML
	private BarChart<String, Integer> mSalesBarChart;
	@FXML
	private LineChart<String, Integer> ySalesLineChart;

	private CdOrderDAO codao = CdOrderDAO.getInstance();
	private static ObservableList<RankVO> rankDataList = FXCollections.observableArrayList();

	@SuppressWarnings("unused")
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> title = DataUtil.fieldName(new RankVO());

		for (int i = 0; i < title.size(); i++) {
			TableColumn<RankVO, ?> columnName = mComponentRank.getColumns().get(i);
			columnName.setCellValueFactory(new PropertyValueFactory<>(title.get(i)));
		}
		mComponentRank.setItems(rankDataList);
		
		reset();
	}

	public void rankTotalList() {
		rankDataList.removeAll(rankDataList);
		RankVO rvo = null;
		ArrayList<RankVO> list;

		// 제품 구분 코드를 제품 구분 명으로 변경
		HashMap<String, String> p_sort = new HashMap<String, String>();
		String[] key = DataUtil.getKey("id");
		String[] val = DataUtil.getKey("pSort");
		for (int i = 0; i < val.length; i++) {
			p_sort.put(key[i], val[i]);
		}

		try {
			list = codao.getCountRank();

			// Key 기준으로 순서 정렬 
			list = judgeSort(list);

			for (int i = 0; i < list.size(); i++) {
				rvo = list.get(i);
				
				//제품 구분 코드를 제품 구분 명으로 변경
				rvo.setProductSort(p_sort.get(rvo.getProductSort()));
				
				rankDataList.add(rvo);
			}
		} catch (Exception e) {
			System.out.println("[  setMComponentRank()  ]  [  Exception  ]");
			e.printStackTrace();
		}
	}	
	
	public void setMSalesPieChart() {
		Map<String, Integer> resultMap = codao.getChartMonthPrice();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

		for (Map.Entry<String, Integer> result : resultMap.entrySet()) {
			pieChartData.add(new PieChart.Data(result.getKey(), result.getValue()));
		}

		mSalesPieChart.setData(pieChartData);

	}

	@SuppressWarnings("unchecked")
	public void setMOrderBarChart() {
		mOrderBarChart.getData().clear();
		
		Map<String, Integer> resultMap = codao.getChartMonthOrder();
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
			String tmpString = entry.getKey();
			int tmpValue = entry.getValue();
			XYChart.Data<String, Integer> d = new XYChart.Data<String, Integer>(tmpString, tmpValue);
			series.getData().add(d);
		}
		mOrderBarChart.getData().addAll(series);

	}

	public void setMSalesBarChart() {
		mSalesBarChart.getData().clear();
		
		Map<String, Integer> resultMap = codao.getChartMonthPrice();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		for (Map.Entry<String, Integer> result : resultMap.entrySet()) {
			series.getData().add(new Data<String, Integer>(result.getKey(), result.getValue()));

		}
		mSalesBarChart.getData().add(series);

	}

	public void setYSalesLineChart() {
		ySalesLineChart.getData().clear();
		
		Map<String, Integer> resultMap = codao.getChartYearPrice();
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();

		for (Map.Entry<String, Integer> result : resultMap.entrySet()) {
			series.getData().add(new Data<String, Integer>(result.getKey(), result.getValue()));
		}
		ySalesLineChart.getData().add(series);

	}

	private ArrayList<RankVO> judgeSort(ArrayList<RankVO> before) {
		ArrayList<RankVO> after = new ArrayList<RankVO>();
		String[] judge = DataUtil.getKey("id");

		for (int i = 0; i < judge.length; i++) {
			for (int j = 0; j < before.size(); j++) {
				if (judge[i].equals(before.get(j).getProductSort())) {
					after.add(before.get(j));
				}
			}
		}

		return after;
	}
	
	public void reset() {
		rankTotalList();
		setMSalesPieChart();
		setMOrderBarChart();
		setMSalesBarChart();
		setYSalesLineChart();
	}
}
