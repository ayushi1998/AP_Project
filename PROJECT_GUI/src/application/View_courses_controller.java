package application;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


// THIS PAGE CAN GO TO FACULTY OR STUDENT

public class View_courses_controller 
{
	@FXML 
	Button back;
	public TableView<sem_course> table;

	public TableColumn<sem_course,String> Sno;

	public TableColumn<sem_course,String> course;

	public TableColumn<sem_course,String> credits;

	public TableColumn<sem_course,String> pc;
	
	ObservableList<sem_course> data = FXCollections.observableArrayList();
	
	Login_controller lc=new Login_controller();
	User v=lc.getUser();
	
	
	
	
	@FXML
	public void initialize()
	{
		
		if(lc.getUser() instanceof Student)
		{
			System.out.println("hi");
			//s=(Student) lc.getUser();
		}
		
		
		 

		      

		 Sno.setCellValueFactory(new PropertyValueFactory<sem_course,String>("sn"));

		 course.setCellValueFactory(new PropertyValueFactory<sem_course,String>("cours"));

		 credits.setCellValueFactory(new PropertyValueFactory<sem_course,String>("credit"));

		 pc.setCellValueFactory(new PropertyValueFactory<sem_course,String>("p"));


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
