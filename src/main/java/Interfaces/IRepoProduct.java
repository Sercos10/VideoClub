package Interfaces;

import Enums.Category;

public interface IRepoProduct {
	void showProductList();
	boolean addProduct (IProduct p);
	boolean removeProduct (IProduct p);
	void modifyName(Integer ID, String name);
	void modifyDesc(Integer ID, String desc);
	void modifyPrize(Integer ID, float precio);
	void modifyCategory(Integer ID, Category category);
	IProduct searchProduct(Integer ID);
    void saveFile(String url);
    void loadFile(String url);
}
