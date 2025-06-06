package upeu.edu.pe.colportores_crud.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import upeu.edu.pe.colportores_crud.entities.Venta;
import upeu.edu.pe.colportores_crud.repository.VentaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VentaServiceImpl implements VentaService{
    private final VentaRepository ventaRepository;


    /// afdasdas///
    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public Venta create(Venta venta) {
        return ventaRepository.save(venta);
    }


    @Override
    public Venta readById(Long id) {
        Optional<Venta> result = ventaRepository.findById(id);
        return result.orElse(null);
    }



    @Override

    public List<Venta> readAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta update(Long id, Venta venta) {
        if (ventaRepository.existsById(id)){
            venta.setId(id);
            return ventaRepository.save(venta);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        ventaRepository.deleteById(id);

    }
//cambie en el repository el colportor por venta//



}
