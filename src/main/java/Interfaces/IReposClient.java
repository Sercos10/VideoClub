package Interfaces;

public interface IReposClient {
	void showClientList();
	void modifyName(Integer ID, String Name);
	void modifyPhone(Integer ID, String Phone);
	void modifyTime(Integer ID, String Time);
	void modifyAddress(Integer ID, String Address);
	void modifyAge(Integer ID, Integer Age);
	boolean addClient(IClient c);
	boolean removeClient(IClient c);
    void saveFile(String url);
    void loadFile(String url);
}
