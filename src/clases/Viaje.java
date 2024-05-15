package clases;

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
		this.lugar = lugar;
		this.fecha = fecha;
		this.precio = precio;
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
		this.fecha = fecha;
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
		this.precio = precio;
	}

	
}
