package com.acme.apolice.adapter.outbound;

import com.acme.apolice.adapter.inbound.dto.ApoliceResponse;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApoliceOutMapperDto {

    /**
     * Inbound to Domain<br>
     * Domain to Inbound
     */
    @Mapping(target = "dataInicio", ignore = true)
    ApoliceResponse domainToOutbound(ApoliceDomain apoliceDomain);
}
