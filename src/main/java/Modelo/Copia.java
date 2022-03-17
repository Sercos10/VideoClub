package Modelo;


import Interfaces.ICopia;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

import Enums.Category;

public class Copia extends Product implements Serializable, ICopia{
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "ID")
	private Integer id_copia;
	
	public Copia(String name, Float price, String description, Integer id, Integer num_cop, Category category,
			Integer id_copia) {
		super(name, price, description, id, num_cop, category);
		this.id_copia = id_copia;
	}
	
	public Copia() {
	}
	
	public Integer getID_copia() {
		return id_copia;
	}

	public void setId_copia(Integer id_copia) {
		this.id_copia = id_copia;
	}

}
