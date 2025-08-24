package com.acme.apolice.infrastructure.database.postgresql.apolice.entities;

import com.acme.apolice.adapter.inbound.dto.CategoriaSeguro;
import com.acme.apolice.adapter.inbound.dto.TipoAssistencia;
import com.acme.apolice.adapter.inbound.dto.TipoCobertura;
import com.acme.apolice.adapter.inbound.dto.TipoPagamento;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "apolice")
public class ApoliceEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "cliente_id")
    private UUID clienteId;

    @Column(name = "produto_id")
    private UUID produtoId;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private CategoriaSeguro categoria;

    @Column(name = "tipo_pagamento")
    @Enumerated(EnumType.STRING)
    private TipoPagamento metodoPagemento;

    @Column(name = "valor_total_premio_mensal")
    private BigDecimal valorTotalPremioMensal;

    @Column(name = "valor_segurado")
    private BigDecimal valorSegurado;

    @Column(name = "coberturas")
    private Set<TipoCobertura> coberturas;

    @Column(name = "assistencias")
    private Set<TipoAssistencia> assistencias;
}
