package com.posbank.modeOne.src.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Correntista {

    @JsonProperty
    String CPF;

    @JsonProperty
    String nome;

    @JsonProperty
    Boolean ativo;

    private LocalDate dataEntrada;

    public Correntista() {
        this.ativo = true;
        this.dataEntrada = LocalDate.now();
    }

    public Correntista(String cpf, String nome) {
        this();
        this.CPF = cpf;
        this.nome = nome;
    }
}
