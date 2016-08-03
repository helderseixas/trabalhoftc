/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.xml;

import br.com.helderseixas.trabalhoftc.entidades.Estado;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author helder
 */
public class EstadoAdapter extends XmlAdapter<Estado, Estado>{

    public static Map<Integer,Estado> estadosLidos = new HashMap<>();
    
    @Override
    public Estado unmarshal(Estado v) throws Exception {
        estadosLidos.put(v.getId(), v);
        return v;
    }

    @Override
    public Estado marshal(Estado v) throws Exception {
        return v;
    }
    
}
