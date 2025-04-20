package upeu.edu.pe.colportores_crud.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import upeu.edu.pe.colportores_crud.entities.Colportor;
import upeu.edu.pe.colportores_crud.entities.Libro;
import upeu.edu.pe.colportores_crud.repository.ColportorRepository;
import upeu.edu.pe.colportores_crud.repository.LibroRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;

    }

    @Override
    public Libro create(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro readById(Long id) {
        Optional<Libro> result = libroRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Libro> readAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro update(Long id, Libro libro) {
        if (libroRepository.existsById(id)) {
            libro.setId(id);
            return libroRepository.save(libro);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
       libroRepository.deleteById(id);
    }
}


