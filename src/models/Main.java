package models;

import ui.MainFrame;

public class Main {

	public static void main(String[] args) {
		
		        // Prueba de Usuarios
		        Library library = new Library();
				        
		        library.loadData();
		        
		        MainFrame frame = new MainFrame(library);
		               frame.setVisible(true);
		    }
		}        
	
