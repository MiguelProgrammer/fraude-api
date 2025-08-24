package com.acme.apolice.infrastructure.database.postgresql.apolice.repositories;

import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.ApoliceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApoliceRepository extends JpaRepository<ApoliceEntity, UUID> {
}
