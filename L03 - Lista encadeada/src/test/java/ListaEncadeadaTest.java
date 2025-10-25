import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula03.ListaEncadeada;
import com.aula03.NoLista;

import static org.junit.jupiter.api.Assertions.*;

public class ListaEncadeadaTest {
    ListaEncadeada<Integer> lista;

    @BeforeEach
    void setup() {
        lista = new ListaEncadeada<Integer>();
    }
    
    @Test
    void Teste1() {
        // Testar se lista vazia
        assertEquals(true, lista.estaVazia());
    }

    @Test
    void Teste2() {
        // Testar se lista não está vazia
        lista.inserir(5);

        assertEquals(false, lista.estaVazia());
    }

    @Test
    void Teste3() {
        // Testar inclusão de um número
        lista.inserir(5);

        assertNotNull(lista.getPrimeiro());
        assertEquals(5, lista.getPrimeiro().getInfo());
        assertEquals(null, lista.getPrimeiro().getProximo());
    }

    @Test
    void Teste4() {
        // Testar inclusão de 3 números
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        
        assertEquals(3, lista.obterComprimento());

        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(15, primeiro.getInfo());

        NoLista<Integer> segundo = primeiro.getProximo();
        assertNotNull(segundo);
        assertEquals(10, segundo.getInfo());

        NoLista<Integer> terceiro = segundo.getProximo();
        assertNotNull(terceiro);
        assertEquals(5, terceiro.getInfo());

        assertNull(terceiro.getProximo());
    }

    @Test
    void Teste5() {
        // Testar busca de dados na lista na primeira posição
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(20, lista.buscar(20).getInfo());
    }

    @Test
    void Teste6() {
        // Testar busca de dados no meio da lista
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(15, lista.buscar(15).getInfo());
    }

    @Test
    void Teste7() {
        // Testar busca de dados inexistente
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(null, lista.buscar(50));
    }

    @Test
    void Teste8() {
        // Testar exclusão de primeiro elemento da lista
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(20);
        assertEquals(3, lista.obterComprimento());

        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(15, primeiro.getInfo());

        NoLista<Integer> segundo = primeiro.getProximo();
        assertNotNull(segundo);
        assertEquals(10, segundo.getInfo());

        NoLista<Integer> terceiro = segundo.getProximo();
        assertNotNull(terceiro);
        assertEquals(5, terceiro.getInfo());

        assertNull(terceiro.getProximo());
    }

    @Test
    void Teste9() {
        // Testar exclusão de elemento no meio da lista
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.retirar(15);
        assertEquals(3, lista.obterComprimento());


        NoLista<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(20, primeiro.getInfo());

        NoLista<Integer> segundo = primeiro.getProximo();
        assertNotNull(segundo);
        assertEquals(10, segundo.getInfo());

        NoLista<Integer> terceiro = segundo.getProximo();
        assertNotNull(terceiro);
        assertEquals(5, terceiro.getInfo());

        assertNull(terceiro.getProximo());
    }

    @Test
    void Teste10() {
        // Testar que obterNo() retorna nó da posição 0
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(20, lista.obterNo(0).getInfo());
    }

    @Test
    void Teste11() {
        // Testar que obterNo() retorna nó da última posição
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(5, lista.obterNo(3).getInfo());
    }

    @Test
    void Teste12() {
        // Testar que obterNo() recusa tentativa de ler posição inválida
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
    
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.obterNo(10).getInfo();
        });
    }

    @Test
    void Teste13() {
        // Testar criar lista vazia retorna em obterComprimento = 0
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    void Teste14() {
        // Testar criar lista não vazia para retornar em obterComprimento = 4
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.obterComprimento());
    }
}
