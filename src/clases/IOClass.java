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
	
}
