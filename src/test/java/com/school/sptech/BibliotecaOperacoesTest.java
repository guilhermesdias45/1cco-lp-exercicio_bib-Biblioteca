package com.school.sptech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaOperacoesTest {

    Biblioteca b;

    @BeforeEach
    void setUp() {
        b = new Biblioteca("Central", 2.5);
    }

    @Test
    void testMatricularValido() {
        b.registrarLivro(5);
        assertEquals(5, b.getQtdLivros());
    }

    @Test
    void testMatricularInvalido() {
        b.registrarLivro(-3);
        b.registrarLivro(null);
        b.registrarLivro(0);
        assertEquals(0, b.getQtdLivros());
    }

    @Test
    void testEmprestarValido() {
        b.registrarLivro(10);
        Integer resultado = b.emprestar(4);
        assertEquals(6, b.getQtdLivros());
        assertEquals(4, resultado);
    }

    @Test
    void testEmprestarInvalido() {
        b.registrarLivro(3);
        assertNull(b.emprestar(5));
        assertNull(b.emprestar(null));
        assertNull(b.emprestar(0));
        assertNull(b.emprestar(-2));
        assertEquals(3, b.getQtdLivros());
    }

    @Test
    void testDevolverValido() {
        b.devolver(4);
        assertEquals(4, b.getQtdLivros());
    }

    @Test
    void testDevolverInvalido() {
        b.devolver(0);
        b.devolver(null);
        b.devolver(-3);
        assertEquals(0, b.getQtdLivros());
    }

    @Test
    void testDesativar() {
        b.registrarLivro(8);
        Integer retorno = b.desativar();
        assertEquals(8, retorno);
        assertFalse(b.getAtiva());
        assertEquals(0, b.getQtdLivros());
    }

    @Test
    void testDesativarJaInativa() {
        b.desativar();
        Integer retorno = b.desativar();
        assertNull(retorno);
    }

    @Test
    void testTransferenciaValida() {
        Biblioteca destino = new Biblioteca("Filial", 2.5);
        b.registrarLivro(10);
        b.transferir(destino, 4);
        assertEquals(6, b.getQtdLivros());
        assertEquals(4, destino.getQtdLivros());
    }

    @Test
    void testTransferenciaInvalida() {
        Biblioteca destino = new Biblioteca("Filial", 2.5);
        b.registrarLivro(3);
        b.transferir(destino, 10);
        assertEquals(3, b.getQtdLivros());
        assertEquals(0, destino.getQtdLivros());
    }

    @Test
    void testReajusteValido() {
        boolean reajustou = b.reajustarMulta(0.10);
        assertTrue(reajustou);
        assertEquals(2.75, b.getMultaDiaria());
    }

    @Test
    void testReajusteInvalido() {
        assertFalse(b.reajustarMulta(null));
        assertFalse(b.reajustarMulta(0.0));
        assertFalse(b.reajustarMulta(-0.2));
        assertEquals(2.5, b.getMultaDiaria());
    }
}

