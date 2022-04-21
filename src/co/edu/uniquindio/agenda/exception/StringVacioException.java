package co.edu.uniquindio.agenda.exception;

public class StringVacioException extends Exception{

	public StringVacioException(String mensaje){
		super(mensaje);
	}
	
	public StringVacioException(){
		super();
	}
}
