package upeu.edu.pe.colportores_crud.services;

import upeu.edu.pe.colportores_crud.entities.Libro;

public interface LibroService {
    Libro create(Libro libro);
    Libro getById(Long id);
    Libro update(Long id, Libro libro);
    void delete(Long id);

}
