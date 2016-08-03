/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.entidades;

import br.com.helderseixas.trabalhoftc.excecoes.MaisDeUmEstadoInicialException;
import br.com.helderseixas.trabalhoftc.excecoes.NenhumEstadoInicialException;
import br.com.helderseixas.trabalhoftc.xml.EstadoAdapter;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author helder
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AutomatoFinitoNaoDeterministico {

    @XmlElement(name = "state")
    @XmlJavaTypeAdapter(EstadoAdapter.class)
    protected Set<Estado> estados;
    @XmlElement(name = "transition")
    protected Set<Transicao> transicoes;

    @XmlTransient
    protected Set<Character> alfabeto;
    @XmlTransient
    protected Estado estadoInicial;

    public AutomatoFinitoNaoDeterministico(Set<Estado> estados,
            Set<Transicao> transicoes) {
        this.estados = estados;
        this.transicoes = transicoes;

        this.carregarEstadoInicial();
        this.carregarAlfabeto();
    }

    protected AutomatoFinitoNaoDeterministico() {

    }

    public void carregarEstadoInicial(){
        for (Estado estado : this.estados) {
            if (estado.isInicial() && this.estadoInicial == null) {
                this.estadoInicial = estado;
            } else if (estado.isInicial() && this.estadoInicial != null) {
                throw new MaisDeUmEstadoInicialException();
            }
        }
        if (this.estadoInicial == null) {
            throw new NenhumEstadoInicialException();
        }        
    }
    
    public void carregarAlfabeto() {
        this.alfabeto = new HashSet<>();
        for (Transicao transicao : transicoes) {
            this.alfabeto.add(transicao.getSimbolo());
        }
    }

    public Estado getEstadoInicial() {
        return this.estadoInicial;
    }

}
