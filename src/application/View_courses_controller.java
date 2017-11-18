package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import classes.Course;
import classes.Fac_viewCourses;
import classes.Faculty;
import classes.Student;
import classes.User;
import classes.sem_course;
import classes.view_courses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * Can view registered courses of the student 
 * @author Tanish and Ayushi
 *
 */

public class View_courses_controller 
{
	@FXML 
	Button back;
	
	Login_controller lc=new Login_controller();
	User v=lc.getUser();
	Student s;
	public TableView<view_courses> table;
	public TableColumn<view_courses,String> man;
	public TableColumn<view_courses,String> course;
	public TableColumn<view_courses,String> code;
	public TableColumn<view_courses,String> ins;
	public TableColumn<view_courses,String> credits;
	
	
	 ObservableList<view_courses> data = FXCollections.observableArrayList();
	 ArrayList<Course> courses=new ArrayList<Course>();
	 
	 public ArrayList<Course> deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("AllCourses.txt"));
			courses=(ArrayList) fileread.readObject();
			
			//System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return courses;
		
	}
	  
	  /**
	   * displays courses in the tablel
	   * @throws ClassNotFoundException
	   * @throws IOException
	   */
	  
	  @FXML
	  public void initialize() throws ClassNotFoundException, IOException 
	  {
		  
	     // ObservableList<sem_course> data = FXCollections.observableArrayList();
		  
	      
			man.setCellValueFactory(new PropertyValueFactory<view_courses,String>("man"));
			course.setCellValueFactory(new PropertyValueFactory<view_courses,String>("course"));
			code.setCellValueFactory(new PropertyValueFactory<view_courses,String>("code"));
			ins.setCellValueFactory(new PropertyValueFactory<view_courses,String>("ins"));
			credits.setCellValueFactory(new PropertyValueFactory<view_courses,String>("credits"));
			
			if(lc.getUser() instanceof Student)
			{
				s=(Student)lc.getUser();
			}
			
			courses=deserializefile();
			//display courses of student
			int i=1;
			view_courses vc;
			for(Course c:s.getClist())
			{
				vc=new view_courses(c.getCoption(),c.getCname(),c.getCcode(),c.getInstr(),c.getCredits());
				data.add(vc);
				i++;
			}
			
			
			table.setItems(data);
	
	
	
	
	
	
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
		System.out.println(v.getUsertype());
	}
	

}
