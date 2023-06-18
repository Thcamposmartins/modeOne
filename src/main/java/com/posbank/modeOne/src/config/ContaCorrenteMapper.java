package com.posbank.modeOne.src.config;

import com.posbank.modeOne.src.dto.ContaCorrenteDTO;
import com.posbank.modeOne.src.service.ContaCorrente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContaCorrenteMapper {

    ContaCorrente contaCorrenteDtoToContaCorrente(ContaCorrenteDTO contaCorrenteDTO);
    ContaCorrenteDTO contaCorrenteToContaCorrenteDto(ContaCorrente contaCorrente);
}
