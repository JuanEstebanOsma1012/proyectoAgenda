package co.edu.uniquindio.agenda.model;

import java.util.Arrays;

public class Grupo {

	private String nombre;
	
	private Agenda agenda;
	private Contacto[] listaContactosGrupo;
	private Cita[] listaCitasGrupo;
	
	public Grupo(String nombre, Agenda agenda) {
		
		this.nombre = nombre;
		this.agenda = agenda;
		this.listaContactosGrupo = new Contacto[agenda.getListaContactos().length];
		this.listaCitasGrupo = new Cita[agenda.getListaCitas().length];
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Contacto[] getListaContactosGrupo() {
		return listaContactosGrupo;
	}

	public void setListaContactosGrupo(Contacto[] listaContactosGrupo) {
		this.listaContactosGrupo = listaContactosGrupo;
	}

	public Cita[] getListaCitasGrupo() {
		return listaCitasGrupo;
	}

	public void setListaCitasGrupo(Cita[] listaCitasGrupo) {
		this.listaCitasGrupo = listaCitasGrupo;
	}

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", agenda=" + agenda + ", listaContactosGrupo="
				+ Arrays.toString(listaContactosGrupo) + ", listaCitasGrupo=" + Arrays.toString(listaCitasGrupo) + "]";
	}
	
}
