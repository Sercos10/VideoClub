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
import java.time.LocalDate;
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

    public static RepoReservation getInstance() {
        if (_instance==null) {
            _instance=new RepoReservation();
        }
        return _instance;
    }
    public boolean addReservation(Integer ID,IClient client, IProduct product){
        boolean added=false;
        if (client!=null&&product!=null){
            if (reservations!=null&&!reservations.containsKey(ID)){
                LocalDate created= LocalDate.now();
                LocalDate expired = created.plusWeeks(7);
                String expirado= ""+expired;
                Status status= Status.RESERVADO;
                String date= ""+created;
                IReservation reservation= new Reservation(ID,date,expirado,status, client, product);
                reservations.put(ID, (Reservation) reservation);
                added=true;
            }
        }
        return added;
    }

    public boolean delReservation(Integer ID){
        boolean deleted=false;
        if (reservations!=null&&reservations.containsKey(ID)){
            reservations.remove(ID);
            deleted=true;
        }
        return deleted;
    }

    public void modifyFechaCreacion(Integer ID, String date) {
        if (reservations!=null&&reservations.containsKey(ID)){
            reservations.get(ID).setDateReser(date);
        }
    }

    public void modifyFechaFinal(Integer ID, String date) {
        if (reservations!=null&&reservations.containsKey(ID)){
            reservations.get(ID).setFinalDate(date);
        }
    }

    public void modifyStatus(Integer ID, Status status) {
        if (reservations != null && reservations.containsKey(ID)) {
            reservations.get(ID).setStatus(status);
        }
    }
    
    public IReservation searchReservation(Integer ID) {
		return(this.reservations.get(ID));
	}

    public void showReservations(){
        if (reservations!=null){
            for (Map.Entry<Integer, Reservation> r : reservations.entrySet()) {
                System.out.println("ID= " + r.getKey());
                System.out.println("Reserva= " + r.getValue());
            }
        }
    }

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
