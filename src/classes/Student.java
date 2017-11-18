package classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * student user
 * @author Tanish and Ayushi 
 *
 */
public class Student extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1243017568013578006L;
	/**
	 *  student user 
	 */
	
	private ArrayList<Course> clist= new ArrayList<Course>();
	private ArrayList<Request> accepted=new ArrayList<Request>();
	private ArrayList<Request> cancelled=new ArrayList<Request>();
	ArrayList<Course> arr=new ArrayList<Course>();
	
	/**
	 * Deserializes all the courses
	 * @return arraylist of courses
	 * @throws ClassNotFoundException class not found exception
	 * @throws IOException ioexception
	 */
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
	
	public Student(String name, String em, String pass, String u) throws ClassNotFoundException, IOException 
	{
		super(name,em,pass,u);
		
		//add mandatory courses
		
		try
		{			
		 arr=deserializefile(); 
		}
		catch (NullPointerException e)
		{
			arr=new ArrayList<Course>();
		}
		
		for(Course c:arr)
		{
			if(c.getCoption().equals("Mandatory"))
			{
				clist.add(c);
			}
			
		}
		//System.out.println("aaaaaaaaaa");
		//System.out.println(clist.get(0).getCname());
		
	}
	

	
	
	public void disp()
	{
		System.out.println(getAccepted().get(0).getDate());
	}
	/**
	 * 
	 * @param r adds confirmed requests
	 */
	public void addConfirmedRequest(Request r)
	{
		getAccepted().add(r);
	}
	/**
	 * 
	 * @param r adds cancelled request 
	 */
	public void addCancelledRequest(Request r)
	{
		getCancelled().add(r);
	}

	public ArrayList<Course> getClist() {
		return clist;
	}


	public void setClist(ArrayList<Course> clist) {
		this.clist = clist;
	}

	/**
	 * @return the accepted
	 */
	public ArrayList<Request> getAccepted() {
		return accepted;
	}

	/**
	 * @param accepted the accepted to set
	 */
	public void setAccepted(ArrayList<Request> accepted) {
		this.accepted = accepted;
	}

	/**
	 * @return the cancelled
	 */
	public ArrayList<Request> getCancelled() {
		return cancelled;
	}

	/**
	 * @param cancelled the cancelled to set
	 */
	public void setCancelled(ArrayList<Request> cancelled) {
		this.cancelled = cancelled;
	}
	
	
	
}
