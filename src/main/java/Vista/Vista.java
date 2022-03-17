package Vista;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import Enums.Category;
import Enums.Status;
import Interfaces.IVista;
import Modelo.Client;
import Modelo.Product;
import Modelo.Reservation;

public class Vista implements IVista{
	private Vista() {
	}
	private static Vista mivista;
	public static Vista getInstance() {
		if(mivista==null) {
			mivista=new Vista();
		}
		return mivista;
	}

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

	public void showMenuClient() {
		System.out.println("1. Anadir cliente");
		System.out.println("2. Eliminar cliente");
		System.out.println("3. Modificar cliente");
		System.out.println("4. Mostrar clientes");
		System.out.println("5. Buscar cliente");
		System.out.println("6. Reservas");
		System.out.println("7. Volver");
	}

	public void showMenuProduct() {
		System.out.println("1. Anadir producto");
		System.out.println("2. Eliminar producto");
		System.out.println("3. Modificar producto");
		System.out.println("4. Mostrar producto");
		System.out.println("5. Buscar producto");
		System.out.println("6. Volver");
	}

	public void showMenuReservation() {
		System.out.println("1. Crear reserva");
		System.out.println("2. Eliminar reserva");
		System.out.println("3. Modificar reserva");
		System.out.println("4. Mostrar reservas");
		System.out.println("5. Buscar reserva");
		System.out.println("6. Volver");
	}

	public void showMenuModifyClient() {
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar telefono");
		System.out.println("3. Modificar direccion");
		System.out.println("4. Modificar edad");
		System.out.println("5. Volver");
	}

	public void showMenuModifyProduct() {
		System.out.println("1. Modificar nombre");
		System.out.println("2. Modificar descripcion");
		System.out.println("3. Modificar precio");
		System.out.println("4. Modificar categoria");
		System.out.println("5. Volver");
	}

	public void showMenuModifyReservation() {
		System.out.println("1. Modificar fecha final");
		System.out.println("2. Modificar estado de la reserva");
		System.out.println("3. Volver");
	}
	
	public void showCategoryMenu() {
		System.out.println("1. Peliculas");
		System.out.println("2. Juegos");
		System.out.println("3. Series");

	}
	
	public void showClientList(HashMap <Integer, Client> c){
		for(Integer key:c.keySet()) {
			System.out.println("ID: " +key+ "Value: " +c.get(key));
		}
	}
	
	public void showReservations(HashMap <Integer, Reservation> c){
		for(Integer key:c.keySet()) {
			System.out.println("ID: " +key+ "Value: " +c.get(key));
		}
	}

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

	public String leeString(String frase) {
		Scanner teclado= new Scanner (System.in);
		String f="";
		System.out.println(frase);
		f=teclado.nextLine();
		return f;
	}

	public void print(String s) {
		System.out.println(s);
	}

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
	
	public void showClient(Object o) {
		System.out.println(o);
	}

	public void showProductList(HashMap<Integer, Product> p) {
		for (Integer key : p.keySet()) {
			System.out.println(p.get(key));
		}
		
	}

	public void showReservationList(HashMap<Integer, Reservation> reserva) {
		for (Integer key : reserva.keySet()) {
			System.out.println(reserva.get(key));
		}
	}

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
	
	public void showStatusMenu() {
		System.out.println("1. Entregado");
		System.out.println("2. Reservado");
		System.out.println("3. Expirado");
	}

	
}
