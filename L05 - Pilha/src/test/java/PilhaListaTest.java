import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula05.PilhaLista;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaListaTest {
        PilhaLista<Integer> pilhaLista;

    @BeforeEach
    void setup() {
        pilhaLista = new PilhaLista<>();
    }

    @Test
    void Teste1() {
        // Conferir se o método estaVazia() reconhece pilha vazia.
        assertEquals(true, pilhaLista.estaVazia());
    }

    @Test
    void Teste2() {
        // Conferir se o método estaVazia() reconhece pilha não vazia.
        pilhaLista.push(10);

        assertEquals(false, pilhaLista.estaVazia());
    }

    @Test
    void Teste3() {
        // Conferir se os dados são empilhados e desempilhados corretamente
        pilhaLista.push(10);
        pilhaLista.push(20);
        pilhaLista.push(30);

        assertEquals(30, pilhaLista.pop());
        assertEquals(20, pilhaLista.pop());
        assertEquals(10, pilhaLista.pop());
        
        assertEquals(true, pilhaLista.estaVazia());
    }

    @Test
    void Teste4() {
        // Conferir se o método peek() retorna o topo da pilha
        pilhaLista.push(10);
        pilhaLista.push(20);
        pilhaLista.push(30);
        
        assertEquals(30, pilhaLista.peek());
        assertEquals(30, pilhaLista.pop());
    }

    @Test
    void Teste5() {
        // Conferir se o método liberar() remove os elementos da pilha
        pilhaLista.push(10);
        pilhaLista.push(20);
        pilhaLista.push(30);
        
        pilhaLista.liberar();

        assertEquals(true, pilhaLista.estaVazia());
    }
}
