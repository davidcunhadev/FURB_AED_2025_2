import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula11.ArvoreBinariaBusca;
import com.aula11.BuscaBinaria;
import com.aula11.BuscaLinear;
import com.aula11.BuscaLinearVetorOrdenado;

public class BuscaTest {
    BuscaLinear<Integer> listaBuscaLinear;
    BuscaLinearVetorOrdenado<Integer> listaBuscaLinearVetorOrdenado;
    BuscaBinaria<Integer> listaBuscaBinaria;
    ArvoreBinariaBusca<Integer> arvoreBinariaBusca;

    @BeforeEach
    void setup() {
        listaBuscaLinear = new BuscaLinear<>();
        listaBuscaLinearVetorOrdenado = new BuscaLinearVetorOrdenado<>();
        listaBuscaBinaria = new BuscaBinaria<>();
        arvoreBinariaBusca = new ArvoreBinariaBusca<>();
    }

    @Test
    void Teste1() {
        // Conferir que o método buscar() localiza um dado armazenado através do algoritmo de busca linear.

        Integer[] dados = new Integer[] {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        listaBuscaLinear.setInfo(dados);

        assertEquals(2, listaBuscaLinear.buscar(20));
    }

    @Test
    void Teste2() {
        // Conferir que o método buscar() localiza um dado armazenado através do algoritmo de busca linear em vetor ordenado.

        Integer[] dados = new Integer[] {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        listaBuscaLinearVetorOrdenado.setInfo(dados);

        assertEquals(4, listaBuscaLinearVetorOrdenado.buscar(40));
    }

    @Test
    void Teste3() {
        // Conferir que o método buscar() localiza um dado armazenado através do algoritmo de busca binária

        Integer[] dados = new Integer[] {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        listaBuscaBinaria.setInfo(dados);

        assertEquals(7, listaBuscaBinaria.buscar(70));
    }

    @Test
    void Teste4() {
        // Conferir que o método buscar() localiza um dado armazenado através do algoritmo de busca binária

        Integer[] dados = new Integer[] {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        listaBuscaBinaria.setInfo(dados);

        assertEquals(-1, listaBuscaBinaria.buscar(75));
    }

    @Test
    void Teste5() {
        // Conferir se o método inserir() mantém os dados armazenados adequadamente, 
        // mantendo a árvore com a característica de ser uma árvore binária de busca.

        arvoreBinariaBusca.inserir(50);
        arvoreBinariaBusca.inserir(30);
        arvoreBinariaBusca.inserir(70);
        arvoreBinariaBusca.inserir(40);
        arvoreBinariaBusca.inserir(25);
        arvoreBinariaBusca.inserir(75);
        arvoreBinariaBusca.inserir(65);
        arvoreBinariaBusca.inserir(35);
        arvoreBinariaBusca.inserir(60);

        assertEquals("<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>", arvoreBinariaBusca.toString());
    }
}