package com.acme.fraude.adapter.outbound;

import com.acme.fraude.adapter.inbound.AnaliseFraudeResponse;
import com.acme.fraude.core.domain.cliente.ClienteDomain;
import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.cliente.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    /**
     * Inbound to Domain<br>
     * Domain to Inbound
     */
    ClienteEntity domainToInfra(ClienteDomain domain);
    ClienteDomain infraToDomain(ClienteEntity entity);
    AnaliseFraudeResponse domainToResponse(ClienteDomain domain);
}