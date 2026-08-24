package service;

import model.Brano;
import model.CodaDiRiproduzione.ModalitaRepeat;

public interface CodaDiRiproduzioneService {
    
    void aggiungiBrano(Brano brano);
    Brano prossimoBrano();
    Brano branoPrecedente();
    Brano getBranoCorrente();
    
    void setShuffle(boolean attivo);
    void toggleShuffle();
    
    void setModalitaRepeat(ModalitaRepeat modalita);
    void toggleRepeat();
}