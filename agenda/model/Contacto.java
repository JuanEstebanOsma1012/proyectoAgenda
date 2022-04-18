package co.edu.uniquindio.agenda.model;

import java.util.Arrays;

public class Contacto {

	private int edad;
	private String nombre;
	private String correo;
	private String direccion;
	private String telefono;
	
	private Agenda agenda;
	private Cita[] listaCitasContacto;
	private Grupo[] listaGrupos;

	public Contacto(String nombre, String correo, String direccion, String telefono, int edad, Agenda agenda) {
		
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = edad;
		this.agenda = agenda;
		this.listaGrupos = new Grupo[agenda.getListaGrupos().length];
		this.listaCitasContacto = new Cita[agenda.getListaCitas().length];
		
	}
	
	public Contacto(int edad, String nombre, String correo, String direccion, String telefono, Agenda agenda,
			Cita[] listaCitasContacto, Grupo[] listaGrupos) {
		
		this.edad = edad;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.agenda = agenda;
		this.listaCitasContacto = listaCitasContacto;
		this.listaGrupos = listaGrupos;
		
	}

	public Contacto(int edad, String nombre, String correo, String direccion, String telefono, Agenda agenda,
			Grupo[] listaGrupos) {
		
		this.edad = edad;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.agenda = agenda;
		this.listaCitasContacto = new Cita[agenda.getListaCitas().length];
		this.listaGrupos = listaGrupos;
	}

	public Contacto(int edad, String nombre, String correo, String direccion, String telefono, Agenda agenda,
			Cita[] listaCitasContacto) {
		
		this.edad = edad;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.agenda = agenda;
		this.listaCitasContacto = listaCitasContacto;
		this.listaGrupos = new Grupo[agenda.getListaGrupos().length];
		
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Cita[] getListaCitasContacto() {
		return listaCitasContacto;
	}

	public void setListaCitasContacto(Cita[] listaCitasContacto) {
		this.listaCitasContacto = listaCitasContacto;
	}

	public Grupo[] getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(Grupo[] listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	@Override
	public String toString() {
		return "Contacto [edad=" + edad + ", nombre=" + nombre + ", correo=" + correo + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", agenda=" + agenda + ", listaCitasContacto="
				+ Arrays.toString(listaCitasContacto) + ", listaGrupos=" + Arrays.toString(listaGrupos) + "]";
	}
	
}
