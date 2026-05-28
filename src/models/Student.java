package models;

public class Student extends User {
	
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
