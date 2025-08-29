package com.school.sptech;


import org.junit.jupiter.api.Test;
import java.lang.reflect.*;
import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaEspecificacaoTest {

    @Test
    public void testConstrutorBiblioteca() throws Exception {
        Constructor<Biblioteca> construtor = Biblioteca.class.getDeclaredConstructor(String.class, Double.class);
        assertTrue(Modifier.isPublic(construtor.getModifiers()));
    }

    @Test
    public void testAtributos() throws Exception {
        Field nome = Biblioteca.class.getDeclaredField("nome");
        Field multa = Biblioteca.class.getDeclaredField("multaDiaria");
        Field qtd = Biblioteca.class.getDeclaredField("qtdLivros");
        Field ativa = Biblioteca.class.getDeclaredField("ativa");

        assertAll(
                () -> assertEquals(String.class, nome.getType()),
                () -> assertEquals(Double.class, multa.getType()),
                () -> assertEquals(Integer.class, qtd.getType()),
                () -> assertEquals(Boolean.class, ativa.getType()),
                () -> assertTrue(Modifier.isPrivate(nome.getModifiers())),
                () -> assertTrue(Modifier.isPrivate(multa.getModifiers())),
                () -> assertTrue(Modifier.isPrivate(qtd.getModifiers())),
                () -> assertTrue(Modifier.isPrivate(ativa.getModifiers()))
        );
    }

    @Test
    public void testMetodosEsperados() throws Exception {
        assertNotNull(Biblioteca.class.getDeclaredMethod("registrarLivro", Integer.class));
        assertNotNull(Biblioteca.class.getDeclaredMethod("emprestar", Integer.class));
        assertNotNull(Biblioteca.class.getDeclaredMethod("devolver", Integer.class));
        assertNotNull(Biblioteca.class.getDeclaredMethod("desativar"));
        assertNotNull(Biblioteca.class.getDeclaredMethod("transferir", Biblioteca.class, Integer.class));
        assertNotNull(Biblioteca.class.getDeclaredMethod("reajustarMulta", Double.class));
    }

    @Test
    public void testSettersProibidos() {
        assertThrows(NoSuchMethodException.class, () -> Biblioteca.class.getDeclaredMethod("setMultaDiaria", Double.class));
        assertThrows(NoSuchMethodException.class, () -> Biblioteca.class.getDeclaredMethod("setQtdLivros", Integer.class));
        assertThrows(NoSuchMethodException.class, () -> Biblioteca.class.getDeclaredMethod("setAtiva", Boolean.class));
    }
}

