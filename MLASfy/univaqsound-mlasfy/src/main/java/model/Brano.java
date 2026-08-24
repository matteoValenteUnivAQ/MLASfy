package model;
import service.Ricercabile;
import service.Riproducibile;
// Assicurati di creare poi le interfacce Riproducibile e Ricercabile nel package opportuno
public class Brano implements Riproducibile, Ricercabile {
    private String titolo;
    private int durata; // Espresso in secondi
    private String testo;
    private Genere genere;
    private Album album;

    public Brano(String titolo, int durata, String testo, Genere genere, Album album) {
        this.titolo = titolo;
        this.durata = durata;
        this.testo = testo;
        this.genere = genere;
        this.album = album;
        album.aggiungiBrano(this);
    }

    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }

    public int getDurata() { return durata; }
    public void setDurata(int durata) { this.durata = durata; }

    public String getTesto() { return testo; }
    public void setTesto(String testo) { this.testo = testo; }

    public Genere getGenere() { return genere; }
    public void setGenere(Genere genere) { this.genere = genere; }

    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }

    //Implementazione di Riproducibile 
    @Override
    public void play() {
        // Logica simulata di riproduzione del singolo brano
        System.out.println("Riproduzione in corso: " + titolo + " - " + album.getArtista().getNomeArte());
    }

    @Override
    public void pause() {
        System.out.println("Brano in pausa: " + titolo);
    }

    

    @Override
    public int getDurataTotale() {
        return this.durata;
    }

    //Implementazione di Ricercabile
    @Override
    public boolean corrispondeA(String query) {
        String q = query.toLowerCase();
        return titolo.toLowerCase().contains(q) || 
               album.getTitolo().toLowerCase().contains(q) || 
               album.getArtista().getNomeArte().toLowerCase().contains(q);
    }
}