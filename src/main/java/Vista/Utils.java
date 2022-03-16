package Vista;

import java.time.LocalDateTime;
import java.util.Random;

import Enums.Category;
import Enums.Status;
import Interfaces.ICopia;
import Interfaces.IProduct;
import Interfaces.IRepoCopia;
import Interfaces.IRespoReservation;
import Interfaces.IVista;
import Modelo.Client;
import Modelo.Product;
import Modelo.RepoCopia;
import Modelo.RepoReservation;
import Modelo.Reservation;
import Modelo.Copia;

public class Utils {
	private Utils() {
	}
	private static Utils myutils;
	public static Utils getInstance() {
		if(myutils==null) {
			myutils=new Utils();
		}
		return myutils;
	}
	ICopia c = new Copia();
	IRespoReservation Rr= RepoReservation.getInstance();
	IVista v = Vista.getInstance();
	IRepoCopia rc = RepoCopia.getInstance();
	
	public Product readProduct() {
		String name,desc;
		Integer id,ncopias;
		Float price;
		Category categoria;
		name=v.leeString("Introduce el nombre del producto");
		desc=v.leeString("Introduce la descripcion del producto");
		id=v.leeEntero("Introduce la id del Producto");
		price=v.leeFloat("Introduce el precio del producto");
		ncopias=v.leeEntero("Introduzca el numero de copias");
		categoria=v.leeCategory("Seleccione que categoria");
		Product p= new Product(name,price,desc,id,ncopias,categoria);
		copyGenerator(p);
		return p;
	}
	public Client readClient() {
		String name,phone,address;
		Integer id,age;
		name=v.leeString("Introduce el nombre del Cliente");
		id=v.leeEntero("Introduce la id del Cliente");
		phone=v.leeString("Introduce el numero de telefono del Cliente");
		LocalDateTime time=LocalDateTime.now();
		address=v.leeString("Introduce la direccion del cliente");
		age=v.leeEntero("Introduce la edad del Cliente");
		
		Client c = new Client(id,name,phone,time,address,age);
		return c;
	}
	public Reservation readReservation(Client c,Copia copia) {
		LocalDateTime Hora =LocalDateTime.now();
		LocalDateTime endr = Hora.plusWeeks(6);
		Integer id = v.leeEntero("Introduzca ID de la reserva");
		Status estado = v.leeStatus("Introzca el estado de la reserva");
		Reservation Reserva = new Reservation(id,Hora,endr,estado,c,copia);
		Rr.addReservation(Reserva);
		return Reserva;
	}
	public Copia copyGenerator(IProduct p){
		int cont=0;
		while(cont<p.getNCopias()) {
			Integer idcopy=this.idGenerator();
			ICopia c = new Copia(p.getName(),p.getPrice(),p.getDescription(),p.getID(),p.getNCopias(),p.getCategory(),idcopy);
			rc.addCopy(c,p);
			cont++;
		}
		return (Copia)c;
	}
	public Integer idGenerator(){
		int max = 200;
		int min= 1;
		Integer n=0;
		Random random = new Random();
		n=random.nextInt(max + min) + min;
		return n;
	}
}
