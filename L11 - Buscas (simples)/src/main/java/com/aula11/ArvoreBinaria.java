package com.aula11;

public class ArvoreBinaria<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(raiz, info);
    }

    @Override
    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    public NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        int cmp = info.compareTo(no.getInfo());

        if (cmp == 0) {
            return no;
        }

        if (cmp < 0) {
            return buscar(no.getEsquerda(), info);
        }

        return buscar(no.getDireita(), info);
    }
}
