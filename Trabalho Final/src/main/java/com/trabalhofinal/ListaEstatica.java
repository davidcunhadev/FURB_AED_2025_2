package com.trabalhofinal;

public class ListaEstatica<T> {
    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new Object[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Object[] placeholder = new Object[(this.info.length + 10)];
        for (int i = 0; i < info.length; i++) {
            placeholder[i] = info[i];
        }
        info = placeholder;
    }

    public void inserir(T valor) {
        if (tamanho >= info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        for (Object i : info) {
            System.out.println(i);
        }
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] != null && info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }    

    public void retirar(T valor) {
        int a = buscar(valor);

        if (a == -1) {
            System.out.println("Valor não encontrado");

        } else {
            for (int i = a; i < tamanho - 1; i++) {
                info[i] = info[(i + 1)];
            }
            info[tamanho - 1] = 0;
            tamanho--;
        }

    }

    public void liberar() {
        Object[] placeholder = new Object[10];
        info = placeholder;
        tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição não correspondente");
        }
        return (T) info[posicao];
    }

    public boolean estaVazia() {
        if (tamanho == 0) {
            return true;
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < tamanho; i++) {
            s += info[i] + ",";
        }
        return s;
    }

    public void inverter() {
        for (int i = 0; i < tamanho / 2; i++) {
            T placeholder = (T) info[i];
            info[i] = info[tamanho - 1 - i];
            info[tamanho - 1 - i] = placeholder;
        }
    }

    public T[] getInfo(){
        return (T[]) this.info;
    }

    public void setInfo(Object[] info){
        this.info = info;
    }

}
