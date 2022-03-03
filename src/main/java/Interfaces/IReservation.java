package Interfaces;

public interface IReservation {
    Integer getID();
    String getDateReser();
    boolean equals(Object o);
    int hashcode();
    String toString();
}
