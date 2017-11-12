package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Handle_requestcontroller {
	
	@FXML
	TextField sno;
	
	@FXML
	ComboBox classroom;
	
	@FXML
	ComboBox ar;
	
	@FXML
	Button confirm;
	
	@FXML
	Button back;
	
	
	public  void initialize()
	{
		
		classroom.getItems().addAll("C01", "C02", "C03");
		ar.getItems().addAll("Yes","No");
		//u=lc.getUser();
		//combo.setEditable(true);
	    //combo.setPromptText("Enter");
	  
	}
	
	
	public void back_click(ActionEvent event) throws Exception
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Admin.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	public void confirm_click(ActionEvent event) throws Exception
	{
		String index=sno.getText();
		String cl=classroom.getValue().toString();
		String status=ar.getValue().toString();
		
		
	}
	

}
