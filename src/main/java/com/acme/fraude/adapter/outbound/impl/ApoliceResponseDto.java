package com.acme.fraude.adapter.outbound.impl;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ApoliceResponseDto(UUID cotacaoId, OffsetDateTime dataSolicitacao) {
}
