package Modelo;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

import Interfaces.IClient;
import Interfaces.IReposClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RepoClient")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoClient implements Serializable, IReposClient{
	
	/**
	 * Método para XML
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Método para declarar la instancia
	 */
	private static RepoClient _instance;
	
	/**
	 * Método para declarar la lista
	 */
	private HashMap <Integer, Client> clientlist;
	
	/**
	 * Método para instanciar la lista de clientes
	 */
	private RepoClient() {
		clientlist= new HashMap <Integer, Client>();
	}
	
	/**
	 * Método para obtener la lista de clientes
	 */
	public HashMap<Integer, Client> getClientList(){
		return clientlist;
	}
	
	/**
	 * Método para instanciar una lista una sola vez
	 * @return Lista instanciada
	 */
	public static RepoClient getInstance() {
		if (_instance==null) {
			_instance=new RepoClient();
		}
		return _instance;
	}
	
	/**
	 * Método para modificar el nombre de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Nombre al que se quiere cambiar
	 */
	public void modifyName(Integer ID, String Name) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setName(Name);
		}
	}
	
	/**
	 * Método para modificar el teléfono de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Teléfono al que se quiere cambiar 
	 */
	public void modifyPhone(Integer ID, String Phone) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setPhone(Phone);;
		}
	}
	
	/**
	 * Método para modificar la fecha de alta de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Fecha de alta a la que se quiere cambiar 
	 */
	public void modifyTime(Integer ID, LocalDateTime Time) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setTime(Time);
		}
	}
	
	/**
	 * Método para modificar la dirección de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Dirección a la que se quiere cambiar 
	 */
	public void modifyAddress(Integer ID, String Address) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setAddress(Address);
		}
	}
	
	/**
	 * Método para modificar la edad de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Edad a la que se quiere cambiar 
	 */
	public void modifyAge(Integer ID, Integer Age) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setAge(Age);
		}
	}
	
	/**
	 * Método para obtener el cliente de una lista
	 * @param ID del cliente a obtener
	 * @return Cliente encontrado
	 */
	public Client getClient(Integer id) {
		return clientlist.get(id);
	}
	
	/**
	 * Método para buscar el cliente de una lista
	 * @param ID del cliente a buscar
	 * @return Cliente buscado
	 */
	public IClient searchClient(Integer ID) {
		return(this.clientlist.get(ID));
	}

	/**
	 * Método para añadir un cliente mediante un cliente dado
	 * @param Cliente que se va a añadir
	 * @return Si se ha añadido al cliente
	 */
	public boolean addClient(IClient c) {
		Client aux= (Client) c;
		boolean added=false;
		if(!this.clientlist.containsKey(aux.getID())) {
			this.clientlist.put(aux.getID(), aux);
			added=true;
		}
		return added;
	}
	
	/**
	 * Método para eliminar un cliente mediante una ID dada
	 * @param
	 * @return Si se ha eliminado al cliente
	 */
	public boolean removeClient(Integer ID) {
		boolean removed=false;
		if(this.clientlist.containsKey(ID)) {
			this.clientlist.remove(ID);
			removed=true;
		}
		return removed; 
	}
	
	/**
	 * Método para guardar los datos en archivo XML
	 * @param Ubicación del archivo
	 */
	public void saveFile(String url) {
		JAXBContext contexto; 
		try {
			contexto = JAXBContext.newInstance(RepoClient.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(_instance, new File(url));
		
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método para saber si una lista contiene un elemento buscado por ID
	 * @param ID del cliente
	 * @return Si se ha encontrado al cliente
	 */
	public boolean Contains(Integer id) {
		return clientlist.containsKey(id);
	}
	
	/**
	 * Método para saber si la lista está vacía
	 * @return Si la lista está vacía
	 */
	public boolean isEmpty() {
		return clientlist.isEmpty();
	}
	
	/**
	 * Método para cargar los datos de un archivo XML
	 * @param Ubicación del archivo
	 */
	public void loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoClient.class);
		    Unmarshaller um = contexto.createUnmarshaller();
		     
		    RepoClient newRepoClient = (RepoClient) um.unmarshal( new File(url) );
		    clientlist=newRepoClient.clientlist;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
