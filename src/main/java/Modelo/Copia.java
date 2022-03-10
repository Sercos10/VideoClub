package Modelo;

import Interfaces.ICopia;

public class Copia extends Product implements ICopia{
	
	private static final long serialVersionUID = 1L;
	private Integer id_copia;

	public Integer getID() {
		return id_copia;
	}
	

}
