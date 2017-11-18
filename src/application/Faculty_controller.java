package application;

import classes.Faculty;
import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Faculty_controller {
	@FXML
	Button view;
	@FXML
	Button add;
	@FXML
	Button cancel;
	@FXML
	Button viewcourse;
	@FXML
	Button logout;
	@FXML
	Label username;
	
	Login_controller lc=new Login_controller();
	User u;
	Faculty f;
	
	@FXML
	public void initialize() 
	{
		if(lc.getUser() instanceof Faculty)
		{
			f=(Faculty) lc.getUser();
		}
		
		username.setText("WELCOME " + f.getUsername());
		
	}
	public void view_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) view.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("View_Room.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	public void add_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) add.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("BookClass.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	
	public void cancel_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) cancel.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("CancelRoom.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	public void viewcourse_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) viewcourse.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Fac_View_courses.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	public void logout_clicked(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) logout.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	
	
	
}
