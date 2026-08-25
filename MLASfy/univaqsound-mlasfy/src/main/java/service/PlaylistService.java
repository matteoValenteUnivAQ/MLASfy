package service;

import model.Brano;
import exceptions.BranoNonTrovatoException;


public interface PlaylistService {
    public void aggiungiBrano(Brano brano);
    public boolean rimuoviBrano(Brano brano)throws BranoNonTrovatoException;
    public void dragDrop();
}