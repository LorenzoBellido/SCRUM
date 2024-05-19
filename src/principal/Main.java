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
		// Variable para recoger la ciudad del viaje
		String ciudad ="";
		// Variable para guardar la fecha del viaje
		String fecha ="";
		// Variable para guardar la fecha modificada
		String nFecha ="";
		// Variable para recoger el precio del viaje
		double precio;
		// Variable para recoger la opcion de los menus 
		int opcion = 0;
		// Variable para mostrar la posicion del array
		int cont = 0;
		// Creaccion del objeto viaje, inicializado a null
		Viaje viaje = null;
		// LLamado a la clase de gestion
		Gestion g = new Gestion();
		// Abrimos un escaner para recoger los mensajes escritos en consola
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
			// Variable para recoger la opcion de los menus
			int opc = 0;
			
	
			do {
				// Se imprime el metodo menu 
				menu();
				// Eliges la opcion y se recoge
				opc = sc.nextInt();
				sc.nextLine();
				
				// Un Switch que ejecuta el metodo que ha elegido en el menu
				switch(opc) {
				case 1:
					// Lista el conjunto de viajes
					g.listado();
					break;
				case 2:
					//Recoge las variables para rellenar el constructor de Viaje
					System.out.println("Nombre de la ciudad");
					ciudad = sc.nextLine();
					System.out.println("Fecha del viaje");
					fecha = sc.next();
					System.out.println("Precio del viaje");
					precio = sc.nextDouble();
					viaje = new Viaje(ciudad, fecha, precio);
					
					//Condicional para comprobar si el viaje se ha aniadido correctamente
					if(g.anyadirViaje(viaje)) {
						System.out.println("Se ha añadido correctamente");
						IOClass.escribir(viaje);
					}else {
						System.out.println("🚫 Error al añadir. 🚫");
					}
					break;
				case 3:
					// Inicializamos el contador del array a 0
					cont = 0;
					// Le pedimos al usuario que introduzca el viaje que busca y lo recoge en ciudad
					System.out.println("Introduzca la ciudad del viaje que desea borrar.");
					ciudad = sc.nextLine();
					// Condicional que comprueba si el viaje esta dentro del set
					if(g.buscar(ciudad)) {
						
						//Si esta imprimira los viajes con ese nombre indicando su posicion
						System.out.println("📍 Elija un viaje 📍");
						for(Viaje vi : g.viajesBusqueda) {
							System.out.println("[" + cont + "] " + vi);
							cont++;
						}
						// Dependiendo de la posicion que elija se borrara una u otra
						opcion = sc.nextInt();
						// Condicional para ver si el viaje se ha borrado correctamente
						if(g.borrarViaje(opcion)) {
							System.out.println("❌ Viaje borrado ❌");
							
						}else {
							System.out.println("🚫 Viaje no borrado 🚫");
						}
					// En este caso si no hay ningun lugar con el nombre introducido no lo encontrara	
					}else {
						System.out.println("🚫 Viaje no encontrado 🚫");
					}
					// Inicializamos la opcion a 0
					opcion = 0;
					// Limpiamos con clear el arralist para que se quede vacio
					g.viajesBusqueda.clear();
					break;
					
				case 4: 
					// Se ejecuta el metodo para imprimir el menu de modificaciones y recogemos su eleccion
					menuModificar();
					opcion = sc.nextInt();
					//Limpia el buffer
					sc.nextLine();
					// Un Switch que ejecuta el metodo que ha elegido en el menuModificaciones
					switch(opcion) {
					case 1:
						// Inicializa la variable con a 0
						cont = 0;
						// Le pedimos al usuario que introduzca el viaje que busca y lo recoge en ciudad
						System.out.println("Introduzca la ciudad del viaje que desea modificar.");
						ciudad = sc.nextLine();
						// Condicional que comprueba si el viaje esta dentro del set
						if(g.buscar(ciudad)) {
							//Imprimira los viajes con ese nombre indicando su posicion
							System.out.println("📍 Elija un viaje 📍");
							for(Viaje vi : g.viajesBusqueda) {
								System.out.println("[" + cont + "] " + vi);
								cont++;
							}
							System.out.println("Introduzca la fecha del viaje");
							fecha = sc.nextLine();
							System.out.println("Introduzca la nueva fecha del viaje");
							nFecha = sc.nextLine();
							if(g.modificarFecha(ciudad, fecha, nFecha)) {
								System.out.println("Viaje modificado");
								
							}else {
								System.out.println("🚫 Viaje no modificado 🚫");
							}
						}else {
							System.out.println("🚫 Viaje no encontrado 🚫");
						}
						g.viajesBusqueda.clear();
						break;
						
					case 2:
						cont = 0;
						System.out.println("Introduzca la ciudad del viaje que desea modificar.");
						ciudad = sc.nextLine();
						if(g.buscar(ciudad)) {
							System.out.println("📍 Elija un viaje 📍");
							for(Viaje vi : g.viajesBusqueda) {
								System.out.println("[" + cont + "] " + vi);
								cont++;
							}
							System.out.println("Introduzca la fecha del viaje");
							fecha = sc.nextLine();
							System.out.println("Introduzca el nuevo precio del viaje");
							precio = sc.nextDouble();
							if(g.modificarPrecio(ciudad, fecha, precio)) {
								System.out.println("Viaje modificado");
								
							}else {
								System.out.println("🚫 Viaje no modificado 🚫");
							}
						}else {
							System.out.println("🚫 Viaje no encontrado 🚫");
						}
						g.viajesBusqueda.clear();
						break;
					}
					break;
					
				case 5:
					if(g.guardarCambios()) {
						System.out.println("💾 Cambios guardados 💾");
					}else {
						System.out.println("❌ No se han guardado los cambios ❌");
					}
					break;
					
				case 6:
					System.out.println("Saliendo.....");
					break;
					
				default:
						System.out.println("🚫 Opción no válida. 🚫");
					break;
				}
			}while(opc != 6);
			
			// Cerrar escaner
			sc.close();
			
		} catch (IOException e) {
			e.getMessage();
		}
	}
	/**
	 * Metodo para imprimir el menu de Viajes
	 */
	private static void menu() {
	    System.out.println("╔════════════════════════════════════════════════════════╗");
	    System.out.println("🛬                 🌎 Menú de Viajes 🌎                  🛬");
	    System.out.println("╟────────────────────────────────────────────────────────╢");
	    System.out.println("🛬 1. Mostrar listado de viajes📋                        🛬");
	    System.out.println("║  2. Insertar nuevo viaje🆕                             ║");
	    System.out.println("🛬 3. Eliminar nuevo viaje❎                             🛬");
	    System.out.println("║  4. Modificar nuevo viaje🛠️                            ║");
	    System.out.println("🛬 5. Guardar cambios💾                                  🛬");
	    System.out.println("║  6. Salir                                              ║");
	    System.out.println("╚════════════════════════════════════════════════════════╝");
	}
	/**
	 * Metodo para imprimir el menu de modificar
	 */
	private static void menuModificar() {
		System.out.println("╔════════════════════════════════════════════════════════╗");
	    System.out.println("🛬                🌎 Menú de Modificar 🌎                 🛬");
	    System.out.println("╟────────────────────────────────────────────────────────╢");
	    System.out.println("🛬 1. Modificar Fecha📋                                  🛬");
	    System.out.println("║  2. Modificar Precio💶                                 ║");
	    System.out.println("🛬 3. Salir                                              🛬");
	    System.out.println("╚════════════════════════════════════════════════════════╝");
	}

	
}
