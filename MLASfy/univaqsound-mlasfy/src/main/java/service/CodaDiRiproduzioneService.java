package service;

import model.Brano;
import model.CodaDiRiproduzione.ModalitaRepeat;
import exceptions.ListaVuotaException;
public interface CodaDiRiproduzioneService {
    
    void aggiungiBrano(Brano brano);
    Brano prossimoBrano()throws ListaVuotaException;
    Brano branoPrecedente();
    Brano getBranoCorrente();
    
    void setShuffle(boolean attivo);
    void toggleShuffle();
    
    void setModalitaRepeat(ModalitaRepeat modalita);
    void toggleRepeat();
}