package co.edu.uniquindio.agenda.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.agenda.application.Utils;
import co.edu.uniquindio.agenda.model.Agenda;
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

public class crearCitaController implements Initializable {

	Agenda agenda;
	Stage stage;
	
	Contacto[] contactosProvisionales;
	String[] nombresContactosProvisionales;
	
	Grupo grupoProvisional;
	String nombreGrupoProvisional;
	
    @FXML
    private TextField txtAsuntoCrearCita;

    @FXML
    private ListView<String> listViewContactosCrearCita;

    @FXML
    private TextField txtFechaCrearCita;

    @FXML
    private TextField txtGrupoCrearCita;

    @FXML
    private TextField txtHoraCrearCita;

    @FXML
    private TextField txtNombreContactoCrearCita;

    @FXML
    private TextField txtNombreGrupoCrearCita;
    
    ObservableList<String> datosNombresContactos = FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	listViewContactosCrearCita.setItems(datosNombresContactos);
	}

    @FXML
    void agregarContactoCrearCita(ActionEvent event) {

    	try {
			
    		Contacto contacto = agenda.obtenerContacto(txtNombreContactoCrearCita.getText());
    		
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
    void eliminarContactoCrearCita(ActionEvent event) {
    	
    	try {
			
    		Contacto contacto = agenda.obtenerContacto(txtNombreContactoCrearCita.getText());
    		
    		int indice = Utils.obtenerPosicion(contacto, contactosProvisionales);
			contactosProvisionales[indice] = null;
			nombresContactosProvisionales[indice] = null;
			
			datosNombresContactos.setAll(Utils.filtrarNulos(nombresContactosProvisionales));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminarGrupoCrearCita(ActionEvent event) {
    	
    	try {
			
    		Grupo grupo = agenda.obtenerGrupo(txtNombreGrupoCrearCita.getText());
    		
    		if (grupo == grupoProvisional) {
				grupoProvisional = null;
				nombreGrupoProvisional = null;
				
				txtGrupoCrearCita.setText("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void agregarGrupoCrearCita(ActionEvent event) {

    	try {
	
    		Grupo grupo = agenda.obtenerGrupo(txtNombreGrupoCrearCita.getText());
    
    		if (!(grupo == grupoProvisional)) {
    			
				grupoProvisional = grupo;
				nombreGrupoProvisional = grupoProvisional.getNombre();
				
				txtGrupoCrearCita.setText(nombreGrupoProvisional);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void crearCita(ActionEvent event) {

    	String fecha = (txtFechaCrearCita.getText() != "") ? txtFechaCrearCita.getText() : null;
    	String hora = (txtHoraCrearCita.getText() != "") ? txtHoraCrearCita.getText() : null;
    	String asunto = (txtAsuntoCrearCita.getText() != "") ? txtAsuntoCrearCita.getText() : null;
    	
    	try {
    		
    		agenda.crearCita(fecha, hora, asunto, grupoProvisional, Utils.filtrarNulos(contactosProvisionales));
    		
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
    	
    }

}

