package Interfaces;

public interface IClient {
    Integer getID();
    String getname();
    String getPhone();
    String getTime();
    String getAddress();
    Integer getAge();
    void setID(Integer ID);
    void setname(String name);
    void setPhone(String Phone);
    void setTime(String Time);
    void setAddress(String Address);
    void setAge(Integer Age);
    boolean equals(Object o);
    String toString();
}
