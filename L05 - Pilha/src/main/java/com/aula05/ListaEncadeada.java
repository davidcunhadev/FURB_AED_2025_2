package com.aula05;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return this.primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<T>();

        novo.setProximo(getPrimeiro());
        novo.setInfo(valor);

        this.primeiro = novo;
    }

    public boolean estaVazia() {
        if (getPrimeiro() == null) {
            return true;
        } else {
            return false;
        }
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> obj = this.primeiro;
        while (obj != null) {
            if (obj.getInfo().equals(valor)) {
                return obj;
            }
            obj = obj.getProximo();
        }
        return null;
    }

    public void retirar(T alvo) {
        NoLista<T> anterior = null;
        NoLista<T> atual = this.primeiro;
    
        while (atual != null && !atual.getInfo().equals(alvo)) {
            anterior = atual;
            atual = atual.getProximo();
        }
    
        if (atual != null) {
            if (anterior == null) {
                this.primeiro = atual.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
        }
    }

    public int obterComprimento() {
        int qtdeItens = 0;
        NoLista<T> obj = this.primeiro;

        while (obj != null) {
            qtdeItens += 1;

            obj = obj.getProximo();
        }

        return qtdeItens;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException("Índice inválido: " + idx);
        }

        NoLista<T> obj = this.primeiro;
        int pos = 0;
        
        while (obj != null) {
            if (pos == idx) {
                return obj;
            } else {
                obj = obj.getProximo();
                pos += 1;
            }
        }

        throw new IndexOutOfBoundsException("Índice inválido: " + idx);
    }

    public String toString() {
        String listaToString = "";

        NoLista<T> p = this.primeiro;

        while (p != null) {
            listaToString += p.getInfo();
            if (p.getProximo() != null) {
                listaToString += ",";
            }
            p = p.getProximo();
        }

        return listaToString;
    }
}