package service;

import java.util.List;
import model.Album;
import model.Artista;
import model.Brano;
import model.Genere;
import model.Ricercabile;

public interface CatalogoService {
    void aggiungiArtista(Artista artista);
    void aggiungiAlbum(Album album, String artistaId);
    void aggiungiBrano(Brano brano, String albumId);

    void rimuoviArtista(String artistaId);
    void rimuoviBrano(String branoId);
    /* rimuoviAlbum ?? */

    List<Ricercabile> cerca(String query);
    List<Brano> filtraPerGenere(Genere genere);
}