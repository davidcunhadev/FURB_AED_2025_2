package lista02_exercicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaEstaticaTest {
    ListaEstatica<Integer> lista;

    @BeforeEach
    void setup() {
        lista = new ListaEstatica<Integer>();
    }

    @Test
    void Teste1() {
        // Testar inserir e toString()
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("5,10,15,20", lista.toString());
    }

    @Test
    void Teste2() {
        // Testar getTamanho()
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.getTamanho());
    }

    @Test
    void Teste3() {
        // Testar buscar existente
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(2, lista.buscar(15));
    }

    @Test
    void Teste4() {
        // Testar buscar inexistente
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(-1, lista.buscar(30));
    }

    @Test
    void Teste5() {
        // Testar retirar
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);
        assertEquals("5,15,20", lista.toString());
    }

    @Test
    void Teste6() {
        // Testar redimensionamento
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(7);
        lista.inserir(8);
        lista.inserir(9);
        lista.inserir(10);
        lista.inserir(11);
        lista.inserir(12);
        lista.inserir(13);
        lista.inserir(14);
        lista.inserir(15);

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());
        assertEquals(15, lista.getTamanho());
    }

    @Test
    void Teste7() {
        // Testar obterElemento válido
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.obterElemento(3));
    }

    @Test
    void Teste8() {
        // Testar obterElemento inválido (exceção)
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.obterElemento(5);
        });
    }

    @Test
    void Teste9() {
        // Testar liberar e estaVazia()
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertEquals(true, lista.estaVazia());
        assertEquals(0, lista.getTamanho());
    }

    @Test
    void inverter() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.inverter();

        assertEquals("20,15,10,5", lista.toString());

        lista.inverter();
        lista.inserir(25);
        lista.inverter();

        assertEquals("25,20,15,10,5", lista.toString());
    }
}
