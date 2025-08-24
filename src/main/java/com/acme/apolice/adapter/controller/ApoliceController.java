package com.acme.apolice.adapter.controller;

import com.acme.apolice.adapter.inbound.ApoliceInMapper;
import com.acme.apolice.adapter.inbound.dto.Apolice;
import com.acme.apolice.adapter.inbound.dto.ApoliceResponse;
import com.acme.apolice.core.usecase.ApoliceUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ApoliceController {

    private final ApoliceInMapper inMapper;
    private final ApoliceUseCase apoliceUseCase;

    public ApoliceController(ApoliceInMapper inMapper, ApoliceUseCase apoliceUseCase) {
        this.inMapper = inMapper;
        this.apoliceUseCase = apoliceUseCase;
    }

    public ResponseEntity<ApoliceResponse> geraApolice(Apolice apolice) {
        apoliceUseCase.enquadramento(inMapper.inboundToDomain(apolice));
    }

    public ResponseEntity<ApoliceResponse> consutaApolice(Integer clienteId, Integer solicitacaoId) {
        return null;
    }
}
