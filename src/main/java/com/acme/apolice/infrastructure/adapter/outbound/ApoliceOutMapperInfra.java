package com.acme.apolice.infrastructure.adapter.outbound;

import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApoliceOutMapperInfra {

    /**
     * Domain to Infra<br>
     * Infra to Domain
     */
    ApoliceEntity domainToEntity(ApoliceDomain apoliceDomain);
    ApoliceDomain entityToDomain(ApoliceEntity dto);

}