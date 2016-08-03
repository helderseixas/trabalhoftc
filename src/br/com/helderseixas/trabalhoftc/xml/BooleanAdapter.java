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
public class BooleanAdapter extends XmlAdapter<EmptyObject, Boolean> {
    @Override
    public EmptyObject marshal(final Boolean v) {
        return v != null && v ? new EmptyObject() : null;
    }

    @Override
    public Boolean unmarshal(final EmptyObject v) {
        return true;
    }
}
