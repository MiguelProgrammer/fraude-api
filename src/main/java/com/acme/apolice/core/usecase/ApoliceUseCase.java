package com.acme.apolice.core.usecase;

import com.acme.apolice.adapter.inbound.ApoliceConsulta;
import com.acme.apolice.adapter.inbound.Estado;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.infrastructure.adapter.outbound.ApoliceOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.CoberturaOutMapperInfra;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.cobertura.CoberturaEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.historico.HistoricoEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ApoliceUseCase {

    private final ApoliceOutMapperInfra inMapper;
    private final ApoliceRepositoryPort apoliceAdapter;
    private final CoberturaOutMapperInfra coberturaOutMapperInfra;

    public ApoliceUseCase(ApoliceOutMapperInfra inMapper, ApoliceRepositoryPort apoliceAdapter, CoberturaOutMapperInfra coberturaOutMapperInfra) {
        this.inMapper = inMapper;
        this.apoliceAdapter = apoliceAdapter;
        this.coberturaOutMapperInfra = coberturaOutMapperInfra;
    }

    public ApoliceDomain enquadramento(ApoliceDomain apoliceDomain) {
        ApoliceEntity apolice = mapperApolice(apoliceDomain);
        return inMapper.entityToDomain(apoliceAdapter.save(apolice));
    }

    public Set<ApoliceConsulta> apoliceDetalhada(UUID id) {
        Set<ApoliceEntity> apoliceEntities = apoliceAdapter.listaApolice(id);
        Set<ApoliceConsulta> apoliceConsultas = new HashSet<>();
                apoliceEntities.forEach(ap -> {
                    ap.getHistorico().forEach(ht -> {
                        ht.setDataCriacao(ap.getDataCriacao());
                    });
        });
        return apoliceConsultas;
    }

    /**
     * INTERNAL SERVICE |
     * MAPEIA ATRIBUTOS OBJETOS DE APÓLICE
     *
     * @param apoliceDomain
     * @return
     */
    private ApoliceEntity mapperApolice(ApoliceDomain apoliceDomain) {
        ApoliceEntity apolice = inMapper.domainToEntity(apoliceDomain);
        CoberturaEntity cobertura = coberturaOutMapperInfra.domainToEntity(apoliceDomain.getCobertura());
        apolice.setCobertura(cobertura);
        apolice.setHistorico(new HashSet<>(List.of(new HistoricoEntity(apolice, Estado.RECEBIDO, apolice.getDataCriacao()))));
        return apolice;
    }
}
