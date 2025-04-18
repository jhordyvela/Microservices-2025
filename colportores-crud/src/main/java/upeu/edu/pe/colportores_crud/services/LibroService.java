package upeu.edu.pe.colportores_crud.services;

import upeu.edu.pe.colportores_crud.entities.Colportor;
import upeu.edu.pe.colportores_crud.entities.Libro;

import java.util.List;

public interface LibroService {
    Libro create(Libro libro);
    List<Libro> readAll();
    Libro update(Long id, Libro libro);
    void delete(Long id);

}
