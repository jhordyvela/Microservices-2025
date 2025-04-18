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
import upeu.edu.pe.colportores_crud.entities.Colportor;
import upeu.edu.pe.colportores_crud.entities.Libro;
import upeu.edu.pe.colportores_crud.services.ColportorService;
import upeu.edu.pe.colportores_crud.services.LibroService;

@RestController
@RequestMapping
@Tag(name = "libros resource")
public class LibroController {
    private final LibroService libroService;
    private final Logger log = LoggerFactory.getLogger(LibroController.class);
    public LibroController(LibroService libroService) {
        this.libroService = libroService;


    }
    @Operation(summary = "Obtener un libro dado su ID")
    @GetMapping(path = "{id}")
    public ResponseEntity<Libro> get(@PathVariable Long id) {
        log.info("GET: libro id={}", id);
        Libro libro = this.libroService.;
        return libro != null ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }
}
