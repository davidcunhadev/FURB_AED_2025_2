import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula05.PilhaCheiaException;
import com.aula05.PilhaVaziaException;
import com.aula05.PilhaVetor;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaVetorTest {
    PilhaVetor<Integer> pilhaVetor;

    @BeforeEach
    void setup() {
        pilhaVetor = new PilhaVetor<Integer>(3);
    }

    @Test
    void Teste1() {
        // Conferir se o método estaVazia() reconhece pilha vazia.
        assertEquals(true, pilhaVetor.estaVazia());
    }

    @Test
    void Teste2() {
        // Conferir se o método estaVazia() reconhece pilha não vazia.
        pilhaVetor.push(10);    
        
        assertEquals(false, pilhaVetor.estaVazia());
    }

    @Test
    void Teste3() {
        // Conferir se os dados são empilhados e desempilhados corretamente
        pilhaVetor.push(10);    
        pilhaVetor.push(20);    
        pilhaVetor.push(30);

        assertEquals(30, pilhaVetor.pop());
        assertEquals(20, pilhaVetor.pop());
        assertEquals(10, pilhaVetor.pop());
        
        assertEquals(true, pilhaVetor.estaVazia());
    }

    @Test
    void Teste4() {
        // Conferir se a exceção PilhaCheiaException é lançada ao tentar exceder a capacidade da pilha.
        pilhaVetor.push(10);    
        pilhaVetor.push(20);    
        pilhaVetor.push(30);
        
        assertThrows(PilhaCheiaException.class, () -> {
            pilhaVetor.push(40);
        });        
    }

    @Test
    void Teste5() {
        // Conferir se a exceção PilhaVaziaException é lançada ao tentar desempilhar dados de uma pilha vazia.
        
        assertThrows(PilhaVaziaException.class, () -> {
            pilhaVetor.pop();
        });        
    }

    @Test
    void Teste6() {
        // Conferir se o método peek() retorna o topo da pilha
        pilhaVetor.push(10);    
        pilhaVetor.push(20);    
        pilhaVetor.push(30);

        assertEquals(30, pilhaVetor.peek());
        assertEquals(30, pilhaVetor.pop());
    }

    @Test
    void Teste7() {
        // Conferir se o método liberar() remove os elementos da pilha
        pilhaVetor.push(10);    
        pilhaVetor.push(20);    
        pilhaVetor.push(30);

        pilhaVetor.liberar();

        assertEquals(true, pilhaVetor.estaVazia());
    }

    @Test
    void Teste8() {
        // Conferir a concatenação de pilhas 
        pilhaVetor = new PilhaVetor<Integer>(10);
    
        pilhaVetor.push(10);    
        pilhaVetor.push(20);    
        pilhaVetor.push(30);
    
        PilhaVetor<Integer> pilhaVetor2 = new PilhaVetor<Integer>(3);
    
        pilhaVetor2.push(40);
        pilhaVetor2.push(50);
    
        pilhaVetor.concatenar(pilhaVetor2);
    
        assertEquals("50,40,30,20,10", pilhaVetor.toString());
    }    
}
