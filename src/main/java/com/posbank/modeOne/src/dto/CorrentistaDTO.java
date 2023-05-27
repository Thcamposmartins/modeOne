package com.posbank.modeOne.src.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.posbank.modeOne.src.service.Correntista;

public class CorrentistaDTO {
    @JsonProperty
    String CPF;

    @JsonProperty
    String nome;

    @JsonProperty
    Boolean ativo;

    public Correntista toCorrentista(){
        return new Correntista(CPF, nome);
    }
}
