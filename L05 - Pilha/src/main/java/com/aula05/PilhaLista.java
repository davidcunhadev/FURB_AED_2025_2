package com.aula05;

public class PilhaLista<T> implements Pilha<T> {
    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    @Override
    public void push(T valor) {
        lista.inserir(valor);
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia!");
        }

        T valor = this.peek();
        lista.retirar(valor);

        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia!");
        }

        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}