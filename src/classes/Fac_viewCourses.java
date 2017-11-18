package classes;

public class Fac_viewCourses {
	 String man, course, code,credits;
	 /**
	  * 
	  * @param man type of the course
	  * @param course name of the course 
	  * @param code code of the course 
	  * @param credits credits for the course 
	  */
		public Fac_viewCourses (String man,String course,String code,String credits)
		{
			this.man=man;
			this.course=course;
			this.code=code;
		
			this.credits=credits;
			
		}
		
		public String getMan() 
		{
	        return man;
	    }

	   /* void setSn(String fName) {
	        sn.set(fName);
	    }*/

	    public String getCourse()
	    {
	        return course;
	    }

	    /*void setCours(String fName) {
	        cours.set(fName);
	    }*/

	     public String getCode() 
	    {
	        return code;
	    }
	
	     public String getCredits() 
	     {
		        return credits;
		 }

}
