package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import service.Ricercabile;
import service.Riproducibile;

/**
 * Rappresenta una playlist creata da un utente.
 * Implementa Riproducibile per la durata totale e Ricercabile per la ricerca testuale.
 */
public class Playlist implements Riproducibile, Ricercabile {

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

    public boolean rimuoviBrano(Brano brano) {
        return this.braniPlaylist.remove(brano);
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
    public void play() {
        // Logica di avvio della riproduzione della playlist
        System.out.println("Riproduzione della playlist: " + nomePlaylist);
    }

    @Override
    public void pause() {
        System.out.println("Playlist in pausa: " + nomePlaylist);
    }

    @Override
    public int getDurataTotale() {
        // Uso degli Stream per calcolare la durata totale in secondi della playlist
        return braniPlaylist.stream().mapToInt(Brano::getDurata).sum();
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
                ", durataTotale=" + getDurata() + "s" +
                '}';
    }
}