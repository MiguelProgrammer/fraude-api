package com.acme.fraude.adapter.outbound;

import com.acme.fraude.adapter.inbound.ApoliceResponse;
import com.acme.fraude.core.domain.apolice.ApoliceDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApoliceOutMapperDto {

    /**
     * Inbound to Domain<br>
     * Domain to Inbound
     */
    ApoliceResponse domainToOutbound(ApoliceDomain apoliceDomain);
}
