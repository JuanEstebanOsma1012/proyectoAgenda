package co.edu.uniquindio.agenda.exception;

public class TelefonoConNoDigitosException extends Exception{

	public TelefonoConNoDigitosException(String mensaje){
		super(mensaje);
	}
	
	public TelefonoConNoDigitosException(){
		super();
	}
	
}
