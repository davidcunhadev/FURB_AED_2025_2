import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula08.Arvore;
import com.aula08.NoArvore;

public class ArvoreTest {
    Arvore<Integer> arvore;

    @BeforeEach
    void setup() {
        arvore = new Arvore<>();
    }

    @Test
    void Teste1() {
        // Validar representação textual de uma árvore
        
        NoArvore<Integer> no1 = new NoArvore<Integer>(1);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);
        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);
        NoArvore<Integer> no8 = new NoArvore<Integer>(8);
        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        arvore.setRaiz(no1);

        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        no3.inserirFilho(no8);
        
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);        

        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    @Test
    void Teste2() {
        // Validar que o método buscar() consegue localizar um nó numa árvore
        
        NoArvore<Integer> no1 = new NoArvore<Integer>(1);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);
        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);
        NoArvore<Integer> no8 = new NoArvore<Integer>(8);
        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        arvore.setRaiz(no1);

        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        no3.inserirFilho(no8);
        
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);        

        assertEquals(true, arvore.pertence(7));
    }

    @Test
    void Teste3() {
        // Validar que o método pertence() identifica que dado não consta na árvore
        
        NoArvore<Integer> no1 = new NoArvore<Integer>(1);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);
        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);
        NoArvore<Integer> no8 = new NoArvore<Integer>(8);
        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        arvore.setRaiz(no1);

        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        no3.inserirFilho(no8);
        
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);        

        assertEquals(false, arvore.pertence(55));
    }

    @Test
    void Teste4() {
        // Validar o método contarNos()
        
        NoArvore<Integer> no1 = new NoArvore<Integer>(1);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);
        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);
        NoArvore<Integer> no8 = new NoArvore<Integer>(8);
        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        arvore.setRaiz(no1);

        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);
        
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        no3.inserirFilho(no8);
        
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);        

        assertEquals(10, arvore.contarNos());
    }
}
