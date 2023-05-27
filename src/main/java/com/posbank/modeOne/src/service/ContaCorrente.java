package com.posbank.modeOne.src.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.beans.BeanInfo;
import java.math.BigDecimal;
import java.util.UUID;

public class ContaCorrente {
    @Getter
    @JsonProperty
    UUID id;

    @Getter
    @Setter
    @JsonProperty
    String banco;

    @Getter
    @Setter
    @JsonProperty
    String agencia;

    @Getter
    @Setter
    @JsonProperty
    String numero;

    @JsonProperty
    BigDecimal saldo;

    @JsonProperty
    private Correntista correntista;

    public ContaCorrente( String banco, String agencia, String numero, Correntista correntista) {
        this();
        this.id = UUID.randomUUID();
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.correntista = correntista;
    }

    public ContaCorrente(){
        this.saldo = BigDecimal.ZERO;
    }

    public int obterNUmeroConta(){
        return Integer.parseInt(numero);
    }

    public boolean indentificadaPor(String banco, String agencia, String numero){
        return this.banco.equals(banco)
                && this.agencia.equals(agencia)
                && this.numero.equals(numero);
    }

    public BigDecimal lerSaldo() {
        return saldo;
    }

    public void executar(Operacao operacao, BigDecimal valor){
        saldo = operacao.executar(saldo, valor);
    }

}
