package Vista;

import Modelo.Product;
import Modelo.RepoProduct;

public class Prueba {

	public static void main(String[] args) {
		RepoProduct RepoProducto = RepoProduct.getInstance();
		Product p=new Product("Nintendo",34f,"Feo",4);
		Product t=new Product("PLay",56f,"Guapo",8);
		
		
		RepoProducto.addProduct(p);
		RepoProducto.addProduct(t);
		RepoProducto.loadFile("Producto.xml");
		RepoProducto.showProductList();
	}

}
