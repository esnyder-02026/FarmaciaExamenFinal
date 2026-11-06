package com.repaso.farmacia.controller;

import com.repaso.farmacia.dto.CategoriaDTO;
import com.repaso.farmacia.service.CategoriaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Endpoint 1: /categorias/mostrarActivos
    @GetMapping("/mostrarActivos")
    public List<CategoriaDTO> mostrarActivos() {
        return categoriaService.mostrarActivos();
    }
}