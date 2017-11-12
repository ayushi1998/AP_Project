package classes;

import java.io.Serializable;

public class User implements Serializable {
	String username;
	String email;
	String password;
	private String usertype;
	
	public User(String name, String email, String password, String user)
	{
		username=name;
		this.email=email;
		this.password=password;
		setUsertype(user);
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
	
	
	

}
