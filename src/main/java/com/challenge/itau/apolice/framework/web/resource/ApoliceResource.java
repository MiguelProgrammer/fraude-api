package com.challenge.itau.apolice.framework.web.resource;


import com.challenge.itau.apolice.adapter.controller.ApoliceController;
import com.challenge.itau.apolice.adapter.inbound.Apolice;
import com.challenge.itau.apolice.adapter.inbound.ApoliceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/apolice")
public class ApoliceResource {

    private ApoliceController controller;

    @GetMapping("/consulta")
    public ResponseEntity<ApoliceResponse> consutaApolice(Integer clienteId, Integer solicitacaoId) {
        return controller.consutaApolice(clienteId, solicitacaoId);
    }

    @PostMapping("/emite")
    public ResponseEntity<ApoliceResponse> geraApolice(Apolice apolice) {
        return controller.geraApolice(apolice);
    }
}
