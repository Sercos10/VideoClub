package Interfaces;

public interface IVista {
    void showMainMenu();
    void showMenuClient();
    void showMenuProduct();
    void showMenuReservation();
    void showMenuModifyClient();
    void showMenuModifyProduct();
    void showMenuModifyReservation();
    void showProductList();
    void showClientList();
    void showReservationList();
    Integer leeEntero(String frase);
    Float leeFloat(String frase);
    String leeString(String frase);
    void print(String s);
    void leeCategory();
    void leeStatus();
    Integer opcMenu3();
    Integer opcMenu6();
    Integer opcMenu7();
    Integer opcMenu5();
    Integer opcMenu4();
}
