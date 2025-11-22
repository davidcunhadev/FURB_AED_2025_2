package com.aula11;

public class MapaDispersao<T> {
    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        this.info = new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave) {
        int tamanho = this.info.length;

        return chave % tamanho;
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);

        if (this.info[indice] == null) {
            this.info[indice] = new ListaEncadeada<>();
        }

        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setValor(dado);

        NoMapa<T> existente = (NoMapa<T>) buscar(chave);
        if (existente != null) {
            existente.setValor(dado);
            return;
        }

        this.info[indice].inserir(noMapa);
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);

        if (this.info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = this.info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getValor();
            }
        }

        return null;
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);

        if (this.info[indice] == null) {
            return;
        }

        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);

        this.info[indice].retirar(noMapa);
    }

    public double calcularFatorCarga() {
        int totalElementos = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                totalElementos += info[i].obterComprimento();
            }
        }

        return (1.0) * totalElementos / this.info.length;
    }

}
