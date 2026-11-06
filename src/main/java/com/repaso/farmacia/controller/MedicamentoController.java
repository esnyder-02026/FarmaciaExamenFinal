package com.repaso.farmacia.controller;

import com.repaso.farmacia.dto.MedicamentoCategoriaDTO;
import com.repaso.farmacia.entity.Medicamento;
import com.repaso.farmacia.service.MedicamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
@CrossOrigin(origins = "*")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    // Endpoint 2: /medicamentos/mostrarActivosFiltro?nombre=crema
    @GetMapping("/mostrarActivosFiltro")
public List<Medicamento> mostrarActivosFiltro(@RequestParam("nombre") String nombre) {
    return medicamentoService.mostrarActivosFiltro(nombre);
}

    // Endpoint 3: /medicamentos/reporteMedicamentoCategoria
    @GetMapping("/reporteMedicamentoCategoria")
    public List<MedicamentoCategoriaDTO> reporteMedicamentoCategoria() {
        return medicamentoService.reporteMedicamentoCategoria();
    }

    // Endpoint 4: /medicamentos/stockBajo?cantidad=10
    @GetMapping("/stockBajo")
    public List<Medicamento> stockBajo(@RequestParam(defaultValue = "10") Integer cantidad) {
        return medicamentoService.stockBajo(cantidad);
    }
}

