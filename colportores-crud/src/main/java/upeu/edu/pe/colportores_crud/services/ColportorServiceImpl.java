package upeu.edu.pe.colportores_crud.services;


import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import upeu.edu.pe.colportores_crud.entities.Colportor;
import upeu.edu.pe.colportores_crud.repository.ColportorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ColportorServiceImpl implements ColportorService {

    private final ColportorRepository colportorRepository;

    public ColportorServiceImpl(ColportorRepository colportorRepository) {
        this.colportorRepository = colportorRepository;
    }

    @Override
    public Colportor create(Colportor colportor) {
        return colportorRepository.save(colportor);
    }

    @Override
    public Colportor readById(Long id) {
        Optional<Colportor> result = colportorRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Colportor> readAll() {
        return colportorRepository.findAll();
    }

    @Override
    public Colportor update(Long id, Colportor colportor) {
        if (colportorRepository.existsById(id)) {
            colportor.setId(id);
            return colportorRepository.save(colportor);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        colportorRepository.deleteById(id);
    }
}