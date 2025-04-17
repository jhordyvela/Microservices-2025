package upeu.edu.pe.colportores_crud.services;

import upeu.edu.pe.colportores_crud.entities.Colportor;

import java.util.List;

public interface ColportorService {
        Colportor create(Colportor colportor);
        Colportor readById(Long id);
        List<Colportor> readAll();
        Colportor update(Long id, Colportor colportor);
        void delete(Long id);
    }

