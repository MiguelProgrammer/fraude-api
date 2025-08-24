package com.acme.apolice.adapter.outbound.reponse;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ApoliceResponseDto(UUID cotacaoId, OffsetDateTime dataSolicitacao) {
}
