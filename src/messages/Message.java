package messages;


import java.io.Serializable;

public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int type; //  0µÇÂ¼

	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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



}
