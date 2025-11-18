package com.trabalhofinal;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;

    ListaEncadeada() {

    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> obj = new NoLista(valor, getPrimeiro());
        this.primeiro = obj;
    }

    public boolean estaVazia() {
        return getPrimeiro() == null;
    }

    public NoLista<T> buscar(T valor) {
        NoLista obj = getPrimeiro();

        while (obj != null) {
            if (obj.getInfo() == valor) {
                return obj;
            }
            obj = obj.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        if (this.primeiro == null)
            return;

        if (this.primeiro.getInfo().equals(valor)) {
            this.primeiro = this.primeiro.getProximo();
            return;

        }

        NoLista<T> obj = this.primeiro.getProximo();
        NoLista<T> anterior = this.primeiro;

        while (obj.getProximo() != null) {
            if (obj.getInfo().equals(valor)) {
                anterior.setProximo(obj.getProximo());
                return;
            }
            anterior = obj;
            obj = obj.getProximo();
        }

    }

    public int obterComprimento() {
        int qtd = 0;
        NoLista<T> obj = this.primeiro;
        while (obj != null) {
            qtd++;
            obj = obj.getProximo();
        }
        return qtd;
    }

    public NoLista<T> obterNo(int no) {
        if (no < 0) {
            throw new IndexOutOfBoundsException("Posição não pode ser menor que 0");
        }

        int noAtual = 0;
        NoLista<T> obj = this.primeiro;

        while (obj != null) {
            if (noAtual == no) {
                return obj;
            }
            obj = obj.getProximo();
            noAtual++;
        }
        throw new IndexOutOfBoundsException("Posição não correspondente");

    }

    public String toString() {
        String string = "";

        if (!(this.primeiro == null)) {
            NoLista<T> obj = this.primeiro;

            while (obj != null) {
                string += obj.getInfo();
                if (obj.getProximo() != null) {
                    string += ", ";
                }
            }
        }
        return string;
    }
}
