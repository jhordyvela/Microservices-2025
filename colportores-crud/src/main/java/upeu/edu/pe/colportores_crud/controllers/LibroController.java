package upeu.edu.pe.colportores_crud.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.colportores_crud.entities.Colportor;
import upeu.edu.pe.colportores_crud.entities.Libro;
import upeu.edu.pe.colportores_crud.services.ColportorService;
import upeu.edu.pe.colportores_crud.services.LibroService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "libros")
@Tag(name = "libros resource")
public class LibroController {
    private final LibroService libroService;
    private final Logger log = LoggerFactory.getLogger(LibroController.class);
    public LibroController(LibroService libroService) {
        this.libroService = libroService;


    }
    @Operation(summary = "Obtener un libro dado su ID")
    @GetMapping(path = "{id}")
    public ResponseEntity<Libro>get(@PathVariable Long id){
        log.info("GET: libro id={}", id);
        Libro libro = this.libroService.readById(id);
        return libro != null ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }
    @Operation(summary = "Guardar un nuevo libro")
    @PostMapping
    public ResponseEntity<Libro> post(@RequestBody Libro libro) {
        log.info("POST: libro {}", libro.getId());
        Libro created = this.libroService.create(libro);
        return ResponseEntity.created(URI.create("libros/" + created.getId())).body(created);
    }


    @Operation(summary = "Actualizar un libro existente dado su ID")
    @PutMapping(path = "{id}")
    public ResponseEntity<Libro> put(@RequestBody Libro libro, @PathVariable Long id) {
        log.info("PUT: libro {}", id);
        return ResponseEntity.ok(this.libroService.update(id,libro));
    }
    @Operation(summary = "Eliminar un libro dado su ID")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE: libro id={}", id);
        this.libroService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Listar todos los libros")
    @GetMapping
    public ResponseEntity<List<Libro>> getAll() {
        log.info("GET: todos los libros");
        return ResponseEntity.ok(this.libroService.readAll());
    }

}
