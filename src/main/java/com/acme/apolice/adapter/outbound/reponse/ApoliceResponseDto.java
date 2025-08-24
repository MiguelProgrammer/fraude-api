package com.acme.apolice.adapter.outbound.reponse;

import com.acme.apolice.adapter.inbound.dto.ApoliceResponse;

import java.time.LocalDate;
import java.util.UUID;

public record ApoliceResponseDto(UUID cotacaoId, LocalDate dataSolicitacao) {

    public ApoliceResponseDto mapperResponseToRecord(ApoliceResponse dto){
        return new ApoliceResponseDto(dto.getId(), dto.getDataInicio());
    }
}
