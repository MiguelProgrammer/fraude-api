package com.acme.apolice.infrastructure.adapter;

import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.repositories.ApoliceRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Component
public class ApoliceRepositoryAdapter implements ApoliceRepositoryPort {

    private final ApoliceRepository apoliceRepository;

    public ApoliceRepositoryAdapter(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }

    @Override
    @Transactional
    public ApoliceEntity save(ApoliceEntity apoliceEntity) {
        return apoliceRepository.save(apoliceEntity);
    }

    @Override
    public Set<ApoliceEntity> listaApolice(UUID id) {
        return apoliceRepository.findByApolice(id);
    }

}
