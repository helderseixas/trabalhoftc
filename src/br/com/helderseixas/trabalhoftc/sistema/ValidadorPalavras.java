/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.sistema;

import br.com.helderseixas.trabalhoftc.entidades.AutomatoFinitoDeterministico;
import br.com.helderseixas.trabalhoftc.entidades.Estado;
import br.com.helderseixas.trabalhoftc.excecoes.TransicaoInexistenteException;

/**
 *
 * @author helder
 */
public class ValidadorPalavras {

    public boolean validarPalavra(AutomatoFinitoDeterministico afd,
            String palavra) {

        try {
            Estado estadoAtual = afd.getEstadoInicial();
            int indicePalavra = 0;
            while (indicePalavra < palavra.length()) {
                char simboloAtual = palavra.charAt(indicePalavra);
                indicePalavra++;                

                estadoAtual = afd.transitar(estadoAtual, simboloAtual);
            }
            
            return estadoAtual.isAceitacao();
            
        } catch (TransicaoInexistenteException e) {
            return false;
        }

    }

}
