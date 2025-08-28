package com.acme.fraude.infrastructure.adapter;

import com.acme.fraude.core.ports.HistoricoRepositoryPort;
import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.historico.HistoricoEntity;
import com.acme.fraude.infrastructure.database.postgresql.apolice.repositories.HistoricoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HistoricoRepositoryAdapter implements HistoricoRepositoryPort {

    private final HistoricoRepository historicoRepository;

    public HistoricoRepositoryAdapter(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    @Override
    public HistoricoEntity save(HistoricoEntity historico) {
        return historicoRepository.save(historico);
    }

    @Override
    public HistoricoEntity getById(UUID uuid) {
        return historicoRepository.getReferenceById(uuid);
    }
}
