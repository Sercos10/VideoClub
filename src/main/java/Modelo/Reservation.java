package model;

import Interfaces.IClient;
import Interfaces.IProduct;
import Interfaces.IReservation;

public class Reservation implements IReservation {
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
    @Override
    public Integer getID() {
        return null;
    }

    @Override
    public String getDateReser() {
        return null;
    }

    @Override
    public int hashcode() {
        return 0;
    }
}
