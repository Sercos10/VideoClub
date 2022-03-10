package Interfaces;

import Enums.Category;

public interface IProduct {
    Float getPrice();
    String getDescription();
    Integer getID();
    String getName();
    Integer getNCopias();
    Category getCategory();
    void setName(String name);
    void setPrice(Float Price);
    void setDescription(String Description);
    void setID(Integer ID);
    void setNCopias(Integer ncopias);
    void setCategory(Category categoria);
    boolean equals(Object o);
    String toString();
}
