package com.aula08;

public class Arvore<T> {
    Arvore<T> arvore;
    NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public String toString() {
        if (this.raiz == null) {
            return "";
        }

        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<";
        s = s + no.getInfo();

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            s = s + obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        s = s + ">";

        return s;
    }

    public boolean pertence(T info) {
        if (this.raiz == null) {
            return false;
        }

        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return true;
        }

        NoArvore<T> p;
        p = no.getPrimeiro();

        while (p != null) {
            if (pertence(p, info)) {
                return true;
            }
            p  = p.getProximo();
        }

        return false;
    }

    public int contarNos() {
        if (this.raiz == null) {
            return 0;
        }

        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        int totalNos = 1;
        NoArvore<T> p = no.getPrimeiro();
        
        while (p != null) {
            totalNos += contarNos(p);
            p = p.getProximo();
        }

        return totalNos;
    }
}
