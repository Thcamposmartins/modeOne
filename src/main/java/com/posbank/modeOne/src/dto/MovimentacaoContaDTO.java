package com.posbank.modeOne.src.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.posbank.modeOne.src.service.ContaCorrente;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class MovimentacaoContaDTO {
    @JsonProperty
    private ContaCorrente conta;

    @JsonProperty
    private BigDecimal valor;

    @JsonProperty
    private int operacao;

}
