package com.acme.apolice.infrastructure.adapter.outbound;

import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApoliceOutMapper {

    /**
     * Domain to Infra<br>
     * Infra to Domain
     */
    ApoliceEntity domainToEntity(ApoliceDomain apoliceDomain);
    ApoliceDomain entityToDomain(ApoliceEntity dto);

}