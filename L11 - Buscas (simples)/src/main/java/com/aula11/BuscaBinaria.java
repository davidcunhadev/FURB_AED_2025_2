package com.aula11;

public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract<T> {

    @Override
    public int buscar(T valor) {
        int n = this.getInfo().length;
        int inicio = 0;;
        int fim = n - 1;

        while (inicio <= fim) {
            int meio =  (inicio + fim) / 2;

            if (valor.compareTo((T) this.getInfo()[meio]) < 0) {
                fim = meio - 1;
            }

            if (valor.compareTo((T) this.getInfo()[meio]) > 0) {
                inicio = meio + 1;
            }

            if (valor.compareTo((T) this.getInfo()[meio]) == 0) {
                return meio;
            }
        }

        return -1;
    }
    
}
