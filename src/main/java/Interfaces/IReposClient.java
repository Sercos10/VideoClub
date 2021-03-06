package Interfaces;

import Modelo.Client;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Interfaz que implementa a la clase RepoClient
 * @author franc
 */
public interface IReposClient {
	HashMap<Integer, Client> getClientList();
	void modifyName(Integer ID, String name);
	void modifyPhone(Integer ID, String phone);
	void modifyTime(Integer ID, LocalDateTime time);
	void modifyAddress(Integer ID, String address);
	void modifyAge(Integer ID, Integer age);
	IClient searchClient(Integer ID);
	boolean addClient(IClient c);
	boolean removeClient(Integer ID);
	boolean Contains(Integer ID);
    void saveFile(String url);
    void loadFile(String url);
    Client getClient(Integer id);
    
}
