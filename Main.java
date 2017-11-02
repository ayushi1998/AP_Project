package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage=primaryStage;
			//BorderPane root = new BorderPane();
			Parent root= FXMLLoader.load(getClass().getResource("Sign_Up.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//signup_controller sc=new signup_controller(primaryStage);
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
