package com.acme.fraude.adapter.controller;

import com.acme.fraude.adapter.inbound.AnaliseFraudeRequest;
import com.acme.fraude.core.usecase.ConsultaFraudeUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteController {

    private final ConsultaFraudeUseCase consultaFraudeUseCase;

    public ClienteController(ConsultaFraudeUseCase consultaFraudeUseCase) {
        this.consultaFraudeUseCase = consultaFraudeUseCase;
    }

    public ResponseEntity<com.acme.fraude.adapter.inbound.AnaliseFraudeResponse> listaApolicePorCliente(AnaliseFraudeRequest analiseFraudeRequest) {
        return ResponseEntity.ok(consultaFraudeUseCase.listaApolicePorCliente(analiseFraudeRequest));
    }
}
