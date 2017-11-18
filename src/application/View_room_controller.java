package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Room;
import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * displays status of the rooms 
 * @author TANISH GUPTA
 *
 */
public class View_room_controller 
{
	@FXML 
	DatePicker date;
	
	@FXML 
	ComboBox classroom;
	
	@FXML
	Button submit;
	
	@FXML
	TextField f_h;
	@FXML
	TextField f_m;
	@FXML
	TextField t_h;
	@FXML
	TextField t_m;
	
	
	@FXML
	Label status;
	@FXML
	Button back;
	
	
	Login_controller lc=new Login_controller();
	User v;
	
	
	HashMap<String,ArrayList<Room>> hm=new HashMap<String,ArrayList<Room>>();
	HashMap<String,ArrayList<Room>> hm2=new HashMap<String,ArrayList<Room>>();
	
	@FXML
	public  void initialize()
	{
		//weekday.getItems().addAll("Monday", "Tuesday", "Wednesday");
		classroom.getItems().addAll("C01", "C02", "C03","C11","C12","C13","C21","C22","C23","C24","LR1","LR2","LR3","S01","S02");
		v=lc.getUser();
		
		//combo.setEditable(true);
	    //combo.setPromptText("Enter");
	  
		
		
	}
	
	public HashMap<String,ArrayList<Room>> deserializefile(String fname) throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream(fname));
			hm=(HashMap) fileread.readObject();
			
			System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return hm;
		
	}

	public HashMap<String,ArrayList<Room>> deserializefile2(String fname) throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream(fname));
			hm2=(HashMap) fileread.readObject();
			
			System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return hm2;
	}		
	
	
	/**
	 * shows if the room is booked or not 
	 * @param event
	 * @throws Exception
	 */
	
	public void submit_click(ActionEvent event) throws Exception
	{
		
		LocalDate l=date.getValue();
		String d=l.toString();
		//System.out .println(d);
		String wd=l.getDayOfWeek().name();
		String cl=classroom.getValue().toString();
		int fh=Integer.parseInt(f_h.getText());
		int fm=Integer.parseInt(f_m.getText());
		int th=Integer.parseInt(t_h.getText());
		int tm=Integer.parseInt(t_m.getText());
		String user=v.getUsertype();
		int c=0;
		int flag=0;
		//checks clash with that weekday courses 
		try
		{
			
		 hm=deserializefile("WeekdayRooms.txt"); //opens file with class booking of courses
		 System.out.println(hm.get("MONDAY").get(0).getTime()+"The stored time of the class in file");
		}
		catch (NullPointerException e)
		{
			hm=new HashMap<String,ArrayList<Room>>();
		}
		Room r=new Room(cl,fh,fm,th,tm,c,user);
		ArrayList<Room> ar=hm.get(wd);
		
		if(ar==null)
			ar=new ArrayList<Room>();
		
		for(Room ro: ar)
		{
			System.out.println(ro.checkClash(r));
			
			if(ro.checkClash(r)==1)
			{
				flag=1;
				System.out.println("weekday clash");
				status.setText("Booked during "+ " "+ro.getTime());
				break;
			}
			
		}
		//check clash with explicit rooms booked on that date
		try
		{

		 hm2=deserializefile2("RoomBooked.txt"); //opens file with class booking on a particular day
		
		}
		catch (NullPointerException e)
		{
			hm2=new HashMap<String,ArrayList<Room>>();
		}
		
		Room r2=new Room(cl,fh,fm,th,tm,c,user);
		ArrayList<Room> ar2=hm2.get(d);
		
		if(ar2==null)
			ar2=new ArrayList<Room>();
		/*
		for(Room ro: ar2)
		{
			System.out.println(ro.checkClash(r)==1);
			if(ro.checkClash(r)==1)
			{
				
				flag=1;
				System.out.println("room clash");
				status.setText("Booked during "+" " + ro.getTime());
				break;
			}
			
		}
		*/
		if(flag==0)
		{
			status.setText("Not booked");
		}
		
		
		
		
	}
		
		
		

	
	
	public void back_click(ActionEvent event) throws Exception
	{
    
	
	if(v.getUsertype().equals("Faculty"))
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Faculty.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	else if(v.getUsertype().equals("Student"))
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Student.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	else
	{
		Stage primaryStage=(Stage) back.getScene().getWindow()  ;
		Pane root= FXMLLoader.load(getClass().getResource("User_Admin.fxml"));
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	}
	
	
	

	

	
	

}