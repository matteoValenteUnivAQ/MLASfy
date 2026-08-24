package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Artista {
    private String nomeArte;
    private String biografia;
    private Genere generePrincipale;
    private List<Album> discografia;

    public Artista(String nomeArte, String biografia, Genere generePrincipale) {
        this.nomeArte = nomeArte;
        this.biografia = biografia;
        this.generePrincipale = generePrincipale;
        this.discografia = new ArrayList<>();
    }

    public String getNomeArte() {
        return nomeArte;
    }

    public void setNomeArte(String nomeArte) {
        this.nomeArte = nomeArte;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Genere getGenerePrincipale() {
        return generePrincipale;
    }

    public void setGenerePrincipale(Genere generePrincipale) {
        this.generePrincipale = generePrincipale;
    }

    public List<Album> getDiscografia() {
        return discografia;
    }

    public void aggiungiAlbum(Album album) {
        this.discografia.add(album);
    }
}