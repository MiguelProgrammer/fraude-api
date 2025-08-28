package com.acme.fraude.core.ports;

import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.historico.HistoricoEntity;

import java.util.UUID;

public interface HistoricoRepositoryPort {

    HistoricoEntity save(HistoricoEntity historicoEntity);
    HistoricoEntity getById(UUID uuid);
}
