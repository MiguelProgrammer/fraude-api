package com.acme.fraude.infrastructure.database.postgresql.apolice.repositories;

import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.historico.HistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HistoricoRepository extends JpaRepository<HistoricoEntity, UUID> {
}
