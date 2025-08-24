package com.acme.apolice.core.usecase;

import com.acme.apolice.adapter.inbound.dto.Estado;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.core.ports.HistoricoRepositoryPort;
import com.acme.apolice.infrastructure.adapter.outbound.ApoliceOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.HistoricoOutMapperInfra;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.HistoricoEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ApoliceUseCase {

    private ApoliceOutMapperInfra inMapper;
    private final ApoliceRepositoryPort apoliceAdapter;
    private HistoricoOutMapperInfra historicoMapper;
    private final HistoricoRepositoryPort historicoRepositoryPort;

    public ApoliceUseCase(ApoliceOutMapperInfra inMapper, ApoliceRepositoryPort apoliceAdapter, HistoricoOutMapperInfra historicoMapper, HistoricoRepositoryPort historicoRepositoryPort) {
        this.inMapper = inMapper;
        this.apoliceAdapter = apoliceAdapter;
        this.historicoMapper = historicoMapper;
        this.historicoRepositoryPort = historicoRepositoryPort;
    }

    public ApoliceDomain enquadramento(ApoliceDomain apoliceDomain) {
        ApoliceEntity apoliceEntity = inMapper.domainToEntity(apoliceDomain);
        apoliceEntity.setHistorico(new HashSet<>(List.of(new HistoricoEntity(apoliceEntity, Estado.RECEBIDO, apoliceEntity.getDataInicio()))));
        return inMapper.entityToDomain(apoliceAdapter.save(apoliceEntity));
    }
}
