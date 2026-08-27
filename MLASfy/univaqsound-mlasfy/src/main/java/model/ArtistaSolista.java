package model;

public class ArtistaSolista extends Artista {
    private String nomeAnagrafico;

    public ArtistaSolista(String nomeArte, String biografia, Genere generePrincipale, String nomeAnagrafico) {
        super(nomeArte, biografia, generePrincipale);
        this.nomeAnagrafico = nomeAnagrafico;
    }

    public String getNomeAnagrafico() {
        return nomeAnagrafico;
    }

    public void setNomeAnagrafico(String nomeAnagrafico) {
        this.nomeAnagrafico = nomeAnagrafico;
    }
    //da rivedere per eccezione ARtistaNonTrovatoException
    public boolean corrispondeA(String query){
        return getNomeArte().toLowerCase().contains(query.toLowerCase()) || nomeAnagrafico.toLowerCase().contains(query.toLowerCase());

    }
}