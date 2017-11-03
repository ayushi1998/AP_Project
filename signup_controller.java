package application;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import classes.User;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class signup_controller 
{
	@FXML
	Button login;
	@FXML
	Button submit;
	
	@FXML
	TextField username;
	@FXML
	TextField email;
	
	@FXML
	PasswordField password;
	
	@FXML 
	ComboBox combo;
	
	ArrayList<User> users;
	

	public void login_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) login.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root,600,400);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//pane.getChildren().setAll(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		System.out.println("hello");
	}
	
	public void submit_click(ActionEvent event) throws Exception
	{
		/* 1. Taking inputs form the user.
		 * 2.User object
		 * 3. Serializing
		 */
		//ComboBox 
		
		User u=new User(username.getText(), email.getText(), password.getText(), combo.getValue().toString());
		
		ObjectOutputStream UsersList	=	null;	
		try	
		{	
			UsersList=new ObjectOutputStream(new FileOutputStream("Users.txt"));	
			UsersList.writeObject(u);	
					
		}	
		finally	
		{	
			UsersList.close();	
		}	
	
		
		
		
		
		
		
		
		
	}
	@FXML
	public  void initialize()
	{
		combo.getItems().addAll("Faculty", "Student", "Admin");
		combo.setEditable(true);
	    combo.setPromptText("Enter");
	  
	}

	
	

	
	

}
