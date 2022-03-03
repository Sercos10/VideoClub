package Interfaces;

public interface IRespoReservation {
	void showReservations();
	boolean addReservation(Integer ID, IClient cliente, IProduct product);
	boolean delReservation(Integer ID);
	void modifyFechaCreacion(Integer ID, String date);
	void modifyFechaFinal(Integer ID, String date);
<<<<<<< HEAD
	void modifyStatus(Integer ID, Status status);
=======
	void modifyFechaStatus(Integer ID, String estado);
>>>>>>> aa88330a9689d53dea45cb2e666c62257b888a42
    void saveFile(String url);
    void loadFile(String url);
}
