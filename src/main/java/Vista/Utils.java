package Vista;

import java.time.LocalDateTime;
import java.util.Random;

import Enums.Category;
import Enums.Status;
import Interfaces.IRepoCopia;
import Interfaces.IRepoProduct;
import Interfaces.IRespoReservation;
import Modelo.Client;
import Modelo.Copia;
import Modelo.Product;
import Modelo.RepoClient;
import Modelo.RepoCopia;
import Modelo.RepoProduct;
import Modelo.RepoReservation;
import Modelo.Reservation;

public class Utils {
	Vista v = Vista.getInstance();
	Copia c = new Copia();
	IRepoCopia rCopy = RepoCopia.getInstance();
	IRepoProduct rProduct = RepoProduct.getInstance();
	RepoClient  rClient= RepoClient.getInstance();
	IRespoReservation Rr = RepoReservation.getInstance();
	private Utils() {
	}
	private static Utils u;
	public static Utils getInstance() {
		if(u==null) {
			u = new Utils();
		}
		return u;
	}
	
	/**
	 * Metodo para leer un producto donde se crea con todos sus atributos y se genera las copias que queramos
	 * @return el producto creado
	 */
	public Product readProduct() {
		String name,desc;
		Integer id,numcop;
		Float price;
		Category cat;
		name=v.leeString("Introduce el nombre del producto");
		desc=v.leeString("Introduce la descripcion del producto");
		id=v.leeEntero("Introduce la id del Producto");
		id=searchKeyProduct(id);
		price=v.leeFloat("Introduce el precio del producto");
		numcop=v.leeEntero("Introduce el numero de copias");
		cat=v.leeCategory("Introduce la Categoria");
		Product p= new Product(name,price,desc,id,numcop,cat);
		copyGenerator(p);
		return p;
	}
	
	/**
	 * Metodo que lee un cliente y lo crea con todos sus atributos
	 * @return el cliente creado
	 */
	public Client readClient() {
		String name,phone,address;
		Integer id,age;
		name=v.leeString("Introduce el nombre del Cliente");
		id=v.leeEntero("Introduce la id del Cliente");
		id=searchKeyClient(id);
		phone=v.leeString("Introduce el numero de telefono del Cliente");
		LocalDateTime time=LocalDateTime.now();
		address=v.leeString("Introduce la direccion del cliente");
		age=v.leeEntero("Introduce la edad del Cliente");
		
		Client c = new Client(id,name,phone,time,address,age);
		return c;
	}
	
	/**
	 * Metodo que le pasamos un cliente y una copia y crea la reserva
	 * @param c cliente que mostramos y elegimos por teclado
	 * @param copia que mostramos y elegimos por teclado
	 */
	public void readReservation(Client c,Copia copia) {
		LocalDateTime Hora =LocalDateTime.now();
		String endr = v.leeString("Introduce la fecha final de la reserva");
		Integer id = v.leeEntero("Introduzca ID de la reserva");
		Reservation Reserva = new Reservation(id,Hora,endr,Status.RESERVADO,c,copia);
		Rr.addReservation(Reserva);
		rCopy.removeCopy(copia);
	}
	
	/**
	 * metodo para generar copias segun el numero de copias que le escribamos por teclado
	 * llama a idgenerator que le asigna una id aleatoria
	 * @param p producto del que queremos producir las copias
	 * @return devuelve todas las copias creadas
	 */
	public Copia copyGenerator(Product p){
		int cont=0;
	while(cont<p.getNum_cop()) {
			Integer idcopy=idGenerator();
			Copia c = new Copia(p.getName(),p.getPrice(),p.getDescription(),p.getID(),p.getNum_cop(),p.getCategory(),idcopy);
			rCopy.addCopy(c);
			cont++;
	}
		return c;
	}
	
	/**
	 * metodo para introducir la id de um producto y que no este asociada a otro producto
	 * @param id del producto
	 * @return devuelve el numero entero de la id que queremos introducir
	 */
	public Integer searchKeyProduct(Integer id) {
		Integer newid;
		if (!rClient.Contains(id)) {
			v.print("La id esta disponible y se le ha asociado correctamente");
		} else {
			while (rProduct.Contains(id)) {
				v.print("Esta id ya esta asociada a otro producto");
				newid = v.leeEntero("Introduzca la id");
				id = newid;
			}
		}
		return id;
	}

	/**
	 * metodo para introducir una id de un cliente y que no este asignada a otro cliente
	 * @param id del cliente
	 * @return devuelve el numero entero de la id que queremos introducir
	 */
	public Integer searchKeyClient(Integer id) {
		Integer newid;
		if (!rClient.Contains(id)) {
			v.print("La id esta disponible y se le ha asociado correctamente");
		} else {
			while (rClient.Contains(id)) {
				v.print("Esta id ya esta asociada a otro cliente\n");
				newid = v.leeEntero("Introduzca otra id");
				id = newid;
		while (rClient.Contains(id)) {
			if (!rClient.Contains(id)) {
				v.print("La id esta disponible y se le ha asociado correctamente");
			}
		}
		
	}
		}
		return id;
	}
	
	/**
	 * metodo para borrar una reserva
	 */
	public void removeReserva() {
		Integer id = v.leeEntero("Introduzla el id de la reserva que quiera borrar");
		Rr.delReservation(id);			
	}
	/**
	 * Metodo para generar un id aleatorio entre 1 y 200.
	 * @return devolvemos el numero generado.
	 */
	public Integer idGenerator(){
		int max = 200;
		int min= 1;
		Integer n=0;
		Random random = new Random();
		n=random.nextInt(max + min) + min;
		return n;
	}
	
	
	
	
	
	
	
	
	
	
	
}
