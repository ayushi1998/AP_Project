package application;

import classes.Course;
import classes.Student;
import classes.schedule_table;
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

public class View_schedule_controller {
	@FXML 
	Button back;
	public TableView<schedule_table> table;

	public TableColumn<schedule_table,String> course;
	public TableColumn<schedule_table,String> mon;
	public TableColumn<schedule_table,String> tue;
	public TableColumn<schedule_table,String> wed;
	public TableColumn<schedule_table,String> thur;
	public TableColumn<schedule_table,String> fri;
	public TableColumn<schedule_table,String> tut;
	public TableColumn<schedule_table,String> lab;

	
	ObservableList<schedule_table> data = FXCollections.observableArrayList();
	Login_controller lc=new Login_controller();
    Student s;
	schedule_table st;
	public void initialize() 
	{
		
		if(lc.getUser() instanceof Student)
		{
			System.out.println("hi");
			s=(Student) lc.getUser();
		}
		  
		table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY); 
		
		 course.setCellValueFactory(new PropertyValueFactory<schedule_table,String>("course"));
		 mon.setCellValueFactory(new PropertyValueFactory<schedule_table,String>("mon_slot"));
		 tue.setCellValueFactory(new PropertyValueFactory<schedule_table,String>("tue_slot"));
		 wed.setCellValueFactory(new PropertyValueFactory<schedule_table,String>("wed_slot"));
		 thur.setCellValueFactory(new PropertyValueFactory<schedule_table,String>("thu_slot"));
		 fri.setCellValueFactory(new PropertyValueFactory<schedule_table,String>("fri_slot"));
		 tut.setCellValueFactory(new PropertyValueFactory<schedule_table,String>("tut_slot"));
		 lab.setCellValueFactory(new PropertyValueFactory<schedule_table,String>("lab_slot"));	
		 
		 
		 for(Course c: s.getClist())
		 {
			 st=new schedule_table(c.getCname(),c.getMon_slot(),c.getTue_slot(),c.getWed_slot(),c.getThu_slot(),c.getFri_slot(),c.getTut_slot(),c.getLab_slot());
			 data.add(st);
			 
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
		System.out.println("hello");
	}
	
	
	
	
	
	
}
