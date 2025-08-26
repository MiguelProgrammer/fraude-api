package com.acme.apolice.framework.web.resource;

import com.acme.apolice.adapter.controller.ApoliceController;
import com.acme.apolice.adapter.inbound.Apolice;
import com.acme.apolice.adapter.inbound.ApoliceConsulta;
import com.acme.apolice.adapter.inbound.ApoliceResponse;
import com.acme.apolice.controller.V1Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/apolice")
public class ApoliceResource implements V1Api {

    @Autowired
    private ApoliceController controller;

    @PostMapping
    public ResponseEntity<ApoliceResponse> geraApolice(Apolice apolice) {
        return controller.geraApolice(apolice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ApoliceConsulta>> listaApolice(UUID id) {
        return  controller.listaApolice(id);
    }
}
