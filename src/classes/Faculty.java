package classes;

public class Faculty extends User{
	
	
	
	
	
	/**
	 *  Faculty user
	 */
	private static final long serialVersionUID = -6504887247679829671L;
	String course;

	/**
	 * 
	 * @param name facaulty name
	 * @param email faculty email
	 * @param password faculty password
 	 * @param user username
	 */
	public Faculty(String name, String email, String password, String user) {
		super(name, email, password, user);
		// TODO Auto-generated constructor stub
	}
	

}
