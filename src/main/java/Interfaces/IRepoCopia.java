package Interfaces;

public interface IRepoCopia {
    boolean addCopia(ICopia c);
    boolean delCopia(Integer ID);
    void saveFile(String url);
    void loadFile(String url);
}
