package Controller;

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
import Modelo.RepoClient;
import Modelo.RepoProduct;
import Modelo.RepoReservation;

public class Controlador implements IController{
	ICopia copia;
	IRepoCopia RepoCopia;
	IVista vista = new Vista();
	Utils u = new Utils();
	IReposClient RepoCliente = RepoClient.getInstance();
	IClient client;
	IProduct product;
	IRepoProduct RepoProducto = RepoProduct.getInstance();
	IReservation reserva;
	IRespoReservation RepoReserva = RepoReservation.getInstance();
	
	
	public void switchMain(int op) {
		RepoCliente.loadFile(null);
		RepoProducto.loadFile(null);
		RepoReserva.loadFile(null);
		switch (op) {
		case 1: vista.showMenuClient();
				break;
		case 2: vista.showMenuProduct();
				break;
		case 3: vista.print("Gracias por utilizar nuestro software");
				break;
		}
	}
	
	public void switchMenuCliente(int op) {
		switch (op) {
		case 1: RepoCliente.addClient(u.readClient());
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu6());
				break;
		case 2: 
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu6());
				break;
		case 3: vista.showMenuModifyClient();
				break;
		case 4: RepoCliente.showClientList();
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu6());
				break;
		case 5: vista.showMenuReservation();
				break;
		case 6: vista.showMainMenu();
				switchMain(vista.opcMenu3());
				break;
		}
	}
	
	public void switchMenuProduct(int op) {
		switch (op) {
		case 1: RepoProducto.addProduct(u.readProduct());
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu5());
				break;
		case 2: 
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu5());
				break;
		case 3: vista.showMenuModifyProduct();
				break;
		case 4: RepoProducto.showProductList();
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu5());
				break;
		case 5: vista.showMainMenu();
				switchMain(vista.opcMenu3());
				break;
		}
	}
	
	public void switchMenuModifyClient(int op) {
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
	
	public void switchModifyProduct(int op) {
		switch (op) {
		case 1:
				break;
		case 2:
				break;
		case 3:
				break;
		case 4:
				break;
		case 5: vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu5());
				break;
		}
	}
	
	
	
	public void run() {
		vista.showMainMenu();
		
	}
	
	
}
