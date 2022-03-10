package Modelo;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBContextFactory;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import Enums.Category;
import Interfaces.IProduct;
import Interfaces.IRepoProduct;

@XmlRootElement(name = "RepoProduct")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoProduct implements IRepoProduct {
	private HashMap<Integer, Product> productList;
	private static RepoProduct _instance;
	
	private RepoProduct() {
		productList = new HashMap<Integer, Product>();
	}

	public HashMap<Integer,Product> getProductList() {
		return productList;
	}

	public static RepoProduct getInstance() {
		if (_instance == null) {
			_instance = new RepoProduct();
		}
		return _instance;
	}

	public boolean addProduct(IProduct p) {
		boolean added = false;
		if (p != null) {
			if (!productList.containsKey(p.getID())) {
				productList.put(p.getID(), (Product) p);
				added = true;
			}
		}
		return added;
	}

	public boolean removeProduct(Integer id) {
		boolean removed = false;
		if(productList.containsKey(id)) {
			productList.remove(id);
			removed=true;
			}
		return removed;
		}
		

	public void modifyName(Integer ID, String name) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setName(name);
		}
	}

	public void modifyDesc(Integer ID, String desc) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setDescription(desc);
		}
	}

	public void modifyPrize(Integer ID, float prize) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setPrice(prize);
		}
	}

	public void saveFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoProduct.class);
			Marshaller m = ((JAXBContext) contexto).createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(_instance, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void loadFile(String url) {
		JAXBContext contexto;

		try {
			contexto = JAXBContext.newInstance(RepoProduct.class);
			Unmarshaller um = contexto.createUnmarshaller();
			RepoProduct newClub = (RepoProduct) um.unmarshal(new File(url));
			productList = newClub.productList;
			;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void modifyCategory(Integer ID, Category category) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setCategory(category);
		}
	}

	public IProduct searchProduct(Integer ID) {
		
		return null;
	}

}
