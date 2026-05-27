package ui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import models.User;
import models.Student;
public class UserTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	private ArrayList<User> users;
    private boolean isAdmin;
    
	private final String[] columnsAdmin = {"Carnet","Nombre","Deudor"};
	private final String[] columnsStudent = {"Carnet", "Nombre"}; 
	
	public UserTableModel(ArrayList<User> n, boolean isAdmin) {
		this.users = n;
		this.isAdmin = isAdmin;
	}

	@Override
	public int getColumnCount() {
		return isAdmin ? columnsAdmin.length : columnsStudent.length;
	}

	@Override
	public int getRowCount() {
		return this.users.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return isAdmin ? columnsAdmin[column] : columnsStudent[column];
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		 User m = users.get(fila);

		    switch (columna) {

		        case 0:
		            return m.getId();

		        case 1:
		            return m.getName();

		        case 2:
		        	if (isAdmin) {
	                    return (m instanceof Student) ? (((Student) m).isDebtor() ? "Si" : "No") : "-";
	                }
	                return null;
	            default: return null;
	        }
	    }
}

