import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula04.ListaDupla;
import com.aula04.NoListaDupla;

import static org.junit.jupiter.api.Assertions.*;

public class ListaDuplaTest {
    ListaDupla<Integer> lista;

    @BeforeEach
    void setup() {
        lista = new ListaDupla<Integer>();
    }

    @Test
    void Teste1() {
        // Testar método de inclusão de dados na lista encadeada, validando que as ligações proximo e anterior estejam consistentes

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("20,15,10,5", lista.toString());
        assertEquals("5,10,15,20", lista.exibirOrdemInversa());
    }

    @Test
    void Teste2() {
        // Testar buscar elemento no início da estrutura de dados

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.buscar(20).getInfo());
    }

    @Test
    void Teste3() {
        // Testar buscar elemento no meio da estrutura de dados

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(10, lista.buscar(10).getInfo());
    }

    @Test
    void Teste4() {
        // Testar remover elemento no início da lista

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        assertEquals("15,10,5", lista.toString());
        assertEquals("5,10,15", lista.exibirOrdemInversa());
    }

    @Test
    void Teste5() {
        // Testar remover elemento no meio da lista

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("20,15,5", lista.toString());
        assertEquals("5,15,20", lista.exibirOrdemInversa());
    }

    @Test
    void Teste6() {
        // Testar remover elemento no final da lista

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(5);

        assertEquals("20,15,10", lista.toString());
        assertEquals("10,15,20", lista.exibirOrdemInversa());
    }

    @Test
    void Teste7() {
        // Testar liberar dados da lista

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> no1 = lista.buscar(5);
        NoListaDupla<Integer> no2 = lista.buscar(10);
        NoListaDupla<Integer> no3 = lista.buscar(15);
        NoListaDupla<Integer> no4 = lista.buscar(20);

        lista.liberar();

        assertEquals(null, no1.getAnterior());
        assertEquals(null, no1.getProximo());

        assertEquals(null, no2.getAnterior());
        assertEquals(null, no2.getProximo());

        assertEquals(null, no3.getAnterior());
        assertEquals(null, no3.getProximo());

        assertEquals(null, no4.getAnterior());
        assertEquals(null, no4.getProximo());
    }
}
