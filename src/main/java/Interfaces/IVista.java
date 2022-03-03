package Interfaces;

public interface IVista {
    void showMainMenu();
    void showMenuClient();
    void showMenuProduct();
    void showMenuReservation();
    void showMenuModifyClient();
    void showMenuModifyProduct();
    void showMenuModifyReservation();
    Integer leeEntero(String frase);
    Float leeFloat(String frase);
    String leeString(String frase);
    void print(String s);
    Integer opcMenu3();
    Integer opcMenu6();
    Integer opcMenu5();
    Integer opcMenu4();
}
