package service;

import model.Playlist;

public interface UtenteService {
    
    public boolean rimuoviPlaylist(Playlist playlistDaRimuovere);
    public void creaPlaylist(Playlist nuovaPlaylist);
}