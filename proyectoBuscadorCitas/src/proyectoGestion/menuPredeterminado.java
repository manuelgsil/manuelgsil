package proyectoGestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import proyectoModelos.Usuario;

public class menuPredeterminado {

	private static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputString = new Scanner(System.in);

	public static void main(String[] args) {
		mostrarInteresesDisponibles();

	}

	/**
	 * @author Manuel 
	 * 
	 * Metodo donde almacenanmos una variable String con el texto
	 * de cada menu para usarlo en distintas partes del codigo
	 * 
	 * 
	 */
	private static void almacenPantallazos(int numeroPantallazo) {
		String bloqueTexto;
		switch (numeroPantallazo) {
		case 1:
			bloqueTexto = """
					�Qu� desea hacer?
					 1. - A�adir una nueva persona
					 2. - Buscar emparejamientos
					 3. - Salir del programa
					 """;
			System.out.println(bloqueTexto);

			break;
		case 2:
			bloqueTexto = """
					�Como desea buscar?
					1. - Filtrando
					2. - Personas con m�s datos en com�n
					3. - Personas con aficiones opuestas
					4.- B�squeda aleatoria
										""";
			System.out.println(bloqueTexto);
			break;

		default:
			break;
		}
	}

	/**@author Manuel
	 * Metodo que sirve como primer menu principal y donde anidaremos los metodos
	 * principales
	 */
	private static void menuMarco() {

		// TODO Modificarlo segun lo que necesitemos

		int opcionUsuario;

		do {
			almacenPantallazos(1);
			opcionUsuario = inputInt.nextInt();
			switch (opcionUsuario) {
			case 1:
				crearUsuario();

				break;
			case 2:

				break;
			case 3:

				break;

			default:
				break;
			}
		} while (opcionUsuario != 3);

	}

	/**
	 * @author Manuel
	 */
	public static void crearUsuario() {
		/*
		 * TODO Desarrollar este metodo para que mediante una serie de preguntas
		 * almacenemos la informacion neceseria para pasarselo al constructor de clase
		 */
		
		
	
	}

	private static void mostrarInteresesDisponibles() {
		// TODO La lista de intereses es provisional. Habra que retocarla de cara al final
		
		String interesUnico = null; // String que usaremos para almacenar la opcion del usuario
		ArrayList<String> interesesUsuario = new ArrayList<>(); // Lista dinamica con la que podremos darle elasticidad
																// a las opciones
		// y al perfil por si quisiera modificar algo
		String bloqueTexto;
		boolean bandera = true;
	
		// Declaramos una lista dinamica para poder a�adir o quitar posteriormente
	
		String[][] listaIntereses = { { "Deportes:", "Futbol", "Baloncesto", "Tenis", "Boxeo" },
				{ "M�sica:", "Rock", "Pop", "Electr�nica" }, { "Arte y cultura:", "Pintura" },
				{ "Mascotas:", "Perros", "Gatos" }, { "Comida:", "Italiana", "Japonesa", "Mexicana" },
				{ "Bienestar y salud:", "Yoga", "Realfooder" }, { "Tecnolog�a:", "Informatica", "Hardware" },
				{ "Videojuegos:", "Rpg", "Estrategia", "Plataformas" },
				{ "Cine y TV:", "Cine clasico", "Series TV", "Ciencia ficcion" },
	
		};
	
		// Imprimir filas de datos
		for (int i = 0; i < listaIntereses.length; i++) {
			System.out.printf("%-3d", i + 1);
			for (int j = 0; j < listaIntereses[i].length; j++) {
				System.out.printf("%-20s", listaIntereses[i][j]);
			}
			System.out.println();
		}
	
		bloqueTexto = """
	
				Debe seleccionar un minimo de 3 intereses.
				Escriba sus prefrencias despues de la lista.
				Cuando finalice o desee acabar, teclee fin.
	
				""";
		System.out.printf(bloqueTexto);
	
		while (bandera) {
	
			interesUnico = inputString.next();
	
			if (interesUnico.equalsIgnoreCase("fin"))
				bandera = false;
	
			else
				interesesUsuario = agregarInteresesUsuario(listaIntereses, interesUnico, interesesUsuario);
	
		}
	
	}

	/**
	 * @author Manuel
	 * 
	 *         Metodo por el cual agregamos el interes escogido por el usuario,
	 *         proveniente de un array bidimensional que contiene los permitidos, a
	 *         un ArrayList. Se ha controlado que no se puedan introducir las
	 *         categorias generales colocando el indice fuera de la variable j
	 *         (siempre empieza en 1)
	 * 
	 * 
	 * @param interesesPermitidos arrayBidimensinoal que contiene los intereses que
	 *                            se pueden escoger
	 * @param interesEscogido     String que contiene la seleccion del usuario
	 * @param interesesUsuario    arraylist que va generandose hasta que el usuario
	 *                            decide acabar
	 * @return Devuelve el arrayList con los intereses introducidos
	 */
	private static ArrayList<String> agregarInteresesUsuario(String[][] interesesPermitidos, String interesEscogido,
			ArrayList<String> interesesUsuario) {
	
		// TODO poner algun tipo de mensaje para comentarle al usuario si se ha a�adido
		// o no algo a su lista
	
		for (int i = 0; i < interesesPermitidos.length; i++) {
			for (int j = 1; j < interesesPermitidos[i].length; j++) { // Controlamos que no se pueda introducir el
																		// INDICE
	
				if (interesesPermitidos[i][j].equalsIgnoreCase(interesEscogido)
						&& !interesesUsuario.contains(interesEscogido)) // Ignore case para que no haya problemas
					interesesUsuario.add(interesEscogido);
			}
		}
	
		return interesesUsuario;
	}
}
