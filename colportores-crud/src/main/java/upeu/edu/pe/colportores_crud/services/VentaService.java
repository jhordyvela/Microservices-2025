package upeu.edu.pe.colportores_crud.services;

import upeu.edu.pe.colportores_crud.entities.Venta;

public interface VentaService {
    Venta create(Venta venta);
    Venta getById(Long id);
    Venta update(Long id, Venta venta);
    void delete(Long id);
}
