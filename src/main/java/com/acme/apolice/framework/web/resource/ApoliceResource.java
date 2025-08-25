package com.acme.apolice.framework.web.resource;

import com.acme.apolice.adapter.controller.ApoliceController;
import com.acme.apolice.adapter.inbound.Apolice;
import com.acme.apolice.adapter.inbound.ApoliceResponse;
import com.acme.apolice.adapter.outbound.reponse.ApoliceResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/apolice")
public class ApoliceResource {

    @Autowired
    private ApoliceController controller;

    @GetMapping("/consulta")
    public ResponseEntity<ApoliceResponse> consutaApolice(UUID clienteId, UUID solicitacaoId) {
        return controller.consutaApolice(clienteId, solicitacaoId);
    }

    @PostMapping("/emite")
    public ResponseEntity<ApoliceResponseDto> geraApolice(Apolice apolice) {
        return controller.geraApolice(apolice);
    }
}
