package com.acme.apolice.core.domain.cobertura;

import java.math.BigDecimal;

public class CoberturaDomain {

    private BigDecimal roubo;
    private BigDecimal perdaTotal;
    private BigDecimal colisaoTerceiros;

    public CoberturaDomain() {
    }

    public CoberturaDomain(BigDecimal roubo, BigDecimal perdaTotal, BigDecimal colisaoTerceiros) {
        this.roubo = roubo;
        this.perdaTotal = perdaTotal;
        this.colisaoTerceiros = colisaoTerceiros;
    }

    public BigDecimal getRoubo() {
        return roubo;
    }

    public void setRoubo(BigDecimal roubo) {
        this.roubo = roubo;
    }

    public BigDecimal getPerdaTotal() {
        return perdaTotal;
    }

    public void setPerdaTotal(BigDecimal perdaTotal) {
        this.perdaTotal = perdaTotal;
    }

    public BigDecimal getColisaoTerceiros() {
        return colisaoTerceiros;
    }

    public void setColisaoTerceiros(BigDecimal colisaoTerceiros) {
        this.colisaoTerceiros = colisaoTerceiros;
    }
}
