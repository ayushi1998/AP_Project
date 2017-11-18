package application;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import classes.Course;
import classes.Fac_viewCourses;
import classes.Faculty;
import classes.Request;
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


public class Fac_viewcoursescontroller {


		@FXML 
		Button back;
		
		Login_controller lc=new Login_controller();
		User v=lc.getUser();
		Faculty f;
		public TableView<Fac_viewCourses > table;
		public TableColumn<Fac_viewCourses ,String> man;
		public TableColumn<Fac_viewCourses ,String> course;
		public TableColumn<Fac_viewCourses ,String> code;
		public TableColumn<Fac_viewCourses ,String> credits;
		
		
		 ObservableList<Fac_viewCourses> data = FXCollections.observableArrayList();
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
		  
		  @FXML
		  public void initialize() throws ClassNotFoundException, IOException 
		  {
	            man.setCellValueFactory(new PropertyValueFactory<Fac_viewCourses ,String>("man"));
				course.setCellValueFactory(new PropertyValueFactory<Fac_viewCourses ,String>("course"));
				code.setCellValueFactory(new PropertyValueFactory<Fac_viewCourses ,String>("code"));
				credits.setCellValueFactory(new PropertyValueFactory<Fac_viewCourses ,String>("credits"));
				
				if(lc.getUser() instanceof Faculty)
				{
					f=(Faculty)lc.getUser();
				}
				
				courses=deserializefile();
				//display courses of faculty
				int i=1;
				Fac_viewCourses fvc;
				for(Course c:courses)
				{
					if(f.getUsername().equals(c.getInstr()))
					{
						fvc=new Fac_viewCourses(c.getCoption(),c.getCname(),c.getCcode(),c.getCredits());
						data.add(fvc);
						i++;
					}
				}
				table.setItems(data);
          }
		
		
		
		
		
		public void back_click(ActionEvent event) throws Exception
		{
			
			Stage primaryStage=(Stage) back.getScene().getWindow()  ;
			Pane root= FXMLLoader.load(getClass().getResource("User_Faculty.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//pane.getChildren().setAll(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println(v.getUsertype());
		}
		

	
}
