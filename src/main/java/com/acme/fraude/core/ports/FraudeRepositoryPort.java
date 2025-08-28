package com.acme.fraude.core.ports;

import com.acme.fraude.core.domain.cliente.ClienteDomain;

import java.util.UUID;

public interface FraudeRepositoryPort {

    ClienteDomain listaByClienteId(UUID idCliente, UUID apoliceId);
}
