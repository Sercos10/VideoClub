package Interfaces;

import java.util.ArrayList;

import Modelo.Copia;

/**
 * Interfaz que implementa a la clase RepoCopia
 * @author franc
 */
public interface IRepoCopia {
	void addCopy(Copia c);
	ArrayList<Copia> getCopyList();
	void removeCopy(Copia c);
	void loadFile(String url);
	void saveFile(String url);
	Copia getCopy(Integer id);
	
}
