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
	private Integer NCopias;
	

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
		NCopias = nCopias;
	}

	public String toString() {
		return "Product Name=" + Name + "Price=" + price + "\n description=" + description + "\n id=" + id
				+ "\n category=" + category + "\n num_cop=" + NCopias;
	}

	public Product() {
	}

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

	public Integer getNCopias() {
		return NCopias;
	}

	public void setNCopias(Integer ncopias) {
		this.NCopias=ncopias;
	}
}
