package upeu.edu.pe.colportores_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.colportores_crud.entities.Colportor;

public interface ColportorRepository extends JpaRepository<Colportor, Long> {
}
