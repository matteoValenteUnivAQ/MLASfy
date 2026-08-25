package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import service.CodaDiRiproduzioneService;
import service.Riproducibile;
public class CodaDiRiproduzione implements CodaDiRiproduzioneService,Riproducibile {
    public enum ModalitaRepeat{
        NESSUNA,
        RIPETI_TUTTO,
        RIPETI_SINGOLO
    }

    private List<Brano> codaBrani;
    private List<Brano> braniOriginali;
    private int indiceCorrente;
    private ModalitaRepeat modalitaRepeat;
    private boolean modalitaShuffle;

    public CodaDiRiproduzione(List<Brano> braniIniziali) {
        this.braniOriginali = new ArrayList<>(braniIniziali);
        this.codaBrani = new ArrayList<>(braniIniziali);
        this.indiceCorrente = 0;
        this.modalitaRepeat = ModalitaRepeat.NESSUNA;
        this.modalitaShuffle = false;
    }

    //attiva e disattiva la modalità shuffle
    public void setShuffle(boolean attivo) {
        this.modalitaShuffle = attivo;
        Brano branoCorrente= getBranoCorrente();
        if (modalitaShuffle) {
            Collections.shuffle(codaBrani);
            //spostiamo il brano attuale all'inizio della coda per non interrompere la riproduzione
            if(branoCorrente!=null){
                codaBrani.remove(branoCorrente);
                codaBrani.add(0, branoCorrente);
                indiceCorrente = 0;
            }
        } else {
            //Ripristiniamo l'ordine originale ritrovando la posizione del brano corrente
            codaBrani = new ArrayList<>(braniOriginali);
            if(branoCorrente!=null){
                indiceCorrente = codaBrani.indexOf(branoCorrente);
            }
        }
    }

    //Logica per andare al Brano successivo
    public Brano prossimoBrano(){
        if(codaBrani.isEmpty()){
            return null;
        }

        //1.Caso repeat singolo: rimaniamo sullo stesso brano
        if(modalitaRepeat==ModalitaRepeat.RIPETI_SINGOLO){
        return getBranoCorrente();
        }

        if(indiceCorrente < codaBrani.size() - 1){
            indiceCorrente++;
        } else {
            //2.Caso repeat tutto: torniamo all'inizio
            if(modalitaRepeat==ModalitaRepeat.RIPETI_TUTTO){
                indiceCorrente=0;
            } else {
                //3.Caso nessun repeat: rimaniamo sull'ultimo brano
                return null;
            }
        }
        return getBranoCorrente();
    }

    public Brano getBranoCorrente(){
        if(codaBrani.isEmpty() || indiceCorrente<0 || indiceCorrente>=codaBrani.size()){
            return null;
        }
        return codaBrani.get(indiceCorrente);
    }

    public void setModalitaRepeat(ModalitaRepeat modalitaRepeat) {
        this.modalitaRepeat = modalitaRepeat;
    }

    public List<Brano> getCodaBrani() {
        return codaBrani;
    }

    public void setCodaBrani(List<Brano> codaBrani) {
        this.codaBrani = codaBrani;
    }

    public List<Brano> getBraniOriginali() {
        return braniOriginali;
    }

    public void setBraniOriginali(List<Brano> braniOriginali) {
        this.braniOriginali = braniOriginali;
    }

    public int getIndiceCorrente() {
        return indiceCorrente;
    }

    public void setIndiceCorrente(int indiceCorrente) {
        this.indiceCorrente = indiceCorrente;
    }

    public ModalitaRepeat getModalitaRepeat() {
        return modalitaRepeat;
    }

    public boolean isModalitaShuffle() {
        return modalitaShuffle;
    }

    public void setModalitaShuffle(boolean modalitaShuffle) {
        this.modalitaShuffle = modalitaShuffle;
    }
// --- Implementazione metodi di CodaDiRiproduzioneService ---

    @Override
    public void aggiungiBrano(Brano brano) {
        if (brano != null) {
            this.braniOriginali.add(brano);
            this.codaBrani.add(brano);
        }
    }

    @Override
    public Brano branoPrecedente() {
        if (codaBrani.isEmpty()) return null;

        if (indiceCorrente > 0) {
            indiceCorrente--;
        } else if (modalitaRepeat == ModalitaRepeat.RIPETI_TUTTO) {
            indiceCorrente = codaBrani.size() - 1;
        }
        return getBranoCorrente();
    }

    @Override
    public void toggleShuffle() {
        setShuffle(!this.modalitaShuffle);
    }

    @Override
    public void toggleRepeat() {
        // Ruota ciclicamente tra le 3 modalità
        switch (this.modalitaRepeat) {
            case NESSUNA:
                setModalitaRepeat(ModalitaRepeat.RIPETI_TUTTO);
                break;
            case RIPETI_TUTTO:
                setModalitaRepeat(ModalitaRepeat.RIPETI_SINGOLO);
                break;
            case RIPETI_SINGOLO:
                setModalitaRepeat(ModalitaRepeat.NESSUNA);
                break;
        }
    }

    public void play(){
            Brano branoCorrente=getBranoCorrente();
            if(branoCorrente!=null){
                //logica JavaFX per riprodurre il brano
                branoCorrente.play();
            }else{
                System.out.println("Nessun brano da riprodurre.");
            }
    }
    public void pause(){
        Brano branoCorrente=getBranoCorrente();
        if(branoCorrente!=null){
            //logica JavaFX per mettere in pausa il brano
            branoCorrente.pause();
        }else{
            System.out.println("Nessun brano da mettere in pausa.");
        }
    }
    public int getDurataTotale(){
        int durataTotale=0;
        for(Brano brano:codaBrani){
      durataTotale+=brano.getDurata();
        }
        return durataTotale;
    }

    
}
