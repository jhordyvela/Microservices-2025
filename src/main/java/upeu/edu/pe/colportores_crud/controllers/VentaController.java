package upeu.edu.pe.colportores_crud.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.colportores_crud.entities.Venta;
import upeu.edu.pe.colportores_crud.services.VentaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "ventas")
@Tag(name = "ventas resource")
public class VentaController {
    private final VentaService ventaService;
    private final Logger log = (Logger) LoggerFactory.getLogger(VentaController.class);

    //
    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @Operation(summary = "obtener una venta dado su ID")
    @GetMapping(path = "{id}")
    public ResponseEntity<Venta>get(@PathVariable long id){
        log.info("GET: venta id={}", id);
        Venta venta = this.ventaService.readById(id);
        return venta != null ? ResponseEntity.ok(venta) : ResponseEntity.notFound().build();

    }

    @Operation(summary = "Guardar una venta")
    @PostMapping
    public ResponseEntity<Venta>Post(@RequestBody Venta venta){
        log.info("POST: venta {}", venta.getId());
        Venta created = this.ventaService.create(venta);
        return ResponseEntity.created(URI.create("ventas/" + created.getId())).body(created);

    }
    @Operation(summary = "Actualizar un libro existente dado su ID")
    @PutMapping(path = "{id}")
    public ResponseEntity<Venta> put(@RequestBody Venta venta, @PathVariable Long id) {
        log.info("PUT: venta {}", id);
        return ResponseEntity.ok(this.ventaService.update(id, venta));
    }
    @Operation(summary = "Eliminar un venta dado su ID")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE: venta id={}", id);
        this.ventaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Listar todas las ventas")
    @GetMapping
    public ResponseEntity<List<Venta>> getAll() {
        log.info("GET: todas las ventas ");
        return ResponseEntity.ok(this.ventaService.readAll());
    }

}
