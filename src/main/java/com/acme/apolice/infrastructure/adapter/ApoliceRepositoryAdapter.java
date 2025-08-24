package com.acme.apolice.infrastructure.adapter;

import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.repositories.ApoliceRepository;
import org.springframework.stereotype.Component;

@Component
public class ApoliceRepositoryAdapter implements ApoliceRepositoryPort {

    private final ApoliceRepository apoliceRepository;

    public ApoliceRepositoryAdapter(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }

    @Override
    public ApoliceEntity save(ApoliceEntity apoliceEntity) {
        return apoliceRepository.save(apoliceEntity);
    }
}
