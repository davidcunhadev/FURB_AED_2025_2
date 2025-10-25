package lista02_exercicios;

public class ListaEstatica<T> {
    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = new Object[10];
        this.tamanho = 0;
    }

    private void redimensionar() {
        Object[] novoVetor = new Object[info.length + 10];

        for (int i = 0; i < tamanho; i++) {
            novoVetor[i] = info[i];
        }
        info = novoVetor;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }    

    public void exibir() {
        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(T numero) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(numero)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T alvo) {
        int posicao = buscar(alvo);
        if (posicao == -1) return;
    
        for (int i = posicao; i < tamanho - 1; i++) {
            info[i] = info[i + 1];
        }
    
        info[--tamanho] = null;
    }

    public void liberar() {
        this.info = new Object[10];
        this.tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Indice inválido: " + posicao);
        }
        return (T) info[posicao];
    }    

    public boolean estaVazia() {
        if (this.tamanho == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public String toString() {
        String vetorToString = "";

        for (int i = 0; i < tamanho; i++) {
            if (info[i] != null) {
                vetorToString += info[i];
                if (i < tamanho - 1) {
                    vetorToString += ",";
                }
            }
        }
        return vetorToString;
    }

    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            Object temp = info[i];
            info[i] = info[tamanho - 1 - i];
            info[tamanho - 1 - i] = temp;
        }
    }    
}