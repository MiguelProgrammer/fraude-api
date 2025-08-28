package com.acme.fraude.core.usecase;

import com.acme.fraude.adapter.inbound.AnaliseFraudeRequest;
import com.acme.fraude.adapter.inbound.AnaliseFraudeResponse;
import com.acme.fraude.adapter.outbound.ClienteMapper;
import com.acme.fraude.core.domain.cliente.ClienteDomain;
import com.acme.fraude.core.ports.FraudeRepositoryPort;

public class ConsultaFraudeUseCase {

    private final ClienteMapper clienteMapper;
    private final FraudeRepositoryPort fraudeRepositoryPort;

    public ConsultaFraudeUseCase(ClienteMapper clienteMapper, FraudeRepositoryPort fraudeRepositoryPort) {
        this.clienteMapper = clienteMapper;
        this.fraudeRepositoryPort = fraudeRepositoryPort;
    }

    public AnaliseFraudeResponse listaApolicePorCliente(AnaliseFraudeRequest request) {
        ClienteDomain domain = fraudeRepositoryPort.listaByClienteId(request.getClienteId(), request.getApoliceId());
        return clienteMapper.domainToResponse(domain);
    }
}
