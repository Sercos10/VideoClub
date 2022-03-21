package Interfaces;

import Enums.Status;
import Modelo.Reservation;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Interfaz que implementa a la clase RepoReservation
 * @author franc
 */
public interface IRespoReservation {
	HashMap<Integer, Reservation> getReservations();
	void addReservation(Reservation r);
	void delReservation(Integer ID);
	void modifyFechaFinal(Integer ID, String date);
	void modifyStatus(Integer ID, Status status);
	IReservation searchReservation(Integer ID);
    void saveFile(String url);
    void loadFile(String url);
    boolean Contains(Integer id);
    boolean isEmpty();
}
