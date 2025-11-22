package com.aula11;

public abstract class BuscaAbstract<T> {
    private Object[] info;

    public Object[] getInfo() {
        return info;
    }

    public void setInfo(Object[] info) {
        this.info = info;
    }

    public abstract int buscar(T valor);
}
