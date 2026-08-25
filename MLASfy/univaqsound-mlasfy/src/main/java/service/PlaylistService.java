package service;

import model.Brano;


public interface PlaylistService {
    public void aggiungiBrano(Brano brano);
    public boolean rimuoviBrano(Brano brano);
    public void dragDrop();
}