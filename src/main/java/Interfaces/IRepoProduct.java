package Interfaces;

import Enums.Category;
import Modelo.Product;

import java.util.HashMap;

/**
 * Interfaz que implementa a la clase RepoProduct
 * @author franc
 */
public interface IRepoProduct {
	HashMap<Integer, Product> getProductList();
	boolean addProduct (IProduct p);
	boolean removeProduct (Integer id);
	void modifyName(Integer ID, String name);
	void modifyDesc(Integer ID, String desc);
	void modifyPrize(Integer ID, float precio);
	void modifyCategory(Integer ID, Category category);
	IProduct searchProduct(Integer ID);
	boolean Contains(Integer ID);
    void saveFile(String url);
    void loadFile(String url);
}
