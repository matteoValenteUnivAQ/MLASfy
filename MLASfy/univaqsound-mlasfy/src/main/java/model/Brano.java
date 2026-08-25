package model;
import service.Ricercabile;
import service.Riproducibile;
import java.time.Duration;
import java.time.Instant;

public class Brano implements Riproducibile, Ricercabile {
    private String titolo;
    private int durata; // Espresso in secondi
    private String testo;
    private Genere genere;
    private Album album;
    private Instant inizioRiproduzione; //istante di tempo di inizio della riproduzione del brano
    private Duration tempoAscoltoTotale = Duration.ZERO; //un brano appena creato non ha ancora avuto tempo di ascolto, quindi inizializziamo a zero
    private long numeroAscolti = 0;//un brano appena creato non ha ancora avuto ascolti, quindi inizializziamo a zero

    public Brano(String titolo, int durata, String testo, Genere genere, Album album) {
        this.titolo = titolo;
        this.durata = durata;
        this.testo = testo;
        this.genere = genere;
        this.album = album;
        album.aggiungiBrano(this);
    }

    public Instant getInizioRiproduzione() { return inizioRiproduzione; }
    public void setInizioRiproduzione(Instant inizioRiproduzione) { this.inizioRiproduzione = inizioRiproduzione; }

    public Duration getTempoAscoltoTotale() { return tempoAscoltoTotale; }
    public void setTempoAscoltoTotale(Duration tempoAscoltoTotale) { this.tempoAscoltoTotale = tempoAscoltoTotale; }

    public long getNumeroAscolti() { return numeroAscolti; }
    public void incrementaNumeroAscolti() { this.numeroAscolti++; }

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
 //Logica simulata di riproduzione del singolo brano
System.out.println("Riproduzione in corso: " + titolo + " - " + album.getArtista().getNomeArte());
    //inizio della riproduzione del brano, memorizzo l'istante di tempo in cui è iniziata la riproduzione
    this.inizioRiproduzione=Instant.now();
    
    }

    @Override
    public void pause() {
        System.out.println("Brano in pausa: " + this.titolo);

        if(this.inizioRiproduzione!=null){
            Duration durataAscoltata = Duration.between(this.inizioRiproduzione, Instant.now());
            this.tempoAscoltoTotale = this.tempoAscoltoTotale.plus(durataAscoltata);
            //Faccio incrementare il numero di ascolti solo se il brano è stato ascoltato per almeno metà della sua durata
            if(durataAscoltata.getSeconds()>=this.durata/2){
                incrementaNumeroAscolti();
            }
            this.inizioRiproduzione = null;
        }else{
            //eccezione brano non in play()
        }
    }

    

    @Override
    public int getDurataTotale() {
        return this.durata;
    }

    //Implementazione di Ricercabile, da rivedere
    @Override
    public boolean corrispondeA(String query) {
        String q = query.toLowerCase();
        return titolo.toLowerCase().contains(q) || 
               album.getTitolo().toLowerCase().contains(q) || 
               album.getArtista().getNomeArte().toLowerCase().contains(q);
    }
}