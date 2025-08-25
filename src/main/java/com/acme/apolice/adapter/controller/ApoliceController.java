package com.acme.apolice.adapter.controller;

import com.acme.apolice.adapter.inbound.*;
import com.acme.apolice.adapter.outbound.ApoliceOutMapperDto;
import com.acme.apolice.core.domain.apolice.ApoliceDomain;
import com.acme.apolice.core.usecase.ApoliceUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ApoliceController {

    private final ApoliceInMapper inMapper;
    private final ApoliceOutMapperDto outMapper;
    private final CoberturaInMapper coberturaInMapper;
    private final ApoliceUseCase apoliceUseCase;

    public ApoliceController(ApoliceInMapper inMapper, ApoliceOutMapperDto outMapper, CoberturaInMapper coberturaInMapper, ApoliceUseCase apoliceUseCase) {
        this.inMapper = inMapper;
        this.outMapper = outMapper;
        this.coberturaInMapper = coberturaInMapper;
        this.apoliceUseCase = apoliceUseCase;
    }

    public ResponseEntity<ApoliceResponse> geraApolice(Apolice apolice) {
        ApoliceDomain apoliceDomain = apoliceUseCase.enquadramento(inMapper.inboundToDomain(apolice));
        return new ResponseEntity<>(outMapper.domainToOutbound(apoliceDomain), HttpStatus.CREATED);
    }

    public ResponseEntity<List<ApoliceConsulta>> listaApolice(UUID id) {
        List<ApoliceConsulta> listaApolice = apoliceUseCase.apoliceDetalhada(id).stream().toList();
        return ResponseEntity.ok(listaApolice);
    }
}
