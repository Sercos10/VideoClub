package Vista;

import java.time.LocalDateTime;

import Enums.Category;
import Enums.Status;
import Interfaces.IRespoReservation;
import Interfaces.IVista;
import Modelo.Client;
import Modelo.Product;
import Modelo.RepoCopia;
import Modelo.RepoReservation;
import Modelo.Reservation;
import Modelo.Copia;

public class Utils {
	Copia c;
	RepoCopia rc;
	RepoReservation Rr= RepoReservation.getInstance();
	
	
	public Product readProduct(IVista v) {
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
	public Client readClient(IVista v) {
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
	public Reservation readReservation(IVista v,Client c,Copia copia) {
		LocalDateTime Hora =LocalDateTime.now();
		LocalDateTime endr = Hora.plusWeeks(6);
		Integer id = v.leeEntero("Introduzca ID de la reserva");
		Status estado = v.leeStatus("Introzca el estado de la reserva");
		Reservation Reserva = new Reservation(id,Hora,endr,estado,c,copia);
		Rr.addReservation(Reserva);
		return Reserva;
	}
	public Copia copyGenerator(Product p){
		int cont=0;
		do {
			Integer idcopy=c.idGenerator();
			Copia c = new Copia(p.getName(),p.getPrice(),p.getDescription(),p.getID(),p.getNCopias(),p.getCategory(),idcopy);
			rc.addCopy(c,p);
			cont++;
		}while(cont<p.getNCopias());
		return c;
	}
}
