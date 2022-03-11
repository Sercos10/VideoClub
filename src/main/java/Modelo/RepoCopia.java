package Modelo;

import java.util.ArrayList;
import Interfaces.IRepoCopia;

public class RepoCopia implements IRepoCopia{
	private ArrayList<Copia> Copias;

	public RepoCopia() {
		Copias = new ArrayList<Copia>();
	}
	public void addCopy(Copia c) {
		Copias.add(c);
	}
}
