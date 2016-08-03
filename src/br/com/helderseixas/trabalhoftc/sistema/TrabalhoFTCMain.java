/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.sistema;

import br.com.helderseixas.trabalhoftc.entidades.AutomatoFinitoDeterministico;
import br.com.helderseixas.trabalhoftc.entidades.AutomatoFinitoNaoDeterministico;
import br.com.helderseixas.trabalhoftc.xml.ManipuladorXML;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

/**
 *
 * @author helder
 */
public class TrabalhoFTCMain {

    public static void main(String[] parametros){
        Scanner teclado = new Scanner(System.in);
        ManipuladorXML manipuladorXML = new ManipuladorXML();
        ValidadorPalavras validadorPalavras = new ValidadorPalavras();
        
        System.out.println("================== Trabalho FTC ==================");
        System.out.println("Conversor de AFN para AFD e validador de setenças");
        
        System.out.print("\n\n\nNome do arquivo contendo AFN: ");
        String nomeArquivo = teclado.nextLine();       
        System.out.println("\nLendo arquivo "+nomeArquivo+"...");
        try {
            AutomatoFinitoNaoDeterministico afn = manipuladorXML.lerXML(nomeArquivo);
            System.out.println("Arquivo "+nomeArquivo+" lido com sucesso!");
        
            System.out.println("\n\nIniciando conversão de AFN para AFD...");
            AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(afn);
            String nomeArquivoAFD = null;
            if(nomeArquivo.contains(".jff")){
                nomeArquivoAFD = nomeArquivo.replaceAll(".jff", "_AFD.jff");
            }else{
                nomeArquivoAFD = nomeArquivo+"_AFD.jff";
            }            
            manipuladorXML.persistirXML(afd, nomeArquivoAFD);
            System.out.println("Conversão realizada com sucesso!");
            System.err.println("Um arquivo com nome "+nomeArquivoAFD+" foi criado contendo os dados do AFD.");
            
            System.out.print("\n\n===Teste sentenças===");
            String continuar;
            do{                
                System.out.print("\n\nSentença: ");
                String sentenca = teclado.nextLine();
                if(validadorPalavras.validarPalavra(afd, sentenca)){
                    System.out.println("\nRESULTADO: sentença válida!");
                }else{
                    System.out.println("\nRESULTADO: sentença inválida!");
                }
                
                
                System.out.println("\nDeseja testar nova sentença? (S para SIM)");
                continuar = teclado.next();
                teclado.nextLine();
                
            }while(continuar.equals("S") || continuar.equals("s"));                                    
        } catch (JAXBException ex) {
            System.err.println("Erro ao manipular arquivo XML: "+nomeArquivo);
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.out);
        }catch(Exception ex){
            System.err.println("Erro: "+ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
    
}
