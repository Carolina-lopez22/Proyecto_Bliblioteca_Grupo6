package models;

import java.util.ArrayList;

public class Library {

    // TODO Array para lista de libros
	
    // Lista de usuarios
    private ArrayList<User> users;

    // TODO Array ista de préstamos
    
    public Library() {

        users = new ArrayList<>();
       
    }
    // Método para agregar un libro
    public void newBook() {
        //TODO Metodo a completar hasta que se cree la clase book
    }

    // Método para agregar un usuario
    public void newUser(User user) {
        users.add(user);
    }

    // Método para prestar un libro
    public void loanBook() {
       //TODO MEtodo a completar haste que se cree la clase loan(Prestamos)
    }

    // Método para devolver un libro
    public void returnBook() {
        //TODO En proceso 
    }

    // Para mostrar todos los libros
    public void showBooks() {

        //TODO En proceso
    }

    // Para mostrar todos los usuarios
    public void showUsers() {

        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (User user : users) {
            System.out.println(user);
        }
    }

    // Mostrar todos los préstamos
    public void showLoans() {
    	
        //TODO En proceso
    }

}