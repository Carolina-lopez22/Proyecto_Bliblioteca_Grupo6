package models;

public class Main {

	public static void main(String[] args) {
		
		        // Prueba de Usuarios
		        Library library = new Library();

		        User user1 = new User(1, "Daniel");
		        User user2 = new User(2, "Alexa");

		        library.newUser(user1);
		        library.newUser(user2);
		               
		    }
		}        
	
