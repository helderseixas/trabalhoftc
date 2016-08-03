/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author helder
 */
@XmlRootElement(name="structure", namespace = "" )
@XmlAccessorType(XmlAccessType.FIELD)
public class Estrutura {
    
    @XmlElement(name = "type")
    private String tipo;

    @XmlElement(name = "automaton")    
    private AutomatoFinitoNaoDeterministico automatoFinito;

    public Estrutura(AutomatoFinitoNaoDeterministico automatoFinito) {
        this.automatoFinito = automatoFinito;
        tipo = "fa";
    }        
    
    private Estrutura(){
        
    }

    public AutomatoFinitoNaoDeterministico getAutomatoFinito() {
        return automatoFinito;
    }        
}
