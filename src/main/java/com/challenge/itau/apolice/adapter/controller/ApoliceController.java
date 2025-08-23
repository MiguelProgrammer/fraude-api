package com.challenge.itau.apolice.adapter.controller;

import com.challenge.itau.apolice.adapter.inbound.Apolice;
import com.challenge.itau.apolice.adapter.inbound.ApoliceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ApoliceController {

    public ResponseEntity<ApoliceResponse> consutaApolice(Integer clienteId, Integer solicitacaoId) {
        return null;
    }

    public ResponseEntity<ApoliceResponse> geraApolice(Apolice apolice) {
        return null;
    }
}
