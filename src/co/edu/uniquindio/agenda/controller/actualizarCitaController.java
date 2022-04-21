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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class actualizarCitaController implements Initializable{

	Agenda agenda;
	Stage stage;
	
	Cita citaAnterior;
	
	Contacto[] contactosProvisionales;
	String[] nombresContactosProvisionales;
	
	Grupo grupoProvisional;
	String nombreGrupoProvisional;
	
    @FXML
    private TextField txtHoraActualizarCita;

    @FXML
    private ListView<String> listViewContactosActualizarCita;

    @FXML
    private TextField txtNombreContactoActualizarCita;

    @FXML
    private TextField txtAsuntoActualizarCita;

    @FXML
    private TextField txtGrupoActualizarCita;

    @FXML
    private TextField txtNombreGrupoActualizarCita;

    @FXML
    private TextField txtFechaActualizarCita;
    
    ObservableList<String> datosNombresContactos = FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		listViewContactosActualizarCita.setItems(datosNombresContactos);
	}

    @FXML
    void agregarGrupoActualizarCita(ActionEvent event) {

    	try {
    		
    		Grupo grupo = agenda.obtenerGrupo(txtNombreGrupoActualizarCita.getText());
    
    		if (!(grupo == grupoProvisional)) {
    			
				grupoProvisional = grupo;
				nombreGrupoProvisional = grupoProvisional.getNombre();
				
				txtGrupoActualizarCita.setText(nombreGrupoProvisional);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void eliminarGrupoActualizarCita(ActionEvent event) {
    	
    	try {
			
    		Grupo grupo = agenda.obtenerGrupo(txtNombreGrupoActualizarCita.getText());
    		
    		if (grupo == grupoProvisional) {
				grupoProvisional = null;
				nombreGrupoProvisional = null;
				
				txtGrupoActualizarCita.setText("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminarContactoActualizarCita(ActionEvent event) {
    	
    	try {
			
    		Contacto contacto = agenda.obtenerContacto(txtNombreContactoActualizarCita.getText());
    		
    		int indice = Utils.obtenerPosicion(contacto, contactosProvisionales);
			contactosProvisionales[indice] = null;
			nombresContactosProvisionales[indice] = null;
			
			datosNombresContactos.addAll(Utils.filtrarNulos(nombresContactosProvisionales));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void agregarContactoActualizarCita(ActionEvent event) {

    	try {
			
    		Contacto contacto = agenda.obtenerContacto(txtNombreContactoActualizarCita.getText());
    		
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
    
    @FXML
    void actualizarCita(ActionEvent event) {

    }
    
    public void asignarAgenda(Agenda agenda, String asuntoCitaAnterior){
    	
    	this.agenda = agenda;
    	
    	try {
			
    		citaAnterior = agenda.obtenerCita(asuntoCitaAnterior);
        	
        	contactosProvisionales = new Contacto[agenda.getListaContactos().length];
        	nombresContactosProvisionales = new String[contactosProvisionales.length];
        	Utils.agregarArregloAOtro(citaAnterior.getListaContactosCita(), contactosProvisionales);
        	for (int i = 0; i < contactosProvisionales.length; i++) {
    			nombresContactosProvisionales[i] = (contactosProvisionales[i] != null) ? contactosProvisionales[i].getNombre() : null;
    		}
        	
        	grupoProvisional = citaAnterior.getGrupoCita();
        	nombreGrupoProvisional = (grupoProvisional != null) ? grupoProvisional.getNombre() : null;
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	txtAsuntoActualizarCita.setText(citaAnterior.getAsunto());
    	txtHoraActualizarCita.setText(citaAnterior.getHora());
    	txtFechaActualizarCita.setText(citaAnterior.getFecha());
    	datosNombresContactos.setAll(Utils.filtrarNulos(nombresContactosProvisionales));
    	
    	String nombreGrupo = (citaAnterior.getGrupoCita() != null) ? citaAnterior.getGrupoCita().getNombre() : "";
    	txtGrupoActualizarCita.setText(nombreGrupo);
    	
    }
}
