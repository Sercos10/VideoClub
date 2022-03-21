package Modelo;

import Enums.Status;
import Interfaces.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name="RepoReservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoReservation implements Serializable, IRespoReservation {

    private static final long serialVersionUID=1L;

    private static RepoReservation _instance;

    private HashMap <Integer, Reservation> reservations;

    private RepoReservation() {
        reservations= new HashMap <Integer, Reservation>();
    }
    
    public HashMap<Integer, Reservation> getReservations(){
		return reservations;
	}

    public static RepoReservation getInstance() {
        if (_instance==null) {
            _instance=new RepoReservation();
        }
        return _instance;
    }

    /**
     * Metodo para añadir una reserva a la coleccion
     * @param r reserva a ser añadida
     */
    public void addReservation(Reservation r) {
    	reservations.put(r.getID(), r);
    }

    /**
     * Metodo para eliminar una reserva
     * @param ID de la reserva a eliminar
     */
    public void delReservation(Integer ID){
    	reservations.remove(ID);
    }

    /**
     * Metodo para modificar la fecha final de la reserva
     * @param ID de la reserva a querer cambiar la fecha final
     * @param date fecha final pasada por parametro
     */
    public void modifyFechaFinal(Integer ID, String date) {
        if (reservations!=null&&reservations.containsKey(ID)){
            reservations.get(ID).setFinalDate(date);
        }
    }

    /**
     * Metodo para modificar la categoria de un producto
     * @param ID para saber de que producto queremos cambiar la categoria pasado como parametro
     * @param status el nuevo Status pasada como parametro
     */
    public void modifyStatus(Integer ID, Status status) {
        if (reservations != null && reservations.containsKey(ID)) {
            reservations.get(ID).setStatus(status);
        }
    }

    /**
     * Metodo para buscar un producto por su id
     * @param ID del producto que queremos buscar pasada como parametro
     * @return devuelve la reserva si lo ha encontrado
     */
    public IReservation searchReservation(Integer ID) {
		return(this.reservations.get(ID));
	}

    /**
     * Metodo para saber si existe una reserva asignada a la id pasada por parametro
     * @param id ID pasada por parametro
     * @return true si existe una reserva asignada a esa id o false si no existe
     */
    public boolean Contains(Integer id) {
		return reservations.containsKey(id);
	}

    /**
     * Metodo para saber si la coleccion de reservas esta vacia
     * @return true si esta vacia o false si hay una reserva como minimo guardada
     */
	public boolean isEmpty() {
		return reservations.isEmpty();
	}

    /**
     * Metodo para guardar los productos en un xml
     * @param url Archivo donde se van a guardar dichas productos.
     */
    public void saveFile(String url) {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(RepoReservation.class);
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            m.marshal(_instance, new File(url));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cargar la Lista de productos de un xml
     * @param url el archivo del que queremos cargar la Lista de Productos
     */
    public void loadFile(String url) {
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(RepoReservation.class);
            Unmarshaller um = contexto.createUnmarshaller();

            RepoReservation newRepoReservation = (RepoReservation) um.unmarshal( new File(url) );
            reservations=newRepoReservation.reservations;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
