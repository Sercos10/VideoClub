package Interfaces;

public interface IClient {
    Integer getID();
    String getname();
    String getAddress();
    Integer getAge();
    String getTelf();
    void setID(Integer ID);
    void setname(String name);
    void setAddress(String Address);
    void setAge(Integer Age);
    void setTelf(String Telf);
    boolean equals(Object o);
    int hashcode();
    String toString();
}
