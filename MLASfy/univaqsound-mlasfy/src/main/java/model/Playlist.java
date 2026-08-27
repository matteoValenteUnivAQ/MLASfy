package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import service.Ricercabile;
import service.Riproducibile;
import service.PlaylistService;
import exceptions.BranoNonTrovatoException;

/**
 * Rappresenta una playlist creata da un utente.
 * Implementa Riproducibile per la durata totale e Ricercabile per la ricerca testuale.
 */
public class Playlist implements Riproducibile, Ricercabile,PlaylistService {

    private String nomePlaylist;
    private String descrizione;
    private LocalDate dataCreazione;
    private Utente creatorePlaylist;
    private List<Brano> braniPlaylist;

    // Costruttore completo
    public Playlist(String nomePlaylist, String descrizione, Utente creatorePlaylist) {
        this.nomePlaylist = Objects.requireNonNull(nomePlaylist, "Il nome della playlist non può essere nullo");
        this.descrizione = descrizione != null ? descrizione : "";
        this.creatorePlaylist = creatorePlaylist;
        this.dataCreazione = LocalDate.now();
        this.braniPlaylist = new ArrayList<>();
    }

    // --- Gestione dei Brani nella Playlist ---

    public void aggiungiBrano(Brano brano) {
        if (brano != null) {
            this.braniPlaylist.add(brano);
        }
    }

    public boolean rimuoviBrano(Brano brano)throws BranoNonTrovatoException {
        if(braniPlaylist.contains(brano)){
           return this.braniPlaylist.remove(brano);
            
        }
         throw new BranoNonTrovatoException("Il brano non è presente nella playlist");
    }

    public void spostaBrano(int indiceOrigine, int indiceDestinazione) {
        if (indiceOrigine >= 0 && indiceOrigine < braniPlaylist.size() &&
            indiceDestinazione >= 0 && indiceDestinazione < braniPlaylist.size()) {
            Brano brano = braniPlaylist.remove(indiceOrigine);
            braniPlaylist.add(indiceDestinazione, brano);
        }
    }

    // --- Implementazione dell'interfaccia Riproducibile ---

    @Override
    public void play()throws BranoNonTrovatoException {
        // Logica di avvio della riproduzione della playlist
        System.out.println("Riproduzione della playlist: " + nomePlaylist);
        CodaDiRiproduzione coda = new CodaDiRiproduzione(braniPlaylist);
        coda.play(); // Avvia la riproduzione della coda di riproduzione in baso
    }

    @Override
    public void pause() {
        System.out.println("Playlist in pausa: " + nomePlaylist);
    }

    @Override
    public long getDurataTotale() {
        
        return braniPlaylist.stream()
            .mapToLong(brano -> brano.getDurata().getSeconds())
            .sum();
    }

    // --- Implementazione dell'interfaccia Ricercabile ---

    @Override
    public boolean corrispondeA(String query) {
        if (query == null || query.isBlank()) {
            return false;
        }
        String q = query.toLowerCase();
        return (nomePlaylist != null && nomePlaylist.toLowerCase().contains(q)) ||
               (descrizione != null && descrizione.toLowerCase().contains(q));
    }

    // --- Getter e Setter ---

    public String getNomePlaylist() {
        return nomePlaylist;
    }

    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Utente getCreatorePlaylist() {
        return creatorePlaylist;
    }

    public void setCreatorePlaylist(Utente creatorePlaylist) {
        this.creatorePlaylist = creatorePlaylist;
    }

    public List<Brano> getBraniPlaylist() {
        // Restituisce una vista non modificabile per preservare l'incapsulamento
        return Collections.unmodifiableList(braniPlaylist);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "nome='" + nomePlaylist + '\'' +
                ", brani=" + braniPlaylist.size() +
                ", durataTotale=" + getDurataTotale() + "s" +
                '}';
    }

    public void dragDrop() {
        // Logica per il drag and drop dei brani nella playlist con JavaFX
        System.out.println("Drag and drop dei brani nella playlist: " + nomePlaylist);
    }
}