package Modelo;

import java.io.Serializable;
import java.util.HashMap;

import Interfaces.ICopia;
import Interfaces.IProduct;
import Interfaces.IRepoCopia;

public class RepoCopia implements Serializable, IRepoCopia{
	
	private static final long serialVersionUID = 1L;
	
	private static RepoCopia Rc;
	
	private HashMap<Integer,Copia> ListaCopias;
	
	private RepoCopia() {
		ListaCopias = new HashMap<Integer,Copia>();
	}
	
	public HashMap<Integer, Copia> getCopyList(){
		return ListaCopias;
	}
	
	public static RepoCopia getInstance() {
		if(Rc==null) {
			Rc = new RepoCopia();
		}
		return Rc;
	}
	
	public void addCopy(ICopia c,IProduct p) {
		ListaCopias.put(c.getID(),(Copia)c);
	}
	
	public boolean Contains(Integer a) {
		return ListaCopias.containsKey(a);	
	}
	
	public void delCopy(ICopia copia) {
		ListaCopias.remove(copia);
	}
}
