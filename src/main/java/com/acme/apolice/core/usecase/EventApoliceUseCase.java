package com.acme.apolice.core.usecase;

import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.ports.driven.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventApoliceUseCase {

    private final EventPublisher eventPublisher;
    private final ObjectMapper objectMapper;

    public EventApoliceUseCase(EventPublisher eventPublisher, ObjectMapper objectMapper) {
        this.eventPublisher = eventPublisher;
        this.objectMapper = objectMapper;
    }

    public void executar(ApoliceDomain command) {
        // lógica de negócio (validação, persistência, etc.)
        // ...

        // Publica evento no Kafka
        try {
            String apoliceJson = objectMapper.writeValueAsString(command);
            eventPublisher.publish("apolice.enquadramento", command.getId().toString(), apoliceJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
