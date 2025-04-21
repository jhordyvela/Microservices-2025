package upeu.edu.pe.colportores_crud.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upeu.edu.pe.colportores_crud.entities.DetalleVenta;
import upeu.edu.pe.colportores_crud.entities.Venta;
import upeu.edu.pe.colportores_crud.services.DetalleVentaService;

@RestController
@RequestMapping(path = "Detalle ventas")
@Tag(name = "Detalleventas resource")
public class DetalleVentaController {
    /// el Logger es para imprimir un mensaje///
    private final DetalleVentaService detalleVentaService;
    private final Logger log = (Logger) LoggerFactory.getLogger(DetalleVentaController.class);

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @Operation(summary = "obtener un detalle de una venta dado su ID")
    @GetMapping(path = "{id}")
    public ResponseEntity<DetalleVenta> get(@PathVariable long id){
        log.info("GET: detalle venta id={}", id);
        DetalleVenta detalleVenta = this.detalleVentaService.readById(id);
        return detalleVenta != null ? ResponseEntity.ok(detalleVenta) : ResponseEntity.notFound().build();

    }



}
