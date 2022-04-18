package co.edu.uniquindio.agenda.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.agenda.model.Agenda;
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
    private TextField txtTelefonoContacto;

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
    private TextField txtNombreContacto;
    
    ObservableList<Contacto> datosContactos = FXCollections.observableArrayList();
    ObservableList<String> datosGrupos = FXCollections.observableArrayList();
    ObservableList<String> datosCitas = FXCollections.observableArrayList();
    ObservableList<String> datosTelefonosContactos = FXCollections.observableArrayList();
    
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
		listViewGrupos.setItems(datosGrupos);
		
		//designar modelo de datos de las listas de citas
		listViewCitas.setItems(datosCitas);
		listViewCitasGrupo.setItems(datosCitas);
		
		//desginar modelo de datos de las listas de contactos
		listViewContactosCita.setItems(datosTelefonosContactos);
		listViewContactosGrupo.setItems(datosTelefonosContactos);
	}
	
    @FXML
    void buscarContacto(ActionEvent event) {

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

    }

    @FXML
    void actualizarContacto(ActionEvent event) {

    	if (!agenda.verificarExistenciaContacto(txtTelefonoContacto.getText())) {
			
    		try {
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FormularioActualizarContacto.fxml"));
    			Parent root = loader.load();
    			
    			actualizarContactoController actualizarContacto = loader.getController();
    			actualizarContacto.asignarAgenda(agenda);
    			
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
    	datosContactos.setAll(agenda.getListaContactos());
    	datosTelefonosContactos.setAll(agenda.obtenerTelefonoContactos());
    }
    
    @FXML
    void crearGrupo(ActionEvent event) {

    }

    @FXML
    void actualizarDatosGrupos(ActionEvent event) {
    	datosGrupos.setAll(agenda.obtenerNombresGrupos());
    }

    @FXML
    void buscarGrupo(ActionEvent event) {

    }

    @FXML
    void actualizarGrupo(ActionEvent event) {

    }

    @FXML
    void eliminarGrupo(ActionEvent event) {

    }

    @FXML
    void eliminarCita(ActionEvent event) {

    }

    @FXML
    void actualizarCita(ActionEvent event) {

    }

    @FXML
    void buscarCita(ActionEvent event) {

    }

    @FXML
    void actualizarDatosCitas(ActionEvent event) {
    	datosCitas.setAll(agenda.obtenerAsuntosCitas());
    }

    @FXML
    void crearCita(ActionEvent event) {

    }
    
}

