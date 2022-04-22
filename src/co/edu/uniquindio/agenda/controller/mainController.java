package co.edu.uniquindio.agenda.controller;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class mainController implements Initializable{
	
	Agenda agenda;
	Stage secondaryStage = new Stage();

    @FXML
    private TableColumn<Contacto, String> correo;

    @FXML
    private TableColumn<Contacto, String> direccion;

    @FXML
    private TableColumn<Contacto, String> telefono;

    @FXML
    private TableColumn<Contacto, String> nombre;

    @FXML
    private TableColumn<Contacto, Integer> edad;

    @FXML
    private TableView<Contacto> tableViewContactos;
    
    @FXML
    private TextField txtNombreContactoBuscar;

    @FXML
    private TextField txtGrupoCita;
    
    @FXML
    private TextField txtAsuntoCitaBuscar;

    @FXML
    private TextField txtAsuntoCitaActualizar;

    @FXML
    private TextField txtNombreGrupoBuscar;

    @FXML
    private TextField txtNombreGrupoActualizar;
    
    @FXML
    private ListView<String> listViewGrupos;
    
    @FXML
    private ListView<String> listViewContactosGrupo;

    @FXML
    private ListView<String> listViewCitasGrupo;
    
    @FXML
    private ListView<String> listViewContactosCita;

    @FXML
    private ListView<String> listViewCitas;

    @FXML
    private TextField txtNombreContactoActualizar;
    
    ObservableList<Contacto> datosContactos = FXCollections.observableArrayList();
    ObservableList<String> datosNombresGrupos = FXCollections.observableArrayList();
    ObservableList<String> datosAsuntosCitas = FXCollections.observableArrayList();
    ObservableList<String> datosNombresContactos = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		agenda = new Agenda("mi nueva Agenda");

		//designar modelo de datos de la tabla de contactos
		nombre.setCellValueFactory( new PropertyValueFactory<Contacto, String>("nombre"));
		direccion.setCellValueFactory( new PropertyValueFactory<Contacto, String>("direccion"));
		telefono.setCellValueFactory( new PropertyValueFactory<Contacto, String>("telefono"));
		correo.setCellValueFactory( new PropertyValueFactory<Contacto, String>("correo"));
		edad.setCellValueFactory( new PropertyValueFactory<Contacto, Integer>("edad"));
		
		tableViewContactos.setItems(datosContactos);
		
		//designar modelo de datos de la lista de grupos
		listViewGrupos.setItems(datosNombresGrupos);
		
		//designar modelo de datos de las listas de citas
		listViewCitas.setItems(datosAsuntosCitas);
		listViewCitasGrupo.setItems(datosAsuntosCitas);
		
		//desginar modelo de datos de las listas de contactos
		listViewContactosCita.setItems(datosNombresContactos);
		listViewContactosGrupo.setItems(datosNombresContactos);
	}
	
    @FXML
    void buscarContacto(ActionEvent event) {
    	
    	try {
			
    		if (agenda.existeContacto(txtNombreContactoBuscar.getText())) {
				
    			Contacto contacto = agenda.obtenerContacto(txtNombreContactoBuscar.getText());
        		
        		datosContactos.setAll(contacto);
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void crearContacto(ActionEvent event) {
    	
    	try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FormularioCrearContacto.fxml"));
			Parent root = loader.load();
			
			crearContactoController crearContacto = loader.getController();
			crearContacto.asignarAgenda(agenda);
			
			Scene scene = new Scene(root);
			secondaryStage.setScene(scene);
			secondaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminarContacto(ActionEvent event) {

    	try {
			
    		if (agenda.existeContacto(txtNombreContactoActualizar.getText())) {
				
    			agenda.eliminarContacto(txtNombreContactoActualizar.getText());
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void actualizarContacto(ActionEvent event) {

    	if (txtNombreContactoActualizar.getText() != "" && agenda.existeContacto(txtNombreContactoActualizar.getText())) {
			
    		try {
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FormularioActualizarContacto.fxml"));
    			Parent root = loader.load();
    			
    			actualizarContactoController actualizarContacto = loader.getController();
    			actualizarContacto.asignarAgenda(agenda, txtNombreContactoActualizar.getText());
    			
    			Scene scene = new Scene(root);
    			secondaryStage.setScene(scene);
    			secondaryStage.show();
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
		}
    }
    
    @FXML
    void actualizarDatosContactos(ActionEvent event) {
    	
    	try {
    		
    		datosContactos.setAll(agenda.getListaContactos());
    		datosNombresContactos.setAll(Utils.extraerNombresContactos(Utils.filtrarNulos(agenda.getListaContactos())));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void crearGrupo(ActionEvent event) {
			
		try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FormularioCrearGrupo.fxml"));
			Parent root = loader.load();
			
			crearGrupoController crearGrupo = loader.getController(); 
	    	crearGrupo.asignarAgenda(agenda);
	    	
	    	Scene scene = new Scene(root);
			secondaryStage.setScene(scene);
			secondaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void actualizarDatosGrupos(ActionEvent event) {
    	datosNombresGrupos.setAll(agenda.obtenerNombresGrupos());
    }

    @FXML
    void buscarGrupo(ActionEvent event) {

    }

    @FXML
    void actualizarGrupo(ActionEvent event) {

    	if (agenda.existeGrupo(txtNombreGrupoActualizar.getText())) {
			
    		try {
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FormularioActualizarContacto.fxml"));
    			Parent root = loader.load();
    			
    			actualizarGrupoController actualizarGrupo = loader.getController();
    			actualizarGrupo.asignarAgenda(agenda, txtNombreGrupoActualizar.getText());
    			
    			Scene scene = new Scene(root);
    			secondaryStage.setScene(scene);
    			secondaryStage.show();
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
		}
    }

    @FXML
    void eliminarGrupo(ActionEvent event) {

    }

    @FXML
    void eliminarCita(ActionEvent event) {

    	try {
			
    		agenda.eliminarCita(txtAsuntoCitaActualizar.getText());
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void actualizarCita(ActionEvent event) {
    	
    	if (agenda.existeCita(txtAsuntoCitaActualizar.getText())) {
			
    		try {
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FormularioActualizarCita.fxml"));
    			Parent root = loader.load();
    			
    			actualizarCitaController actualizarCita = loader.getController();
    			actualizarCita.asignarAgenda(agenda, txtAsuntoCitaActualizar.getText());
    			
    			Scene scene = new Scene(root);
    			secondaryStage.setScene(scene);
    			secondaryStage.show();
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
		}
    	
    }

    @FXML
    void buscarCita(ActionEvent event) {

    }

    @FXML
    void actualizarDatosCitas(ActionEvent event) {
    	datosAsuntosCitas.setAll(agenda.obtenerAsuntosCitas());
    }

    @FXML
    void crearCita(ActionEvent event) {

    	try {
			
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FormularioCrearCita.fxml"));
    		Parent root = loader.load();
    		
    		crearCitaController crearCita = loader.getController();
    		crearCita.asignarAgenda(agenda);
    		
    		Scene scene = new Scene(root);
    		secondaryStage.setScene(scene);
    		secondaryStage.show();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

