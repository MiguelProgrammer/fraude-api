package com.acme.apolice.infrastructure.adapter;

import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.projection.ApoliceConsultaProjection;
import com.acme.apolice.infrastructure.database.postgresql.apolice.repositories.ApoliceRepository;
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
        ApoliceConsultaProjection byApolice = apoliceRepository.findByApolice(id);
        return byApolice;
    }

}
