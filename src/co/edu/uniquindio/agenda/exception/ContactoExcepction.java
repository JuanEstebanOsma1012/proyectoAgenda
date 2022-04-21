package co.edu.uniquindio.agenda.exception;

@SuppressWarnings("serial")
public class ContactoExcepction extends Exception {

	public ContactoExcepction(String mensaje){
		super(mensaje);
	}
	
	public ContactoExcepction(){
		super();
	}
}