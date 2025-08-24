package com.acme.apolice.core.domain.apolice;

import com.acme.apolice.adapter.inbound.dto.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public class ApoliceDomain {

    @JsonIgnore
    private UUID id;
    private UUID clienteId;
    private UUID produtoId;
    private CategoriaSeguro categoria;
    private TipoCanalVendas origem;
    private TipoPagamento metodoPagemento;
    private BigDecimal valorTotalPremioMensal;
    private BigDecimal valorSegurado;
    private Set<TipoCobertura> coberturas;
    private Set<TipoAssistencia> assistencias;

    public ApoliceDomain() {
    }

    public ApoliceDomain(UUID id, UUID clienteId, UUID produtoId, CategoriaSeguro categoria, TipoCanalVendas origem, TipoPagamento metodoPagemento, BigDecimal valorTotalPremioMensal, BigDecimal valorSegurado, Set<TipoCobertura> coberturas, Set<TipoAssistencia> assistencias) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.categoria = categoria;
        this.origem = origem;
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

    public TipoCanalVendas getOrigem() {
        return origem;
    }

    public void setOrigem(TipoCanalVendas origem) {
        this.origem = origem;
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
