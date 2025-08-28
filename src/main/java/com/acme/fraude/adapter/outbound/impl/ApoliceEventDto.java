package com.acme.fraude.adapter.outbound.impl;

import com.acme.fraude.adapter.inbound.Estado;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ApoliceEventDto(UUID apoliceId,
                              Estado estado,
                              OffsetDateTime dataSolicitacao) {
}
