package classes;

import java.io.Serializable;

public class Room implements Serializable{
	//start time
	
	//end time
	
	String room;
	//String purpose;  // For the student to specify a purpose to RequestRoom.
	int fh;
	int fm;
	int th;
	int tm;
	//String day;
	int cap;
	int start;
	int end;
	public Room(String a,int c,int d,int e,int f,int g)
	{
		room=a;
		fh=c;
		fm=d;
		th=e;
		tm=f;
		cap=g;
		start=fh*60+fm;
		end=th*60+tm;
	}
	
	public int getFH()
	{
		return fh;
	}
	
	public String getTime()
	{
		return fh+":"+fm+"-"+th+":"+tm;
	}
	public String getRoom()
	{
		return room;
	}
	public int checkClash(Room t)
	{
		//String tem=t.getRoom();
		//System.out.println(t.room+" "+room);
		if(t.room.equals(room))
		{
			//System.out.println("same room");
			if(t.start>=end || start>=t.end)
			{
				return 0;
			}
			else 
				return 1;
		}
		else
			return 0;
	}
	
	public int checkSlot(Room t)
	{
		if(t.room.equals(room) && t.start==start && t.end==end )
		{
			return 1;
		}
		else 
			return 0;
	}

}
