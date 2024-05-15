package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class IOClass {

	public static BufferedReader reader = null;
	public static BufferedWriter writer = null;
	public static String linea ="";
	
	
	static public boolean leer() {
		boolean ret = false;
			
			try {
				if((linea = reader.readLine())!=null) {
					ret = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ret;
	}
	
	static public void escribir(Viaje viaje) {
		try {
			String[] valores = new String[3];
			valores[0] = viaje.getLugar();
			valores[1] = viaje.getFecha();
			valores[2] = String.valueOf(viaje.getPrecio());
			writer.newLine();
			writer.write(valores[0] + "::" + valores[1]+ "::" + valores[2]);
			writer.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
