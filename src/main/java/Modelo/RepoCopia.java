package Modelo;

import java.util.HashMap;

import Interfaces.ICopia;
import Interfaces.IProduct;
import Interfaces.IRepoCopia;

public class RepoCopia implements IRepoCopia{
	private RepoCopia() {
		ListaCopias = new HashMap<Integer,Copia>();
	}
	private static RepoCopia Rc;
	public static RepoCopia getInstance() {
		if(Rc==null) {
			Rc = new RepoCopia();
		}
		return Rc;
	}
	
	private HashMap<Integer,Copia> ListaCopias;
	
	
	public void addCopy(ICopia c,IProduct p) {
		ListaCopias.put(c.getID(),(Copia)c);
	}
	public boolean Contains(Integer a) {
		return ListaCopias.containsKey(a);	
	}
}
