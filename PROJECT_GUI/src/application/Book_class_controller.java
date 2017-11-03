package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Book_class_controller {
	@FXML 
	ComboBox weekday;
	
	@FXML 
	ComboBox classroom;
	
	
	@FXML
	public  void initialize()
	{
		weekday.getItems().addAll("Monday", "Tuesday", "Wednesday");
		classroom.getItems().addAll("C01", "C02", "C03");
		
		//combo.setEditable(true);
	    //combo.setPromptText("Enter");
	  
	}

}
