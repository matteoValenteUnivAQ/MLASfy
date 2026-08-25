package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import service.CatalogoService;

public class Catalogo<T> implements CatalogoService {
    private List<T> elementi;

    public Catalogo() {
        this.elementi = new ArrayList<>();
    }

    public void aggiungi(T elemento) {
        this.elementi.add(elemento);
    }

    public void rimuovi(T elemento) {
        this.elementi.remove(elemento);
    }

    public List<T> getElementi() {
        return elementi;
    }

    // Filtra gli elementi del catalogo usando le lambda espressioni
    public List<T> cerca(Predicate<T> criterio) {
        return elementi.stream()
                       .filter(criterio)
                       .collect(Collectors.toList());
    }
}