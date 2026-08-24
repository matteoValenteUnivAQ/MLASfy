package service;

import model.Utente;
import model.Playlist;

public interface UtenteService {
    void registraUtente(Utente utente);
    void aggiornaAnagrafica(Utente utente, String nome, String cognome, String email);
    void eliminaPlaylist(Utente utente, Playlist playlist);
    Playlist creaPlaylist(Utente utente, String nome, String descrizione);
}