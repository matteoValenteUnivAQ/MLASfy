package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
    private String titolo;
    private Artista artista;
    private Date annoPubblicazione; // Gestito come data o intero 
    private Genere genere;
    private String copertina; // Percorso del file immagine
    private List<Brano> brani;

    public Album(String titolo, Artista artista, Date annoPubblicazione, Genere genere, String copertina) {
        this.titolo = titolo;
        this.artista = artista;
        this.annoPubblicazione = annoPubblicazione;
        this.genere = genere;
        this.copertina = copertina;
        this.brani = new ArrayList<>();
        
        // Mantiene sincronizzata la discografia dell'artista
        artista.aggiungiAlbum(this);
    }

    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }

    public Artista getArtista() { return artista; }
    public void setArtista(Artista artista) { this.artista = artista; }

    public Date getAnnoPubblicazione() { return annoPubblicazione; }
    public void setAnnoPubblicazione(Date annoPubblicazione) { this.annoPubblicazione = annoPubblicazione; }

    public Genere getGenere() { return genere; }
    public void setGenere(Genere genere) { this.genere=genere; }

    public String getCopertina() { return copertina; }
    public void setCopertina(String copertina) { this.copertina = copertina; }

    public List<Brano> getBrani() { return brani; }

    public void aggiungiBrano(Brano brano) {
        this.brani.add(brano);
    }

    // Calcola la durata complessiva sommando la durata dei singoli brani (utile per le statistiche o viste dettagliate)
    public int getDurataTotale() {
        return brani.stream().mapToInt(Brano::getDurata).sum();
    }
}