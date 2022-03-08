package Interfaces;

import Enums.Status;

public interface IRespoReservation {
	void showReservations();
	boolean addReservation(Integer ID, IClient cliente, IProduct product);
	boolean delReservation(Integer ID);
	void modifyFechaCreacion(Integer ID, String date);
	void modifyFechaFinal(Integer ID, String date);
	void modifyStatus(Integer ID, Status status);
	IReservation searchReservation(Integer ID);
    void saveFile(String url);
    void loadFile(String url);
}
