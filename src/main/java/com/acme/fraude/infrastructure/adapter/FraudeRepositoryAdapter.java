package com.acme.fraude.infrastructure.adapter;

import com.acme.fraude.adapter.outbound.ClienteMapper;
import com.acme.fraude.core.domain.cliente.ClienteDomain;
import com.acme.fraude.core.ports.FraudeRepositoryPort;
import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.cliente.ClienteEntity;
import com.acme.fraude.infrastructure.database.postgresql.apolice.repositories.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FraudeRepositoryAdapter implements FraudeRepositoryPort {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public FraudeRepositoryAdapter(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDomain listaByClienteId(UUID idCliente, UUID idApolice) {
        ClienteEntity entity = clienteRepository.findByClienteId(idCliente, idApolice);
        ClienteDomain clienteDomain = clienteMapper.infraToDomain(entity);
        return clienteDomain;
    }
}
