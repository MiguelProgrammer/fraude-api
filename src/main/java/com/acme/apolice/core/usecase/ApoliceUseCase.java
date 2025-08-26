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

import java.util.UUID;

public class ApoliceUseCase {

    private final ApoliceOutMapperInfra inMapper;
    private final ApoliceRepositoryPort apoliceAdapter;
    private final ApoliceMapperImpl mapperApolice;
    private final EventApoliceUseCase eventApoliceUseCase;

    public ApoliceUseCase(ApoliceOutMapperInfra inMapper, ApoliceRepositoryPort apoliceAdapter, CoberturaOutMapperInfra coberturaOutMapperInfra, HistoricoOutMapperInfra historicoOutMapperInfra, EventApoliceUseCase eventApoliceUseCase) {
        this.inMapper = inMapper;
        this.apoliceAdapter = apoliceAdapter;
        this.eventApoliceUseCase = eventApoliceUseCase;
        this.mapperApolice = new ApoliceMapperImpl(inMapper, coberturaOutMapperInfra, historicoOutMapperInfra);
    }

    public ApoliceDomain enquadramento(ApoliceDomain domain) {

        /**
         * salva apólice
         */
        ApoliceEntity entity = mapperApolice.mapperApolice(domain);
        ApoliceDomain apoliceDomain = inMapper.entityToDomain(apoliceAdapter.save(entity));

        /**
         * publica
         */
        eventApoliceUseCase.executar(apoliceDomain);

        return apoliceDomain;
    }

    public ApoliceConsulta apoliceDetalhada(UUID id) {
        ApoliceConsultaProjection apoliceConsultaProjection = apoliceAdapter.listaApolice(id);
        return mapperApolice.mapperProjection(apoliceConsultaProjection);
    }
}
