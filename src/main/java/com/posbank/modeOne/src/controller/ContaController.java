package com.posbank.modeOne.src.controller;

import com.posbank.modeOne.src.config.MovimentacaoContaMapper;
import com.posbank.modeOne.src.dto.CorrentistaDTO;
import com.posbank.modeOne.src.dto.MovimentacaoContaDTO;
import com.posbank.modeOne.src.repository.ContasCorrenteRepository;
import com.posbank.modeOne.src.service.ContaCorrente;
import com.posbank.modeOne.src.service.MovimentacaoConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContasCorrenteRepository contasCorrenteRepository;
    @Autowired
    private MovimentacaoContaMapper mapperMovimentacao;

    @PostMapping
    public ResponseEntity<ContaCorrente> criarConta(@RequestBody CorrentistaDTO correntistaDTO) {

        String banco = "123";
        String agencia = "545454";
        String numero = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));

        ContaCorrente conta = new ContaCorrente(banco, agencia, numero, correntistaDTO.toCorrentista());
        contasCorrenteRepository.salvar(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @GetMapping
    public ResponseEntity<String> consultarSaldo(@RequestParam(name = "banco") String banco,
                                                 @RequestParam(name = "agencia") String agencia,
                                                 @RequestParam(name = "numero") String numero) {
        ContaCorrente contaCorrente = contasCorrenteRepository.buscar(banco, agencia, numero).orElse(new ContaCorrente());

        return ResponseEntity.status(200).body("Seu saldo atual é de " + contaCorrente.lerSaldo() + " reais !");
    }

    @PutMapping
    public ResponseEntity<String> movimentarConta(@RequestBody MovimentacaoContaDTO movimentacaoDTO) {
        MovimentacaoConta movimentacao = mapperMovimentacao.movimentacaoContaDtoToMovimentacaoConta(movimentacaoDTO);
        Optional<ContaCorrente> opContaCorrente = contasCorrenteRepository.buscar(movimentacao.getBanco(), movimentacao.getAgencia(), movimentacao.getNumero());
        if (opContaCorrente.isEmpty()) {
            return ResponseEntity.badRequest().body("Conta corrente não existe");
        }
        ContaCorrente contaCorrente = opContaCorrente.get();
        movimentacao.executarEm(contaCorrente);
        contasCorrenteRepository.salvar(contaCorrente);

        return ResponseEntity.status(200).body("Moviventação realizada com sucesso");
    }

    @DeleteMapping
    public ResponseEntity<String> fecharConta(@RequestParam(name = "id") UUID id){
//        ContaCorrente conta = contaCorrenteMapper.getDestination(contaCorrenteDTO);
        contasCorrenteRepository.fechar(id);
        return ResponseEntity.status(200).body("Fechamento de conta realizada com sucesso");
    }
}
