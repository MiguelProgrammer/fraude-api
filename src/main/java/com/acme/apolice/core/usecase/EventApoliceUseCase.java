package com.acme.apolice.core.usecase;

import com.acme.apolice.adapter.inbound.ApoliceConsulta;
import com.acme.apolice.adapter.inbound.Estado;
import com.acme.apolice.adapter.inbound.Historico;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.domain.enums.TipoCliente;
import com.acme.apolice.core.ports.driven.EventPublisher;
import com.acme.apolice.core.usecase.exception.ApoliceUseCaseBusinessException;
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

        /**
         * API EXTERNA
         */
        TipoCliente tipo =

        publicaApolice(command);
    }

    private void publicaApolice(ApoliceDomain command) {
        try {

            String apoliceJson = objectMapper.writeValueAsString(command);
            eventPublisher.publish(APOLICE_ENQUADRAMENTO_TOPIC, command.getId().toString(), apoliceJson);

        } catch (ApoliceUseCaseBusinessException | JsonProcessingException e) {
            throw new ApoliceUseCaseBusinessException(e.getMessage());
        }
    }

    public void processarApolice(ApoliceConsulta apoliceConsulta) {

        // 1. Carrega a apólice do banco de dados

        // 2. Decide a ação com base no status da apólice
        switch (event.getStatus()) {
            case RECEBIDO:
                // Lógica para validar com a API de fraude
                Historico historico = new Historico();
                historico.setStatus(Estado.RECEBIDO);
                apoliceConsulta.setStatus(obtemRisco(apoliceConsulta));

                // Transiciona para VALIDADO ou REJEITADO
                break;
            case PENDENTE:
                // Lógica para consumir evento de pagamento ou subscrição
                // Transiciona para APROVADO ou REJEITADO
                break;
            default:
                // Lógica para estados já concluídos
                break;
        }

        // 3. Salva a apólice e publica o novo evento no Kafka
        apoliceRepository.save(apolice); // adapter para atuazar apolice
        publicaApolice(apolice.toEvent()); // preparar objeto para enviar ao kafka
    }

    private TipoCliente obtemRisco(ApoliceConsulta apoliceConsulta){
        return TipoCliente.determinarTipo(apoliceConsulta.getValorSegurado(),
                Collections.singletonList(apoliceConsulta.getCategoria()));
    }
}
