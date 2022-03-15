package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

import Interfaces.IRepoCopia;
import Vista.Utils;

public class RepoCopia implements IRepoCopia{
	private HashMap<Integer,Copia> ListaCopias;
	public RepoCopia() {
		ListaCopias = new HashMap<Integer,Copia>();
	}
	public void addCopy(Copia c,Product p) {
		if(ListaCopias.containsKey(c.getId_copia())) {
			u.copyGenerator(p);
		}
		ListaCopias.put(c.getID(),c);
	}
}
