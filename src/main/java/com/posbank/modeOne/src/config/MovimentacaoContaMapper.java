package com.posbank.modeOne.src.config;

import com.posbank.modeOne.src.dto.MovimentacaoContaDTO;
import com.posbank.modeOne.src.service.MovimentacaoConta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimentacaoContaMapper {

    MovimentacaoConta movimentacaoContaDtoToMovimentacaoConta(MovimentacaoContaDTO movimentacaoContaDTO);
    MovimentacaoContaDTO movimentacaoContaToMovimentacaoContaDto(MovimentacaoConta movimentacaoConta);
}
