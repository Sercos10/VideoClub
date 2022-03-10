package Modelo;

import Enums.Status;
import Interfaces.IClient;
import Interfaces.ICopia;
import Interfaces.IProduct;
import Interfaces.IReservation;

import java.io.Serializable;

public class Reservation implements Serializable, IReservation {

	private static final long serialVersionUID = 1L;

    private Integer ID;
    private String DateReser;
    private String FinalDate;
    private Status status;
    private IClient client;
    private ICopia copia;

    public Reservation(){
        this.ID=-1;
        this.DateReser="";
        this.FinalDate="";
        this.status=null;
        this.client=null;
        this.copia=null;
    }

    public Reservation(Integer ID, String Date, String FinalDate, Status status,IClient client, ICopia copia){
        this.ID=ID;
        this.DateReser=Date;
        this.FinalDate=FinalDate;
        this.status=status;
        this.client=client;
        this.copia=copia;
    }
   
    public Integer getID() {
        return null;
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

    public void setClient(IClient client) {
        this.client = client;
    }

    public ICopia getCopia() {
        return copia;
    }

    public void setCopia(ICopia copia) {
        this.copia = copia;
    }

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
}
