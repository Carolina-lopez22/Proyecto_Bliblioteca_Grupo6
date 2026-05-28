package models;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
	
	private static final String FILE_BOOKS = "books.csv";
	private static final String FILE_USERS = "users.csv";
	private static final String FILE_LOANS = "loans.csv";
	
    private ArrayList<Book> books;
    // Lista de usuarios
    private ArrayList<User> users;
    
    private ArrayList<Loan> loans;

    
    public Library() {
    	books = new ArrayList<>();
        loans = new ArrayList<>();
        users = new ArrayList<>();
        loadData();
        if (users.isEmpty()) {

            users.add( new Admin("admin", "Administrador","1234")
            );
            saveData();
        }
    }
    public Admin login(String user, String pass) {

        for (User u : users) {
        if( u instanceof Admin ){
        	Admin a = (Admin) u;
        	
            if (a.getId().equals(user) &&
                a.getPassword().equals(pass)) {

                return a;
            }
        }
        }
        return null;
    }
    
       public boolean addAdmin(String id, String name, String pass) {

        for (User u : users) {

            if (u.getId().equals(id)) {
                return false;
            }
        }

        users.add(new Admin(id, name, pass));

        saveData();

        return true;
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
    	saveData();
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
    	users.add(new Student(c,n, false));
    	saveData();
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
    	
    	for (int i = 0; i< users.size(); i++) {
    		 User u = users.get(i);
    	        if (u.getId().equals(id)) {
    	            u.setName(name); 
    			saveData();
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
    			saveData();
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
    		saveData();
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
    			saveData();
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
    			(user.getId(), book.getUniqueCode(), maxDays);
    	
    	loans.add(loan); // guarda el prestamo
    	book.loanCopy();// reducir las copias que hay disponibles 
    	if (user instanceof Student) {
            Student s = (Student) user;
            s.setDebtor(true);
        }
    	saveData();
    	return true;
    }
    
    public Loan searchLoan(String book, String user) {
    	for (Loan l:loans) {
    		if (l.getBook().equals(book) && l.getStudent().equals(user)) {
    			return l;
    		}
    	}
    	return null;
    }
    // Método para devolver un libro
    public boolean returnBook(String studentId, String bookCode) {   		
    		for (Loan loan : loans) {
    		
    			boolean sameStudent =
                        loan.getStudent().equals(studentId);

                boolean sameBook =
                        loan.getBook().equals(bookCode);

                boolean activeLoan =
                        !loan.isReturned();

                if (sameStudent && sameBook && activeLoan) {
                    // Para marcar como devuelto
                    loan.markAsReturned();
                    
                    // Buscar libro para aumentar copias
                    for (Book book : books) {
                        if (book.getUniqueCode().equals(bookCode)) {
                            book.returnCopy();
                            break;
               }
        }
                   

                            // Revisa si aún tiene préstamos activos
                            boolean hasActiveLoans = false;
                            for (Loan l : loans) {
                                boolean sameUser =
                                        l.getStudent().equals(studentId);

                                boolean stillActive =
                                        !l.isReturned();
                                if (sameUser && stillActive) {

                                    hasActiveLoans = true;
                                    break;
                                }
                            }

                    for (User user : users) {
                     if (user.getId().equals(studentId)) {             
                    	if (user instanceof Student) {
                    		Student s = (Student) user;
                    		s.setDebtor(hasActiveLoans);
                    	}
                         break;   
                     }
                    }
            saveData();
            return true;
          }
        }
            return false;
    }
    
    public boolean deleteLoan(String student, String book) {
    	for (int i = 0; i < loans.size(); i++) {
    		Loan temp = loans.get(i);
    		if(temp.getStudent().equals(student) && temp.getBook().equals(book)) {
    			loans.remove(i);
    			saveData();
    			return true;
    		}
    	}
    	
    	return false;
    }
    public boolean addStudent(String id, String name) {

        for (User s : users) {

            if (s.getId().equals(id)) {
                return false;
            }
        }

        users.add(new Student(id, name, false));

        saveData();

        return true;
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
   
    //Agregando Percistencia 
    
    // Metodo para guardar datos 
    public void saveData() {
        saveBooks();
        saveUsers();
        saveLoans();
    }

    private void saveBooks() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_BOOKS))) {
            for (Book b : books) {
                pw.println(
                    escapeCsv(b.getUniqueCode()) + "," +
                    escapeCsv(b.getTitle())      + "," +
                    escapeCsv(b.getAuthor())     + "," +
                    b.getYear()                  + "," +
                    b.getCopies()
                );
            }
        } catch (IOException e) {
            System.out.println("Error al guardar books.csv: " + e.getMessage());
        }
    }

    private void saveUsers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_USERS))) {
            for (User u : users) {
                if (u instanceof Admin) {
                    Admin a = (Admin) u;
                    pw.println("ADMIN,"   + escapeCsv(a.getId()) + "," + escapeCsv(a.getName()) + "," + escapeCsv(a.getPassword()));
                } else if (u instanceof Student) {
                    Student s = (Student) u;
                    pw.println("STUDENT," + escapeCsv(s.getId()) + "," + escapeCsv(s.getName()) + "," + s.isDebtor());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar users.csv: " + e.getMessage());
        }
    }

    private void saveLoans() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_LOANS))) {
            for (Loan l : loans) {
                pw.println(
                    escapeCsv(l.getStudent())   + "," +
                    escapeCsv(l.getBook())      + "," +
                    l.getLoanDate().toString()  + "," +
                    l.getMaxDays()              + "," +
                    l.isReturned()
                );
            }
        } catch (IOException e) {
            System.out.println("Error al guardar loans.csv: " + e.getMessage());
        }
    }
    // Para cargar los datos
    public void loadData() {
        loadBooks();
        loadUsers();
        loadLoans();
    }

    private void loadBooks() {
        File f = new File(FILE_BOOKS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = splitCsv(line);
                if (parts.length < 5) continue;
                books.add(new Book(parts[0], parts[1], parts[2],
                        Integer.parseInt(parts[3].trim()),
                        Integer.parseInt(parts[4].trim())));
            }
        } catch (IOException e) {
            System.out.println("Error al leer books.csv: " + e.getMessage());
        }
    }

    private void loadUsers() {
        File f = new File(FILE_USERS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = splitCsv(line);
                if (parts.length < 4) continue;
                switch (parts[0].trim().toUpperCase()) {
                    case "ADMIN":
                        users.add(new Admin(parts[1], parts[2], parts[3]));
                        break;
                    case "STUDENT":
                        users.add(new Student(parts[1], parts[2], Boolean.parseBoolean(parts[3].trim())));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer users.csv: " + e.getMessage());
        }
    }

    private void loadLoans() {
        File f = new File(FILE_LOANS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = splitCsv(line);
                if (parts.length < 5) continue;
                Loan loan = new Loan(parts[0], parts[1], Integer.parseInt(parts[3].trim()));
                loan.setLoanDate(LocalDate.parse(parts[2].trim()));
                if (Boolean.parseBoolean(parts[4].trim())) loan.markAsReturned();
                loans.add(loan);
            }
        } catch (IOException e) {
            System.out.println("Error al leer loans.csv: " + e.getMessage());
        }
    }
    private String escapeCsv(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }

    private String[] splitCsv(String line) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"'); i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                result.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        result.add(current.toString());
        return result.toArray(new String[0]);
    }
}
