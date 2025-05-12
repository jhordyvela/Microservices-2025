package upeu.edu.pe.colportores_crud.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import upeu.edu.pe.colportores_crud.entities.Stock;
import upeu.edu.pe.colportores_crud.repository.StockRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void registrarMovimiento(Stock stock) {
        // Obtener el balance anterior del último movimiento
        Integer ultimoBalance = stockRepository.findAll().stream()
                .filter(s -> s.getLibro().getId().equals(stock.getLibro().getId()))
                .map(Stock::getBalance)
                .reduce((first, second) -> second) // obtener el último
                .orElse(0);

        // Calcular nuevo balance
        int nuevoBalance = ultimoBalance + stock.getEntradas() - stock.getSalidas();
        stock.setBalance(nuevoBalance);

        // Guardar movimiento
        stockRepository.save(stock);
    }
}
