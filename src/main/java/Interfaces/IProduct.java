package Interfaces;

public interface IProduct {
    Float getPrice();
    String getDescription();
    Integer getID();
    void setPrice(Float Price);
    void setDescription(String Description);
    void setID(Integer ID);
    boolean equals(Object o);
    int hashcode();
    String toString();
}
