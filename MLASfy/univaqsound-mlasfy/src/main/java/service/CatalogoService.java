package service;

import java.util.List;
import java.util.function.Predicate;


public interface CatalogoService<T> {
    public void aggiungi(T elemento);
    public void rimuovi(T elemento);

    public List<T> cerca(Predicate<T> criterio);
    
}