package co.edu.uniquindio.agenda.model;

import java.util.Arrays;
import co.edu.uniquindio.agenda.exception.ContactoExcepction;

public class Agenda {

	private String titulo;
	private Contacto[] listaContactos;
	private Grupo[] listaGrupos;
	private Cita[] listaCitas;

	public Agenda(String titulo){
		
		this.titulo = titulo;
		this.listaCitas = new Cita[10];
		this.listaGrupos = new Grupo[10];
		this.listaContactos = new Contacto[10];
		
	}
	
	public Agenda(String titulo, int numContactos, int numGrupos, int numCitas) {

		this.titulo = titulo;
		this.listaContactos = new Contacto[numContactos];
		this.listaGrupos = new Grupo[numGrupos];
		this.listaCitas = new Cita[numCitas];

	}

	public Agenda(String titulo, Contacto[] listaContactos, Cita[] listaCitas, Grupo[] listaGrupos){
		
		this.titulo = titulo;
		this.listaCitas = listaCitas;
		this.listaContactos = listaContactos;
		this.listaGrupos = listaGrupos;
		
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Contacto[] getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}

	public Grupo[] getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(Grupo[] listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public Cita[] getListaCitas() {
		return listaCitas;
	}

	public void setListaCitas(Cita[] listaCitas) {
		this.listaCitas = listaCitas;
	}

	@Override
	public String toString() {
		return "Agenda [titulo=" + titulo + ", listaContactos=" + Arrays.toString(listaContactos) + ", listaGrupos="
				+ Arrays.toString(listaGrupos) + ", listaCitas=" + Arrays.toString(listaCitas) + "]";
	}

	public String crearContacto(String nombre, String correo, String direccion, String telefono, int edad) {
		
		String mensaje = "";
		int posicionDisponible = 0;
		boolean existeContacto = false;

		posicionDisponible = obtenerPosicionDisponibleContacto();

		if(posicionDisponible == -1){
			
			mensaje = "No hay posiciones disponibles";
			
		}else{

			existeContacto = verificarExistenciaContacto(telefono);
			if(existeContacto == false){
				
				listaContactos[posicionDisponible] = new Contacto(nombre, correo, direccion, telefono, edad, this);
				mensaje = "El contacto fue creado";
				
			}else{
				
				mensaje = "Ya existe un contacto con este numero de telefono";
				
			}
		}

		return mensaje;
	}

	public Contacto obtenerContacto(String nombre) {

		for (Contacto contacto : listaContactos) {
			if(contacto != null && contacto.getNombre().equals(nombre)){
				return contacto;
			}
		}

		return null;
	}

	public String actualizarContacto(String telefonoAnterior, String telefonoNuevo,
			String nombreNuevo,String correpoNuevo,String direccionNueva) throws ContactoExcepction{

		String mensaje = "";
		Contacto contactoEncontrado= null;

		contactoEncontrado = obtenerContacto(telefonoAnterior);

		if(contactoEncontrado == null){
			 throw new ContactoExcepction("El contacto no existe");
		}
		else{
			 contactoEncontrado.setNombre(nombreNuevo);
			 contactoEncontrado.setCorreo(correpoNuevo);
			 contactoEncontrado.setDireccion(direccionNueva);
			 contactoEncontrado.setTelefono(telefonoNuevo);
		}

		return "El contacto ha sido actualizado";

	}
	
	public String eliminarContacto (String telefono) throws ContactoExcepction{

		boolean existeContacto = false;

		existeContacto = verificarExistenciaContacto(telefono);

		if(existeContacto == false){
			throw new ContactoExcepction("El contacto no existe");
		}else{

			int posContacto = obtenerPosContacto(telefono);

			listaContactos [posContacto] = null;
		}

		return "Contacto eliminado";
	}
	
	public boolean verificarExistenciaContacto(String nombre) {

		for (Contacto contacto : listaContactos) {
			if(contacto != null && contacto.getNombre().equals(nombre)){
				return true;
			}
		}

		return false;
	}




	private int obtenerPosicionDisponibleContacto() {

		int pos = -1;

		for (int i = 0; i < listaContactos.length; i++) {
			if(listaContactos [i] == null){
				return i;
			}
		}
		return pos;
	}



	

	private int obtenerPosContacto(String telefono) {


		int pos = 0;
		Contacto contactoAuxliar = null;

		for (int i = 0; i < listaContactos.length; i++) {
			contactoAuxliar = listaContactos[i];
			if(contactoAuxliar != null && contactoAuxliar.getTelefono().equals(telefono)){
				return i;
			}
		}
		return pos;
	}

	public String[] obtenerNombresGrupos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] obtenerTelefonoContactos() {
		String[] prueba = {""};
		return prueba;
	}

	public String obtenerAsuntosCitas() {
		// TODO Auto-generated method stub
		return null;
	}









}
