package Interfaces;

public interface IReposClient {
	void showClientList();
	void modifyName(Integer ID, String name);
	void modifyPhone(Integer ID, String phone);
	void modifyTime(Integer ID, String time);
	void modifyAddress(Integer ID, String address);
	void modifyAge(Integer ID, Integer age);
	boolean addClient(IClient c);
	boolean removeClient (IClient c);
    void saveFile(String url);
    void loadFile(String url);
    
}
