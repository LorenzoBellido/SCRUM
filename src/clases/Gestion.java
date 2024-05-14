package clases;

import java.util.HashSet;

public class Gestion {

	private HashSet<Viaje> viajes = new HashSet<Viaje>();

	public Gestion() {
	}

	public boolean anyadirViaje(Viaje v) {
		boolean anadido = false;
		if(v != null) {
			viajes.add(v);
			anadido = true;
		}
		return anadido;
	}
	
	public boolean borrarViaje(Viaje v) {
		boolean borrado = false;
		if(viajes.contains(v)) {
			viajes.remove(v);
			
			borrado = true;
		}
		return borrado;
	}
	
	
	
}
