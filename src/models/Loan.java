package models;
import java.io.Serializable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa un préstamo realizado por un estudiante.
 * Guarda el libro prestado, el estudiante, la fecha del préstamo,
 * los días máximos permitidos y si ya fue devuelto.
 */
public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;
	private String student;          // Nombre del estudiante que realiza el préstamo
    private String book;             // Libro prestado (puede ser código o título)
    private LocalDate loanDate;      // Fecha en que se realizó el préstamo
    private int maxDays;             // Días máximos permitidos para devolver el libro
    private boolean returned;        // Bandera que indica si el libro ya fue devuelto

    /**
     * Constructor que crea un nuevo préstamo con la fecha actual.
     */
    public Loan(String student, String book, int maxDays) {
        this.student = student;
        this.book = book;
        this.maxDays = maxDays;
        this.loanDate = LocalDate.now();
        this.returned = false; // Por defecto, el préstamo inicia como "no devuelto"
    }

    // -----------------------------
    // GETTERS
    // -----------------------------

    public String getStudent() { return student; }
    public String getBook() { return book; }
    public LocalDate getLoanDate() { return loanDate; }
    public int getMaxDays() { return maxDays; }
    public boolean isReturned() { return returned; }

    // -----------------------------
    // MÉTODOS DE CONTROL
    // -----------------------------

    /**
     * Marca el préstamo como devuelto.
     * Cambia la bandera returned a true.
     */
    public void markAsReturned() {
        this.returned = true;
    }

    /**
     * Calcula cuántos días han pasado desde que se realizó el préstamo.
     * @return número de días entre loanDate y la fecha actual.
     */
    public long calculateDays() {
        return ChronoUnit.DAYS.between(loanDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return "Préstamo de " + book + " a " + student +
               " | Fecha: " + loanDate +
               " | Máximo: " + maxDays + " días" +
               " | Devuelto: " + (returned ? "Sí" : "No");
    }
}

