package clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public boolean guardarCambios() {
		BufferedWriter bw = null;
		try {
			bw = IOClass.writer = new BufferedWriter(new FileWriter("src\\fichero\\datosTurismo.txt"));
			bw.write("");
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		boolean guardado = false;
		for(Viaje v : viajes) {
		try {
			bw = IOClass.writer = new BufferedWriter(new FileWriter("src\\fichero\\datosTurismo.txt",true));
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
			}finally {
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
