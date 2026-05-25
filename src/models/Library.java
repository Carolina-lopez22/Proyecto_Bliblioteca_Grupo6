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
    
    public boolean newBook(String id, String name, String author, int year, int copies) {
    	for (Book b: books) {
    		if ( b.getUniqueCode().equals(id)) {
    			return false;
    		}
    	}
    	books.add(new Book(id,name,author,year,copies));
    	return true;
    }

    // Método para agregar un usuario
    public void newUser(User user) {
        users.add(user);
    }
    // Sobrecarga para poder ingresar texto
    public boolean newUser(String c, String n) {
    	for (User u: users) {
    		if (u.getId().equals(c)) {
    			return false;
    		}
    	}
    	users.add(new User(c,n));
    	return true;
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

    public boolean updateUser(String id, String name) {
    	User n = new User(id,name);
    	for (int i = 0; i< users.size(); i++) {
    		String temp = users.get(i).getId();
    		if (temp.equals(id)) {
    			users.set(i, n);
    			return true;
    		}
    		
    	}
    	return false;
    }
    
    public boolean deleteUser(String id) {
    	for (int i = 0; i< users.size(); i++) {
    		String temp = users.get(i).getId();
    		if (temp.equals(id)) {
    			users.remove(i);
    			return true;
    		}
    		
    	}
    	return false;
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
    
    public Book findBookById(String id) {
    	for (Book b : books) {
    		if (b.getUniqueCode().equals(id)) return b;
    	}
    	return null;
    }
    
    public boolean updateBook(String id, String name, String author, int year, int copies) {
    	Book b = new Book(id, name, author, year, copies);
    	String temp;
    	for (int i = 0; i< books.size(); i++) {
    		temp = books.get(i).getUniqueCode();
    		if (temp.equals(id)) { books.set(i, b);
    		return true;}
    	}
    	return false;
    }
    
    public boolean deleteBook(String id) {
    	String temp;
    	for (int i = 0; i< books.size(); i++) {
    		temp = books.get(i).getUniqueCode();
    		if (temp.equals(id)) { 
    			books.remove(i);
    			return true;}
    	}
    	return false;
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