package aula06;

public class FilaVetor<T> implements Fila<T> {
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (this.tamanho == this.limite) {
            throw new FilaCheiaException("A fila está cheia!");
        }

        int posicaoInserir;
        posicaoInserir = (this.inicio + this.tamanho) % limite;
        this.info[posicaoInserir] = valor;

        this.tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public T peek() {
        if (this.estaVazia()) {
            throw new FilaVaziaException("A fila está vazia!");
        }

        return (T) this.info[inicio];
    }

    @Override
    public T retirar() {
        if (this.estaVazia()) {
            throw new FilaVaziaException("A fila está vazia!");
        }

        T valor = this.peek();
        this.info[this.inicio] = null; 
        this.inicio = (this.inicio + 1) % limite;
        this.tamanho--;

        return valor;
    }

    @Override
    public void liberar() {
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {

        FilaVetor<T> novoVetor = new FilaVetor<>(this.limite + f2.limite);

        for (int i = 0; i < this.tamanho; i++) {
            int pos = (this.inicio + i) % this.limite;
            novoVetor.inserir((T) this.info[pos]);
        }

        for (int i = 0; i < f2.tamanho; i++) {
            int pos = (f2.inicio + i) % f2.limite;
            novoVetor.inserir((T) f2.info[pos]);
        }

        return novoVetor;
    }

    public String toString() {
        String resultado = "";

        int posicao = this.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            if (i > 0) {
                resultado += ",";
            }
            resultado = resultado + this.info[posicao];
            posicao = (posicao + 1) % this.limite;
        }

        return resultado;
    }

    public int getLimite() {
        return this.limite;
    }
}
