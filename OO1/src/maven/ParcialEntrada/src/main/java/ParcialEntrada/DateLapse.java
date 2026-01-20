package ParcialEntrada;
import java.time.LocalDate;
import java.util.*;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class DateLapse {

	private LocalDate from;
	private LocalDate to;
	
	
	public DateLapse (LocalDate fechaFrom, LocalDate fechaTo) {
		this.setFrom(fechaFrom);
		this.setTo(fechaTo);
	}
	
	public int sizeInDays() {
		return (int) Math.abs(this.getTo().toEpochDay() - this.getFrom().toEpochDay());
	}
	
	public boolean indludesDate (LocalDate other) {
		if (other.isAfter(this.getFrom().minusDays(1)) && other.isBefore(this.getTo().plusDays(1))) return true;
		return false;
		
		
		
	}
	public LocalDate getFrom() {
		return from;
	}
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	public LocalDate getTo() {
		return to;
	}
	public void setTo(LocalDate to) {
		this.to = to;
	}
	
	
}
