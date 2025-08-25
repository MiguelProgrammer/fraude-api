package com.acme.apolice.core.ports;

import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;

public interface ApoliceRepositoryPort {

    ApoliceEntity save(ApoliceEntity apoliceEntity);
}
