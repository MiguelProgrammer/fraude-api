package com.acme.apolice.infrastructure.database.postgresql.apolice.entities;

import com.acme.apolice.adapter.inbound.dto.CategoriaSeguro;
import com.acme.apolice.adapter.inbound.dto.TipoAssistencia;
import com.acme.apolice.adapter.inbound.dto.TipoCobertura;
import com.acme.apolice.adapter.inbound.dto.TipoPagamento;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

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

    public ApoliceEntity() {
    }

    public ApoliceEntity(UUID id, UUID clienteId, UUID produtoId, CategoriaSeguro categoria, TipoPagamento metodoPagemento, BigDecimal valorTotalPremioMensal, BigDecimal valorSegurado, Set<TipoCobertura> coberturas, Set<TipoAssistencia> assistencias) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.categoria = categoria;
        this.metodoPagemento = metodoPagemento;
        this.valorTotalPremioMensal = valorTotalPremioMensal;
        this.valorSegurado = valorSegurado;
        this.coberturas = coberturas;
        this.assistencias = assistencias;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public UUID getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(UUID produtoId) {
        this.produtoId = produtoId;
    }

    public CategoriaSeguro getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaSeguro categoria) {
        this.categoria = categoria;
    }

    public TipoPagamento getMetodoPagemento() {
        return metodoPagemento;
    }

    public void setMetodoPagemento(TipoPagamento metodoPagemento) {
        this.metodoPagemento = metodoPagemento;
    }

    public BigDecimal getValorTotalPremioMensal() {
        return valorTotalPremioMensal;
    }

    public void setValorTotalPremioMensal(BigDecimal valorTotalPremioMensal) {
        this.valorTotalPremioMensal = valorTotalPremioMensal;
    }

    public BigDecimal getValorSegurado() {
        return valorSegurado;
    }

    public void setValorSegurado(BigDecimal valorSegurado) {
        this.valorSegurado = valorSegurado;
    }

    public Set<TipoCobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(Set<TipoCobertura> coberturas) {
        this.coberturas = coberturas;
    }

    public Set<TipoAssistencia> getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(Set<TipoAssistencia> assistencias) {
        this.assistencias = assistencias;
    }
}
