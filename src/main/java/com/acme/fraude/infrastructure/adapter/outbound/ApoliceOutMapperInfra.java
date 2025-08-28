package com.acme.fraude.infrastructure.adapter.outbound;

import com.acme.fraude.adapter.inbound.ApoliceConsulta;
import com.acme.fraude.core.domain.apolice.ApoliceDomain;
import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import com.acme.fraude.infrastructure.database.postgresql.apolice.projection.ApoliceConsultaProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApoliceOutMapperInfra {

    /**
     * Domain to Infra<br>
     * Infra to Domain<br>
     * Projection to Domain
     */
    ApoliceEntity domainToEntity(ApoliceDomain apoliceDomain);
    ApoliceDomain entityToDomain(ApoliceEntity dto);
    ApoliceConsulta projectionToDomain(ApoliceConsultaProjection apoliceConsultaProjection);
    ApoliceEntity domainConsultaToEntity(ApoliceConsulta apoliceConsulta);
}