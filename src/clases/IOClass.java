package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class IOClass {

	/**
	 * Atributo que crea un objeto para leer ficheros
	 */
	public static BufferedReader reader = null;
	/**
	 * Atributo que crea un objeto para escribir en ficheros
	 */
	public static BufferedWriter writer = null;
	/**
	 * Atributo que guarda la linea que lee el reader
	 */
	public static String linea = "";

	/**
	 * Funcion que lee linea por linea el fichero seleccionado y manda un booleano
	 * para saber cuando tiene que parar
	 * 
	 * @return Devuelve true en caso de que el fichero no tenga nada mas por leer y
	 *         false en caso de que pueda seguir leyendo
	 */
	static public boolean leer() {
		// Se crea una variable booleana que guarda el valor que de la senyal
		boolean ret = false;

		// El programa intenta leer el documento
		try {
			// Si la linea que ha leido no es nulo se recoge true en la variable, si la
			// siguiente linea no esta vacia
			if ((linea = reader.readLine()) != null) {
				// La variable se asigna a valor true
				ret = true;
			}
		} // En caso de fallo por una excepcion de entrada y salida se envia un mensaje de
			// fallo
		catch (IOException e) {
			e.printStackTrace();
		}
		// Se devuelve la variable
		return ret;
	}

	/**
	 * Funcion que sirve para escribie toda la informacion con el formato del
	 * archivo de texto
	 * 
	 * @param viaje Objeto que contiene toda la informacion del viaje
	 */
	static public void escribir(Viaje viaje) {
		// El programa intenta escribir el contenido en el fichero
		try {
			// Se crea una tabla que guarda los datos separados del viaje
			String[] valores = new String[3];
			// En la primera posicion se guarda el lugar
			valores[0] = viaje.getLugar();
			// En la segunda posicion se guarda la fecha
			valores[1] = viaje.getFecha();
			// En la tercera posicion se guarda el precio
			valores[2] = String.valueOf(viaje.getPrecio());
			// Se crea una nueva linea de texto
			writer.newLine();
			// Se escribe con el formato sobre esa linea
			writer.write(valores[0] + "::" + valores[1] + "::" + valores[2]);
			// Se vuelve a crear una nueva linea de texto
			writer.newLine();

		} // En caso de fallo por una excepcion de entrada y salida se envia un mensaje de
		// fallo
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
