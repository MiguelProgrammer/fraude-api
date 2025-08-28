package com.acme.fraude.infrastructure.database.postgresql.apolice.repositories;

import com.acme.fraude.infrastructure.database.postgresql.apolice.entities.cliente.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {

    @Query("select a from ClienteEntity a where a.clienteId =:idCliente and a.apoliceId =:idApolice")
    ClienteEntity findByClienteId(@Param("idCliente") UUID idCliente, @Param("idApolice") UUID idApolice);
}
