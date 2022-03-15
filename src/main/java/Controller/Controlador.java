package Controller;

import Interfaces.IClient;
import Interfaces.IController;
import Interfaces.IProduct;
import Interfaces.IRepoProduct;
import Interfaces.IReposClient;
import Interfaces.IReservation;
import Interfaces.IRespoReservation;
import Interfaces.IVista;

public class Controlador implements IController{
	IVista vista;
	IReposClient RepoClient;
	IClient client;
	IProduct product;
	IRepoProduct RepoProduct;
	IReservation reserva;
	IRespoReservation RepoReserva;
	
	
	public void run() {		
	}
	
	
}
