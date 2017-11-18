package classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Request implements Serializable {
	
	/**
	 * Request class 
	 */
	private static final long serialVersionUID = -6223548932271502888L;
	private String room;
	private String purpose;  // For the student to specify a purpose to RequestRoom.
	private int fh;
	private int fm;
	private int th;
	private int tm;
	private String date;
	int cap;
	int start;
	int end;
	private Student stu;
	private Date dob;
	/**
	 * 
	 * @param a date
	 * @param b starting hour
	 * @param c starting min
	 * @param d ending hr
	 * @param e ending min
	 * @param f purpose
	 * @param g room preferred
	 * @param s object of student 
	 */
	public Request(String a,int b,int c,int d,int e,String f, String g, Student s)
	{
		setDate(a);
		setFh(b);
		setFm(c);
		setTh(d);
		setTm(e);
		setPurpose(f);
		setRoom(g);
		setStudent(s);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    setDob(new Date());  
	 
	    
	    
	}

	public Student getStudent() {
		return stu;
	}

	public void setStudent(Student stu) {
		this.stu = stu;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getFh() {
		return fh;
	}

	public void setFh(int fh) {
		this.fh = fh;
	}

	public int getFm() {
		return fm;
	}

	public void setFm(int fm) {
		this.fm = fm;
	}

	public int getTh() {
		return th;
	}

	public void setTh(int th) {
		this.th = th;
	}

	public int getTm() {
		return tm;
	}

	public void setTm(int tm) {
		this.tm = tm;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @param purpose the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
