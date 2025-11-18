import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula10.OrdenacaoBolha;
import com.aula10.OrdenacaoBolhaOtimizada;
import com.aula10.OrdenacaoMergeSort;
import com.aula10.OrdenacaoQuickSort;

public class OrdenacaoTest {
    OrdenacaoBolha<Integer> vetorBolha;
    OrdenacaoBolhaOtimizada<Integer> vetorBolhaOtimizado;
    OrdenacaoQuickSort<Integer> vetorQuicksort;
    OrdenacaoMergeSort<Integer> vetorMergesort;

    @BeforeEach
    void setup() {
        vetorBolha = new OrdenacaoBolha<>();
        vetorBolhaOtimizado = new OrdenacaoBolhaOtimizada<>();
        vetorQuicksort = new OrdenacaoQuickSort<>();
        vetorMergesort = new OrdenacaoMergeSort<>();
    }

    @Test
    void Teste1() {
        // Validar algoritmo de ordenação Bolha
        Integer[] vetorInt = {70, 2, 88, 15, 90, 30};
        vetorBolha.setInfo(vetorInt);

        vetorBolha.ordenar();

        Integer[] result = {2,15,30,70,88,90};
        assertArrayEquals(result, vetorBolha.getInfo());
    }

    @Test
    void Teste2() {
        // Validar algoritmo de ordenação bolha otimizado
        Integer[] vetorInt = {70, 2, 88, 15, 90, 30};
        vetorBolhaOtimizado.setInfo(vetorInt);

        vetorBolhaOtimizado.ordenar();

        Integer[] result = {2,15,30,70,88,90};
        assertArrayEquals(result, vetorBolhaOtimizado.getInfo());
    }

    @Test
    void Teste3() {
        // Validar algoritmo de ordenação Quicksort
        Integer[] vetorInt = {70, 2, 88, 15, 90, 30};
        vetorQuicksort.setInfo(vetorInt);

        vetorQuicksort.ordenar();

        Integer[] result = {2,15,30,70,88,90};
        assertArrayEquals(result, vetorQuicksort.getInfo());
    }

    @Test
    void Teste4() {
        // Validar algoritmo de ordenação MergeSort
        Integer[] vetorInt = {70, 2, 88, 15, 90, 30};
        vetorMergesort.setInfo(vetorInt);

        vetorMergesort.ordenar();

        Integer[] result = {2,15,30,70,88,90};
        assertArrayEquals(result, vetorMergesort.getInfo());
    }
}