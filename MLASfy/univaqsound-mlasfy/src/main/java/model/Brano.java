package model;
import service.Ricercabile;
import service.Riproducibile;
import java.time.Duration;
import java.time.Instant;
import exceptions.ListaVuotaException;

public class Brano implements Riproducibile, Ricercabile {
    private String titolo;
    private Duration durata;
    private String testo;
    private Genere genere;
    private Album album;
    private Instant inizioRiproduzione; //istante di tempo di inizio della riproduzione del brano
    private Duration tempoAscoltoTotale = Duration.ZERO; //un brano appena creato non ha ancora avuto tempo di ascolto, quindi inizializziamo a zero
    private long numeroAscolti = 0;//un brano appena creato non ha ancora avuto ascolti, quindi inizializziamo a zero

    public Brano(String titolo, long durataInSecondi, String testo, Genere genere, Album album)throws ListaVuotaException {
        this.titolo = titolo;
        this.durata = Duration.ofSeconds(durataInSecondi);
        this.testo = testo;
        this.genere = genere;
        if(album == null){
            throw new ListaVuotaException("L'album non può essere nullo per un brano.");
        }
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

    public Duration getDurata() { return this.durata; }
    public void setDurata(Duration durata) { this.durata = durata; }

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
    //Per la classe PlayerBarController in metodo caricaBrano()
    public String getDurataFormattata() {
        long minuti = durata.toMinutes();
        long secondi = durata.toSecondsPart(); // Prende i secondi rimanenti oltre i minuti
        return String.format("%02d:%02d", minuti, secondi);
    }

    @Override
    public void pause() {
        System.out.println("Brano in pausa: " + this.titolo);

        if(this.inizioRiproduzione!=null){
            Duration durataAscoltata = Duration.between(this.inizioRiproduzione, Instant.now());
            this.tempoAscoltoTotale = this.tempoAscoltoTotale.plus(durataAscoltata);
            //Faccio incrementare il numero di ascolti solo se il brano è stato ascoltato per almeno metà della sua durata
            if(durataAscoltata.getSeconds()>=this.durata.toSeconds()/2){
                incrementaNumeroAscolti();
            }
            this.inizioRiproduzione = null;
        }else{
            //eccezione brano non in play()
        }
    }

    

    @Override
    public long getDurataTotale() {
        return this.durata.toSeconds();
    }

    // da rivedere per BranoNonTRoavtoException
    @Override
    public boolean corrispondeA(String query) {
        String q = query.toLowerCase();
        return titolo.toLowerCase().contains(q) || 
               album.getTitolo().toLowerCase().contains(q) || 
               album.getArtista().getNomeArte().toLowerCase().contains(q);
    }
}