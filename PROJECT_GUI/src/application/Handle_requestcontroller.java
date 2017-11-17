package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import classes.Course;
import classes.Request;
import classes.Room;
import classes.Student;
import classes.User;
import classes.request_table;
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
	
	public TableView<request_table> table;

	public TableColumn<request_table,String> Sno;

	public TableColumn<request_table,String> date;

	public TableColumn<request_table,String> time;

	public TableColumn<request_table,String> purpose;

	public TableColumn<request_table,String> room;

	public TableColumn<request_table,String> status;
	
	ObservableList<request_table> data = FXCollections.observableArrayList();

	ArrayList<Request> hm=new ArrayList<Request>();
	HashMap<String,ArrayList<Room>> hm2=new HashMap<String,ArrayList<Room>>();
	HashMap<String,User> usermap=new HashMap<String,User>();
	String dob;
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
	
	
	public ArrayList<Request> deserializefile() throws ClassNotFoundException, IOException{
		 ObjectInputStream fileread=null;
		// HashMap<String,ArrayList<Room>> hm=null;
		try{
			fileread=new ObjectInputStream(new FileInputStream("RequestDatabase.txt"));
			hm=(ArrayList) fileread.readObject();
			
			//System.out.println("function");
		}
		finally{
			fileread.close();
		}
		return hm;
		
	}
	
	public HashMap<String,ArrayList<Room>> deserializefile(String fname) throws ClassNotFoundException, IOException{
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
	
	
	
	public  void initialize() throws ClassNotFoundException, IOException
	{
		
		classroom.getItems().addAll("C01", "C02", "C03");
		ar.getItems().addAll("Yes","No");
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date da = new Date();  
	    

		 Sno.setCellValueFactory(new PropertyValueFactory<request_table,String>("sno"));
		 date.setCellValueFactory(new PropertyValueFactory<request_table,String>("date"));
		 time.setCellValueFactory(new PropertyValueFactory<request_table,String>("time"));
		 purpose.setCellValueFactory(new PropertyValueFactory<request_table,String>("purpose"));
		 room.setCellValueFactory(new PropertyValueFactory<request_table,String>("room"));
		 status.setCellValueFactory(new PropertyValueFactory<request_table,String>("status"));
		 try
			{
				
			 hm=deserializefile(); 
			 //System.out.println(hm.get("MONDAY").get(0).getTime()+"The stored time of the class in file");
			}
			catch (NullPointerException e)
			{
				hm=new ArrayList<Request>();
			}
		 
		// Now display shortlisted requests in the table
			int i=1;
			request_table sem;
			for(Request c: hm)
			{
				long days= (da.getTime()-c.getDob().getTime())/(1000 * 60 * 60 * 24);
				
				if(days<5) //check if the request is more than 5 days 
				{sem=new request_table(Integer.toString(i),c.getDate(),c.getFh()+":"+c.getFm()+"-"+c.getTh()+":"+c.getTm(),c.getPurpose(),c.getRoom()," ");
				data.add(sem);
				i++;
				}
				else
				{
					hm.remove(c);
				}
				
			}
			table.setItems(data);
		 
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
		int i=Integer.parseInt(index);
		String cl=classroom.getValue().toString();
		String status=ar.getValue().toString();
		Student st;
		
		//data.clear();
		if(i>hm.size())
		{
			System.out.println("Sno out of bound");
		}
		else
		{
			//displaying requests in table	
			request_table sem;
			for(int j=0;j<i-1;j++)
			{
				Request c=hm.get(j);
				sem=new request_table(Integer.toString(i),c.getDate(),c.getFh()+":"+c.getFm()+"-"+c.getTh()+":"+c.getTm(),c.getPurpose(),c.getRoom()," ");
				data.add(sem);
			}
			
			
			//confirming/rejecting
			Request re= hm.get(i-1);
			st=re.getStudent();
			System.out.println(re.getRoom());
			if(status.equals("Yes"))
			{
				
				System.out.println(re.getStudent()+" "+st);
				st.addConfirmedRequest(new Request(re.getDate(),re.getFh(),re.getFm(),re.getTh(),re.getTm(),re.getPurpose(),cl,re.getStudent())); // Student get to know about accepted requests
				
				sem=new request_table(Integer.toString(i),re.getDate(),re.getFh()+":"+re.getFm()+"-"+re.getTh()+":"+re.getTm(),re.getPurpose(),re.getRoom(),"Accepted ");
				data.add(sem);
				
				//deserialize booked room file and add this requested room
				try
				{

				 hm2=deserializefile("RoomBooked.txt"); //opens file with class booking on a particular day
				
				}
				catch (NullPointerException e)
				{
					hm2=new HashMap<String,ArrayList<Room>>();
				}
				
				
				Room r2=new Room(re.getRoom(),re.getFh(),re.getFm(),re.getTh(),re.getTm(),0,"Admin");
				//(hm2.get("11-14-2017")
				//System.out.println( hm2.get("2017-11-14"));
				//System.out.println(hm2.get( re.getDate()));
				//ArrayList<Room> ar2=hm2.get( re.getDate());
				
				ArrayList<Room> ar2;
				if(hm2.get( re.getDate())!=null) 
				{
					ar2=hm2.get( re.getDate());
					
					
				}
				else
				{
					
					ar2=new ArrayList<Room>();
					
				}
				
				
				ar2.add(r2);
				
				hm2.put(re.getDate(), ar2);
				
				 ObjectOutputStream UsersList=null;	
					
					try	
					{	
						UsersList=new ObjectOutputStream(new FileOutputStream("RoomBooked.txt"));	
						UsersList.writeObject(hm2);			
					}	
					finally	
					{	
						UsersList.close();	
					}	
				
				
					
			}
			else
			{ 
				sem=new request_table(Integer.toString(i),re.getDate(),re.getFh()+":"+re.getFm()+"-"+re.getTh()+":"+re.getTm(),re.getPurpose(),re.getRoom(),"Rejected");
				st.addCancelledRequest(hm.get(i-1)); // Student get to know about cancelled requests
			}
			
			//remove it from list
			hm.remove(i-1);
			data.remove(i-1);
			//displaying requests in table	
			for(int j=i;j<hm.size();j++)
			{
				Request c=hm.get(j);
				sem=new request_table(Integer.toString(i),c.getDate(),c.getFh()+":"+c.getFm()+"-"+c.getTh()+":"+c.getTm(),c.getPurpose(),c.getRoom()," ");
				data.add(sem);
			}
			table.setItems(data);
			
			// now serializing the student 
			 usermap=deserialize_user();
			 usermap.put(st.getEmail(), st);
			 
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
				
				
			ObjectOutputStream requestlist=null;	
				
				try	
				{	
					requestlist=new ObjectOutputStream(new FileOutputStream("RequestDatabase.txt"));	
					requestlist.writeObject(hm);	
							
				}	
				finally	
				{	
					requestlist.close();	
				}	
			 
			 
		}
		
		
	}
	

}
