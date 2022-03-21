package Controller;


import Enums.Category;
import Enums.Status;
import Interfaces.IClient;
import Interfaces.IController;
import Interfaces.IProduct;
import Interfaces.IRepoCopia;
import Interfaces.IRepoProduct;
import Interfaces.IReposClient;
import Interfaces.IReservation;
import Interfaces.IRespoReservation;
import Interfaces.IVista;
import Vista.Utils;
import Vista.Vista;
import Modelo.Client;
import Modelo.Product;
import Modelo.RepoClient;
import Modelo.RepoCopia;
import Modelo.RepoProduct;
import Modelo.RepoReservation;
import Modelo.Reservation;

public class Controlador implements IController {
	IVista vista = Vista.getInstance();
	IRepoCopia rCopy = RepoCopia.getInstance();
	Utils u = Utils.getInstance();
	IReposClient RepoCliente = RepoClient.getInstance();
	IClient client = new Client();
	IProduct product = new Product();
	IRepoProduct RepoProducto = RepoProduct.getInstance();
	IReservation reserva = new Reservation();
	IRespoReservation RepoReserva = RepoReservation.getInstance();

	/**
	 * Menu Principal que se encarga de llamar a todos los submenus
	 * @param op opcion que le pasamos al programa para elegir donde queremos ir
	 */
	private void switchMain(int op) {

		switch (op) {
		case 1:
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		case 2:
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 3:
			vista.print("Gracias por utilizar nuestro software");
			break;
		}
	}

	/**
	 * Menu de clientes donde manejamos varias opciones ademas de tener submenus. 
	 * @param op opciones que le pasamos para elegir donde ir
	 */
	private void switchMenuCliente(int op) {
		switch (op) {
		case 1:
			RepoCliente.addClient(u.readClient());
			RepoCliente.saveFile("cliente.xml");
			vista.separar();
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		case 2:
			Integer id6 = vista.leeEntero("Introduce el ID del cliente");
			RepoCliente.removeClient(id6);
			RepoCliente.saveFile("cliente.xml");
			vista.separar();
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		case 3:
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 4:
			vista.showClientList(RepoCliente.getClientList());
			vista.separar();
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		case 5:
			Integer id = vista.leeEntero("Introduce el ID del cliente");
			vista.showClient(RepoCliente.searchClient(id));
			vista.separar();
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		case 6:
			vista.showMenuReservation();
			switchMenuReservation(vista.opcMenu6());
			break;
		case 7:
			vista.showMainMenu();
			switchMain(vista.opcMenu3());
			break;
		}
	}

	/**
	 * Menu de producto donde controlamos todas las opciones de producto y tiene varios submenus 
	 * para modificar el producto
	 * @param op opcion que le pasamos al programa para elegir a donde ir
	 */
	private void switchMenuProduct(int op) {
		switch (op) {
		case 1:
			RepoProducto.addProduct(u.readProduct());
			RepoProducto.saveFile("producto.xml");
			vista.separar();
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 2:
			Integer id7 = vista.leeEntero("Introduce el ID del cliente");
			RepoProducto.removeProduct(id7);
			RepoProducto.saveFile("producto.xml");
			vista.separar();
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 3:
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 4:
			vista.showProductList(RepoProducto.getProductList());
			vista.separar();
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 5:
			Integer id2 = vista.leeEntero("Introduce el ID del producto");
			vista.showClient(RepoProducto.searchProduct(id2));
			vista.separar();
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 6:
			vista.showMainMenu();
			switchMain(vista.opcMenu3());
			break;
		}
	}

	/**
	 * Menu para modificar el cliente, donde controlamos todas las opciones para poder
	 * modificarlo
	 * @param op opcion que le pasamos al programa para poder elegir que queremos modificar
	 */
	private void switchMenuModifyClient(int op) {
		switch (op) {
		case 1:
			Integer id = vista.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id);
			String name = vista.leeString("Introduzca el nuevo nombre");
			RepoCliente.modifyName(id, name);
			RepoCliente.saveFile("cliente.xml");
			vista.separar();
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 2:
			Integer id2 = vista.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id2);
			String telef = vista.leeString("Introduzca el nuevo telefono");
			RepoCliente.modifyPhone(id2, telef);
			RepoCliente.saveFile("cliente.xml");
			vista.separar();
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 3:
			Integer id4 = vista.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id4);
			String dir = vista.leeString("Introduzca la nueva direccion");
			RepoCliente.modifyAddress(id4, dir);
			RepoCliente.saveFile("cliente.xml");
			vista.separar();
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 4:
			Integer id5 = vista.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id5);
			Integer edad = vista.leeEntero("Introduzca la edad");
			RepoCliente.modifyAge(id5, edad);
			RepoCliente.saveFile("cliente.xml");
			vista.separar();
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 5:
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		}
	}

	/**
	 * Menu donde elegimos que queremos modificar del producto
	 * @param op opcion que elegimos para poder modificar el producto
	 */
	private void switchModifyProduct(int op) {
		switch (op) {
		case 1:
			Integer id6 = vista.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id6);
			String name2 = vista.leeString("Introduzca el nombre del producto");
			RepoProducto.modifyName(id6, name2);
			RepoProducto.saveFile("producto.xml");
			vista.separar();
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 2:
			Integer id7 = vista.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id7);
			String desc2 = vista.leeString("Introduzca la descripcion del producto");
			RepoProducto.modifyDesc(id7, desc2);
			RepoProducto.saveFile("producto.xml");
			vista.separar();
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 3:
			Integer id8 = vista.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id8);
			Integer precio2 = vista.leeEntero("Introduzca el precio del producto");
			RepoProducto.modifyPrize(id8, precio2);
			RepoProducto.saveFile("producto.xml");
			vista.separar();
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 4:
			Integer id9 = vista.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id9);
			Category cate2 = vista.leeCategory("Introduzca la nueva categoria");
			RepoProducto.modifyCategory(id9, cate2);
			RepoProducto.saveFile("producto.xml");
			vista.separar();
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 5:
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu5());
			break;
		}
	}

	/**
	 * Menu de reservas donde podremos elegir el cliente y el producto para hacer una reserva
	 * @param op opcion que le pasamos al menu para poder elegir entre las opciones
	 */
	private void switchMenuReservation(int op) {
		switch (op) {
		case 1:
			this.newReserva();
			RepoReserva.saveFile("reserva.xml");
			vista.separar();
			vista.showMenuReservation();
			switchMenuReservation(vista.opcMenu6());
			break;
		case 2:
			Integer id9 = vista.leeEntero("Introduce la ID de la reserva");
			RepoReserva.delReservation(id9);
			RepoReserva.saveFile("reserva.xml");
			vista.separar();
			vista.showMenuReservation();
			switchMenuReservation(vista.opcMenu6());
			break;
		case 3:
			vista.showMenuModifyReservation();
			switchMenuModifyReservation(vista.opcMenu3());
			break;
		case 4:
			if (RepoReserva.isEmpty()) {
				vista.print("No hay Reservas para mostrar");
			}
			vista.showReservationList(RepoReserva.getReservations());
			vista.separar();
			vista.showMenuReservation();
			switchMenuReservation(vista.opcMenu6());
			break;
		case 5:
			Integer id10 = vista.leeEntero("Introduce la ID de la reserva");
			vista.showClient(RepoReserva.searchReservation(id10));
			vista.separar();
			vista.showMenuReservation();
			switchMenuReservation(vista.opcMenu6());
			break;
		case 6:
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		}
	}

	/**
	 * Menu para poder modificar varios aspectos de la reserva
	 * @param op opcion que le pasamos al menu para elegir que queremos modificar de la reserva
	 */
	private void switchMenuModifyReservation(int op) {
		switch (op) {
		case 1:
			Integer id11 = vista.leeEntero("Introduce la ID de la reserva");
			Status st = vista.leeStatus("Introduce el nuevo status de la reserva");
			RepoReserva.modifyStatus(id11, st);
			RepoReserva.saveFile("reserva.xml");
			vista.separar();
			vista.showMenuModifyReservation();
			switchMenuModifyReservation(vista.opcMenu3());
			break;
		case 2:
			vista.showMenuReservation();
			switchMenuReservation(vista.opcMenu6());
			break;
		}
	}

	/**
	 * Metodo que se encarga de controlar los errores al introducir una ID para modificar el cliente
	 * @param id que le pasamos al metodo para saber que cliente queremos modificar
	 * @return
	 */
	public Integer searchKeyClienttoModify(Integer id) {
		int cont = 0;
		Integer newid;

		while (!RepoCliente.Contains(id)) {
			cont++;
			vista.print("Esta id no esta asociada a ningun cliente");
			newid = vista.leeEntero("Introduzca otra id");
			id = newid;
			if (cont == 3) {
				System.out.println("Has agotado tus intentos volveras al Programa Principal en 3 segundos");
				esperar(3);
				vista.showMainMenu();
				switchMain(vista.opcMenu3());
			}
		}
		return id;
	}

	/**
	 * Metodo para controlar los errores al introducir una ID del producto que no exista
	 * @param id del producto que queremos modificar
	 * @return
	 */
	public Integer searchKeyProducttoModify(Integer id) {
		int cont = 0;
		Integer newid;

		while (!RepoProducto.Contains(id)) {
			cont++;
			vista.print("Esta id no esta asociada a ningun producto");
			newid = vista.leeEntero("Introduzca otra id");
			id = newid;
			if (cont == 3) {
				System.out.println("Has agotado tus intentos volveras al Programa Principal en 3 segundos");
				esperar(3);
				vista.showMainMenu();
				switchMain(vista.opcMenu3());
			}
		}
		return id;
	}
	
	/**
	 * metodo para controlar los errores al introducir una id cuando modificas una reserva
	 * @param id
	 * @return
	 */
	public Integer searchKeyRerservationtoModify(Integer id) {
		int cont = 0;
		Integer newid;

		while (!RepoReserva.Contains(id)) {
			cont++;
			vista.print("Esta id no esta asociada a ninguna reserva");
			newid = vista.leeEntero("Introduzca otra id");
			id = newid;
			if (cont == 3) {
				System.out.println("Has agotado tus intentos volveras al Programa Principal en 3 segundos");
				esperar(3);
				vista.showMainMenu();
				switchMain(vista.opcMenu3());
			}
		}
		return id;
	}
	
	/**
	 * metodo para hacer una reserva donde muestra los clientes y los productos, luego eliges una copia
	 * y te la asigna
	 */
	public void newReserva() {
		vista.showClientList(RepoCliente.getClientList());
		Integer id_cliente = vista.leeEntero("Introduzca la id del cliente que quiere hacer la reserva\n");
		searchKeyClienttoModify(id_cliente);
		vista.showProductList(RepoProducto.getProductList());
		Integer id_producto = vista.leeEntero("Introduzca la id del producto que quiere hacer la reserva\n");
		searchKeyProducttoModify(id_producto);
		vista.showCopyList(id_producto);
		Integer id_copia = vista.leeEntero("Introduzca la id de la copia que quiere reservar\n");
		u.readReservation(RepoCliente.getClient(id_cliente), rCopy.getCopy(id_copia));
	}
	
	/**
	 * metodo que sirve para hacer una espera en un control de errores
	 * @param segundos que queremos asignar a la espera
	 */
	public static void esperar(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Programa principal que se encarga de llamar al menu principal y el mismo se encarga de llamar 
	 * a los otros metodos para poder ejecutar el programa
	 */
	public void run() {
		vista.showMainMenu();
		switchMain(vista.opcMenu3());
	}

}
