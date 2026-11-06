package com.repaso.farmacia.controller;

import com.repaso.farmacia.dto.ClienteVentaDTO;
import com.repaso.farmacia.dto.ClienteVentaDetalleDTO;
import com.repaso.farmacia.service.ClienteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Endpoint 5: /clientes/reporteClienteVenta
    @GetMapping("/reporteClienteVenta")
    public List<ClienteVentaDTO> reporteClienteVenta() {
        return clienteService.reporteClienteVenta();
    }

    // Endpoint 6: /clientes/reporteClienteVentaDetalle
    @GetMapping("/reporteClienteVentaDetalle")
    public List<ClienteVentaDetalleDTO> reporteClienteVentaDetalle() {
        return clienteService.reporteClienteVentaDetalle();
    }
}

