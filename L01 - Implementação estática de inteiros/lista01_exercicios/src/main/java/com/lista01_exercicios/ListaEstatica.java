package com.lista01_exercicios;

public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    public void redimensionar() {
        int[] novoVetor = new int[info.length + 10];

        for (int i = 0; i < tamanho; i++) {
            novoVetor[i] = info[i];
        }
        info = novoVetor;
    }

    public void inserir(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }    

    public void exibir() {
        for (int i : info) {
            if (i == 0) {
                break;
            }
            System.out.println(i);
        }
    }

    public int buscar(int numero) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int alvo) {
        int posicaoAlvo = -1;

        for (int i = 0; i <= tamanho; i++) {
            if (posicaoAlvo == -1) {
                if (info[i] == alvo) {
                    posicaoAlvo = i;
                    tamanho--;
                }
            }

            if (posicaoAlvo != -1) {
                info[i] = info[i + 1];
            }
        }
    }    

    public void liberar() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    public int obterElemento(int indiceNumero) {
        if (indiceNumero < 0 || indiceNumero >= tamanho) {
            throw new IndexOutOfBoundsException("Indice inválido: " + indiceNumero);
        }
        return info[indiceNumero];
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
            if (info[i] != 0) {
                vetorToString += info[i];
                if (i < tamanho - 1) {
                    vetorToString += ",";
                }
            }
        }
        return vetorToString;
    }
}