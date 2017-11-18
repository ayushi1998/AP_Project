package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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
import classes.Admin;
import classes.Faculty;
import classes.Student;
import classes.User;
/**
 * sign up controller
 * @author Tanish and Ayushi 
 *
 */
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
	
	 HashMap<String,User> usermap=new HashMap<String,User>();
	 public static User u;
	 public static Student s;
	 public static Faculty f;
	 public static Admin a;
	
	 /**
	  * deserialie users
	  * 
	  * @throws ClassNotFoundException
	  * @throws IOException
	  */
	public HashMap<String,User> deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		 HashMap<String,User> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("User.txt"));
			hm=(HashMap) fileread.readObject();
			usermap=hm;
			System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return usermap;
	}
	
	public User getUser()
	{
		System.out.println("called"+ u.getUsertype());
		return u;
	}
	
	/**
	 * takes u to login page 
	 * @param event
	 * @throws Exception
	 */
	public void login_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) login.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		//System.out.println("hello");
	}
	/**
	 * gets signed up
	 * @param event
	 * @throws Exception
	 */
	public void submit_click(ActionEvent event) throws Exception
	{
		/* 1. Taking inputs form the user.
		 * 2.User object
		 * 3. Serializing
		 */
		String Username=username.getText();
		String Email=email.getText();
		String Password=password.getText();
		String[] sp=Email.split("@");
		try
		{

		HashMap<String,User> usermap=deserializefile();
		
		}
		catch (NullPointerException e)
		{
			usermap=new HashMap<String,User>();
		}
			
		if(Username.equals("") || Email.equals("") || Password.equals(""))
		{
			System.out.println("Input missing");
		}
		else if(sp[0].equals(Email) || !sp[1].equals("iiitd.ac.in"))
		{
			System.out.println("Input Valid id");
		}
		else
		{
			if(combo.getValue().toString().equals("Student"))	
			{	
				s=new Student(username.getText(), email.getText(), password.getText(), combo.getValue().toString());
				usermap.put(email.getText(), s);
			}
			else if(combo.getValue().toString().equals("Faculty"))	
			{	
				f=new Faculty(username.getText(), email.getText(), password.getText(), combo.getValue().toString());
				usermap.put(email.getText(), f);
			}
			else {
				a=new Admin(username.getText(), email.getText(), password.getText(), combo.getValue().toString());
				usermap.put(email.getText(), a);
			}
		
		//Validate Email
		
		System.out.println(email.getText());
		
		//usermap.put(email.getText(), u);
	
		System.out.println(usermap.size());
		

		ObjectOutputStream UsersList=null;	
		
		try	
		{	
			UsersList=new ObjectOutputStream(new FileOutputStream("User.txt"));	
			UsersList.writeObject(usermap);	
					
		}	
		finally	
		{	
			UsersList.close();	
		}	
	
		
		Stage primaryStage=(Stage) submit.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		//System.out.println("hello");
		
		
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
