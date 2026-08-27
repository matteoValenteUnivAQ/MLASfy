package service;
import exceptions.BranoNonTrovatoException;
import exceptions.ListaVuotaException;
public interface Riproducibile {
    public void play() throws BranoNonTrovatoException;
    public void pause()throws BranoNonTrovatoException;
    public long getDurataTotale() throws ListaVuotaException;
}