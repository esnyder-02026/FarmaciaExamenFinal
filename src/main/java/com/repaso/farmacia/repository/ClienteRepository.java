package com.repaso.farmacia.repository;

import com.repaso.farmacia.dto.ClienteVentaDTO;
import com.repaso.farmacia.dto.ClienteVentaDetalleDTO;
import com.repaso.farmacia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Endpoint 5: Reporte Cliente - Venta solo ventas activas, ordenado por fecha (22 filas)
    @Query("SELECT new com.repaso.farmacia.dto.ClienteVentaDTO(" +
           "c.nombre, c.apellido, v.fechaVenta, v.total) " +
           "FROM Venta v JOIN v.idCliente c " +
           "WHERE v.estado = true AND c.estado = true " +
           "ORDER BY v.fechaVenta ASC")
    List<ClienteVentaDTO> obtenerReporteClienteVenta();

    // Endpoint 6: Reporte Cliente - Venta Detalle uniendo VentaDetalle, Venta, Cliente y Medicamento (46 filas)
    @Query("SELECT new com.repaso.farmacia.dto.ClienteVentaDetalleDTO(" +
           "c.nombre, c.apellido, v.fechaVenta, m.nombre, vd.cantidad, vd.precioUnitario, vd.subtotal) " +
           "FROM VentaDetalle vd " +
           "JOIN vd.idVenta v " +
           "JOIN v.idCliente c " +
           "JOIN vd.idMedicamento m " +
           "WHERE v.estado = true AND c.estado = true AND m.estado = true")
    List<ClienteVentaDetalleDTO> obtenerReporteClienteVentaDetalle();
}