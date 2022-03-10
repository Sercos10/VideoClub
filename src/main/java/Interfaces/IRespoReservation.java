package Interfaces;

import Enums.Status;

import java.time.LocalDateTime;

public interface IRespoReservation {
	void showReservations();
	boolean addReservation(Integer ID, IClient cliente, IProduct product);
	boolean delReservation(Integer ID);
	void modifyFechaCreacion(Integer ID, LocalDateTime date);
	void modifyFechaFinal(Integer ID, LocalDateTime date);
	void modifyStatus(Integer ID, Status status);
	IReservation searchReservation(Integer ID);
    void saveFile(String url);
    void loadFile(String url);
}
