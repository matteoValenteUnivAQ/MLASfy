package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Rappresenta un utente ascoltatore della piattaforma UnivaqSound.
 * Mantiene le informazioni anagrafiche, la lista delle playlist create,
 * la cronologia degli ascolti e le preferenze musicali (generi preferiti).
 */
public class Utente {

    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private List<Playlist> playlist;
    private List<Genere> preferenzeMusicali;

    // Costruttore completo
    public Utente(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = Objects.requireNonNull(nome, "Il nome non può essere nullo");
        this.cognome = Objects.requireNonNull(cognome, "Il cognome non può essere nullo");
        this.email = email;
        this.dataNascita = Objects.requireNonNull(dataNascita, "La data di nascita non può essere nulla");
        this.playlist = new ArrayList<>();
        this.preferenzeMusicali = new ArrayList<>();
    }

    

    //Gestione Playlist

    public void creaPlaylist(Playlist nuovaPlaylist) {
        if (nuovaPlaylist != null && !this.playlist.contains(nuovaPlaylist)) {
            this.playlist.add(nuovaPlaylist);
        } //else con eccezzione
    }

    public boolean rimuoviPlaylist(Playlist playlistDaRimuovere) {
        return this.playlist.remove(playlistDaRimuovere);
    }

   

    

    //Gestione Preferenze Musicali

    public void aggiungiGenerePreferito(Genere genere) {
        if (genere != null && !this.preferenzeMusicali.contains(genere)) {
            this.preferenzeMusicali.add(genere);
        }
    }

    public boolean rimuoviGenerePreferito(Genere genere) {
        return this.preferenzeMusicali.remove(genere);
    }

    

    // Getter e Setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public List<Playlist> getPlaylist() {
        return Collections.unmodifiableList(playlist);
    }



    public List<Genere> getPreferenzeMusicali() {
        return Collections.unmodifiableList(preferenzeMusicali);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(email, utente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}