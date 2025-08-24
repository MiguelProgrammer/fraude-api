package com.acme.apolice.adapter.outbound;

import com.acme.apolice.adapter.inbound.dto.Apolice;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApoliceOutMapper {

        /**
         * Inbound to Domain<br>
         * Domain to Inbound
         */
        ApoliceDomain inboundToDomain(Apolice dto);
        Apolice domainToInbound(ApoliceDomain apoliceDomain);

        /**
         * Domain to Infra<br>
         * Infra to Domain
         */
        ApoliceEntity domainToEntity(ApoliceDomain apoliceDomain);
        ApoliceDomain entityToDomain(ApoliceEntity dto);

    }
