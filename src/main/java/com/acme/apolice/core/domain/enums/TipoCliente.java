package com.acme.apolice.core.domain.enums;

import com.acme.apolice.adapter.inbound.CategoriaSeguro;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum TipoCliente {

    /**
     * Cliente Regular<hr>Cliente com um perfil de risco baixo,
     * com histórico comum e sem registros significativos de risco.
     * A solicitação terá seu estado alterado para aprovada caso:
     * <ul><li>a. Capital segurado não ultrapasse R$ 500.00,00 para seguro de vida ou residencial</li>
     * <li>b. Capital segurado não ultrapasse R$ 350.000,00 para seguro auto</li>
     * <li>c. Capital segurado não ultrapasse R$ 255.000,00 para qualquer outro tipo de seguro</li>
     * <li>d. Caso contrário deverá ser rejeitada.</li>
     * </ul>
     */
    REGULAR {

        @Override
        public Boolean validar(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("500.00,00");
            boolean seguroValido = cobertura.contains(CategoriaSeguro.VIDA) || cobertura.contains(CategoriaSeguro.RESIDENCIAL);
            return valorSegurado.compareTo(capitalPermitido) <= 0 && seguroValido && validaCapitalESeguroAuto(valorSegurado, cobertura) && validaCapital(valorSegurado, cobertura);
        }

        private Boolean validaCapitalESeguroAuto(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("350.000,00");
            boolean seguroValido = cobertura.contains(CategoriaSeguro.AUTO);
            return valorSegurado.compareTo(capitalPermitido) <= 0 && seguroValido;
        }

        private Boolean validaCapital(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("255.000,00");
            return valorSegurado.compareTo(capitalPermitido) <= 0 && temSeguro(cobertura);
        }
    },

    /**
     * Cliente Alto Risco<hr>
     * Cliente com perfil de maior risco, seja por comportamento ou
     * histórico recente de problemas relacionados a sinistros,
     * neste caso é necessário avaliar se:
     * <ul><li>a. Capital segurado não ultrapasse R$ 250.00,00 para seguro auto </li>
     * <li>b. Capital segurado não ultrapasse R$ 150.00,00 para seguro residencial</li>
     * <li>c. Capital segurado não ultrapasse R$ 125.000,00 para qualquer outro tipo de seguro</li>
     * <li>d. Caso contrário deverá ser rejeitada.</li></ul>
     */
    ALTO_RISCO {

        @Override
        public Boolean validar(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("250.00,00");
            boolean seguroValido = cobertura.contains(CategoriaSeguro.AUTO);
            return valorSegurado.compareTo(capitalPermitido) <= 0 && seguroValido && validaCapitalESeguro(valorSegurado, cobertura) && validaCapital(valorSegurado, cobertura);
        }

        private Boolean validaCapitalESeguro(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("150.00,00");
            boolean seguroValido = cobertura.contains(CategoriaSeguro.RESIDENCIAL);
            return valorSegurado.compareTo(capitalPermitido) <= 0 && seguroValido;
        }

        private Boolean validaCapital(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("125.000,00");
            return valorSegurado.compareTo(capitalPermitido) <= 0 && temSeguro(cobertura);

        }
    },

    /**
     * Cliente Preferencial<hr>
     * Cliente com um bom relacionamento com a seguradora, geralmente com menor risco associado.
     * A solicitação terá limites maiores para aprovação conforme as seguintes regras:
     * <ul><li>a. Capital segurado inferior a R$ 800.000,00 para seguro vida</li>
     * <li>b. Capital segurado inferior a R$ 450.00,00 para seguro auto e residencial</li>
     * <li>c. Capital segurado não ultrapasse R$ 375.000,00 para qualquer outro tipo de seguro</li>
     * <li>d. Caso contrário deverá ser rejeitada.</li></ul>
     */
    PREFERENCIAL {

        @Override
        public Boolean validar(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("800.000,00");
            boolean seguroValido = cobertura.contains(CategoriaSeguro.VIDA);
            return valorSegurado.compareTo(capitalPermitido) <= 0 && seguroValido && validaCapitalESeguro(valorSegurado, cobertura) && validaCapital(valorSegurado, cobertura);
        }

        private Boolean validaCapitalESeguro(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("450.00,00");
            boolean seguroValido = cobertura.contains(CategoriaSeguro.RESIDENCIAL) && cobertura.contains(CategoriaSeguro.AUTO);
            return valorSegurado.compareTo(capitalPermitido) <= 0 && seguroValido;
        }

        private Boolean validaCapital(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("375.000,00");
            return valorSegurado.compareTo(capitalPermitido) <= 0 && temSeguro(cobertura);
        }
    },

    /**
     * Cliente Sem Informação<hr>
     * Cliente sem histórico ou com pouco histórico com a seguradora.
     * A solicitação será analisada com maior cautela verificando se:
     * <ul><li>a. Capital segurado não ultrapasse R$ 200.00,00 para seguro de vida ou residencial</li>
     * <li>b. Capital segurado não ultrapasse R$75.000,00 para seguro auto</li>
     * <li>c. Capital segurado não ultrapasse R$ 55.000,00 para qualquer</li>
     * <li>d. Caso contrário deverá ser rejeitada.</li></ul>
     */
    SEM_INFORMACAO {

        @Override
        public Boolean validar(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("200.00,00");
            boolean seguroValido = cobertura.contains(CategoriaSeguro.RESIDENCIAL) && cobertura.contains(CategoriaSeguro.VIDA);
            return valorSegurado.compareTo(capitalPermitido) <= 0 && seguroValido && validaCapitalESeguro(valorSegurado, cobertura) && validaCapital(valorSegurado, cobertura);
        }

        private Boolean validaCapitalESeguro(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("75.000,00");
            boolean seguroValido = cobertura.contains(CategoriaSeguro.AUTO);
            return valorSegurado.compareTo(capitalPermitido) <= 0 && seguroValido;
        }

        private Boolean validaCapital(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
            BigDecimal capitalPermitido = new BigDecimal("55.000,00");
            return valorSegurado.compareTo(capitalPermitido) <= 0 && temSeguro(cobertura);
        }
    };

    public abstract Boolean validar(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura);

    public static TipoCliente determinarTipo(BigDecimal valorSegurado, List<CategoriaSeguro> cobertura) {
        for (TipoCliente tipo : TipoCliente.values()) {
            if (tipo.validar(valorSegurado, cobertura)) {
                return tipo;
            }
        }
        return null;
    }

    /**
     * INTERNAL SERVICE ENUM
     * @param cobertura
     * @return
     */
    private static Boolean temSeguro(List<CategoriaSeguro> cobertura) {
        return cobertura.stream().anyMatch(sg -> Arrays.stream(CategoriaSeguro.values()).toList().contains(sg));
    }

}
