package com.acme.apolice.adapter.inbound.impl;

import com.acme.apolice.adapter.inbound.ApoliceConsulta;
import com.acme.apolice.adapter.inbound.Estado;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.infrastructure.adapter.outbound.ApoliceOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.CoberturaOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.HistoricoOutMapperInfra;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.cobertura.CoberturaEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.historico.HistoricoEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.projection.ApoliceConsultaProjection;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record ApoliceMapperImpl(ApoliceOutMapperInfra inMapper,
                                CoberturaOutMapperInfra coberturaOutMapperInfra,
                                HistoricoOutMapperInfra historicoOutMapperInfra) {

    /**
     * INTERNAL SERVICE | MAPPER
     */
    public ApoliceEntity mapperApolice(ApoliceDomain apoliceDomain) {
        ApoliceEntity apolice = inMapper.domainToEntity(apoliceDomain);
        CoberturaEntity cobertura = coberturaOutMapperInfra.domainToEntity(apoliceDomain.getCobertura());
        apolice.setHistorico(Set.of(new HistoricoEntity(apolice, Estado.RECEBIDO, apolice.getDataCriacao())));
        apolice.setCobertura(cobertura);
        return apolice;
    }

    /**
     * INTERNAL SERVICE | MAPPER
     */
    public Set<ApoliceConsulta> mapperProjection(Set<ApoliceConsultaProjection> apoliceConsultaProjections) {
        return apoliceConsultaProjections.stream()
                .map(ap -> {
                    ApoliceConsulta dto = inMapper.projectionToDomain(ap);
                    List<HistoricoEntity> historicoOrdenado = ap.getHistorico().stream().sorted(Comparator.comparing(HistoricoEntity::getDataCriacao)).toList();
                    dto.setHistorico(historicoOutMapperInfra.listEnityToDomain(historicoOrdenado));
                    dto.setStatus(historicoOrdenado.get(historicoOrdenado.size() - 1).getStatus());
                    return dto;
                }).collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
