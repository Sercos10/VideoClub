package Interfaces;

import Enums.Status;
import Modelo.Client;
import Modelo.Copia;
import Modelo.Product;

import java.time.LocalDateTime;

/**
 * Interfaz que implementa a la clase Reservation
 * @author franc
 */
public interface IReservation {
    Integer getID();
    void setID(Integer ID);
    String getDateReser();
    void setDateReser(String dateReser);
    String getFinalDate();
    void setFinalDate(String finalDate);
    Status getStatus();
    void setStatus(Status status);
    IClient getClient();
    void setClient(Client client);
    Product getCopia();
    void setCopia(Copia copia);
    boolean equals(Object o);
    String toString();
}
