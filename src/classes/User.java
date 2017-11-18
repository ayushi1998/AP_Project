package classes;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 *  user class
	 */
	private static final long serialVersionUID = 8652118894487804965L;
	protected String username;
	protected String email;
	protected String password;
	protected String usertype;
	
	
	public User(String name, String email, String password, String user)
	{
		setUsername(name);
		this.setEmail(email);
		this.setPassword(password);
		setUsertype(user);
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
