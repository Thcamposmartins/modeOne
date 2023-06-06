package com.posbank.modeOne.src.repository;

import com.posbank.modeOne.src.service.ContaCorrente;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class ContasCorrenteRepository {
    private Set<ContaCorrente> contas;

    public ContasCorrenteRepository() {
        contas = new HashSet<>();
    }

    public void salvar(ContaCorrente conta) {
        contas.add(conta);
    }

    public Optional<ContaCorrente> buscar(String banco, String agencia, String numero){
        return contas.stream()
                .filter(contaCorrente -> contaCorrente.indentificadaPor(banco, agencia, numero))
                .findFirst();
    }

    public void fechar(UUID id) {
        Stream<ContaCorrente> conta = contas.stream().filter(x -> x.getId().equals(id));

        contas.remove(conta);
    }
}
