package co.edu.uniquindio.agenda.exception;

public class EdadNegativaException extends Exception{

	public EdadNegativaException(String mensaje){
		super(mensaje);
	}
	
	public EdadNegativaException(){
		super();
	}
}
