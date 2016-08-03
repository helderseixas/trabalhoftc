/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.entidades;

import br.com.helderseixas.trabalhoftc.xml.CharacterAdapter;
import br.com.helderseixas.trabalhoftc.xml.TransicaoEstadoAdapter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author helder
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Transicao {
    @XmlElement(name = "from")
    @XmlJavaTypeAdapter(TransicaoEstadoAdapter.class)
    private Estado estadoOrigem;
    @XmlElement(name = "read")
    @XmlJavaTypeAdapter(CharacterAdapter.class)
    private Character simbolo;
    @XmlElement(name = "to")
    @XmlJavaTypeAdapter(TransicaoEstadoAdapter.class)
    private Estado estadoDestino;

    public Transicao(Estado estadoOrigem, char simbolo, Estado estadoDestino) {
        this.estadoOrigem = estadoOrigem;
        this.simbolo = simbolo;
        this.estadoDestino = estadoDestino;
    }
    
    private Transicao(){
        
    }

    public Estado getEstadoOrigem() {
        return estadoOrigem;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public Estado getEstadoDestino() {
        return estadoDestino;
    }
    
    
}
