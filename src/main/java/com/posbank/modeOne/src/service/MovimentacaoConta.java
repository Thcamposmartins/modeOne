package com.posbank.modeOne.src.service;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class MovimentacaoConta {

    private ContaCorrente conta;

    private BigDecimal valor;

    private int operacao;

    public int obterNumeroConta(){
        return conta.obterNumeroConta();
    }

    public void executarEm(ContaCorrente conta){
        Operacao operacao = Operacao.values()[this.operacao];
        conta.executar(operacao, valor);
    }

    public String getBanco() {
        return conta.getBanco();
    }

    public String getAgencia() {
        return conta.getAgencia();
    }

    public String getNumero() {
        return conta.getNumero();
    }
}
