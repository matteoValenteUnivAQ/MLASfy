package model;

import java.util.ArrayList;
import java.util.List;

public class ArtistaGruppo extends Artista {
    private List<ArtistaSolista> componenti;

    public ArtistaGruppo(String nomeArte, String biografia, Genere generePrincipale) {
        super(nomeArte, biografia, generePrincipale);
        this.componenti = new ArrayList<>();
    }

    public List<ArtistaSolista> getComponenti() {
        return componenti;
    }

    public void aggiungiComponente(ArtistaSolista artista) {
        this.componenti.add(artista);
    }

    public void rimuoviComponente(ArtistaSolista artista) {
        this.componenti.remove(artista);
    }
}