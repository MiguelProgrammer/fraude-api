package com.acme.fraude.infrastructure.adapter.outbound;

import com.acme.fraude.core.domain.cobertura.CoberturaDomain;
import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.cobertura.CoberturaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoberturaOutMapperInfra {

    /**
     * Domain to Infra<br>
     * Infra to Domain
     */
    CoberturaEntity domainToEntity(CoberturaDomain domain);
    CoberturaDomain entityToDomain(CoberturaEntity entity);

}