package model;

import Interfaces.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class RepoReservation implements Serializable, IRepoReservation {

    private static RepoReservation instance = null;
    private static final long serialVersionUID=1L;
    private RepoReservation(){

    }
    public static RepoReservation newInstance(){
        if(instance==null){
            instance = new RepoReservation();
        }else{
            return instance;
        }
        return instance;
    }
    private HashMap<Integer, IReservation> reservations;

    public boolean addReservation(Integer ID,IClient client, IProduct product){
        boolean added=false;
        if (client!=null&&product!=null){
            for (Map.Entry<Integer, IReservation> r: reservations.entrySet()) {
                if (!r.getKey().equals(ID)){
                    added=true;
                }
            }
            LocalDate created= LocalDate.now();
            String date= ""+created;
            IReservation reservation= new Reservation(ID,date, client, product);
            reservations.put(ID,reservation);
        }
        return added;
    }

    public IReservation modifyReservation(Integer ID,IReservation reservation){
        IReservation temp= new Reservation();
        if (reservation!=null){
            for (Map.Entry<Integer, IReservation> r: reservations.entrySet()) {
                    if (r.getKey().equals(ID)){
                        IVista vista;
                        vista.showMenuModify();
                        int opcion=vista.leeEntero("Introduce la opcion que quieras modificar");
                        switch (opcion){
                            case 1:
                        }
                }
            }
        }
    }

    public boolean delReservation(Integer ID){
        boolean deleted=false;
        IVista vista;
        for (Map.Entry<Integer, IReservation> r: reservations.entrySet()) {
            if (!r.getKey().equals(ID)){
                reservations.remove(ID);
                vista.print("Reserva eliminada con exito");
                deleted=true;
            }
        }
        if (!deleted){
            vista.print("No se ha podido eliminar la reserva porque el ID intoducido no coincide con el de ninguna reserva");
        }
        return deleted;
    }

    @Override
    public void modifyFechaCreacion(Integer ID, String date) {

    }

    @Override
    public void modifyFechaFinal(Integer ID, String date) {

    }

    @Override
    public void modifyStatus(Integer ID, String status) {

    }

    public void showReservations(){
        for (Map.Entry<Integer, IReservation> r : reservations.entrySet()) {
            System.out.println("ID= " + r.getKey());
            System.out.println("Reserva= " + r.getValue());
        }
    }
    public void saveFile(String url) {

    }
    public void loadFile(String url) {

    }
}
