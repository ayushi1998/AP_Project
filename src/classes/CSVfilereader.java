package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVfilereader {
	
	public static List<Course> c;
	
	/**
	 * reads csv file and stores the database
	 * @param args not used
	 * @throws IOException
	 */
	public static void main(String[] args)throws IOException {
		//c = readCourseFromCSV("csv.txt");
		c = new ArrayList<Course>();
		Path pathtofile = Paths.get("csv.txt");

		try  {
			File fi=new File("csv.txt");
			FileReader f=new FileReader(fi);
			BufferedReader br = new BufferedReader(f);
			String line = br.readLine();
			//line=br.readLine();
			while (line != null) {
				//String[] s1 = line.split(",");
				//System.out.println(s1[0]);
				String[] s2 = line.split(",");
				Course course = new Course(s2[0], s2[1], s2[2], s2[3], s2[4], s2[5], s2[6], s2[7], s2[8], s2[9],
						s2[10], s2[11], s2[12], s2[13], s2[14]);
				c.add(course);
				line = br.readLine();
				
			}
			f.close();
		}
		finally
		{
			
		}
		
		 ObjectOutputStream UsersList=null;	
			
			try	
			{	
				UsersList=new ObjectOutputStream(new FileOutputStream("AllCourses.txt"));	
				UsersList.writeObject(c);			
			}	
			finally	
			{	
				UsersList.close();	
			}	
			
		
		for (Course b : c) {
			System.out.println(b.getCname()+"-"+ b.getPostcond());
		}
		
		coursebooking();
		
		
	}
	
	/**
	 * Stores rooms booked for the courses
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void coursebooking() throws FileNotFoundException, IOException
	{
		// create weekday booked room database
		HashMap<String,ArrayList<Room>> hm=new HashMap<String,ArrayList<Room>>();
		ArrayList<Room> temp=new ArrayList<Room>();
		ArrayList<Room> temp1=new ArrayList<Room>();
		ArrayList<Room> temp2=new ArrayList<Room>();
		ArrayList<Room> temp3=new ArrayList<Room>();
		ArrayList<Room> temp4=new ArrayList<Room>();
		
		temp.add(new Room("C21",11,00,12,00,100," "));
		temp.add(new Room("C02",15,00,16,00,50," "));
		temp.add(new Room("C12",10,00,11,00,50," "));
		temp.add(new Room("C24",16,00,17,30,50," "));
		temp.add(new Room("C01",16,00,17,30,50," "));
		temp.add(new Room("C12",16,00,17,30,50," "));
		temp.add(new Room("C11",16,00,17,30,50," "));
		temp.add(new Room("LR1",12,00,13,00,50," "));
		temp.add(new Room("LR2",12,00,13,00,50," "));
		temp.add(new Room("S01",12,00,13,00,50," "));
		temp.add(new Room("S02",12,00,13,00,50," "));
		temp.add(new Room("LR1",8,30,10,00,50," "));
		temp.add(new Room("LR1",13,30,15,00,50," "));
		temp.add(new Room("LR3",14,00,15,00,50," "));
		temp.add(new Room("LR2",13,30,15,00,50," "));
		temp.add(new Room("C23",14,00,15,00,50," "));
		hm.put("MONDAY", temp);
		//System.out.println(hm.get("MONDAY"));
		//System.out.println(hm.get("MONDAY"));
		temp1.add(new Room("C21",13,30,15,00,50," "));
		temp1.add(new Room("C21",15,00,16,00,50," "));
		temp1.add(new Room("C21",11,00,12,00,50," "));
		temp1.add(new Room("C02",10,00,11,00,50," "));
		temp1.add(new Room("C22",16,00,17,30,50," "));
		temp1.add(new Room("C24",16,00,17,30,50," "));
		temp1.add(new Room("C03",16,00,17,30,50," "));
		temp1.add(new Room("C13",16,00,17,30,50," "));
		temp1.add(new Room("C02",16,00,18,00,50," "));
		hm.put("TUESDAY", temp);
		
		temp2.add(new Room("C21",11,00,12,00,50," "));
		temp2.add(new Room("C21",14,30,16,00,50," "));
		temp2.add(new Room("C12",10,00,11,00,50," "));
		temp2.add(new Room("C24",16,00,17,30,50," "));
		temp2.add(new Room("C01",16,00,17,30,50," "));
		temp2.add(new Room("C12",16,00,17,30,50," "));
		temp2.add(new Room("C11",16,00,17,30,50," "));
		temp2.add(new Room("S01",16,00,17,30,50," "));
		temp2.add(new Room("LR2",13,30,14,30,50," "));
		temp2.add(new Room("LR3",16,00,17,30,50," "));
		temp2.add(new Room("C22",16,00,17,30,50," "));
		temp2.add(new Room("C23",16,00,17,30,50," "));
		hm.put("WEDNESDAY", temp);

		temp3.add(new Room("C21",11,00,12,00,50," "));
		temp3.add(new Room("C01",16,00,17,30,50," "));
		temp3.add(new Room("C21",15,00,16,00,50," "));
		temp3.add(new Room("C21",14,00,15,00,50," "));
		temp3.add(new Room("C02",10,00,11,00,50," "));
		hm.put("THURSDAY", temp);
		
		temp4.add(new Room("C21",11,30,13,00,50," "));
		temp4.add(new Room("C21",15,00,16,00,50," "));
		temp4.add(new Room("C21",14,00,15,00,50," "));
		temp4.add(new Room("C12",9,30,10,30,50," "));
		temp4.add(new Room("C24",16,00,17,30,50," "));
		temp4.add(new Room("C03",16,00,17,30,50," "));
		temp4.add(new Room("C22",16,00,17,30,50," "));
		temp4.add(new Room("C13",16,00,17,30,50," "));
		temp4.add(new Room("LR1",16,00,17,30,50," "));
		temp4.add(new Room("LR2",16,00,17,30,50," "));
		temp4.add(new Room("LR3",16,00,17,30,50," "));
		temp4.add(new Room("LR1",10,30,11,30,50," "));
		hm.put("FRIDAY", temp);
		
		
		//System.out.println(hm.get("MONDAY"));
		ObjectOutputStream UsersList=null;	
		
		try	
		{	
			UsersList=new ObjectOutputStream(new FileOutputStream("WeekdayRooms.txt"));	
			UsersList.writeObject(hm);			
		}	
		finally	
		{	
			UsersList.close();	
		}	
		
	}
	
	
}
