package upeu.edu.pe.colportores_crud.services;

import upeu.edu.pe.colportores_crud.entities.Venta;

import java.util.List;

public interface VentaService {
    Venta create(Venta venta);
    Venta readById(Long id);
    List<Venta> readAll();
    Venta update(Long id, Venta venta);
    void delete(Long id);

}
