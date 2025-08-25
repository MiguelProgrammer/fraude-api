package com.acme.apolice.core.ports;

import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;

import java.util.Set;
import java.util.UUID;

public interface ApoliceRepositoryPort {

    ApoliceEntity save(ApoliceEntity apoliceEntity);

    Set<ApoliceEntity> listaApolice(UUID id);
}
