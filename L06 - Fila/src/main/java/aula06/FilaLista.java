package aula06;

public class FilaLista<T> implements Fila<T> {
    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (lista.estaVazia()) {
            throw new FilaVaziaException("A fila está vazia!");
        }

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        if (lista.estaVazia()) {
            throw new FilaVaziaException("A fila está vazia!");
        }

        T valor = this.peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }

    public String toString() {
        return lista.toString();
    }
}
