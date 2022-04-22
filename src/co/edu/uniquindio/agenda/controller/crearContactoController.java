package co.edu.uniquindio.agenda.controller;

import co.edu.uniquindio.agenda.model.Agenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class crearContactoController {

	Agenda agenda;
	Stage stage;
	
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
    void crearNuevoContacto(ActionEvent event) {

    	try {
    		
    		String nombre = (txtNombreContacto.getText() != "") ? txtNombreContacto.getText() : null;
        	String correo = (txtCorreoContacto.getText() != "") ? txtCorreoContacto.getText() : null;
        	String direccion = (txtDireccionContacto.getText() != "") ? txtDireccionContacto.getText() : null;
        	String telefono = (txtTelefonoContacto.getText() != "") ? txtTelefonoContacto.getText() : null;
        	int edad = (txtEdadContacto.getText() != "") ? Integer.parseInt(txtEdadContacto.getText()) : -1;
			
    		agenda.crearContacto(nombre, correo, direccion, edad, telefono);
        	
        	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	stage.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public void asignarAgenda(Agenda agenda){
    	this.agenda = agenda;
    }
}

