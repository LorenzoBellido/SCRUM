package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import clases.IOClass;

public class Main {

	public static void main(String[] args) {

		String ciudad ="";
		String fecha ="";
		double precio;
		try {
			IOClass.reader = new BufferedReader(new FileReader("src\\fichero\\datosTurismo.txt"));
			String[] valores = null;
			while(IOClass.leer()) {
				valores = IOClass.linea.split("::");
				if(valores.length == 3) {
					ciudad = valores[0];
					fecha = valores[1];
					precio = Double.parseDouble(valores[2]);
					System.out.println("Ciudad: " + ciudad + " Fecha" + fecha + " Precio: " + precio);
				}
			}
//			IOClass.writer = new BufferedWriter(new FileWriter("src\\fichero\\datosTurismo.txt"));
//			Scanner sc = new Scanner(System.in);
//			
//			int opc = 0;
//			String ciudad ="";
//			String fecha ="";
//			double precio;
//			do {
//				menu();
//				opc = sc.nextInt();
//				sc.nextLine();
//				
//				switch(opc) {
//				case 1:
//					System.out.println("Nombre de la ciudad");
//					ciudad = sc.nextLine();
//					System.out.println("Fecha del viaje");
//					/*
//					 * 
//					 */
//					break;
//				}
//			}while(opc != 3);
		} catch (IOException e) {
//			e.getMessage();
		}
	}
	
	private static void menu() {
		System.out.println("1. Insertar nuevo viaje");
		System.out.println("2. Mostrar listado de viajes");
		System.out.println("3. Salir");
	}

}
