import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aula06.FilaLista;

public class FilaListaTest {
    FilaLista<Integer> filaLista;

    @BeforeEach
    void setup() {
        filaLista = new FilaLista<>();
    }

    @Test
    void Teste1() {
        // Conferir se o método estaVazia() reconhece fila vazia
        assertEquals(true, filaLista.estaVazia());
    }

    @Test
    void Teste2() {
        // Conferir se o método estaVazia() reconhece fila não vazia
        filaLista.inserir(10);

        assertEquals(false, filaLista.estaVazia());
    }

    @Test
    void Teste3() {
        // Conferir se os dados são enfileirados e desenfileirados corretamente
        filaLista.inserir(10);
        filaLista.inserir(20);
        filaLista.inserir(30);

        assertEquals(10, filaLista.retirar());
        assertEquals(20, filaLista.retirar());
        assertEquals(30, filaLista.retirar());

        assertEquals(true, filaLista.estaVazia());
    }

    @Test
    void Teste4() {
        // Conferir se o método peek() retorna o início da fila
        filaLista.inserir(10);
        filaLista.inserir(20);
        filaLista.inserir(30);

        assertEquals(10, filaLista.peek());
        assertEquals(10, filaLista.retirar());
    }

    @Test
    void Teste5() {
        // Conferir se o método liberar() remove os elementos da fila
        filaLista.inserir(10);
        filaLista.inserir(20);
        filaLista.inserir(30);

        filaLista.liberar();

        assertEquals(true, filaLista.estaVazia());
    }
}
