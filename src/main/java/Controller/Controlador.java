package Controller;

import Enums.Category;
import Interfaces.IClient;
import Interfaces.IController;
import Interfaces.ICopia;
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
import Modelo.RepoProduct;
import Modelo.RepoReservation;

public class Controlador implements IController{
	ICopia copia;
	IRepoCopia RepoCopia;
	IVista vista = new Vista();
	Utils u = new Utils();
	IReposClient RepoCliente = RepoClient.getInstance();
	IClient client = new Client();
	IProduct product;
	IRepoProduct RepoProducto = RepoProduct.getInstance();
	IReservation reserva;
	IRespoReservation RepoReserva = RepoReservation.getInstance();
	
	
	private void switchMain(int op) {
		RepoCliente.loadFile(null);
		RepoProducto.loadFile(null);
		RepoReserva.loadFile(null);
		switch (op) {
		case 1: vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 2: vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu6());
				break;
		case 3: vista.print("Gracias por utilizar nuestro software");
				RepoCliente.saveFile(null);
				RepoProducto.saveFile(null);
				RepoReserva.saveFile(null);
				break;
		}
	}
	
	private void switchMenuCliente(int op) {
		switch (op) {
		case 1: RepoCliente.addClient(u.readClient());
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 2: Integer id6 = vista.leeEntero("Introduce el ID del cliente");
				RepoCliente.removeClient(id6);
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 3: vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 4: vista.showClientList(RepoCliente.getClientList());
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 5: Integer id = vista.leeEntero("Introduce el ID del cliente");
				RepoCliente.searchClient(id);
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 6: vista.showMenuReservation();
				vista.showMenuReservation();
				switchMenuReservation(vista.opcMenu6());
				break;
		case 7: vista.showMainMenu();
				switchMain(vista.opcMenu3());
				break;
		}
	}
	
	private void switchMenuProduct(int op) {
		switch (op) {
		case 1: RepoProducto.addProduct(u.readProduct());
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu6());
				break;
		case 2: 
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu6());
				break;
		case 3: vista.showMenuModifyProduct();
				switchMenuProduct(vista.opcMenu5());
				break;
		case 4: vista.showProductList(RepoProducto.getProductList());
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu6());
				break;
		case 5: Integer id2 = vista.leeEntero("Introduce el ID del producto");
				RepoProducto.searchProduct(id2);
				break;
		case 6: vista.showMainMenu();
				switchMain(vista.opcMenu3());
				break;
		}
	}
	
	private void switchMenuModifyClient(int op) {
		switch (op) {
		case 1: Integer id = vista.leeEntero("Introduzca el ID del cliente");
				String name=vista.leeString("Introduzca el nuevo nombre");
				RepoCliente.modifyName(id, name);
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 2: Integer id2 = vista.leeEntero("Introduzca el ID del cliente");
				String telef=vista.leeString("Introduzca el nuevo telefono");
				RepoCliente.modifyPhone(id2, telef);
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 3: Integer id3 = vista.leeEntero("Introduzca el ID del cliente");
				String fecha=vista.leeString("Introduzca la fecha de alta");
				RepoCliente.modifyTime(id3, fecha);
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 4: Integer id4 = vista.leeEntero("Introduzca el ID del cliente");
				String dir = vista.leeString("Introduzca la nueva direccion");
				RepoCliente.modifyAddress(id4, dir);
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 5: Integer id5 = vista.leeEntero("Introduzca el ID del cliente");
				Integer edad = vista.leeEntero("Introduzca la edad");
				RepoCliente.modifyAge(id5, edad);
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 6: vista.showMenuClient();
				switchMenuCliente(vista.opcMenu6());
				break;
		}
	}
	
	private void switchModifyProduct(int op) {
		switch (op) {
		case 1: Integer id6 = vista.leeEntero("Introduzca el ID del producto");
				String name2 = vista.leeString("Introduzca el nombre del producto");
				RepoProducto.modifyName(id6, name2);
				vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 2: Integer id7 = vista.leeEntero("Introduzca el ID del producto");
				String desc2 = vista.leeString("Introduzca la descripcion del producto");
				RepoProducto.modifyDesc(id7, desc2);
				vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 3: Integer id8 = vista.leeEntero("Introduzca el ID del producto");
				Integer precio2 = vista.leeEntero("Introduzca el precio del producto");
				RepoProducto.modifyPrize(id8, precio2);
				vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 4: Integer id9 = vista.leeEntero("Introduzca el ID del producto");
				Category cate2 = 
				RepoProducto.modifyCategory(id9, cate2);
				vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 5: vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu5());
				break;
		}
	}
	
	private void switchMenuReservation(int op) {
		switch (op) {
		case 1: 
				vista.showMenuReservation();
				switchMenuReservation(vista.opcMenu6());
				break;
		case 2:
				break;
		case 3: vista.showMenuModifyReservation();
				switchMenuModifyReservation(vista.opcMenu4());
				break;
		case 4:
				break;
		case 5:
				break;
		case 6: vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		}
	}
	
	private void switchMenuModifyReservation(int op) {
		switch (op) {
		case 1:
				vista.showMenuModifyReservation();
				switchMenuModifyReservation(vista.opcMenu4());
				break;
		case 2:
				break;
		case 3:
				break;
		case 4: vista.showMenuReservation();
				switchMenuReservation(vista.opcMenu6());
				break;
		}
	}
	
	
	
	public void run() {
		vista.showMainMenu();
		Integer opc2 = vista.leeEntero("Introduzca la opcion");
		switchMain(opc2);
		
	}
	
	
}
