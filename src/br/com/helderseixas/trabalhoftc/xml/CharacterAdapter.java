/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author helder
 */
public class CharacterAdapter extends XmlAdapter<String, Character>{

    @Override
    public Character unmarshal(String v) throws Exception {
        return v.charAt(0);
    }

    @Override
    public String marshal(Character v) throws Exception {
        return v.toString();
    }
    
}
