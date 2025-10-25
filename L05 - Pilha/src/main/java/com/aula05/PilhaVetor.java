package com.aula05;

public class PilhaVetor<T> implements Pilha<T> {
    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T valor) {
        if (this.limite == this.tamanho) {
            throw new PilhaCheiaException("Capacidade esgotada da pilha");
        }

        this.info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public T peek() {
        if (this.tamanho == 0) {
            throw new PilhaVaziaException("A pilha está vazia!");
        }

        return (T) this.info[tamanho - 1];
    }

    @Override
    public T pop() {
        if (this.tamanho == 0) {
            throw new PilhaVaziaException("A pilha está vazia!");
        }

        T valor = peek();
        this.info[tamanho - 1] = null;
        tamanho--;

        return valor;
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public void liberar() {
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    public String toString() {   
        String resultado = "";
        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i];
            if (i > 0) {
                resultado += ",";
            }
        }
        return resultado;
    }

    public void concatenar(PilhaVetor<T> p) {
        if (this.tamanho + p.tamanho > this.limite) {
            throw new PilhaCheiaException("Capacidade insuficiente para concatenar");
        }
    
        for (int i = 0; i < p.tamanho; i++) {
            this.push((T) p.info[i]);
        }
    }    
}
