package upeu.edu.pe.colportores_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.colportores_crud.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
