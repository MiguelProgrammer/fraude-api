package com.acme.apolice.adapter.inbound;

import com.acme.apolice.adapter.inbound.Cobertura;
import com.acme.apolice.core.domain.cobertura.CoberturaDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoberturaInMapper {

    /**
     * Inbound to Domain<br>
     * Domain to Inbound
     */
    CoberturaDomain inboundToDomain(Cobertura dto);
    Cobertura domainToInbound(CoberturaDomain coberturaDomain);


}