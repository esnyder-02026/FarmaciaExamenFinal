package com.repaso.farmacia.service;

import com.repaso.farmacia.dto.MedicamentoCategoriaDTO;
import com.repaso.farmacia.entity.Medicamento;
import com.repaso.farmacia.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<Medicamento> mostrarActivosFiltro(String nombre) {
    return medicamentoRepository.buscarPorNombreActivo(nombre);
}

    public List<MedicamentoCategoriaDTO> reporteMedicamentoCategoria() {
        return medicamentoRepository.obtenerReporteMedicamentoCategoria();
    }

    public List<Medicamento> stockBajo(Integer cantidad) {
        return medicamentoRepository.findByEstadoTrueAndStockLessThanOrderByStockAsc(cantidad);
    }
}
