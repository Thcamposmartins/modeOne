package com.posbank.modeOne.src.controller;

import com.googlecode.jmapper.JMapper;
import com.posbank.modeOne.src.dto.ContaCorrenteDTO;
import com.posbank.modeOne.src.dto.CorrentistaDTO;
import com.posbank.modeOne.src.repository.ContasCorrenteRopository;
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
    private ContasCorrenteRopository contasCorrenteRopository;
//    @Autowired
//    private JMapper<ContaCorrente, ContaCorrenteDTO> contaCorrenteMapper;

    @PostMapping
    public ResponseEntity<ContaCorrente> criarConta(@RequestBody CorrentistaDTO correntistaDTO) {

        String banco = "123";
        String agencia = "545454";
        String numero = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));

        ContaCorrente conta = new ContaCorrente(banco, agencia, numero, correntistaDTO.toCorrentista());
        contasCorrenteRopository.salvar(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @GetMapping
    public ResponseEntity<String> consultarSaldo(@RequestParam(name = "banco") String banco,
                                                 @RequestParam(name = "agencia") String agencia,
                                                 @RequestParam(name = "numero") String numero) {
        ContaCorrente contaCorrente = contasCorrenteRopository.buscar(banco, agencia, numero).orElse(new ContaCorrente());

        return ResponseEntity.status(200).body("Seu saldo atual é de " + contaCorrente.lerSaldo() + " reais !");
    }

    @PutMapping
    public ResponseEntity<String> movimentarConta(@RequestBody MovimentacaoConta movimentacao) {

        Optional<ContaCorrente> opContaCorrente = contasCorrenteRopository.buscar(movimentacao.getBanco(), movimentacao.getAgencia(), movimentacao.getNumero());
        if (opContaCorrente.isEmpty()) {
            return ResponseEntity.badRequest().body("Conta corrente não existe");
        }
        ContaCorrente contaCorrente = opContaCorrente.get();
        movimentacao.executarEm(contaCorrente);
        contasCorrenteRopository.salvar(contaCorrente);

        return ResponseEntity.status(200).body("Moviventação realizada com sucesso");
    }

    @DeleteMapping
    public ResponseEntity<String> fecharConta(@RequestParam(name = "id") UUID id){
//        ContaCorrente conta = contaCorrenteMapper.getDestination(contaCorrenteDTO);
        contasCorrenteRopository.fechar(id);
        return ResponseEntity.status(200).body("Fechamento de conta realizada com sucesso");
    }
}
