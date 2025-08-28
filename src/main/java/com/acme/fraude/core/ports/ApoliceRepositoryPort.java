package com.acme.fraude.core.ports;

import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import com.acme.fraude.infrastructure.database.postgresql.apolice.projection.ApoliceConsultaProjection;

import java.util.UUID;

public interface ApoliceRepositoryPort {

    ApoliceEntity save(ApoliceEntity apoliceEntity);
    ApoliceConsultaProjection listaApolice(UUID id);
}
