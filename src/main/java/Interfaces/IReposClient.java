package Interfaces;

public interface IReposClient {
	void showClientList();
<<<<<<< HEAD
	void modifyName(Integer ID, String name);
	void modifyPhone(Integer ID, String phone);
	void modifyTime(Integer ID, String time);
	void modifyAddress(Integer ID, String address);
	void modifyAge(Integer ID, Integer age);
	boolean addClient(IClient c);
	boolean removeClient (IClient c);
=======
	void modifyName(Integer ID, String Name);
	void modifyPhone(Integer ID, String Phone);
	void modifyTime(Integer ID, String Time);
	void modifyAddress(Integer ID, String Address);
	void modifyAge(Integer ID, Integer Age);
	boolean addClient(IClient c);
	boolean removeClient(IClient c);
>>>>>>> aa88330a9689d53dea45cb2e666c62257b888a42
    void saveFile(String url);
    void loadFile(String url);
    
}
