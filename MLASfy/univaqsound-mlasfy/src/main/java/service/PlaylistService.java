package service;

import model.Brano;

/**
 * TODO: update UML schema
 *
 * - rimuoviBrano
 * - Sort
 * */

public interface PlaylistService {
    void aggiungiBrano(Brando brano);
    void rimuoviBrano(Brano brano);
    void Sort();
    void dragDrop();
}