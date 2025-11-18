package com.aula10;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T>{

    public OrdenacaoMergeSort() {
    }

    @Override
    public void ordenar() {
        Object[] info = this.getInfo();
        int n = (info.length -1);
        mergeSort(0, n);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio+1, fim);
            merge(inicio, fim, meio);
        }
    }

    private void merge(int inicio, int fim, int meio) {
        T[] info = this.getInfo();

        int tamEsquerda = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];
        for (int i = 0; i <= tamEsquerda - 1; i++) {
            esquerda[i] = info[inicio+i];
        }

        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for (int i = 0; i <= tamDireita - 1; i++) {
            direita[i] = info[meio+1+i];
        }

        int cE = 0;
        int cD = 0;
        int iFinal = 0;

        for (int i = inicio; i <= fim; i++) {
            if (cE < tamEsquerda && cD < tamDireita) {
                if((esquerda[cE]).compareTo((T) direita[cD]) < 0) {
                    info[i] = (T) esquerda[cE];
                    cE++;

                } else {
                    info[i] = (T) direita[cD];
                    cD++;
                }
            } else {
                iFinal = i;
                break;
            }
        }

        while (cE < tamEsquerda) {
            info[iFinal] = esquerda[cE];
            cE++;
            iFinal++;
        }
        while (cD < tamDireita) {
            info[iFinal] = direita[cD];
            cD++;
            iFinal++;
        }
    }
   
}
