package com.acme.fraude.infrastructure.adapter;

import com.acme.fraude.core.ports.ApoliceRepositoryPort;
import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import com.acme.fraude.infrastructure.database.postgresql.apolice.projection.ApoliceConsultaProjection;
import com.acme.fraude.infrastructure.database.postgresql.apolice.repositories.ApoliceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

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
        ApoliceEntity entity = apoliceRepository.save(apoliceEntity);
        entity.setApoliceId(entity.getId());
        return entity;
    }

    @Override
    public ApoliceConsultaProjection listaApolice(UUID id) {
        return apoliceRepository.findByApolice(id);
    }

}
