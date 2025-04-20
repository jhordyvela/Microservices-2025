package upeu.edu.pe.colportores_crud.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import upeu.edu.pe.colportores_crud.entities.DetalleVenta;
import upeu.edu.pe.colportores_crud.repository.DetalleVentaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetalleVentaServiceImpl implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }


    @Override
    public DetalleVenta create(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta readById(Long id) {
        Optional<DetalleVenta> result = detalleVentaRepository.findById(id);

        return result.orElse(null);
    }

    @Override
    public List<DetalleVenta> readAll() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta update(Long id, DetalleVenta detalleVenta) {
        if (detalleVentaRepository.existsById(id)){
            detalleVenta.setId(id);
            return detalleVentaRepository.save(detalleVenta);
        }
        return null;
    }

    @Override
    public void delete(long id){
        detalleVentaRepository.deleteById(id);
    }
}
