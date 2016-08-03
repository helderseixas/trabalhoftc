/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helderseixas.trabalhoftc.sistema;

import br.com.helderseixas.trabalhoftc.entidades.AutomatoFinitoDeterministico;
import br.com.helderseixas.trabalhoftc.entidades.AutomatoFinitoNaoDeterministico;
import br.com.helderseixas.trabalhoftc.entidades.Estado;
import br.com.helderseixas.trabalhoftc.entidades.Transicao;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author helder
 */
public class ValidadorPalavrasTest {

    static AutomatoFinitoDeterministico afdNumerosPares01;
    static AutomatoFinitoDeterministico afdTerminaZero;

    public ValidadorPalavrasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        configuraAFDNumerosPares01();
        configuraAFDTerminaZero();
    }

    private static void configuraAFDNumerosPares01() {
        Map<String, Estado> mapEstado = new HashMap<>();
        mapEstado.put("pp", new Estado("pp", true, true));
        mapEstado.put("pi", new Estado("pi"));
        mapEstado.put("ip", new Estado("ip"));
        mapEstado.put("ii", new Estado("ii"));
        Set<Estado> estados = new HashSet<>(mapEstado.values());
        
        Transicao pp0 = new Transicao(mapEstado.get("pp"), '0', mapEstado.get("ip"));
        Transicao pp1 = new Transicao(mapEstado.get("pp"), '1', mapEstado.get("pi"));
        Transicao pi0 = new Transicao(mapEstado.get("pi"), '0', mapEstado.get("ii"));
        Transicao pi1 = new Transicao(mapEstado.get("pi"), '1', mapEstado.get("pp"));
        Transicao ip0 = new Transicao(mapEstado.get("ip"), '0', mapEstado.get("pp"));
        Transicao ip1 = new Transicao(mapEstado.get("ip"), '1', mapEstado.get("ii"));
        Transicao ii0 = new Transicao(mapEstado.get("ii"), '0', mapEstado.get("pi"));
        Transicao ii1 = new Transicao(mapEstado.get("ii"), '1', mapEstado.get("ip"));
        Set<Transicao> transicoes = new HashSet<>();
        transicoes.add(pp0);
        transicoes.add(pp1);
        transicoes.add(pi0);
        transicoes.add(pi1);
        transicoes.add(ip0);
        transicoes.add(ip1);
        transicoes.add(ii0);
        transicoes.add(ii1);

        AutomatoFinitoNaoDeterministico afn
                = new AutomatoFinitoNaoDeterministico(estados, transicoes);
        afdNumerosPares01 = new AutomatoFinitoDeterministico(afn);
    }

    private static void configuraAFDTerminaZero() {
        Map<String, Estado> mapEstado = new HashMap<>();
        mapEstado.put("e1", new Estado("e1", true, false));
        mapEstado.put("e2", new Estado("e2", false, true));
        
        Set<Estado> estados = new HashSet<>(mapEstado.values());
        
        Transicao t1 = new Transicao(mapEstado.get("e1"), '0', mapEstado.get("e1"));
        Transicao t2 = new Transicao(mapEstado.get("e1"), '0', mapEstado.get("e2"));
        Transicao t3 = new Transicao(mapEstado.get("e1"), '1', mapEstado.get("e1"));
        Set<Transicao> transicoes = new HashSet<>();
        transicoes.add(t1);
        transicoes.add(t2);
        transicoes.add(t3);
        
        AutomatoFinitoNaoDeterministico afn
                = new AutomatoFinitoNaoDeterministico(estados, transicoes);
        afdTerminaZero = new AutomatoFinitoDeterministico(afn);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of validarPalavra method, of class ValidadorPalavras.
     */
    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_0() {
        System.out.println("testValidarPalavra_afdNumerosPares01_0");
        String palavra = "0";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_1() {
        System.out.println("testValidarPalavra_afdNumerosPares01_1");
        String palavra = "1";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_00() {
        System.out.println("testValidarPalavra_afdNumerosPares01_00");
        String palavra = "00";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = true;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_01() {
        System.out.println("testValidarPalavra_afdNumerosPares01_01");
        String palavra = "01";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_10() {
        System.out.println("testValidarPalavra_afdNumerosPares01_10");
        String palavra = "10";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_11() {
        System.out.println("testValidarPalavra_afdNumerosPares01_11");
        String palavra = "11";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = true;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_110() {
        System.out.println("testValidarPalavra_afdNumerosPares01_110");
        String palavra = "110";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_1100() {
        System.out.println("testValidarPalavra_afdNumerosPares01_1100");
        String palavra = "1100";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = true;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_1101() {
        System.out.println("testValidarPalavra_afdNumerosPares01_1101");
        String palavra = "1101";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }

    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdNumerosPares01_1102() {
        System.out.println("testValidarPalavra_afdNumerosPares01_1102");
        String palavra = "1101";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdNumerosPares01, palavra);
        assertEquals(expResult, result);
    }
    
    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdTerminaZero_0() {
        System.out.println("testValidarPalavra_afdTerminaZero_0");
        String palavra = "0";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = true;
        boolean result = instance.validarPalavra(afdTerminaZero, palavra);
        assertEquals(expResult, result);
    }    
    
    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdTerminaZero_1() {
        System.out.println("testValidarPalavra_afdTerminaZero_1");
        String palavra = "1";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdTerminaZero, palavra);
        assertEquals(expResult, result);
    }     
    
    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdTerminaZero_00() {
        System.out.println("testValidarPalavra_afdTerminaZero_00");
        String palavra = "00";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = true;
        boolean result = instance.validarPalavra(afdTerminaZero, palavra);
        assertEquals(expResult, result);
    }       
    
    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdTerminaZero_01() {
        System.out.println("testValidarPalavra_afdTerminaZero_01");
        String palavra = "01";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdTerminaZero, palavra);
        assertEquals(expResult, result);
    }           
    
    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdTerminaZero_10() {
        System.out.println("testValidarPalavra_afdTerminaZero_10");
        String palavra = "10";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = true;
        boolean result = instance.validarPalavra(afdTerminaZero, palavra);
        assertEquals(expResult, result);
    }               
    
    @Test
    @SuppressWarnings("empty-statement")
    public void testValidarPalavra_afdTerminaZero_11() {
        System.out.println("testValidarPalavra_afdTerminaZero_11");
        String palavra = "11";
        ValidadorPalavras instance = new ValidadorPalavras();
        boolean expResult = false;
        boolean result = instance.validarPalavra(afdTerminaZero, palavra);
        assertEquals(expResult, result);
    }                   
}
