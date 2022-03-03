package Modelo;

import java.io.Serializable;

import Interfaces.IClient;
import Interfaces.IProduct;
import Interfaces.IReservation;

public class Reservation implements Serializable, IReservation {

	private static final long serialVersionUID = 1L;
	
    private Integer ID;
    private String DateReser    ;
    private IClient client;
    private IProduct product;

    public Reservation(){
        this.ID=-1;
        this.DateReser="";
        this.client=null;
        this.product=null;
    }

    public Reservation(Integer ID, String Date, IClient client, IProduct product){
        this.ID=ID;
        this.DateReser=Date;
        this.client=client;
        this.product=product;
    }
   
    public Integer getID() {
        return null;
    }

    public String getDateReser() {
        return null;
    }
    
    public boolean equals(Object obj) {
		return false;
    }
}
