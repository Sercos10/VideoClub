package Modelo;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import Interfaces.IRepoCopia;

public class RepoCopia implements Serializable, IRepoCopia {
	private static final long serialVersionUID = 1L;
	private ArrayList<Copia> ListaCopias;

	private RepoCopia() {
		ListaCopias = new ArrayList<Copia>();
	}

	private static RepoCopia RC;

	public static RepoCopia getInstance() {
		if (RC == null) {
			RC = new RepoCopia();
		}
		return RC;
	}

	public void addCopy(Copia c) {
		ListaCopias.add(c);
	}

	public void CopyByIdProduct(Integer id) {
		for (Copia c : ListaCopias) {
			if (c.getID() == id) {
				System.out.println(c);
			}
		}
	}

	public void saveFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoClient.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(RC, new File(url));

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void removeCopy(Copia c) {
		ListaCopias.remove(c);
	}

	public Copia getCopy(Integer id) {
		Copia aux = new Copia();
		for(Copia c : ListaCopias) {
			if(c.getId_copia()==id) {
				System.out.println(c);
			aux=c;
			return aux;
			}
		}
		return aux;
			
		}

	public void loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoCopia.class);
			Unmarshaller um = contexto.createUnmarshaller();

			RepoCopia newRepoCopias = (RepoCopia) um.unmarshal(new File(url));
			ListaCopias = newRepoCopias.ListaCopias;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
