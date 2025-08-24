package com.acme.apolice.core.usecase;

import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.infrastructure.adapter.outbound.ApoliceOutMapper;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;

public class ApoliceUseCase {

    private ApoliceOutMapper inMapper;
    private final ApoliceRepositoryPort apoliceAdapter;

    public ApoliceUseCase(ApoliceRepositoryPort apoliceAdapter) {
        this.apoliceAdapter = apoliceAdapter;
    }

    public ApoliceEntity enquadramento(ApoliceDomain apoliceDomain){
        ApoliceEntity apoliceEntity = inMapper.domainToEntity(apoliceDomain);
        return apoliceAdapter.save(apoliceEntity);
    }
}
