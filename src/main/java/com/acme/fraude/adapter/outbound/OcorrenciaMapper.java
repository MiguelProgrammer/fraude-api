package com.acme.fraude.adapter.outbound;

import com.acme.fraude.core.domain.cliente.OcorrenciaDomain;
import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.cliente.OcorrenciaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OcorrenciaMapper {

    /**
     * Inbound to Domain<br>
     * Domain to Inbound
     */
    OcorrenciaEntity domainToInfra(OcorrenciaDomain domain);
    OcorrenciaDomain infraToDomain(OcorrenciaEntity entity);
}