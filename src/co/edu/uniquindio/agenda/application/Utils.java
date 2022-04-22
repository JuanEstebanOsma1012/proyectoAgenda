package co.edu.uniquindio.agenda.application;

import co.edu.uniquindio.agenda.model.Cita;
import co.edu.uniquindio.agenda.model.Contacto;
import co.edu.uniquindio.agenda.model.Grupo;

public class Utils {

	public static int obtenerPosicion(Contacto contacto, Contacto[] contactos) throws Exception{
		
		if (contactos == null) {
			throw new Exception("la lista de contactos es nula o el contacto es nulo");
		}
		
		int indice = -1;
		for (int i = 0; i < contactos.length && indice == -1; i++) {
			if (contactos[i] == contacto) {
				indice = i;
			}
		}
		
		if (indice == -1) {
			throw new Exception("no se encontró el contacto");
		}
		
		return indice;
	}
	
	public static int obtenerPosicion(Cita cita, Cita[] citas) throws Exception{
		
		if (citas == null || cita == null) {
			throw new Exception("datos nulos");
		}
		
		int indice = -1;
		for (int i = 0; i < citas.length && indice == -1; i++) {
			if (citas[i] == cita) {
				indice = i;
			}
		}
		
		if (indice == -1) {
			throw new Exception("no se encontró la cita");
		}
		
		return indice;
	}
	
	public static String[] filtrarNulos(String[] arreglo){
		
		String[] arregloFiltrado = new String[arreglo.length - obtenerPosicionesNulas(arreglo)];
		
		int indice = 0;
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] != null) {
				arregloFiltrado[indice] = arreglo[i];
				indice++;
			}
		}
		
		return arregloFiltrado;
	}

	public static Contacto[] filtrarNulos(Contacto[] contactos) {

		Contacto[] contactosFiltrados = new Contacto[contactos.length - obtenerPosicionesNulas(contactos)];
		
		int indice = 0;
		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] != null) {
				contactosFiltrados[indice] = contactos[i];
				indice++;
			}
		}
		
		return contactosFiltrados;
	}
	
	public static Cita[] filtrarNulos(Cita[] citas) {
		
		Cita[] citasFiltradas = new Cita[obtenerPosicionesNulas(citas) - citas.length];
		
		int indice = 0;
		for (int i = 0; i < citas.length; i++) {
			if (citas[i] != null) {
				citasFiltradas[indice] = citas[i];
				indice++;
			}
		}
		
		return citasFiltradas;
	}
	
	public static Grupo[] filtrarNulos(Grupo[] grupos) {
		
		Grupo[] gruposFiltrados = new Grupo[obtenerPosicionesNulas(grupos) - grupos.length];
		
		int indice = 0;
		for (int i = 0; i < grupos.length; i++) {
			if (grupos[i] != null) {
				gruposFiltrados[indice] = grupos[i];
				indice++;
			}
		}
		
		return gruposFiltrados;
	}
	
	public static boolean existeEnArreglo(Contacto contacto, Contacto[] contactosProvisionales) {

		for (int i = 0; i < contactosProvisionales.length; i++) {
			if (contacto == contactosProvisionales[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean existeEnArreglo(Cita cita, Cita[] citasProvisionales) {

		for (int i = 0; i < citasProvisionales.length; i++) {
			if (cita == citasProvisionales[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean existeEnArreglo(Grupo grupo, Grupo[] gruposProvisionales) {

		for (int i = 0; i < gruposProvisionales.length; i++) {
			if (grupo == gruposProvisionales[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	private static int obtenerPosicionesNulas(Grupo[] grupos) {

		int posicionesNulas = 0;
		for (int i = 0; i < grupos.length; i++) {
			if (grupos[i] == null) {
				posicionesNulas++;
			}
		}
		
		return posicionesNulas;
	}

	private static int obtenerPosicionesNulas(Cita[] citas) {

		int posicionesNulas = 0;
		for (int i = 0; i < citas.length; i++) {
			if (citas[i] == null) {
				posicionesNulas++;
			}
		}
		
		return posicionesNulas;
	}

	private static int obtenerPosicionesNulas(Contacto[] contactos) {

		int posicionesNulas = 0;
		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] == null) {
				posicionesNulas++;
			}
		}
		
		return posicionesNulas;
	}

	private static int obtenerPosicionesNulas(String[] arreglo) {

		int posicionesNulas = 0;
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] == null) {
				posicionesNulas++;
			}
		}
		
		return posicionesNulas;
	}

	public static void agregarArregloAOtro(Cita[] arregloParaAgregar, Cita[] arreglo) throws Exception {

		if (arregloParaAgregar == null || arreglo == null) {
			throw new Exception("datos nulos");
		} else if (arregloParaAgregar.length > arreglo.length) {
			throw new Exception("arreglos incompatibles");
		}
		
		for (int i = 0; i < arregloParaAgregar.length; i++) {
			arreglo[i] = arregloParaAgregar[i];
		}
	}

	public static void agregarArregloAOtro(Contacto[] arregloParaAgregar, Contacto[] arreglo) throws Exception{
		
		if (arregloParaAgregar == null || arreglo == null) {
			throw new Exception("datos nulos");
		} else if (arregloParaAgregar.length > arreglo.length) {
			throw new Exception("arreglos incompatibles");
		}
		
		for (int i = 0; i < arregloParaAgregar.length; i++) {
			arreglo[i] = arregloParaAgregar[i];
		}
	}

	public static String[] extraerNombresContactos(Contacto[] listaContactos) {

		String[] nombresContactos = new String[listaContactos.length];
		for (int i = 0; i < listaContactos.length; i++) {
			
			nombresContactos[i] = listaContactos[i].getNombre();
			
		}
		
		return nombresContactos;
	}
}
