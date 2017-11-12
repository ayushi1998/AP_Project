package application;

import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


// THIS PAGE CAN GO TO FACULTY OR STUDENT

public class View_courses_controller 
{
	@FXML 
	Button back;
	
	Login_controller lc=new Login_controller();
	User v=lc.getUser();
	
	public void back_click(ActionEvent event) throws Exception
	{
		
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Student.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println(v.getUsertype());
	}
	

}
