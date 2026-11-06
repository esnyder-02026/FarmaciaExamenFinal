package com.repaso.farmacia.service;

import com.repaso.farmacia.dto.CategoriaDTO;
import com.repaso.farmacia.entity.Categoria;
import com.repaso.farmacia.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> mostrarActivos() {
        return categoriaRepository.findByEstadoTrue().stream()
                .map(c -> new CategoriaDTO(c.getIdCategoria(), c.getEstado(), c.getNombre(), c.getDescripcion()))
                .collect(Collectors.toList());
    }
}