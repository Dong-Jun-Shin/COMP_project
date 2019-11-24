package application;
	
import controller.LoginMainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/loginMain.fxml"));
			Parent root = loader.load();

			LoginMainController controller = loader.getController();
			controller.setPrimaryStage(primaryStage);

			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
			
			primaryStage.setTitle("COMP(Component Order Management Program)[Ver1.0]");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println("start() error = " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

//TODO 화면 전환 시, 페이드 인아웃 처리, Jmetro 적용