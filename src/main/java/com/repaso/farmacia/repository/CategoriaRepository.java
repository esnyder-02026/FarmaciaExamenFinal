package com.repaso.farmacia.repository;

import com.repaso.farmacia.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Endpoint 1: Devuelve categorías activas (7 filas)
    List<Categoria> findByEstadoTrue();
}