package com.acme.apolice.core.usecase;

import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.infrastructure.adapter.outbound.ApoliceOutMapperInfra;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;

public class ApoliceUseCase {

    private ApoliceOutMapperInfra inMapper;
    private final ApoliceRepositoryPort apoliceAdapter;

    public ApoliceUseCase(ApoliceOutMapperInfra inMapper, ApoliceRepositoryPort apoliceAdapter) {
        this.inMapper = inMapper;
        this.apoliceAdapter = apoliceAdapter;
    }

    public ApoliceDomain enquadramento(ApoliceDomain apoliceDomain) {
        ApoliceEntity apoliceEntity = inMapper.domainToEntity(apoliceDomain);
        return inMapper.entityToDomain(apoliceAdapter.save(apoliceEntity));
    }
}
