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

    	String nombre = txtNombreContacto.getText();
    	String correo = txtCorreoContacto.getText();
    	String direccion = txtDireccionContacto.getText();
    	String telefono = txtTelefonoContacto.getText();
    	int edad = Integer.parseInt(txtEdadContacto.getText());
    	
    	agenda.crearContacto(nombre, correo, direccion, telefono, edad);
    	
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    	
    }
    
    public void asignarAgenda(Agenda agenda){
    	this.agenda = agenda;
    }
}

