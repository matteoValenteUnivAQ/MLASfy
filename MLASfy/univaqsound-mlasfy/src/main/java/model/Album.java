package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import exceptions.ListaVuotaException;

public class Album  {
    private String titolo;
    private Artista artista;
    private LocalDate dataPubblicazione; // Gestito come data 
    private Genere genere;
    private String copertina; // Percorso del file immagine
    private List<Brano> brani;

    public Album(String titolo, Artista artista, LocalDate dataPubblicazione, Genere genere, String copertina) {
        this.titolo = titolo;
        this.artista = artista;
        this.dataPubblicazione= dataPubblicazione;
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

    public LocalDate getDataPubblicazione() { return this.dataPubblicazione; }
    public void setDataPubblicazione(LocalDate dataPubblicazione) { this.dataPubblicazione = dataPubblicazione; }

    public Genere getGenere() { return genere; }
    public void setGenere(Genere genere) { this.genere=genere; }

    public String getCopertina() { return copertina; }
    public void setCopertina(String copertina) { this.copertina = copertina; }

    public List<Brano> getBrani() { return brani; }
    public void setBrani(List<Brano> brani){this.brani=brani;}

    public LocalDate getdataPubblicazione(){return this.dataPubblicazione;}
    

    public void aggiungiBrano(Brano brano) {
        this.brani.add(brano);
    }

    // Calcola la durata complessiva sommando la durata dei singoli brani (utile per le statistiche o viste dettagliate)
    public int getDurataTotale()throws ListaVuotaException {
        if(brani.isEmpty()){
            throw new ListaVuotaException("L'album non contiene brani.");
        }
        return brani.stream().mapToInt(brano -> Math.toIntExact(brano.getDurata().toSeconds())).sum();
    }
}