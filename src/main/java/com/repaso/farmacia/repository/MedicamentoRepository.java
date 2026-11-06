package com.repaso.farmacia.repository;

import com.repaso.farmacia.dto.MedicamentoCategoriaDTO;
import com.repaso.farmacia.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

    // Consulta explícita para evitar fallos de mapeo de minúsculas/mayúsculas
    @Query("SELECT m FROM Medicamento m WHERE m.estado = true AND LOWER(m.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Medicamento> buscarPorNombreActivo(@Param("nombre") String nombre);

    @Query("SELECT new com.repaso.farmacia.dto.MedicamentoCategoriaDTO(" +
           "m.nombre, m.laboratorio, c.nombre, m.precio, m.stock) " +
           "FROM Medicamento m JOIN m.idCategoria c " +
           "WHERE m.estado = true AND c.estado = true " +
           "ORDER BY c.nombre ASC, m.nombre ASC")
    List<MedicamentoCategoriaDTO> obtenerReporteMedicamentoCategoria();

    // Stock bajo
    List<Medicamento> findByEstadoTrueAndStockLessThanOrderByStockAsc(Integer cantidad);
}