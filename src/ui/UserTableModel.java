package ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import models.User;

public class UserTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	private ArrayList<User> users;
	
	private final String[] columns = 
		{"Carnet","Nombre","Deudor"};
	
	public UserTableModel(ArrayList<User> n) {
		this.users = n;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return this.users.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
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
		            return m.isDebtor() ? "Si":"No";

		        default:
		            return null;
	}
	
	
}
}

