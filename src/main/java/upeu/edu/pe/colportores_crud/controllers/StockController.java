package upeu.edu.pe.colportores_crud.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.colportores_crud.entities.Stock;
import upeu.edu.pe.colportores_crud.repository.StockRepository;
import upeu.edu.pe.colportores_crud.services.StockService;

import java.util.List;

@RestController
@RequestMapping("stocks")
public class StockController {

    private final StockService stockService;
    private final StockRepository stockRepository;
    private final Logger log = LoggerFactory.getLogger(StockController.class);

    public StockController(StockService stockService, StockRepository stockRepository) {
        this.stockService = stockService;
        this.stockRepository = stockRepository;
    }

    @Operation(summary = "Registrar un nuevo movimiento de stock")
    @PostMapping
    public ResponseEntity<?> registrarMovimiento(@RequestBody Stock stock) {
        log.info("POST: registrar movimiento de stock para libro ID={}", stock.getLibro().getId());
        stockService.registrarMovimiento(stock);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Listar todos los movimientos de stock")
    @GetMapping
    public ResponseEntity<List<Stock>> getAll() {
        log.info("GET: todos los movimientos de stock");
        return ResponseEntity.ok(stockRepository.findAll());
    }

    @Operation(summary = "Listar movimientos de stock por libro ID")
    @GetMapping("/libro/{libroId}")
    public ResponseEntity<List<Stock>> getByLibro(@PathVariable Long libroId) {
        log.info("GET: movimientos de stock para libro ID={}", libroId);
        List<Stock> lista = stockRepository.findAll().stream()
                .filter(s -> s.getLibro().getId().equals(libroId))
                .toList();

        return ResponseEntity.ok(lista);
    }
}