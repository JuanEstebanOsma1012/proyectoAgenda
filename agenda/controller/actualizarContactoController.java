package co.edu.uniquindio.agenda.controller;

import co.edu.uniquindio.agenda.model.Agenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class actualizarContactoController {

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
    void actualizarContacto(ActionEvent event) {
    	
    }
    
    public void asignarAgenda(Agenda agenda){
    	this.agenda = agenda;
    }

}

