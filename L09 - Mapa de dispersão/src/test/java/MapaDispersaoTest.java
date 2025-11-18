import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aula11.Aluno;
import com.aula11.MapaDispersao;

public class MapaDispersaoTest {
    MapaDispersao<Aluno> mapaDispersao;

    @BeforeEach
    void setup() {
        mapaDispersao = new MapaDispersao<>(53);
    }

    @Test
    void Teste1() {
        // Validar que o método insere um um dado novo no mapa de dispersão e consegue localizá-lo
        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));

        mapaDispersao.inserir(12000, obj1);
        Aluno resultado = mapaDispersao.buscar(12000);

        assertSame(obj1, resultado);
    }

    @Test
    void Teste2() {
        // Validar que o método insere mais de um objeto no mapa de dispersão, localizando os diversos objetos
        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno obj3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno obj4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapaDispersao.inserir(12000, obj1);
        Aluno resultado1 = mapaDispersao.buscar(12000);
        assertSame(obj1, resultado1);

        mapaDispersao.inserir(14000, obj2);
        Aluno resultado2 = mapaDispersao.buscar(14000);
        assertSame(obj2, resultado2);

        mapaDispersao.inserir(12500, obj3);
        Aluno resultado3 = mapaDispersao.buscar(12500);
        assertSame(obj3, resultado3);

        mapaDispersao.inserir(13000, obj4);
        Aluno resultado4 = mapaDispersao.buscar(13000);
        assertSame(obj4, resultado4);
    }

    @Test
    void Teste3() {
        // Validar inserção e busca de objetos quando há colisão
        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno obj3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        Aluno obj4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapaDispersao.inserir(12000, obj1);
        Aluno resultado1 = mapaDispersao.buscar(12000);
        assertSame(obj1, resultado1);

        mapaDispersao.inserir(14000, obj2);
        Aluno resultado2 = mapaDispersao.buscar(14000);
        assertSame(obj2, resultado2);

        mapaDispersao.inserir(14226, obj3);
        Aluno resultado3 = mapaDispersao.buscar(14226);
        assertSame(obj3, resultado3);

        mapaDispersao.inserir(17180, obj4);
        Aluno resultado4 = mapaDispersao.buscar(17180);
        assertSame(obj4, resultado4);
    }
}
