package models;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
	
    // Lista de usuarios
    private ArrayList<User> users;
    
    private ArrayList<Loan> loans;
    
    public Library() {
    	books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();
        
    }
    // Método para agregar un libro
    public void newBook(Book book) {
       books.add(book);
    }

    // Método para agregar un usuario
    public void newUser(User user) {
        users.add(user);
    }
    // MEtodo para buscar Usuario
    public User findUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    //Metodo para buscar libro
    public Book findBookByTitle(String title) {
       for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
}

    // Método para prestar un libro
    public boolean loanBook(User user, Book book, int maxDays) {
    	if(!book.canBeLoaned()) {
    		return false;
      }
    	Loan loan = new Loan
    			(user.getName(), book.getTitle(), maxDays);
    	
    	loans.add(loan); // guarda el prestamo
    	book.loanCopy();// reducir las copias que hay disponibles
    	user.setDebtor(true); //Para usuarios que tienen prestamos
    	return true;
    }
    // Método para devolver un libro
    public boolean returnBook(String studentName, String bookTitle) {   		
    		for (Loan loan : loans) {
    		
    			boolean sameStudent =
                        loan.getStudent().equals(studentName);

                boolean sameBook =
                        loan.getBook().equals(bookTitle);

                boolean activeLoan =
                        !loan.isReturned();

                if (sameStudent && sameBook && activeLoan) {
                    // Para marcar como devuelto
                    loan.markAsReturned();
                    
                    // Buscar libro para aumentar copias
                    for (Book book : books) {
                        if (book.getTitle().equals(bookTitle)) {
                            book.returnCopy();
                            break;
               }
        }
                    // Buscar usuario para actualizarlo

                    for (User user : users) {
                        if (user.getName().equals(studentName)) {
                        	
                            // Revisa si aún tiene préstamos activos
                            boolean hasActiveLoans = false;
                            for (Loan l : loans) {
                                boolean sameUser =
                                        l.getStudent().equals(studentName);

                                boolean stillActive =
                                        !l.isReturned();
                                if (sameUser && stillActive) {

                                    hasActiveLoans = true;
                                    break;
                                }
                            }

                            // Actualiza estado de deudor
                            user.setDebtor(hasActiveLoans);
                            break;
                        }
                    }         
            return true;
          }
        }
            return false;
    }

    public ArrayList<User> getUsers(){
    	return users;
    }
    
    public ArrayList<Book> getBooks(){
    	return books;
    }
    
    public ArrayList<Loan> getLoans(){
    	return loans;
    }
    
}