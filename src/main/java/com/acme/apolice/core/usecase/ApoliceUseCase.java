package com.acme.apolice.core.usecase;

import com.acme.apolice.adapter.inbound.ApoliceConsulta;
import com.acme.apolice.adapter.inbound.impl.ApoliceMapperImpl;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.infrastructure.adapter.outbound.ApoliceOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.CoberturaOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.HistoricoOutMapperInfra;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.projection.ApoliceConsultaProjection;

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

        /**
         * CENÁRIO 1
         */
        ApoliceDomain apoliceDomain = inMapper.entityToDomain(apoliceAdapter.save(entity));

        /**
         * CENÁRIO 2
         */
        apoliceUseCase.executar(apoliceDomain);

        return apoliceDomain;
    }

    public ApoliceConsulta apoliceDetalhada(UUID id) {
        ApoliceConsultaProjection apoliceConsultaProjection = apoliceAdapter.listaApolice(id);
        ApoliceConsulta apoliceConsulta = mapperApolice.mapperProjection(apoliceConsultaProjection);
        return apoliceConsulta;
    }
}
