package models;

import java.io.Serializable;

public class Student extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private boolean debtor;

	public Student(String id, String name, boolean debtor) {
		super(id, name);
		this.debtor = debtor;
	}

	public boolean isDebtor() {
		return debtor;
	}

	public void setDebtor(boolean debtor) {
		this.debtor = debtor;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " Deudor: " + (debtor ? "Si" : "No");
}
}
