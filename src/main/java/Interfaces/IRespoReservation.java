package Interfaces;

import Enums.Status;
import Modelo.Reservation;

import java.time.LocalDateTime;
import java.util.HashMap;

public interface IRespoReservation {
	HashMap<Integer, Reservation> getReservations();
	boolean addReservation(Integer ID, IClient cliente, ICopia copia);
	boolean delReservation(Integer ID);
	void modifyFechaCreacion(Integer ID, LocalDateTime date);
	void modifyFechaFinal(Integer ID, LocalDateTime date);
	void modifyStatus(Integer ID, Status status);
	IReservation searchReservation(Integer ID);
    void saveFile(String url);
    void loadFile(String url);
}
