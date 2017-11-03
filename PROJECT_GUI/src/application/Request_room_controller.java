package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Request_room_controller {
	@FXML 
	ComboBox weekday;
	
	@FXML 
	ComboBox classroom;
	@FXML 
	TextField purpose;
	@FXML 
	Button back;
	
	@FXML
	public  void initialize()
	{
		weekday.getItems().addAll("Monday", "Tuesday", "Wednesday");
		classroom.getItems().addAll("C01", "C02", "C03");
		
		//combo.setEditable(true);
	    //combo.setPromptText("Enter");
	  
	}
	
	public void back_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Student.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
}
