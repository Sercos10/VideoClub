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
	
	private static final long serialVersionUID = 1L;
	
	private static RepoClient _instance;
	
	private HashMap <Integer, Client> clientlist;
	
	/**
	 * Metodo para instanciar la lista de clientes
	 */
	private RepoClient() {
		clientlist= new HashMap <Integer, Client>();
	}
	
	/**
	 * Metodo para obtener la lista de clientes
	 */
	public HashMap<Integer, Client> getClientList(){
		return clientlist;
	}
	
	/**
	 * Metodo para instanciar una lista una sola vez
	 * @return Lista instanciada
	 */
	public static RepoClient getInstance() {
		if (_instance==null) {
			_instance=new RepoClient();
		}
		return _instance;
	}
	
	/**
	 * Metodo para modificar el nombre de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Name Nombre al que se quiere cambiar
	 */
	public void modifyName(Integer ID, String Name) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setName(Name);
		}
	}
	
	/**
	 * Metodo para modificar el telefono de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Phone Telefono al que se quiere cambiar
	 */
	public void modifyPhone(Integer ID, String Phone) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setPhone(Phone);;
		}
	}
	
	/**
	 * Metodo para modificar la fecha de alta de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Time Fecha de alta a la que se quiere cambiar
	 */
	public void modifyTime(Integer ID, LocalDateTime Time) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setTime(Time);
		}
	}
	
	/**
	 * Metodo para modificar la direccion de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Address Direccion a la que se quiere cambiar
	 */
	public void modifyAddress(Integer ID, String Address) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setAddress(Address);
		}
	}
	
	/**
	 * Metodo para modificar la edad de un cliente localizado por su ID
	 * @param ID del cliente a buscar
	 * @param Age Edad a la que se quiere cambiar
	 */
	public void modifyAge(Integer ID, Integer Age) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setAge(Age);
		}
	}
	
	/**
	 * Metodo para obtener el cliente de una lista
	 * @param id ID del cliente a obtener
	 * @return Cliente encontrado
	 */
	public Client getClient(Integer id) {
		return clientlist.get(id);
	}
	
	/**
	 * Metodo para buscar el cliente de una lista
	 * @param ID del cliente a buscar
	 * @return Cliente buscado
	 */
	public IClient searchClient(Integer ID) {
		return(this.clientlist.get(ID));
	}

	/**
	 * Metodo para anadir un cliente mediante un cliente dado
	 * @param c Cliente que se va a anadir
	 * @return Si se ha anadido al cliente
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
	 * Metodo para eliminar un cliente mediante una ID dada
	 * @param ID
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
	 * Metodo para guardar los datos en archivo XML
	 * @param url Ubicacion del archivo
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
	 * Metodo para saber si una lista contiene un elemento buscado por ID
	 * @param id ID del cliente
	 * @return Si se ha encontrado al cliente
	 */
	public boolean Contains(Integer id) {
		return clientlist.containsKey(id);
	}
	
	/**
	 * Metodo para saber si la lista esta vacia
	 * @return Si la lista esta vacia
	 */
	public boolean isEmpty() {
		return clientlist.isEmpty();
	}
	
	/**
	 * Metodo para cargar los datos de un archivo XML
	 * @param url Ubicacion del archivo
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
