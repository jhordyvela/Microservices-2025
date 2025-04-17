package upeu.edu.pe.colportores_crud.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.colportores_crud.entities.Colportor;
import upeu.edu.pe.colportores_crud.services.ColportorService;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "colportores")
@Tag(name = "colportores resource")
public class ColportoresController {
    private final ColportorService colportorService;
    private final Logger log = LoggerFactory.getLogger(ColportoresController.class);

    public ColportoresController(ColportorService colportorService) {
        this.colportorService = colportorService;
    }

    @Operation(summary = "Obtener un colportor dado su ID")
    @GetMapping(path = "{id}")
    public ResponseEntity<Colportor> get(@PathVariable Long id) {
        log.info("GET: colportor id={}", id);
        Colportor colportor = this.colportorService.readById(id);
        return colportor != null ? ResponseEntity.ok(colportor) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Guardar un nuevo colportor")
    @PostMapping
    public ResponseEntity<Colportor> post(@RequestBody Colportor colportor) {
        log.info("POST: colportor {}", colportor.getNombre());
        Colportor created = this.colportorService.create(colportor);
        return ResponseEntity.created(URI.create("colportores/" + created.getId())).body(created);
    }

    @Operation(summary = "Actualizar un colportor existente dado su ID")
    @PutMapping(path = "{id}")
    public ResponseEntity<Colportor> put(@RequestBody Colportor colportor, @PathVariable Long id) {
        log.info("PUT: company {}", id);
        return ResponseEntity.ok(this.colportorService.update(id,colportor));
    }

    @Operation(summary = "Eliminar un colportor dado su ID")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE: colportor id={}", id);
        this.colportorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Listar todos los colportores")
    @GetMapping
    public ResponseEntity<List<Colportor>> getAll() {
        log.info("GET: todos los colportores");
        return ResponseEntity.ok(this.colportorService.readAll());
    }
}







