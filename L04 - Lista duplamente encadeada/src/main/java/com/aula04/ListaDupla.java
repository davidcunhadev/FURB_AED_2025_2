package com.aula04;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return this.primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<T>();

        novo.setInfo(valor);
        novo.setProximo(getPrimeiro());
        novo.setAnterior(null);

        if (this.primeiro != null) {
            this.primeiro.setAnterior(novo);
        }

        this.primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> obj = this.primeiro;
        while (obj != null) {
            if (obj.getInfo().equals(valor)) {
                return obj;
            }
            obj = obj.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> atual = buscar(valor);

        if (atual != null) {
            if (atual == this.primeiro) {
                this.primeiro = atual.getProximo();
                if (this.primeiro != null) {
                    this.primeiro.setAnterior(null);
                }
            }
            else if (atual.getProximo() == null) {
                atual.getAnterior().setProximo(null);
            } else {
                atual.getAnterior().setProximo(atual.getProximo());
                atual.getProximo().setAnterior(atual.getAnterior());
            }
        }
    }

    public String exibirOrdemInversa() {
        String listaReversa = "";
        NoListaDupla<T> obj = this.primeiro;


        while (obj != null && obj.getProximo() != null) {
            obj = obj.getProximo();
        }
    
        while (obj != null) {
            listaReversa += obj.getInfo();
            if (obj.getAnterior() != null) {
                listaReversa += ",";
            }
            obj = obj.getAnterior();
        }

        return listaReversa;
    }

    public void liberar() {
        NoListaDupla<T> obj = this.primeiro;

        while (obj != null) {
            NoListaDupla<T> proximo = obj.getProximo();
            obj.setProximo(null);
            obj.setAnterior(null);
            obj = proximo;
        }
    
        this.primeiro = null;
    }

    public String toString() {
        String listaToString = "";
        NoListaDupla<T> obj = this.primeiro;

        while (obj != null) {
            listaToString += obj.getInfo();
            if (obj.getProximo() != null) {
                listaToString += ",";
            }
            obj = obj.getProximo();
        }

        return listaToString;
    }
}
