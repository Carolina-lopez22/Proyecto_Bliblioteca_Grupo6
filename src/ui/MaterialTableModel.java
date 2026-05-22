package ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import models.Book;

public class MaterialTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	private ArrayList<Book> books;
	
	private final String[] columns = 
		{"Codigo","Titulo","Autor","Año","Copias"};
	
	public MaterialTableModel(ArrayList<Book> n) {
		this.books = n;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return this.books.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		 Book m = books.get(fila);

		    switch (columna) {

		        case 0:
		            return m.getUniqueCode();

		        case 1:
		            return m.getTitle();

		        case 2:
		            return m.getAuthor();
		            
		        case 3:
		        	return m.getYear();
		        	
		        case 4:
		        	return m.getCopies();

		        default:
		            return null;
	}
	
	
}
}
