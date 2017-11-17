package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Course;
import classes.Request;
import classes.Student;
import classes.User;
import classes.sem_course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Add_courses_controller {
	@FXML 
	Button back;
	@FXML
	Button register;
	@FXML
	TextField searchbar;
	@FXML
	Button search;
	@FXML
	TextField sno;
	
	//
	public TableView<sem_course> table;

	public TableColumn<sem_course,String> Sno;

	public TableColumn<sem_course,String> course;

	public TableColumn<sem_course,String> credits;

	public TableColumn<sem_course,String> pc;
	ObservableList<sem_course> data = FXCollections.observableArrayList();

	
	ArrayList<Course> arr=new ArrayList<Course>();
	Login_controller lc=new Login_controller();
	Student s;
	ArrayList<Course> shortlist=new ArrayList<Course>();
	ArrayList<String> shortlist_name=new ArrayList<String>();
	HashMap<String,User> usermap=new HashMap<String,User>();
	
	
	@FXML
	public void initialize()
	{
		
		if(lc.getUser() instanceof Student)
		{
			System.out.println("hi");
			s=(Student) lc.getUser();
		}
		
		 

		      

		 Sno.setCellValueFactory(new PropertyValueFactory<sem_course,String>("sn"));

		 course.setCellValueFactory(new PropertyValueFactory<sem_course,String>("cours"));

		 credits.setCellValueFactory(new PropertyValueFactory<sem_course,String>("credit"));

		 pc.setCellValueFactory(new PropertyValueFactory<sem_course,String>("p"));



		 
		//System.out.println(s.);
	}
	
	
	public ArrayList<Course> deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("AllCourses.txt"));
			arr=(ArrayList) fileread.readObject();
			
			System.out.println("function");
			
		}
		finally{
			fileread.close();
		}
		return arr;
		
	}
	
	public HashMap<String,User> deserialize_user() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
		ObjectInputStream fileread=null;
		HashMap<String,User> h=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("User.txt"));
			h=(HashMap) fileread.readObject();
			usermap=h;
			
		}
		finally{
			fileread.close();
		}
		return h;
	}
	
	public void search_click(ActionEvent event) throws Exception
	{
		String[] pc=searchbar.getText().split(" ");
		
		
		try
		{			
		 arr=deserializefile(); 
		}
		catch (NullPointerException e)
		{
			arr=new ArrayList<Course>();
		}
		
		
		for(Course c: arr)
		{
			for(int i=0;i<pc.length;i++)
			{
				for(int j=0;j<c.getKeywords().length;j++)
				{		
					//System.out.println(shortlist.contains(c));
					if(pc[i].toLowerCase().equals(c.getKeywords()[j].toLowerCase()) && !shortlist_name.contains(c.getCname()) && !c.getCoption().equals("Mandatory"))  
					{
						//s.getClist().add(c);\
						System.out.println(c.getCname());
						shortlist.add(c);
						shortlist_name.add(c.getCname());
						break;
					}
				}
			}
		}
		
		// Now display shortlisted course name and post condition in the table
		int i=1;
		sem_course sem;
		for(Course c: shortlist)
		{
			sem=new sem_course(Integer.toString(i),c.getCname(),c.getCredits(),c.getPostcond());
			data.add(sem);
			i++;
		}
		table.setItems(data);
	}
	
	public void register_click(ActionEvent event) throws Exception
	{
		int index=Integer.parseInt(sno.getText());
		
		
		s.getClist().add(shortlist.get(index-1));
		
		System.out.println(s.getClist().get(3).getCname());
		//now serialize student back to the data base
		 usermap=deserialize_user();
		 usermap.put(s.getEmail(), s);
		 
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
