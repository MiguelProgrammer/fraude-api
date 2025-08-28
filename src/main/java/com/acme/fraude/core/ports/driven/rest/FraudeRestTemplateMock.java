package com.acme.fraude.core.ports.driven.rest;

import com.acme.fraude.adapter.inbound.AnaliseFraudeRequest;
import com.acme.fraude.core.domain.cliente.ClienteDomain;

public interface FraudeRestTemplateMock {

    AnaliseFraudeRequest analisarRisco(ClienteDomain cliente);
}
