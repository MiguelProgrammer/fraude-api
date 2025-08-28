package com.acme.fraude.infrastructure.config;

import com.acme.fraude.adapter.controller.ClienteController;
import com.acme.fraude.adapter.outbound.ClienteMapper;
import com.acme.fraude.core.ports.FraudeRepositoryPort;
import com.acme.fraude.core.usecase.ConsultaFraudeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public ClienteController clienteController(ConsultaFraudeUseCase consultaFraudeUseCase) {
        return new ClienteController(consultaFraudeUseCase);
    }

    @Bean
    public ConsultaFraudeUseCase consultaFraudeUseCase(ClienteMapper clienteMapper, FraudeRepositoryPort fraudeRepositoryPort) {
        return new ConsultaFraudeUseCase(clienteMapper, fraudeRepositoryPort);
    }
}
