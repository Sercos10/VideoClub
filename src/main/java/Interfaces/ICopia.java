package Interfaces;

/**
 * Interfaz que implementa a la clase Copia
 * @author franc
 */
public interface ICopia extends IProduct{
    Integer getID_copia();
    boolean equals(Object o);
    String toString();
}
