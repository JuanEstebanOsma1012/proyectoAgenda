package co.edu.uniquindio.agenda.controller;

import co.edu.uniquindio.agenda.model.Agenda;
import co.edu.uniquindio.agenda.model.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class actualizarContactoController {

	Agenda agenda;
	Stage stage;
	
	Contacto contactoAnterior;
	
    @FXML
    private TextField txtTelefonoContacto;

    @FXML
    private TextField txtCorreoContacto;

    @FXML
    private TextField txtDireccionContacto;

    @FXML
    private TextField txtNombreContacto;

    @FXML
    private TextField txtEdadContacto;

    @FXML
    void actualizarContacto(ActionEvent event) {
    	
    	String nombre = (txtNombreContacto.getText() != "") ? txtNombreContacto.getText() : null;
    	String direccion = (txtDireccionContacto.getText() != "") ? txtDireccionContacto.getText() : null;
    	String correo = (txtCorreoContacto.getText() != "") ? txtCorreoContacto.getText() : null;
    	String telefono = (txtTelefonoContacto.getText() != "") ? txtTelefonoContacto.getText() : null;
    	int edad = (txtEdadContacto.getText() != "") ? Integer.parseInt(txtEdadContacto.getText()) : -1;
    	
    	try {
			
    		agenda.actualizarContacto(contactoAnterior, nombre, direccion, correo, telefono, edad);
        	
        	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	stage.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public void asignarAgenda(Agenda agenda, String nombreContacto){
    	
    	this.agenda = agenda;
    	
    	try {
			
    		this.contactoAnterior = agenda.obtenerContacto(nombreContacto);
        	
        	txtNombreContacto.setText(contactoAnterior.getNombre());
        	txtDireccionContacto.setText(contactoAnterior.getDireccion());
        	txtCorreoContacto.setText(contactoAnterior.getCorreo());
        	txtTelefonoContacto.setText(contactoAnterior.getTelefono());
        	txtEdadContacto.setText(Integer.toString(contactoAnterior.getEdad()));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

