package classes;

public class Request {
	
	String room;
	String purpose;  // For the student to specify a purpose to RequestRoom.
	int fh;
	int fm;
	int th;
	int tm;
	String date;
	int cap;
	int start;
	int end;
	Student stu;
	
	public Request(String a,int b,int c,int d,int e,String f, String g, Student s)
	{
		date=a;
		fh=b;
		fm=c;
		th=d;
		tm=e;
		purpose=f;
		room=g;
		stu=s;
	}
	
}
