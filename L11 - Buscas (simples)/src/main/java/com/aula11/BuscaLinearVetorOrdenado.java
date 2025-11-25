package com.aula11;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract<T> {

    @Override
    public int buscar(T valor) {
        int n = this.getInfo().length;

        for (int i = 0; i < n - 1; i++) {
            if (this.getInfo()[i].equals(valor)) {
                return i;
            }

            if (valor.compareTo((T) this.getInfo()[i]) < 0) {
                break;
            }
        }

        return -1;
    }

}
