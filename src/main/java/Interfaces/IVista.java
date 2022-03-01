package Interfaces;

public interface IVista {
    void showMainMenu();
    void showMenuClient();
    void showMenuItem();
    void showMenuProduct();
    void showMenuReservation();
    void showMenuModify();
    Integer leeEntero(String frase);
    Float leeFloat(String frase);
    String leeString(String frase);
    void print(String s);
    Integer opcMenu();
}
