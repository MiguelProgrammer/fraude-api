package com.acme.apolice.core.usecase;

import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.domain.enums.TipoCliente;
import com.acme.apolice.core.ports.driven.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;

public class EventApoliceUseCase {

    public static final String APOLICE_ENQUADRAMENTO_TOPIC = "apolice.enquadramento";
    private final EventPublisher eventPublisher;
    private final ObjectMapper objectMapper;

    public EventApoliceUseCase(EventPublisher eventPublisher, ObjectMapper objectMapper) {
        this.eventPublisher = eventPublisher;
        this.objectMapper = objectMapper;
    }

    public void executar(ApoliceDomain command) {
        // lógica de negócio (validação, persistência, etc.)
        // ...

        TipoCliente tipo = TipoCliente.determinarTipo(command.getValorSegurado(), Collections.singletonList(command.getCategoria()));

        // Publica evento no Kafka
        try {
            String apoliceJson = objectMapper.writeValueAsString(command);
            eventPublisher.publish(APOLICE_ENQUADRAMENTO_TOPIC, command.getId().toString(), apoliceJson);

            // command.set


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
