package com.trabalhofinal;

public class PilhaLista<T> implements Pilha<T> {
    private ListaEncadeada<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeada<T>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        if (lista.getPrimeiro() == null) {
            throw new PilhaVaziaException("A pilha está vazia");
        }
        T valor = lista.getPrimeiro().getInfo();
        lista.retirar(lista.getPrimeiro().getInfo());

        return valor;
    }

    @Override
    public T peek() {
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (lista.getPrimeiro() != null) {
            lista.retirar(lista.getPrimeiro().getInfo());
        }
    }

    public String toString() {
        return lista.toString();
    }

}