package com.acme.fraude.framework.web.resource;

import com.acme.fraude.adapter.controller.ClienteController;
import com.acme.fraude.adapter.inbound.AnaliseFraudeRequest;
import com.acme.fraude.adapter.inbound.AnaliseFraudeResponse;
import com.acme.fraude.controller.V1Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/analise")
public class FraudeResource implements V1Api {

    @Autowired
    private ClienteController clienteController;

    /**
     * POST /v1/analise : Realiza a análise de risco de um cliente
     * Realiza a análise de risco do cliente com base no ID da apólice e do cliente.
     *
     * @param analiseFraudeRequest (required)
     * @return Análise de risco realizada com sucesso (status code 200)
     * or Requisição inválida (status code 400)
     */
    @Override
    @PostMapping
    public ResponseEntity<AnaliseFraudeResponse> analisarRisco(AnaliseFraudeRequest analiseFraudeRequest) {
        return clienteController.listaApolicePorCliente(analiseFraudeRequest);
    }
}
