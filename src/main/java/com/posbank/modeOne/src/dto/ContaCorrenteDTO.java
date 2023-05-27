package com.posbank.modeOne.src.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.posbank.modeOne.src.service.Correntista;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

public class ContaCorrenteDTO {
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
    Correntista correntista;

}
