package co.edu.uniquindio.agenda.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.agenda.application.Utils;
import co.edu.uniquindio.agenda.model.Agenda;
import co.edu.uniquindio.agenda.model.Cita;
import co.edu.uniquindio.agenda.model.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class crearGrupoController implements Initializable {

	Stage stage;
	Agenda agenda;
	
	Contacto[] contactosProvisionales;
	String[] nombresContactosProvisionales;
	
	Cita[] citasProvisionales;
	String[] asuntosCitasProvisionales;
	
    @FXML
    private TextField txtAsuntoCitaCrearGrupo;

    @FXML
    private TextField txtNombreCrearGrupo;

    @FXML
    private TextField txtNombreContactoCrearGrupo;

    @FXML
    private ListView<String> listViewContactosCrearGrupo;

    @FXML
    private ListView<String> listViewCitasCrearGrupo;
    
    ObservableList<String> datosNombresContactos = FXCollections.observableArrayList();
    ObservableList<String> datosAsuntosCitas = FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {

    	listViewContactosCrearGrupo.setItems(datosNombresContactos);
    	listViewCitasCrearGrupo.setItems(datosAsuntosCitas);
    
	}

    @FXML
    void agregarContactoCrearGrupo(ActionEvent event) {
    	
    	try {
			
    		Contacto contacto = agenda.obtenerContacto(txtNombreContactoCrearGrupo.getText());
    		
    		if (!Utils.existeEnArreglo(contacto, contactosProvisionales)) {
				
    			int indice = Utils.obtenerPosicion(null, contactosProvisionales);
            	contactosProvisionales[indice] = contacto;
            	nombresContactosProvisionales[indice] = contacto.getNombre();
    			
            	datosNombresContactos.setAll(Utils.filtrarNulos(nombresContactosProvisionales));
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminarContactoCrearGrupo(ActionEvent event) {

    	try {
			
    		Contacto contacto = agenda.obtenerContacto(txtNombreContactoCrearGrupo.getText());
    		
    		int indice = Utils.obtenerPosicion(contacto, contactosProvisionales);
			contactosProvisionales[indice] = null;
			nombresContactosProvisionales[indice] = null;
			
			datosNombresContactos.setAll(Utils.filtrarNulos(nombresContactosProvisionales));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminarCitaCrearGrupo(ActionEvent event) {
    	
    	try {
			
    		Cita cita = agenda.obtenerCita(txtAsuntoCitaCrearGrupo.getText());
    		
    		int indice = Utils.obtenerPosicion(cita, citasProvisionales);
			citasProvisionales[indice] = null;
			asuntosCitasProvisionales[indice] = null;
			
			datosAsuntosCitas.setAll(Utils.filtrarNulos(asuntosCitasProvisionales));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void agregarCitaCrearGrupo(ActionEvent event) {
    	
    	try {
			
    		Cita cita = agenda.obtenerCita(txtAsuntoCitaCrearGrupo.getText());
    		
    		if (!Utils.existeEnArreglo(cita, citasProvisionales)) {
				
    			int indice = Utils.obtenerPosicion(null, citasProvisionales);
    			citasProvisionales[indice] = cita;
            	asuntosCitasProvisionales[indice] = cita.getAsunto();
    			
            	datosAsuntosCitas.setAll(Utils.filtrarNulos(asuntosCitasProvisionales));
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void crearGrupo(ActionEvent event) {
    	
    	try {
			
    		agenda.crearGrupo(txtNombreCrearGrupo.getText(), Utils.filtrarNulos(citasProvisionales), Utils.filtrarNulos(contactosProvisionales));
        	
        	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        	stage.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void asignarAgenda(Agenda agenda){
    	
    	this.agenda = agenda;
    	
		contactosProvisionales = new Contacto[agenda.getListaContactos().length];
		nombresContactosProvisionales = new String[contactosProvisionales.length];
		
		citasProvisionales = new Cita[agenda.getListaCitas().length];
		asuntosCitasProvisionales = new String[citasProvisionales.length];
    }

}

