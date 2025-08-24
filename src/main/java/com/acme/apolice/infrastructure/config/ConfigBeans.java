package com.acme.apolice.infrastructure.config;

import com.acme.apolice.adapter.controller.ApoliceController;
import com.acme.apolice.adapter.inbound.ApoliceInMapper;
import com.acme.apolice.adapter.outbound.ApoliceOutMapperDto;
import com.acme.apolice.core.ports.ApoliceRepositoryPort;
import com.acme.apolice.core.ports.HistoricoRepositoryPort;
import com.acme.apolice.core.usecase.ApoliceUseCase;
import com.acme.apolice.infrastructure.adapter.outbound.ApoliceOutMapperInfra;
import com.acme.apolice.infrastructure.adapter.outbound.HistoricoOutMapperInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public ApoliceController apoliceController(ApoliceInMapper inMapper, ApoliceOutMapperDto outMapper, ApoliceUseCase apoliceUseCase) {
        return new ApoliceController(inMapper, outMapper, apoliceUseCase);
    }

    @Bean
    public ApoliceUseCase apoliceUseCase(ApoliceOutMapperInfra inMapper, ApoliceRepositoryPort apoliceAdapter, HistoricoOutMapperInfra historicoMapper, HistoricoRepositoryPort historicoRepositoryPort) {
        return new ApoliceUseCase(inMapper, apoliceAdapter, historicoMapper, historicoRepositoryPort);
    }
}
