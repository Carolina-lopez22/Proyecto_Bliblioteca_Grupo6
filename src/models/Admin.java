package models;

public class Admin extends User {
	
	private static final long serialVersionUID = 1L;
	private String password;

	public Admin(String id, String name, String password) {
		super(id, name);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
