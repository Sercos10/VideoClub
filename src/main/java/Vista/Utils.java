package Vista;

import Modelo.Client;
import Modelo.Product;
import Modelo.Copia;

public class Utils {
	Copia c;
	
	
	public Product readProduct(Vista v) {
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
	public Client readClient(Vista v) {
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
	public Copia copyGenerator(Product p){
		int cont=0;
		do {
			Integer idcopy=c.idGenerator();
			Copia c = new Copia(p.getName(),p.getPrice(),p.getDescription(),p.getID(),p.getNum_cop(),p.getCategory(),idcopy);
			rc.addCopy(c,p);
			cont++;
		}while(cont<p.getNum_cop());
		return c;
	}
}
