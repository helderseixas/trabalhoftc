/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.entidades;

import br.com.helderseixas.trabalhoftc.xml.BooleanAdapter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author helder
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Estado {
        
    private static int GERADOR_ID = 0;
    
    @XmlAttribute
    private int id;    
    @XmlTransient
    private Set<String> partesEstado;
    @XmlElement(name = "initial")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean inicial = false;
    @XmlElement(name = "final")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean aceitacao = false;
      
    private Estado(){
        id = GERADOR_ID;
        GERADOR_ID++;
    }

    public Estado(Set<String> partesEstado) {
        this();
        this.partesEstado = partesEstado;
        this.inicial = false;
        this.aceitacao = false;
    }
    
    public Estado(String estado) {
        this();
        partesEstado = new HashSet<>();
        partesEstado.add(estado);
        this.inicial = false;
        this.aceitacao = false;        
    }

    public Estado(Set<String> partesEstado, boolean inicial, boolean aceitacao){
        this(partesEstado);
        this.inicial = inicial;
        this.aceitacao = aceitacao;
    }
    
    public Estado(String estado, boolean inicial, boolean aceitacao) {
        this();
        partesEstado = new HashSet<>();
        partesEstado.add(estado);
        this.inicial = inicial;
        this.aceitacao = aceitacao;
    }

    public boolean isInicial() {
        return inicial;
    }     

    public boolean isAceitacao() {
        return aceitacao;
    }        

    public int getId() {
        return id;
    }        
    
    public Set<String> getPartesEstado() {
        return partesEstado;
    }
    
    @XmlAttribute(name = "name")
    public String getNome(){
        StringBuilder nome = new StringBuilder("[");
        int i = 1;
        for(String parteEstado : this.partesEstado){
            nome.append(parteEstado);
            if(i<this.partesEstado.size()){
                nome.append(",");
            }
            i++;
        }
        nome.append("]");
        return nome.toString();
    }
    
    public void setNome(String nome){
        this.partesEstado = new HashSet<>();
        this.partesEstado.add(nome);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.partesEstado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.partesEstado, other.partesEstado)) {
            return false;
        }
        return true;
    }

   

    
}
