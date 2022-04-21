package co.edu.uniquindio.agenda.test;

import java.util.Arrays;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Test {

	public static void main(String[] args) {

//retornar un arreglo de contactos que el nombre inicie en vocal y que el nombre de al menos uno de los grupos a los que pertenece termine en consonante
//Nota: no puede haber elementos nulos
		
// aqui pueden pedir los datos al usuario

//		Agenda agenda = new Agenda("Mi agenda personal", 10, 3);
//
//		// crear contacto
//		agenda.crearContacto("Robinson","rarias2@uniquindio.edu.co","calle 2", "315405");
//
//
//		try {
//			agenda.eliminarContacto("134455");a
//		} catch (ContactoExcepction e) {
//
//			JOptionPane.showMessageDialog(null,e.getMessage());
//		}

		// CRUD : crear obtener  actualizar eliminar
		
		ObservableList<String> prueba = FXCollections.observableArrayList();
		
		ListView<String> list = new ListView<String>(prueba);
		
		list.setItems(prueba);
		
		String[] arregloPrueba = {"hola", "mundo", "hello", null, "world"};
		
		prueba.addAll(arregloPrueba);
		
		Stage stage = new Stage();
		
		AnchorPane root = new AnchorPane(list);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		

	}

}
