package Interfaces;

import Enums.Category;

public interface IProduct {
    Float getPrice();
    String getDescription();
    Integer getID();
    String getName();
    Integer getNum_cop();
    Category getCategory();
    void setName(String name);
    void setPrice(Float Price);
    void setDescription(String Description);
    void setID(Integer ID);
    void setCategory(Category category);
    void setNum_cop(Integer Num_cop);
    boolean equals(Object o);
    String toString();
}
