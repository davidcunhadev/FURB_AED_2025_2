package com.aula11;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        raiz = inserir(raiz, info);
    }

    private NoArvoreBinaria<T> inserir(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return new NoArvoreBinaria<>(info);
        }

        int cmp = info.compareTo(no.getInfo());

        if (cmp < 0) {
            no.setEsquerda(inserir(no.getEsquerda(), info));
        } else if (cmp > 0) {
            no.setDireita(inserir(no.getDireita(), info));
        }

        return no;
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(raiz, info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
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