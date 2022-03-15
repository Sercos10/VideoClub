package Interfaces;

import java.util.HashMap;

import Enums.Category;
import Enums.Status;
import Modelo.Client;
import Modelo.Product;
import Modelo.Reservation;

public interface IVista {
    void showMainMenu();
    void showMenuClient();
    void showMenuProduct();
    void showMenuReservation();
    void showMenuModifyClient();
    void showMenuModifyProduct();
    void showMenuModifyReservation();
    void showProductList(HashMap<Integer,Product> p);
    void showClientList(HashMap<Integer,Client> clie);
    void showReservationList(HashMap<Integer, Reservation> reserva);
    Integer leeEntero(String frase);
    Float leeFloat(String frase);
    String leeString(String frase);
    void print(String s);
    Category leeCategory(String s);
    Status leeStatus(String s);
    Integer opcMenu3();
    Integer opcMenu6();
    Integer opcMenu7();
    Integer opcMenu5();
    Integer opcMenu4();
    void showClient(Object O);
}
