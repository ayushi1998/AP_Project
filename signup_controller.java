package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


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
import classes.User;

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
	
	 ArrayList<User> userlist=new ArrayList<User>();

	
	public ArrayList<User>  deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		 ArrayList<User> array=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("User.txt"));
			array=(ArrayList<User>) fileread.readObject();
			userlist=array;
			System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return array;
	}
	
	public	static	void	main(String[]	args)	
						throws	IOException,ClassNotFoundException {
	
		
	}
	
	

	public void login_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) login.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root,600,400);
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
		
		//System.out.println(userlist.size());
		ArrayList<User> userlist=deserializefile();
		User u=new User(username.getText(), email.getText(), password.getText(), combo.getValue().toString());
		userlist.add(u);
		System.out.println(userlist.size());
		//userlist=u;
		ObjectOutputStream UsersList	=	null;	
		try	
		{	
			UsersList=new ObjectOutputStream(new FileOutputStream("User.txt"));	
			UsersList.writeObject(userlist);	
					
		}	
		finally	
		{	
			UsersList.close();	
		}	
	
		
		if(combo.getValue().toString()=="Faculty")
		{
			Stage primaryStage=(Stage) submit.getScene().getWindow()  ;
			Pane root= FXMLLoader.load(getClass().getResource("User_Faculty.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//pane.getChildren().setAll(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else if(combo.getValue().toString()=="Student"){
			Stage primaryStage=(Stage) submit.getScene().getWindow()  ;
			Pane root= FXMLLoader.load(getClass().getResource("User_Student.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//pane.getChildren().setAll(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else{
			Stage primaryStage=(Stage) submit.getScene().getWindow()  ;
			Pane root= FXMLLoader.load(getClass().getResource("User_Admin.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//pane.getChildren().setAll(root);
			primaryStage.setScene(scene);
			primaryStage.show();
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
