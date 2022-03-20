package Vista;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import Enums.Category;
import Enums.Status;
import Interfaces.IVista;
import Modelo.Client;
import Modelo.Product;
import Modelo.RepoCopia;
import Modelo.Reservation;


public class Vista implements IVista{
	
	RepoCopia rCopia = RepoCopia.getInstance();
	
	private Vista() {
		
	}
	private static Vista mivista;
	
	/**
	 * Metodo para convertir vista en patron singleton
	 * @return devuelve vista
	 */
	public static Vista getInstance() {
		if(mivista==null) {
			mivista=new Vista();
		}
		return mivista;
	}

	/**
	 * Metodo de la vista principal del menu
	 */
	public void showMainMenu() {
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("|  _         _    _    ___     ____    _______    _____    _        _     _    ____      |");                          
		System.out.println("| |*|       |*|  |*|  |***|   |****|  |*******|  |*****|  |*|      |*|   |*|  |****|     |");
		System.out.println("|  |*|     |*|   |*|  |*  *|  |*|     |*|   |*|  |*|      |*|      |*|   |*|  |*   *|    |");
		System.out.println("|   |*|   |*|    |*|  |*   *| |****|  |*|   |*|  |*|      |*|      |*|   |*|  |***|      |");
		System.out.println("|    |*| |*|     |*|  |*  *|  |*|     |*|   |*|  |*|      |*|___   |*|___|*|  |*   *|    |");
		System.out.println("|      |**|      |*|  |***|   |****|  |*******|  |*****|  |*****|  |****** |  |****|     |");
		System.out.println("|                                                                                        |");
		System.out.println("|----------------------------------------------------------------------------------------|");
	    System.out.println("                                                                                          ");
	    System.out.println("                                                                                          ");
	    System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("|                                 1. Clientes                                            |");
		System.out.println("|                                 2. Productos                                           |");
		System.out.println("|                                 3. Salir                                               |");
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	/**
	 * Metodo de la vista del menu de cliente
	 */
	public void showMenuClient() {
		System.out.println("1. Anadir cliente");
		System.out.println("2. Eliminar cliente");
		System.out.println("3. Modificar cliente");
		System.out.println("4. Mostrar clientes");
		System.out.println("5. Buscar cliente");
		System.out.println("6. Reservas");
		System.out.println("7. Volver");
	}

	/**
	 * Metodo de la vista del menu de producto
	 */
	public void showMenuProduct() {
		System.out.println("1. Anadir producto");
		System.out.println("2. Eliminar producto");
		System.out.println("3. Modificar producto");
		System.out.println("4. Mostrar producto");
		System.out.println("5. Buscar producto");
		System.out.println("6. Volver");
	}

	/**
	 * Metodo de la vista del menu de reserva
	 */
	public void showMenuReservation() {
		System.out.println("1. Crear reserva");
		System.out.println("2. Eliminar reserva");
		System.out.println("3. Modificar reserva");
		System.out.println("4. Mostrar reservas");
		System.out.println("5. Buscar reserva");
		System.out.println("6. Volver");
	}

	/**
	 * Metodo de la vista del menu de modificar un cliente
	 */
	public void showMenuModifyClient() {
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar telefono");
		System.out.println("3. Modificar direccion");
		System.out.println("4. Modificar edad");
		System.out.println("5. Volver");
	}

	/**
	 * Metodo de la vista del menu de modificar un producto
	 */
	public void showMenuModifyProduct() {
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar descripcion");
		System.out.println("3. Modificar precio");
		System.out.println("4. Modificar categoria");
		System.out.println("5. Volver");
	}

	/**
	 * Metodo de la vista del menu de modificacr una reserva
	 */
	public void showMenuModifyReservation() {
		System.out.println("1. Modificar estado de la reserva");
		System.out.println("2. Volver");
	}
	
	/**
	 * Metodo que muestra las categorias de los productos para poder elegirlas a la hora de crear
	 * o modificar un producto
	 */
	public void showCategoryMenu() {
		System.out.println("1. Peliculas");
		System.out.println("2. Juegos");
		System.out.println("3. Series");

	}
	
	/**
	 * Metodo para mostrar la lista de clientes que se encuentra en el hashmap
	 */
	public void showClientList(HashMap <Integer, Client> c){
		for(Integer key:c.keySet()) {
			System.out.println("ID: " +key+ "Value: " +c.get(key));
		}
	}
	
	/**
	 * Metodo que muestra todas las reservas que se encuentra en el hashmap
	 * @param c
	 */
	public void showReservations(HashMap <Integer, Reservation> c){
		for(Integer key:c.keySet()) {
			System.out.println("ID: " +key+ "Value: " +c.get(key));
		}
	}
	
	/**
	 * Muestra el menu de copias del producto creado
	 * @param id de la copia que vamos a elegir
	 */
	public void showCopyList(Integer id) {
		rCopia.CopyByIdProduct(id);
	}

	/**
	 * Metodo que controla los errores a la hora de introducir un entero
	 */
	public Integer leeEntero(String frase) {
		Scanner teclado= new Scanner(System.in);
		boolean valid=false;
		Integer numero=-1;
		do {
			try {
				System.out.println(frase);
				numero=teclado.nextInt();
				valid=true;
			}catch(InputMismatchException ex) {
				System.out.println("Error. Vuelve a introducir un valor");
				teclado.next();
			}
		}while(!valid);
		return numero;
	}

	/**
	 * Metodo que controla los errores a la hora de introducir un float
	 */
	public Float leeFloat(String frase) {
		Scanner teclado= new Scanner(System.in);
		boolean valid=false;
		Float numero=1.f;
		do {
			try {
				System.out.println(frase);
				numero=teclado.nextFloat();
				valid=true;
			}catch(InputMismatchException ex) {
				System.out.println("Error. Vuelve a introducir un valor");
				teclado.next();
			}
		}while(!valid);
		return numero;
	}

	/**
	 * Metodo que lee por teclado una cadena de caracteres
	 */
	public String leeString(String frase) {
		Scanner teclado= new Scanner (System.in);
		String f="";
		System.out.println(frase);
		f=teclado.nextLine();
		return f;
	}

	/**
	 * Metodo para imprimir por pantalla una cadena de caracteres
	 */
	public void print(String s) {
		System.out.println(s);
	}

	/**
	 * Metodo para elegir la opcion del menu para elegir en donde queremos entrar
	 * Controla los errores para que tengamos que elegir una opcion que este en el menu
	 */
	public Integer opcMenu3() {
		boolean valid= false;
		Integer opcion=-1;
		do {
			valid = false;
			opcion=leeEntero("Introduzca una opcion");
			if(opcion<1 || opcion>3) {
			System.out.println("Debe insertar un valor valido");
			valid=true;
			}
		}while(valid);
		return opcion;
	}

	/**
	 * Metodo para elegir la opcion del menu para elegir en donde queremos entrar
	 * Controla los errores para que tengamos que elegir una opcion que este en el menu 
	 */
	public Integer opcMenu6() {
		boolean valid= false;
		Integer opcion=-1;
		do {
			valid = false;
			opcion=leeEntero("Introduzca una opcion");
			if(opcion<1 || opcion>6) {
			System.out.println("Debe insertar un valor valido");
			valid=true;
			}
		}while(valid);
		return opcion;
	}

	/**
	 * Metodo para elegir la opcion del menu para elegir en donde queremos entrar
	 * Controla los errores para que tengamos que elegir una opcion que este en el menu
	 */
	public Integer opcMenu5() {
		boolean valid= false;
		Integer opcion=-1;
		do {
			valid = false;
			opcion=leeEntero("Introduzca una opcion");
			if(opcion<1 || opcion>5) {
			System.out.println("Debe insertar un valor valido");
			valid=true;
			}
		}while(valid);
		return opcion;
	}

	/**
	 * Metodo para elegir la opcion del menu para elegir en donde queremos entrar
	 * Controla los errores para que tengamos que elegir una opcion que este en el menu 
	 */
	public Integer opcMenu4() {
		boolean valid= false;
		Integer opcion=-1;
		do {
			valid = false;
			opcion=leeEntero("Introduzca una opcion");
			if(opcion<1 || opcion>4) {
			System.out.println("Debe insertar un valor valido");
			valid=true;
			}
		}while(valid);
		return opcion;
	}
	
	/**
	 *  Metodo para elegir la opcion del menu para elegir en donde queremos entrar
	 *  Controla los errores para que tengamos que elegir una opcion que este en el menu
	 */
	public Integer opcMenu7() {
		boolean valid= false;
		Integer opcion=-1;
		do {
			valid = false;
			opcion=leeEntero("Introduzca una opcion");
			if(opcion<1 || opcion>7) {
			System.out.println("Debe insertar un valor valido");
			valid=true;
			}
		}while(valid);
		return opcion;
	}
	
	/**
	 * Metodo que imprime un objeto por pantalla, ya sea reserva, cliente o producto
	 */
	public void showClient(Object o) {
		System.out.println(o);
	}

	/**
	 * Muestra la lista de productos que se encuentra en el hashmap
	 */
	public void showProductList(HashMap<Integer, Product> p) {
		for (Integer key : p.keySet()) {
			System.out.println(p.get(key));
		}
		
	}

	/**
	 * Metodo para mostrar las reservas que se encuentran en el hashmap
	 */
	public void showReservationList(HashMap<Integer, Reservation> reserva) {
		for (Integer key : reserva.keySet()) {
			System.out.println(reserva.get(key));
		}
	}

	/**
	 * Metodo para elegir una categoria del producto a la hora de crear o modificar el producto
	 */
	public Category leeCategory(String s) {
		this.print(s);
		showCategoryMenu();
		int opc=opcMenu3();
		switch(opc) {
		case 1:
			return Category.PELICULAS;
		case 2:
			return Category.JUEGOS;
		case 3:
			return Category.SERIES;
		default:
			return Category.PELICULAS;
		}
	}
	
	/**
	 * Metodo para leer el status de la reserva a la hora de modificar la reserva
	 */
	public Status leeStatus(String s) {
		this.print(s);
		showStatusMenu();
		int opc=opcMenu3();
		switch(opc) {
		case 1:
			return Status.ENTREGADO;
		case 2:
			return Status.RESERVADO;
		case 3:
			return Status.EXPIRADO;
		default:
			return Status.RESERVADO;
		}
	}
	
	/**
	 * Metodo para mostrar los status la reserva y poder elegirlos a la hora de modificar la reserva
	 */
	public void showStatusMenu() {
		System.out.println("1. Entregado");
		System.out.println("2. Reservado");
		System.out.println("3. Expirado");
	}

	
}
