package upeu.edu.pe.colportores_crud.services;

import upeu.edu.pe.colportores_crud.entities.DetalleVenta;

import java.util.List;

public interface DetalleVentaService {
    DetalleVenta create (DetalleVenta detalleVenta);
    DetalleVenta readById (Long id);
    List<DetalleVenta> readAll();
    DetalleVenta update (Long id, DetalleVenta detalleVenta);
    void delete (long id);





}
