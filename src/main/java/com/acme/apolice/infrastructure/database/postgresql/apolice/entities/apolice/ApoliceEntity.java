package com.acme.apolice.infrastructure.database.postgresql.apolice.entities.apolice;

import com.acme.apolice.adapter.inbound.CategoriaSeguro;
import com.acme.apolice.adapter.inbound.TipoAssistencia;
import com.acme.apolice.adapter.inbound.TipoPagamento;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.cobertura.CoberturaEntity;
import com.acme.apolice.infrastructure.database.postgresql.apolice.entities.historico.HistoricoEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "apolice")
@SequenceGenerator(name = "apolice_sequence")
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

    @Column(name = "cobertura")
    private CoberturaEntity cobertura;

    @Column(name = "assistencias")
    private Set<TipoAssistencia> assistencias;

    @Column(name = "data_inicio")
    private OffsetDateTime dataInicio;

    @Column(name = "data_fim")
    private OffsetDateTime dataFinalizacao;

    @OneToMany(mappedBy = "apolice", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HistoricoEntity> historico = new HashSet<>();

    public ApoliceEntity() {
    }

    public ApoliceEntity(UUID id, UUID clienteId, UUID produtoId, CategoriaSeguro categoria, TipoPagamento metodoPagemento, BigDecimal valorTotalPremioMensal, BigDecimal valorSegurado, CoberturaEntity cobertura, Set<TipoAssistencia> assistencias, OffsetDateTime dataInicio, OffsetDateTime dataFinalizacao, Set<HistoricoEntity> historico) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.categoria = categoria;
        this.metodoPagemento = metodoPagemento;
        this.valorTotalPremioMensal = valorTotalPremioMensal;
        this.valorSegurado = valorSegurado;
        this.cobertura = cobertura;
        this.assistencias = assistencias;
        this.dataInicio = dataInicio;
        this.dataFinalizacao = dataFinalizacao;
        this.historico = historico;
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

    public CoberturaEntity getCobertura() {
        return cobertura;
    }

    public void setCobertura(CoberturaEntity cobertura) {
        this.cobertura = cobertura;
    }

    public Set<TipoAssistencia> getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(Set<TipoAssistencia> assistencias) {
        this.assistencias = assistencias;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public OffsetDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public Set<HistoricoEntity> getHistorico() {
        return historico;
    }

    public void setHistorico(Set<HistoricoEntity> historico) {
        this.historico = historico;
    }
}
