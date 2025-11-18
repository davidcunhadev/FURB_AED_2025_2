package com.aula10;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo - 1);
            quickSort(idxPivo + 1, fim);
        }
    }
    
    public void quickSort() {
        int n = this.getInfo().length - 1;
        quickSort(0, n);
    }

    private int particionar(int inicio, int fim) {
        T[] info = this.getInfo();
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];

        while (true) {
            do {
                a = a + 1;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            do {
                b = b - 1;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b) {
                break;
            }

            trocar(a, b);
        }
        trocar(b, inicio);
        return b;
    }

    @Override
    public void ordenar() {
        if (getInfo() == null || getInfo().length <= 1) return;
        quickSort(0, getInfo().length - 1);
    }
    
}
