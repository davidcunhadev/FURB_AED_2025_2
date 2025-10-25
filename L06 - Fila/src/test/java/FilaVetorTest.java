import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aula06.FilaCheiaException;
import aula06.FilaVaziaException;
import aula06.FilaVetor;

public class FilaVetorTest {
    FilaVetor<Integer> filaVetor;

    @BeforeEach
    void setup() {
        filaVetor = new FilaVetor<>(3);
    }

    @Test
    void Teste1() {
        // Conferir se o método estaVazia() reconhece fila vazia
        assertEquals(true, filaVetor.estaVazia());
    }

    @Test
    void Teste2() {
        // Conferir se o método estaVazia() reconhece fila não vazia
        filaVetor.inserir(10);

        assertEquals(false, filaVetor.estaVazia());
    }

    @Test
    void Teste3() {
        // Conferir se os dados são enfileirados e desenfilerados corretamente
        filaVetor.inserir(10);
        filaVetor.inserir(20);
        filaVetor.inserir(30);

        assertEquals(10, filaVetor.retirar());
        assertEquals(20, filaVetor.retirar());
        assertEquals(30, filaVetor.retirar());

        assertEquals(true, filaVetor.estaVazia());
    }

    @Test
    void Teste4() {
        // Conferir se a exceção FilaCheiaException é lançada ao tentar exceder a capacidade da fila
        filaVetor.inserir(10);
        filaVetor.inserir(20);
        filaVetor.inserir(30);

        assertThrows(FilaCheiaException.class, () -> {
            filaVetor.inserir(40);
        }); 
    }

    @Test
    void Teste5() {
        // Conferir se a exceção  FilaVaziaException é lançada ao tentar desenfileirar dados de uma fila vazia
        FilaVetor<Integer> filaVetor2 = new FilaVetor<>(3);

        assertThrows(FilaVaziaException.class, () -> {
            filaVetor2.retirar();
        }); 
    }

    @Test
    void Teste6() {
        // Conferir se o método peek() retorna o início da fila
        filaVetor.inserir(10);
        filaVetor.inserir(20);
        filaVetor.inserir(30);

        assertEquals(10, filaVetor.peek());
        assertEquals(10, filaVetor.retirar());
    }

    @Test
    void Teste7() {
        // Conferir se o método liberar() remove os elementos da fila
        filaVetor.inserir(10);
        filaVetor.inserir(20);
        filaVetor.inserir(30);

        filaVetor.liberar();

        assertEquals(true, filaVetor.estaVazia()
        );
    }

    @Test
    void Teste8() {
        // Conferir a concatenação de filas
        filaVetor = new FilaVetor<>(5);
        filaVetor.inserir(10);
        filaVetor.inserir(20);
        filaVetor.inserir(30);

        FilaVetor<Integer> filaVetor2 = new FilaVetor<>(3);
        filaVetor2.inserir(40);
        filaVetor2.inserir(50);

        FilaVetor<Integer> filaVetor3 = filaVetor.criarFilaConcatenada(filaVetor2);

        assertEquals("10,20,30,40,50", filaVetor3.toString());
        assertEquals("10,20,30", filaVetor.toString());
        assertEquals("40,50", filaVetor2.toString());

        assertEquals(8, filaVetor3.getLimite()
        );
    }
}
