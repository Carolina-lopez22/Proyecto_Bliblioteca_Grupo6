package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Date {
	public static LocalDate formatDate(CharSequence Date) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			return LocalDate.parse(Date, formato);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
}
