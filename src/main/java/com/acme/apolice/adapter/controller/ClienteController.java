package com.acme.apolice.adapter.controller;

import com.acme.apolice.adapter.inbound.ApoliceConsulta;
import com.acme.apolice.core.usecase.ClienteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    public ResponseEntity<ApoliceConsulta> listaApolicePorCliente(UUID idCliente) {
        return ResponseEntity.ok(clienteUseCase.listaApolicePorCliente(idCliente));
    }
}
