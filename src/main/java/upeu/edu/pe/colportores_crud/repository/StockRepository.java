package upeu.edu.pe.colportores_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.colportores_crud.entities.Stock;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}