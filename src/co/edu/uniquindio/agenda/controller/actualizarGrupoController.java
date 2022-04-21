package co.edu.uniquindio.agenda.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.agenda.application.Utils;
import co.edu.uniquindio.agenda.model.Agenda;
import co.edu.uniquindio.agenda.model.Cita;
import co.edu.uniquindio.agenda.model.Contacto;
import co.edu.uniquindio.agenda.model.Grupo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class actualizarGrupoController implements Initializable{

	Stage stage;
	Agenda agenda;
	
	Grupo grupoAnterior;
	
	Contacto[] contactosProvisionales;
	String[] nombresContactosProvisionales;
	
	Cita[] citasProvisionales;
	String[] asuntosCitasProvisionales;
	
    @FXML
    private TextField txtAsuntoCitaActualizarGrupo;

    @FXML
    private ListView<String> listViewCitasActualizarGrupo;

    @FXML
    private TextField txtNombreContactoActualizarGrupo;

    @FXML
    private ListView<String> listViewContactosActualizarGrupo;

    @FXML
    private TextField txtNombreActualizarGrupo;
    
    ObservableList<String> datosNombresContactos = FXCollections.observableArrayList();
    ObservableList<String> datosAsuntosCitas = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listViewContactosActualizarGrupo.setItems(datosNombresContactos);
		listViewCitasActualizarGrupo.setItems(datosAsuntosCitas);
		
	}
    
    @FXML
    void agregarCitaActualizarGrupo(ActionEvent event) {
    	
    	try {
			
    		Cita cita = agenda.obtenerCita(txtAsuntoCitaActualizarGrupo.getText());
    		
    		if (!Utils.existeEnArreglo(cita, citasProvisionales)) {
				
    			int indice = Utils.obtenerPosicion(null, citasProvisionales);
    			citasProvisionales[indice] = cita;
            	asuntosCitasProvisionales[indice] = cita.getAsunto();
    			
            	datosAsuntosCitas.addAll(Utils.filtrarNulos(asuntosCitasProvisionales));
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminarCitaActualizarGrupo(ActionEvent event) {
    	
    	try {
			
    		Cita cita = agenda.obtenerCita(txtAsuntoCitaActualizarGrupo.getText());
    		
    		int indice = Utils.obtenerPosicion(cita, citasProvisionales);
			citasProvisionales[indice] = null;
			asuntosCitasProvisionales[indice] = null;
			
			datosAsuntosCitas.addAll(Utils.filtrarNulos(asuntosCitasProvisionales));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminarContactoActualizarGrupo(ActionEvent event) {
    	
    	try {
			
    		Contacto contacto = agenda.obtenerContacto(txtNombreContactoActualizarGrupo.getText());
    		
    		int indice = Utils.obtenerPosicion(contacto, contactosProvisionales);
			contactosProvisionales[indice] = null;
			nombresContactosProvisionales[indice] = null;
			
			datosNombresContactos.addAll(Utils.filtrarNulos(nombresContactosProvisionales));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    }

    @FXML
    void actualizarGrupo(ActionEvent event) {

    	String nombre = (txtNombreActualizarGrupo.getText() != "") ? txtNombreActualizarGrupo.getText() : null;
    	
    	try {
			
    		agenda.actualizarGrupo(grupoAnterior, nombre, Utils.filtrarNulos(citasProvisionales), Utils.filtrarNulos(contactosProvisionales));
        	
        	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	stage.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void agregarContactoActualizarGrupo(ActionEvent event) {
    	
    	try {
			
    		Contacto contacto = agenda.obtenerContacto(txtNombreContactoActualizarGrupo.getText());
    		
    		if (!Utils.existeEnArreglo(contacto, contactosProvisionales)) {
				
    			int indice = Utils.obtenerPosicion(null, contactosProvisionales);
            	contactosProvisionales[indice] = contacto;
            	nombresContactosProvisionales[indice] = contacto.getNombre();
    			
            	datosNombresContactos.addAll(Utils.filtrarNulos(nombresContactosProvisionales));
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void asignarAgenda(Agenda agenda, String asuntoGrupoAnterior){
    	
    	this.agenda = agenda;
    	grupoAnterior = agenda.obtenerGrupo(asuntoGrupoAnterior);
    	
    	contactosProvisionales = new Contacto[agenda.getListaContactos().length];
    	nombresContactosProvisionales = new String[contactosProvisionales.length];
    	try {
			Utils.agregarArregloAOtro(grupoAnterior.getListaContactosGrupo(), contactosProvisionales);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	for (int i = 0; i < contactosProvisionales.length; i++) {
			nombresContactosProvisionales[i] = (contactosProvisionales[i] != null) ? contactosProvisionales[i].getNombre() : null;
		}
    	
    	citasProvisionales = new Cita[agenda.getListaCitas().length];
    	asuntosCitasProvisionales = new String[citasProvisionales.length];
    	try {
			Utils.agregarArregloAOtro(grupoAnterior.getListaCitasGrupo(), citasProvisionales);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	for (int i = 0; i < citasProvisionales.length; i++) {
			asuntosCitasProvisionales[i] = (citasProvisionales[i] != null) ? citasProvisionales[i].getAsunto() : null;
		}
    	
    	txtNombreActualizarGrupo.setText(grupoAnterior.getNombre());
    	datosNombresContactos.setAll(Utils.filtrarNulos(nombresContactosProvisionales));
    	datosAsuntosCitas.setAll(Utils.filtrarNulos(asuntosCitasProvisionales));
    	
    }
}

