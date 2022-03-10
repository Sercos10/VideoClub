package Interfaces;

import Enums.Category;

public interface IProduct {
    Float getPrice();
    String getDescription();
    Integer getID();
    String getName();
    void setName(String name);
    void setPrice(Float Price);
    void setDescription(String Description);
    void setID(Integer ID);
    void setCategory(Category category);
    boolean equals(Object o);
    String toString();
}
