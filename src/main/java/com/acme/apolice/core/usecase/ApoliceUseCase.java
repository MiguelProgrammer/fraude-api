package com.acme.apolice.core.usecase;

import com.acme.apolice.adapter.inbound.ApoliceConsulta;
import com.acme.apolice.adapter.inbound.impl.ApoliceMapperImpl;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.infrastructure.adapter.outbound.ApoliceOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.CoberturaOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.HistoricoOutMapperInfra;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;

import java.util.Set;
import java.util.UUID;

public class ApoliceUseCase {

    private final ApoliceOutMapperInfra inMapper;
    private final ApoliceRepositoryPort apoliceAdapter;
    private final ApoliceMapperImpl mapperApolice;
    private final EventApoliceUseCase apoliceUseCase;

    public ApoliceUseCase(ApoliceOutMapperInfra inMapper, ApoliceRepositoryPort apoliceAdapter, CoberturaOutMapperInfra coberturaOutMapperInfra, HistoricoOutMapperInfra historicoOutMapperInfra, EventApoliceUseCase apoliceUseCase) {
        this.inMapper = inMapper;
        this.apoliceAdapter = apoliceAdapter;
        this.apoliceUseCase = apoliceUseCase;
        this.mapperApolice = new ApoliceMapperImpl(inMapper, coberturaOutMapperInfra, historicoOutMapperInfra);
    }

    public ApoliceDomain enquadramento(ApoliceDomain domain) {
        ApoliceEntity entity = mapperApolice.mapperApolice(domain);
        ApoliceEntity save = apoliceAdapter.save(entity);
        ApoliceDomain apoliceDomain = inMapper.entityToDomain(save);
        apoliceUseCase.executar(apoliceDomain);
        return apoliceDomain;
    }

    public Set<ApoliceConsulta> apoliceDetalhada(UUID id) {
        return mapperApolice.mapperProjection(apoliceAdapter.listaApolice(id));
    }
}
