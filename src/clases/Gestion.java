package clases;

import java.util.ArrayList;
import java.util.HashSet;

public class Gestion {

	static public HashSet<Viaje> viajes = new HashSet<Viaje>();
	
	static public ArrayList<Viaje> viajesBusqueda= new ArrayList<Viaje>();

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
	
	public boolean borrarViaje(int opc) {
		boolean borrado = false;
		Viaje v = null;
		if(opc >= 0) {
			v = viajesBusqueda.get(opc);
			
			borrado = viajes.remove(v);
			}
		return borrado;
	}
	
	
	
	public static void listado() {
		System.out.println(viajes);
	}
	
	public static boolean buscar(String lugar) {
		boolean encontrado = false;
		int cont = 0;
		for(Viaje v : viajes) {
			if(lugar.equalsIgnoreCase(v.getLugar())) {
				encontrado = true;
				viajesBusqueda.add(v);
			}
		}
		return encontrado;
	}
}
