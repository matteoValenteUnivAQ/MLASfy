package service;

import java.util.List;
import model.Artista;
import model.Brano;
import model.Utente;

public interface StatisticheService {
    List<Brano> getTopBrani(int limite);
    List<Artista> getTopArtisti(int limite);
    List<Brano> getSuggerimenti(Utente utente);
    int getTempoTotaleAscolto(Utente utente);
}