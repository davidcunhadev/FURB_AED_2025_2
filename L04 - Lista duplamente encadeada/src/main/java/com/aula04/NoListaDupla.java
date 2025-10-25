package com.aula04;

public class NoListaDupla<T> {
    private T info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public void setProximo(NoListaDupla<T> valor) {
        this.proximo = valor;
    }

    public NoListaDupla<T> getProximo() {
        return this.proximo;
    }

    public void setAnterior(NoListaDupla<T> valor) {
        this.anterior = valor;
    }

    public NoListaDupla<T> getAnterior() {
        return this.anterior;
    }
}
