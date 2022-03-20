package Interfaces;

import Modelo.Copia;

public interface IRepoCopia {
	void addCopy(Copia c);
	void CopyByIdProduct(Integer id);
	void removeCopy(Copia c);
	void loadFile(String url);
	void saveFile(String url);
	Copia getCopy(Integer id);
	
}
