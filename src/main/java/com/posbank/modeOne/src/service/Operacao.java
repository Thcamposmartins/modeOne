package com.posbank.modeOne.src.service;

import java.math.BigDecimal;

public enum Operacao {
    DEPOSITO {
        @Override
        public BigDecimal executar(BigDecimal saldo, BigDecimal valor) {
            return saldo.add(valor);
        }
    }, SAQUE {
        @Override
        public BigDecimal executar(BigDecimal saldo, BigDecimal valor) {
            return saldo.equals(BigDecimal.ZERO) ? saldo.subtract(BigDecimal.ZERO) : saldo.subtract(valor);
        }
    };

    public abstract BigDecimal executar(BigDecimal saldo, BigDecimal valor);
}
