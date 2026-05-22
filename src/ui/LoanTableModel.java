package ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import models.Loan;

public class LoanTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	private ArrayList<Loan> loans;
	
	private final String[] columns = 
		{"Estudiante","Libro","Fecha","Dias","Regresado"};
	
	public LoanTableModel(ArrayList<Loan> n) {
		this.loans = n;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return this.loans.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		 Loan m = loans.get(fila);

		    switch (columna) {

		        case 0:
		            return m.getStudent();

		        case 1:
		            return m.getBook();

		        case 2:
		            return m.getLoanDate();
		            
		        case 3:
		        	return m.getMaxDays();
		        	
		        case 4:
		        	return m.isReturned() ? "Si":"No";

		        default:
		            return null;
	}
	
	
}
}
