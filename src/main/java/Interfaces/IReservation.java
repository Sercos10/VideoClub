package Interfaces;

import Enums.Status;

import java.time.LocalDateTime;

public interface IReservation {
    Integer getID();
    void setID(Integer ID);
    LocalDateTime getDateReser();
    void setDateReser(LocalDateTime dateReser);
    LocalDateTime getFinalDate();
    void setFinalDate(LocalDateTime finalDate);
    Status getStatus();
    void setStatus(Status status);
    IClient getClient();
    void setClient(IClient client);
    IProduct getProduct();
    void setProduct(IProduct product);
    boolean equals(Object o);
    String toString();
}
