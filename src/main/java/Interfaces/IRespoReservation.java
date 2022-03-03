package Interfaces;

public interface IRespoReservation {
	void showReservations();
	boolean addReservation(Integer ID, IClient cliente, IProduct product);
	boolean delReservation(Integer ID);
	void modifyFechaCreacion(Integer ID, String date);
	void modifyFechaFinal(Integer ID, String date);
	void modifyFechaStatus(Integer ID, String estado);
    void saveFile(String url);
    void loadFile(String url);
}
