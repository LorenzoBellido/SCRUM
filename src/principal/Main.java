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
		int opcion = 0;
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
				case 3:
					System.out.println("Introduzca la ciudad del viaje que desea borrar.");
					ciudad = sc.nextLine();
					if(g.buscar(ciudad)) {
						System.out.println(g.viajesBusqueda);
						System.out.println("Elija un viaje");
						opcion = sc.nextInt();
						if(g.borrarViaje(opcion)) {
							System.out.println("Viaje borrado");
						}else {
							System.out.println("Viaje no borrado");
						}
					}else {
						System.out.println("Viaje no encontrado");
					}
					break;
					
				case 4: 
					
					break;
					
				default:
						System.out.println("Opción no válida.");
					break;
				}
			}while(opc != 5);
			
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
	    System.out.println("╔════════════════════════════════════════════════════════╗");
	    System.out.println("🛬                  🌎Menú de Viajes🌏                   🛬");
	    System.out.println("╟────────────────────────────────────────────────────────╢");
	    System.out.println("🛬 1. Mostrar listado de viajes📍                        🛬");
	    System.out.println("║  2. Insertar nuevo viaje📍                             ║");
	    System.out.println("🛬 3. Eliminar nuevo viaje📍                             🛬");
	    System.out.println("║  4. Modificar nuevo viaje📍                            ║");
	    System.out.println("🛬 5. Salir                                              🛬");
	    System.out.println("╚════════════════════════════════════════════════════════╝");
	}


}
