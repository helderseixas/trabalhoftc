/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.entidades;

import br.com.helderseixas.trabalhoftc.excecoes.TransicaoInexistenteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author helder
 */
public class AutomatoFinitoDeterministico extends AutomatoFinitoNaoDeterministico {

    public AutomatoFinitoDeterministico(AutomatoFinitoNaoDeterministico afn) {
        super();
        this.converter(afn);
    }

    private void converter(AutomatoFinitoNaoDeterministico afn) {
        List<Estado> estadosParaVerificar = new ArrayList<>();

        this.alfabeto = afn.alfabeto;
        this.transicoes = new HashSet<>();
        this.estados = new HashSet<>();

        this.estadoInicial = afn.estadoInicial;
        this.estados.add(this.estadoInicial);
        estadosParaVerificar.add(this.estadoInicial);

        while (!estadosParaVerificar.isEmpty()) {
            Estado estadoEmVerificacao = estadosParaVerificar.get(0);
            estadosParaVerificar.remove(estadoEmVerificacao);

            for (char simbolo : this.alfabeto) {
                List<Transicao> transicoesEncontradas = afn.transicoes.stream().filter(new Predicate<Transicao>() {
                    @Override
                    public boolean test(Transicao t) {
                        if (t.getSimbolo() == simbolo) {
                            String nomeEstado = t.getEstadoOrigem().getPartesEstado().toArray()[0].toString();
                            return estadoEmVerificacao.getPartesEstado().contains(nomeEstado);
                        } else {
                            return false;
                        }
                    }
                }).collect(Collectors.toList());
                if (!transicoesEncontradas.isEmpty()) {
                    Set<String> partesEstado = new HashSet<>();
                    boolean aceitacao = false;
                    for (Transicao transicao : transicoesEncontradas) {
                        partesEstado.addAll(transicao.getEstadoDestino().getPartesEstado());
                        if (transicao.getEstadoDestino().isAceitacao()) {
                            aceitacao = true;
                        }
                    }

                    Estado estadoDestino = null;
                    Estado estadoNovo = new Estado(partesEstado, false, aceitacao);
                    if (!this.estados.contains(estadoNovo)) {
                        this.estados.add(estadoNovo);
                        estadosParaVerificar.add(estadoNovo);
                        estadoDestino = estadoNovo;
                    } else {
                        for (Estado estado : this.estados) {
                            if(estado.equals(estadoNovo)){
                                estadoDestino = estado;
                                break;
                            }
                        }
                    }
                    Transicao transicao = new Transicao(estadoEmVerificacao, simbolo, estadoDestino);
                    this.transicoes.add(transicao);
                }
            }
        }
    }

    public Estado transitar(Estado estadoAtual, char simboloAtual) {
        Transicao destino = transicoes.stream().filter(new Predicate<Transicao>() {
            @Override
            public boolean test(Transicao t) {
                return t.getEstadoOrigem().equals(estadoAtual) && t.getSimbolo() == simboloAtual;
            }
        }).findFirst().orElse(null);

        if (destino != null) {
            return destino.getEstadoDestino();
        } else {
            throw new TransicaoInexistenteException();
        }
    }

}
