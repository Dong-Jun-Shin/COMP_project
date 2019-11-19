package application;
	
import controller.LoginMainController;
import controller.ManageMainController;
import controller.SalesMainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/loginMain.fxml"));
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/salesMain.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/manageMain.fxml"));
			//연결된 소스 속의 모든 객체를 생성하는 load()
			Parent root = loader.load();
			
//			LoginMainController controller = loader.getController();
//			SalesMainController controller = loader.getController();
			ManageMainController controller = loader.getController();
//			controller.setPrimaryStage(primaryStage);

			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
			
			primaryStage.setTitle("COMP(Component Order Management Program)[Ver1.0]");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


//TODO 다 끝나면 printStack 찾아서 getMessage로 바꾸기
//TODO 다 끝나면 주석 확인하기
