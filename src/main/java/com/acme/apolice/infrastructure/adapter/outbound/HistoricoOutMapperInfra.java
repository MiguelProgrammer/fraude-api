package com.acme.apolice.infrastructure.adapter.outbound;

import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.HistoricoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricoOutMapperInfra {

    /**
     * Domain to Infra<br>
     * Infra to Domain
     */
    HistoricoEntity domainToEntity(ApoliceDomain apoliceDomain);
    ApoliceDomain entityToDomain(ApoliceEntity dto);

}