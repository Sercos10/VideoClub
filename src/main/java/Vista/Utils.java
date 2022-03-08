package Vista;

import Modelo.Client;
import Modelo.Product;

public class Utils {
	Vista v= new Vista();
	
	
	public Product readProduct() {
		String name,desc;
		Integer id;
		Float price;
		name=v.leeString("Introduce el nombre del producto");
		desc=v.leeString("Introduce la descripcion del producto");
		id=v.leeEntero("Introduce la id del Producto");
		price=v.leeFloat("Introduce el precio del producto");
		Product p= new Product(name,price,desc,id);
		return p;
	}
	public Client readClient() {
		String name,phone,time,address;
		Integer id,age;
		name=v.leeString("Introduce el nombre del Cliente");
		id=v.leeEntero("Introduce la id del Cliente");
		phone=v.leeString("Introduce el numero de telefono del Cliente");
		time=v.leeString("Introduce la hora");
		address=v.leeString("Introduce la direccion del cliente");
		age=v.leeEntero("Introduce la edad del Cliente");
		
		Client c = new Client(id,name,phone,time,address,age);
		return c;
	}
}
