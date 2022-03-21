package Modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import Enums.Category;
import Interfaces.IProduct;

@XmlRootElement(name = "Producto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements IProduct, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String Name;
	private Float price;
	private String description;
	@XmlAttribute(name = "identificador")
	private Integer id;
	private Category category;
	private Integer num_cop;
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Float getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public Integer getID() {
		return id;
	}
	
	public Integer getNum_cop() {
		return num_cop;
	}
	
	public void setNum_cop(Integer num_cop) {
		this.num_cop = num_cop;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setID(Integer id) {
		this.id = id;
	}
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	public Product(String name, Float price, String description, Integer id,Integer nCopias, Category category) {
		Name = name;
		this.price = price;
		this.description = description;
		this.id = id;
		this.category = category;
		num_cop = nCopias;
	}

	/**
	 * Metodo para generar el toString de producto
	 * @return
	 */
	public String toString() {
		return " Nombre Del Producto=" + Name + ", Precio= " + price + ", Description= " + description + ", ID= " + id + ", Categoria= " + category + ", Nº Copias= " + num_cop+"\n"
	            + "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
	}

	public Product() {
	}

	/**
	 * Metodo para comprobar si un producto es igual a otro
	 * @param obj  Objeto recibido
	 * @return Si es igual
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
