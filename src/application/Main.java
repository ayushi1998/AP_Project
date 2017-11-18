package application;
	
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import classes.Room;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main  extends Application implements Serializable  {
	
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
			

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	static HashMap<String,ArrayList<Room>> hm2=new HashMap<String,ArrayList<Room>>();
	
	public static void main(String[] args) throws Exception{

		launch(args);
	}
}
