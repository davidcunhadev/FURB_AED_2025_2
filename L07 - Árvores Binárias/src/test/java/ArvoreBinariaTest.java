import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula07.ArvoreBinaria;
import com.aula07.NoArvoreBinaria;

public class ArvoreBinariaTest {
    ArvoreBinaria<Integer> arvoreBinaria;

    @BeforeEach
    void setup() {
        arvoreBinaria = new ArvoreBinaria<>();
    }

    @Test
    void Teste1() {
        // Conferir se é reconhecida árvore vazia
        assertEquals(true, arvoreBinaria.estaVazia());
    }

    @Test
    void Teste2() {
        // Conferir se é reconhecida árvore não vazia
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, null, null);
        arvoreBinaria.setRaiz(no1);
        
        assertEquals(false, arvoreBinaria.estaVazia());
    }

    @Test
    void Teste3() {
        // Conferir a representação textual da árvore usando o caminho pré-ordem
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6, null, null);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5, null, null);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4, null, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);
        
        arvoreBinaria.setRaiz(no1);

        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvoreBinaria.toString());
    }

    @Test
    void Teste4() {
        // Conferir se a árvore consegue avaliar se um valor armazenado na raiz pertence à árvore
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6, null, null);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5, null, null);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4, null, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);

        arvoreBinaria.setRaiz(no1);

        assertEquals(true, arvoreBinaria.pertence(1));
    }

    @Test
    void Teste5() {
        // Conferir se a árvore consegue avaliar se um valor armazenado num nó não raiz e não folha pertence à árvore
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6, null, null);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5, null, null);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4, null, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);

        arvoreBinaria.setRaiz(no1);

        assertEquals(true, arvoreBinaria.pertence(3));
    }

    @Test
    void Teste6() {
        // Conferir se a árvore consegue avaliar se um valor armazenado num nó folha pertence à árvore
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6, null, null);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5, null, null);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4, null, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);

        arvoreBinaria.setRaiz(no1);

        assertEquals(true, arvoreBinaria.pertence(6));
    }

    @Test
    void Teste7() {
        // Conferir se a árvore conclui que determinado dado não pertence à árvore
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6, null, null);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5, null, null);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4, null, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);

        arvoreBinaria.setRaiz(no1);

        assertEquals(false, arvoreBinaria.pertence(10));
    }

    @Test
    void Teste8() {
        // Verificar se o árvore consegue contar a quantidade de nós de uma árvore com altura igual à 2.
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6, null, null);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5, null, null);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4, null, null);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);

        arvoreBinaria.setRaiz(no1);

        assertEquals(6, arvoreBinaria.contarNos());
    }
}
