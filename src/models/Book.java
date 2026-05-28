package models;

import java.time.Year;
/**
 * Representa un libro dentro del sistema de biblioteca.
 * Contiene información básica como código, título, autor, año y número de copias.
 * Incluye métodos para verificar disponibilidad y actualizar el número de copias.
 */
public class Book  {

	private String uniqueCode;   // Código único del libro
    private String title;        // Título del libro
    private String author;       // Autor del libro
    private int year;            // Año de publicación
    private int copies;          // Cantidad de copias disponibles

    /**
     * Constructor que inicializa todos los atributos del libro.
     */
    public Book(String uniqueCode, String title, String author, int year, int copies) {
    	
    	int currentYear = Year.now().getValue();
        // Validación del año
        if (year < 1000 || year > currentYear) {

            throw new IllegalArgumentException(

                "El año debe estar entre 1000 y " + currentYear

            );
        }
            
        this.uniqueCode = uniqueCode;
        this.title = title;
        this.author = author;
        this.year = year;
        this.copies = copies;
    }

    // -----------------------------
    // MÉTODOS BANDERA Y DE CONTROL
    // -----------------------------

    /**
     * Método bandera que indica si el libro puede ser prestado.
     * @return true si hay copias disponibles, false si no.
     */
    public boolean canBeLoaned() {
        return copies > 0;
    }

    /**
     * Reduce en 1 la cantidad de copias cuando se realiza un préstamo.
     * Este método debe llamarse solo si canBeLoaned() es true.
     */
    public void loanCopy() {
        if (copies > 0) {
            copies--;
        }
    }

    /**
     * Aumenta en 1 la cantidad de copias cuando se devuelve un libro.
     */
    public void returnCopy() {
        copies++;
    }

    // -----------------------------
    // GETTERS Y SETTERS
    // -----------------------------

    public String getUniqueCode() { return uniqueCode; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public int getCopies() { return copies; }

    /**
     * Permite modificar la cantidad de copias disponibles.
     */
    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return title + " (" + author + ") - " + year + " | Copias: " + copies;
    }
}

