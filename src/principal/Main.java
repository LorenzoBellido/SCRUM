package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import clases.Gestion;
import clases.IOClass;
import clases.Viaje;

public class Main {

	public static void main(String[] args) {

		String ciudad ="";
		String fecha ="";
		double precio;
		Viaje viaje = null;
		Gestion g = new Gestion();
		Scanner sc = new Scanner(System.in);
		try {
			IOClass.reader = new BufferedReader(new FileReader("src\\fichero\\datosTurismo.txt"));
			String[] valores = null;
			while(IOClass.leer()) {
				valores = IOClass.linea.split("::");
				if(valores.length == 3) {
					ciudad = valores[0];
					fecha = valores[1];
					precio = Double.parseDouble(valores[2]);
					viaje = new Viaje(ciudad, fecha, precio);
					g.anyadirViaje(viaje);
				}
			}
			IOClass.writer = new BufferedWriter(new FileWriter("src\\fichero\\datosTurismo.txt", true));
			
			int opc = 0;
			do {
				menu();
				opc = sc.nextInt();
				sc.nextLine();
				
				switch(opc) {
				case 1:
					g.listado();
					break;
				case 2:
					System.out.println("Nombre de la ciudad");
					ciudad = sc.nextLine();
					System.out.println("Fecha del viaje");
					fecha = sc.next();
					System.out.println("Precio del viaje");
					precio = sc.nextDouble();
					viaje = new Viaje(ciudad, fecha, precio);
					
					if(g.anyadirViaje(viaje)) {
						System.out.println("Se ha añadido correctamente");
						IOClass.escribir(viaje);
					}else {
						System.out.println("Error al añadir");
					}
					break;
				}
			}while(opc != 3);
			
			System.out.println("Saliendo.....");
		} catch (IOException e) {
			e.getMessage();
		}finally {
			try {
				IOClass.writer.flush();
				IOClass.writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void menu() {
		System.out.println("1. Mostrar listado de viajes");
		System.out.println("2. Insertar nuevo viaje");
		System.out.println("3. Salir");
	}

}
