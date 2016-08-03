/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.xml;

import br.com.helderseixas.trabalhoftc.entidades.Estado;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author helder
 */
public class TransicaoEstadoAdapter extends XmlAdapter<Integer, Estado>{

    @Override
    public Estado unmarshal(Integer v) throws Exception {
        return EstadoAdapter.estadosLidos.get(v);
    }

    @Override
    public Integer marshal(Estado v) throws Exception {
        return v.getId();
    }

    
}
