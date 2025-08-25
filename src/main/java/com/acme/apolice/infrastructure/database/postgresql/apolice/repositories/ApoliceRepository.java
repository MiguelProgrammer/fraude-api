package com.acme.apolice.infrastructure.database.postgresql.apolice.repositories;

import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice.ApoliceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;
import java.util.UUID;

public interface ApoliceRepository extends JpaRepository<ApoliceEntity, UUID> {

    @Query(value = "select * from apolice where id = :id or cliente = :id", nativeQuery = true)
    Set<ApoliceEntity> findByApolice(@Param("id") UUID clienteId);
}
