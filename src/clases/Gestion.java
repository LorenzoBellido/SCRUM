package clases;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Clase Gestión que se encarga de administrar, modificar, añadir o borrar los
 * viajes.
 */
public class Gestion {
	/**
	 * Colección de viajes con sus diferentes atributos(lugar,fecha,precio)
	 */
	public static HashSet<Viaje> viajes = new HashSet<Viaje>();

	/**
	 * Array List encargado de guardar aquellos viajes que al ser buscados coincidan
	 * en el lugar
	 */
	public static ArrayList<Viaje> viajesBusqueda = new ArrayList<Viaje>();

	/**
	 * Constructor sin parámetros
	 */
	public Gestion() {
	}

	/**
	 * Método para añadir viajes al HashSet de viajes
	 * 
	 * @param v Objeto de tipo Viaje introducido por parámetro
	 * @return Devuelve un booleano, true si se ha añadido correctamente y false si
	 *         no se ha añadido
	 */
	public boolean anyadirViaje(Viaje v) {
		boolean anadido = false;
		if (v != null) {
			viajes.add(v);
			anadido = true;
		}
		return anadido;
	}

	/**
	 * Método para borrar un viaje de viajes, se introduce por parámetros una opción
	 * ya que al usuario se le mostrará un menú con los distintos viajes que van a
	 * esa ciudad
	 * 
	 * @param opc Entero introducido por parámetros que elegirá el viaje a borrar
	 * @return Devuelve un booleano, true si se ha borrado correctamente y false si
	 *         no se ha borrado
	 */
	public boolean borrarViaje(int opc) {
		boolean borrado = false;

		Viaje v = null;
		if (opc >= 0) {
			v = viajesBusqueda.get(opc);

			borrado = viajes.remove(v);
		}
		return borrado;
	}
	
	public boolean buscarViaje(String lugar) {
		boolean encontrado = false;
		
		return encontrado;
	}
	

	/**
	 * Función para moodificar el parametro del Precio de un viaje
	 * 
	 * @param lugar  Parametro para dar un lugar al viaje
	 * @param fecha  Parametro para dar una fecha al viaje
	 * @param precio Parametro para dar un precio la viaje
	 * @return Devuelve un booleano, true si se ha modificado correctamente y false
	 *         si no se ha modificado
	 */
	public static boolean modificarPrecio(String lugar, String fecha, double precio) {
		boolean modificado = false;

		Viaje viajenuevo = new Viaje(lugar, fecha);

		for (Viaje viaje : viajes) {

			if (viaje.equals(viajenuevo)) {
				viaje.setPrecio(precio);
				modificado = true;
			}
		}

		return modificado;

	}

	/**
	 * Función para moodificar el parámetro Fecha de un lugar
	 * 
	 * @param lugar Parametro para dar un lugar al viaje
	 * @param fecha Parametro para dar una fecha al viaje
	 * @return Devuelve un booleano, true si se ha modificado correctamente y false
	 *         si no se ha modificado
	 */
	public static boolean modificarFecha(String lugar, String fecha, String nFecha) {
		boolean modificado = false;

		Viaje viajenuevo = new Viaje(lugar, fecha);

		for (Viaje viaje : viajes) {

			if (viaje.equals(viajenuevo)) {
				viaje.setFecha(nFecha);
				modificado = true;
			}
		}

		return modificado;

	}

	/**
	 * Método que guarda los cambios en un archivo .txt Esta función recoge los
	 * datos del HashSet viajes y los escribe en el archivo datosTurismo.txt en
	 * formato Lugar::Fecha::Precio para poder ser leido o munipulado posteriormente
	 * 
	 * @return Devuelve un booleano, true si se ha guardado correctamente y false si
	 *         no se ha guardado
	 */
	public boolean guardarCambios() {
		BufferedWriter bw = null;
		try {
			bw = IOClass.writer = new BufferedWriter(new FileWriter("src\\fichero\\datosTurismo.txt"));
			bw.write("");
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean guardado = false;
		/*
		 * Bucle que va recorriendo la lista de viajes y va cogiendo los datos y
		 * escribiendolos
		 */
		for (Viaje v : viajes) {
			try {
				bw = IOClass.writer = new BufferedWriter(new FileWriter("src\\fichero\\datosTurismo.txt", true));
				bw.newLine();
				bw.write(v.getLugar());
				bw.write("::");
				bw.write(v.getFecha());
				bw.write("::");
				bw.write(String.valueOf(v.getPrecio()));
				bw.newLine();
				guardado = true;
			} catch (IOException e) {
				System.out.println("❌ Erro con el Archivo ❌");
			} finally {
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					System.out.println("❌ Error con el Archivo ❌");
					guardado = false;
				}

			}
		}
		return guardado;
	}

	/**
	 * Método para mostrar el listado de viajes
	 */
	public static void listado() {
		for(Viaje valor : viajes) {
			System.out.println(valor);
		}
		
	}

	/**
	 * Función que busca un viaje por el lugar y lo añade a la tabla viajesBusqueda
	 * por si hubiese más de uno para elegirlo más tarde
	 * 
	 * @param lugar Lugar del viaje que desea buscar
	 * @return Devuelve un booleano, true si se ha encontrado correctamente y false si
	 *         no se ha encontrado
	 */
	public static boolean buscar(String lugar) {
		boolean encontrado = false;
		for (Viaje v : viajes) {
			if (lugar.equalsIgnoreCase(v.getLugar())) {
				encontrado = true;
				viajesBusqueda.add(v);
			}
		}
		return encontrado;
	}
}
