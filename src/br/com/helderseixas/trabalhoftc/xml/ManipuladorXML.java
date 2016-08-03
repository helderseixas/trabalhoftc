/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.xml;

import br.com.helderseixas.trabalhoftc.entidades.AutomatoFinitoNaoDeterministico;
import br.com.helderseixas.trabalhoftc.entidades.Estrutura;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author helder
 */
public class ManipuladorXML {

    public void persistirXML(AutomatoFinitoNaoDeterministico afn, String nomeArquivo) throws JAXBException {
        Estrutura estrutura = new Estrutura(afn);

        JAXBContext jc = JAXBContext.newInstance(Estrutura.class);
        File xml = new File(nomeArquivo);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(estrutura, xml);
    }
    
    public AutomatoFinitoNaoDeterministico lerXML(String nomeArquivo) throws JAXBException{
        JAXBContext jc = JAXBContext.newInstance(Estrutura.class);
        File xml = new File(nomeArquivo);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Estrutura estrutura = (Estrutura) unmarshaller.unmarshal(xml);
        estrutura.getAutomatoFinito().carregarEstadoInicial();
        estrutura.getAutomatoFinito().carregarAlfabeto();
        return estrutura.getAutomatoFinito();
    }
}
