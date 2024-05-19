package clases;
/**
 * Clase Viaje: Es utilizada para crear obejetos de tipo viaje
 */
public class Viaje {
	/**
	 * Atributo para dar un lugar a la clase viaje
	 */
	private String lugar = "";
	/**
	 * Atributo para dar un fecha a la clase viaje
	 */
	private String fecha = "";
	/**
	 * Atributo para dar un precio al viaje
	 */
	private double precio = 0;

	/**
	 * Constructor completo para la clase Viaje
	 * 
	 * @param lugar  Parametro para dar un lugar al viaje
	 * @param fecha  Parametro para dar una fecha al viaje
	 * @param precio Parametro para dar un precio al viaje
	 */
	public Viaje(String lugar, String fecha, double precio) {
		super();
		if (lugar != null && lugar != "") {
			this.lugar = lugar;
		}
		if (comprobarFecha(fecha)) {
			this.fecha = fecha;
		}
		if (precio > 0) {
			this.precio = precio;
		}

	}
	
	/**
	 * Constructor para la clase Viaje para utilizar con el Equals
	 * 
	 * @param lugar Parametro para dar un lugar al viaje
	 * @param fecha Parametro para dar una fecha al viaje
	 */
	public Viaje(String lugar, String fecha) {
		super();
		if (lugar != null && lugar != "") {
			this.lugar = lugar;
		}
		if (comprobarFecha(fecha)) {
			this.fecha = fecha;
		}
	}



	/**
	 * Metodo get para obtener el lugar del viaje
	 * 
	 * @return Devuelve un string con el lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Metodo get para obtener la fecha del viaje
	 * 
	 * @return Devuelve un String con la fecha del viaje
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Metodo set para modificar el atributo fecha
	 * 
	 * @param fecha Parametro que actualizara la fecha
	 */
	public void setFecha(String fecha) {
		if (comprobarFecha(fecha)) {
			this.fecha = fecha;
		}
	}

	/**
	 * Metodo get para obtener el precio del viaje
	 * 
	 * @return Devuelve el precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Metodo set para modificar el atributo precio del viaje
	 * 
	 * @param precio Parametro para actualizar el valor del precio
	 */
	public void setPrecio(double precio) {
		if (precio > 0) {
			this.precio = precio;
		}
	}
	
	/**
	 * Funcion para comprobar el formato de la fecha 
	 * 
	 * @return Devuelve un boolean para saber si el formato es correcto
	 */
	public boolean comprobarFecha(String fecha) {
		boolean correcto = false;
		String guardar[] = null;
		guardar = fecha.split("/");
		int dia = Integer.parseInt(guardar[0]);
		int mes = Integer.parseInt(guardar[1]);
		int anio = Integer.parseInt(guardar[2]);

		if (dia > 0 && dia < 31) {
			correcto = true;
		}

		if (mes > 0 && mes < 13) {
			correcto = true;
		}

		if (anio > 0) {
			correcto = true;
		}

		return correcto;
	}
	/**
	 * Comprueba si dos viajes son iguales que lo son cuando el lugar y la fecha
	 * coinciden
	 * 
	 * @return Boolean con un true cuando son inguales y un false cuando son difrentes
	 */
	@Override
	public boolean equals(Object obj) {
		boolean igual = false;
		Viaje viaje = (Viaje) obj;
		if (viaje.lugar.equals(this.lugar) && viaje.fecha.equals(this.fecha)) {
			igual = true;
		}
		return igual;
	}
	/**
	 * El metodo ToString ejecuta que cada vez que nosotros tenemos que imprimir el objeto, 
	 * utilizara el formato definido en este metodo
	 * 
	 * @return Devuelve un cadena
	 */
	@Override
	public String toString() {
		String cad = "";
		cad += "Ciudad: " + this.lugar + "🗺️ ";
		cad += "Fecha: " + this.fecha + "📆 ";
		cad += "Precio: " + this.precio + "💶\n\n";
		return cad;
	}

}
