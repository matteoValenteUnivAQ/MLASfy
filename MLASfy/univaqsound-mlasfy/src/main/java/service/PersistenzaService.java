package service;

public interface PersistenzaService {
    void salvaDato(Object data, String path);
    Object caricaDato(String path);
}