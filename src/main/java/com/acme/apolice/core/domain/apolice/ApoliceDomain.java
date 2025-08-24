package com.acme.apolice.core.domain.apolice;

import com.acme.apolice.adapter.inbound.dto.CategoriaSeguro;
import com.acme.apolice.adapter.inbound.dto.TipoAssistencia;
import com.acme.apolice.adapter.inbound.dto.TipoCobertura;
import com.acme.apolice.adapter.inbound.dto.TipoPagamento;

import java.math.BigDecimal;
import java.util.Set;

public class ApoliceDomain {

    private Integer clienteId;
    private Integer produtoId;
    private CategoriaSeguro categoria;
    private TipoPagamento metodoPagemento;
    private BigDecimal valorTotalPremioMensal;
    private BigDecimal valorSegurado;
    private Set<TipoCobertura> coberturas;
    private Set<TipoAssistencia> assistencias;

    public ApoliceDomain() {
    }

    public ApoliceDomain(Integer clienteId, Integer produtoId, CategoriaSeguro categoria, TipoPagamento metodoPagemento, BigDecimal valorTotalPremioMensal, BigDecimal valorSegurado, Set<TipoCobertura> coberturas, Set<TipoAssistencia> assistencias) {
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.categoria = categoria;
        this.metodoPagemento = metodoPagemento;
        this.valorTotalPremioMensal = valorTotalPremioMensal;
        this.valorSegurado = valorSegurado;
        this.coberturas = coberturas;
        this.assistencias = assistencias;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
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
