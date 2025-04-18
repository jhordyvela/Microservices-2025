package upeu.edu.pe.colportores_crud.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import upeu.edu.pe.colportores_crud.entities.Libro;
import upeu.edu.pe.colportores_crud.repository.ColportorRepository;
import upeu.edu.pe.colportores_crud.repository.LibroRepository;

import java.util.List;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;

    }

    @Override
    public Libro create(Libro libro) {
        return LibroRepository;
    }

    @Override
    public List<Libro> readAll() {
        return List.of();
    }

    @Override
    public Libro update(Long id, Libro libro) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}


