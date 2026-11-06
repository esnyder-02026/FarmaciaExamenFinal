package com.repaso.farmacia.service;

import com.repaso.farmacia.dto.ClienteVentaDTO;
import com.repaso.farmacia.dto.ClienteVentaDetalleDTO;
import com.repaso.farmacia.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteVentaDTO> reporteClienteVenta() {
        return clienteRepository.obtenerReporteClienteVenta();
    }

    public List<ClienteVentaDetalleDTO> reporteClienteVentaDetalle() {
        return clienteRepository.obtenerReporteClienteVentaDetalle();
    }
}
