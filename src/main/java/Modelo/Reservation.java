package Modelo;

import Enums.Status;
import Interfaces.IClient;
import Interfaces.ICopia;
import Interfaces.IReservation;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Reservation implements Serializable, IReservation {

	private static final long serialVersionUID = 1L;

	 private Integer ID;
	 
	 private String DateReser;
	 
	 private String FinalDate;
	 
	 private Status status;
	 
	 private Client client;
	 
	 private Copia copia;

    public Reservation(){
        this.ID=-1;
        this.DateReser=null;
        this.FinalDate=null;
        this.status=null;
        this.client=null;
        this.copia=null;
    }

    public Reservation(Integer ID, String Date, String FinalDate, Status status,Client client,Copia copy){
        this.ID=ID;
        this.DateReser=Date;
        this.FinalDate=FinalDate;
        this.status=status;
        this.client=client;
        this.copia=copy;
    }
   
    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getDateReser() {
        return this.DateReser;
    }

    public void setDateReser(String dateReser) {
        DateReser = dateReser;
    }

    public String getFinalDate() {
        return FinalDate;
    }

    public void setFinalDate(String finalDate) {
        FinalDate = finalDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public IClient getClient() {
        return client;
    }

    /**
     * Metodo para comprobar si una reserva es igual a otra
     * @param obj  Objeto recibido
     * @return Si es igual
     */
    public boolean equals(Object obj){
        boolean valid=false;
        if(obj!=null) {
            if(this==obj) {
                valid=true;
            }else {
                if(this.getClass()==obj.getClass()) {
                    Client tmp= (Client) obj;
                    if(this.getClass().equals(tmp.getClass())) {
                        valid=true;
                    }
                }
            }
        }
        return valid;
    }

    /**
     * Metodo para generar el toString de reserva
     * @return
     */
    @Override
    public String toString() {
        return "Reservation{" +
                "ID=" + ID +
                ", DateReser='" + DateReser + '\'' +
                ", FinalDate='" + FinalDate + '\'' +
                ", status=" + status +
                ", client=" + client +
                ", copia=" + copia +
                '}';
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getCopia() {
        return copia;
    }


    public void setCopia(Copia copy) {
        this.copia = copy;
    }

	
}
