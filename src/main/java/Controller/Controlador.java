package Controller;


import Enums.Category;
import Interfaces.IClient;
import Interfaces.IController;
import Interfaces.IProduct;
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
import Modelo.RepoProduct;
import Modelo.RepoReservation;
import Modelo.Reservation;

public class Controlador implements IController {
	IVista vista = Vista.getInstance();
	Utils u = Utils.getInstance();
	IReposClient RepoCliente = RepoClient.getInstance();
	IClient client = new Client();
	IProduct product = new Product();
	IRepoProduct RepoProducto = RepoProduct.getInstance();
	IReservation reserva = new Reservation();
	IRespoReservation RepoReserva = RepoReservation.getInstance();

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

	private void switchMenuCliente(int op) {
		switch (op) {
		case 1:
			RepoCliente.addClient(u.readClient());
			RepoCliente.saveFile("cliente.xml");
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		case 2:
			Integer id6 = vista.leeEntero("Introduce el ID del cliente");
			RepoCliente.removeClient(id6);
			RepoCliente.saveFile("cliente.xml");
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		case 3:
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 4:
			vista.showClientList(RepoCliente.getClientList());
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		case 5:
			Integer id = vista.leeEntero("Introduce el ID del cliente");
			vista.showClient(RepoCliente.searchClient(id));
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

	private void switchMenuProduct(int op) {
		switch (op) {
		case 1:
			RepoProducto.addProduct(u.readProduct());
			RepoProducto.saveFile("producto.xml");
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 2:
			Integer id7 = vista.leeEntero("Introduce el ID del cliente");
			RepoProducto.removeProduct(id7);
			RepoProducto.saveFile("producto.xml");
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 3:
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 4:
			vista.showProductList(RepoProducto.getProductList());
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 5:
			Integer id2 = vista.leeEntero("Introduce el ID del producto");
			vista.showClient(RepoProducto.searchProduct(id2));
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu6());
			break;
		case 6:
			vista.showMainMenu();
			switchMain(vista.opcMenu3());
			break;
		}
	}

	private void switchMenuModifyClient(int op) {
		switch (op) {
		case 1:
			Integer id = vista.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id);
			String name = vista.leeString("Introduzca el nuevo nombre");
			RepoCliente.modifyName(id, name);
			RepoCliente.saveFile("cliente.xml");
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 2:
			Integer id2 = vista.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id2);
			String telef = vista.leeString("Introduzca el nuevo telefono");
			RepoCliente.modifyPhone(id2, telef);
			RepoCliente.saveFile("cliente.xml");
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 3:
			Integer id4 = vista.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id4);
			String dir = vista.leeString("Introduzca la nueva direccion");
			RepoCliente.modifyAddress(id4, dir);
			RepoCliente.saveFile("cliente.xml");
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 4:
			Integer id5 = vista.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id5);
			Integer edad = vista.leeEntero("Introduzca la edad");
			RepoCliente.modifyAge(id5, edad);
			RepoCliente.saveFile("cliente.xml");
			vista.showMenuModifyClient();
			switchMenuModifyClient(vista.opcMenu5());
			break;
		case 5:
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		}
	}

	private void switchModifyProduct(int op) {
		switch (op) {
		case 1:
			Integer id6 = vista.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id6);
			String name2 = vista.leeString("Introduzca el nombre del producto");
			RepoProducto.modifyName(id6, name2);
			RepoProducto.saveFile("producto.xml");
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 2:
			Integer id7 = vista.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id7);
			String desc2 = vista.leeString("Introduzca la descripcion del producto");
			RepoProducto.modifyDesc(id7, desc2);
			RepoProducto.saveFile("producto.xml");
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 3:
			Integer id8 = vista.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id8);
			Integer precio2 = vista.leeEntero("Introduzca el precio del producto");
			RepoProducto.modifyPrize(id8, precio2);
			RepoProducto.saveFile("producto.xml");
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 4:
			Integer id9 = vista.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id9);
			Category cate2 = vista.leeCategory("Introduzca la nueva categoria");
			RepoProducto.modifyCategory(id9, cate2);
			RepoProducto.saveFile("producto.xml");
			vista.showMenuModifyProduct();
			switchModifyProduct(vista.opcMenu5());
			break;
		case 5:
			vista.showMenuProduct();
			switchMenuProduct(vista.opcMenu5());
			break;
		}
	}

	private void switchMenuReservation(int op) {
		switch (op) {
		case 1:
			RepoReserva.saveFile("reserva.xml");
			vista.showMenuReservation();
			switchMenuReservation(vista.opcMenu6());
			break;
		case 2:
			RepoReserva.saveFile("reserva.xml");
			break;
		case 3:
			vista.showMenuModifyReservation();
			switchMenuModifyReservation(vista.opcMenu3());
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			vista.showMenuClient();
			switchMenuCliente(vista.opcMenu7());
			break;
		}
	}

	private void switchMenuModifyReservation(int op) {
		switch (op) {
		case 1:
			RepoReserva.saveFile("reserva.xml");
			vista.showMenuModifyReservation();
			switchMenuModifyReservation(vista.opcMenu3());
			break;
		case 2:
			RepoReserva.saveFile("reserva.xml");
			vista.showMenuModifyReservation();
			switchMenuModifyReservation(vista.opcMenu3());
			break;
		case 3:
			vista.showMenuReservation();
			switchMenuReservation(vista.opcMenu6());
			break;
		}
	}

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
				u.esperar(3);
				vista.showMainMenu();
				switchMain(vista.opcMenu3());
			}
		}
		return id;
	}

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
				u.esperar(3);
				vista.showMainMenu();
				switchMain(vista.opcMenu3());
			}
		}
		return id;
	}

	public void run() {
		vista.showMainMenu();
		switchMain(vista.opcMenu3());
	}

}
