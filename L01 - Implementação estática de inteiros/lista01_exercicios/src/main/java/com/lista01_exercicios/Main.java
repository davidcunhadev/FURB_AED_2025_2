package com.lista01_exercicios;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica();

        // Testar método de inclusão de dados na lista.
        // Criar uma lista. Adicionar os dados 5, 10, 15 e 20. 
        // -> toString() deve resultar em “5,10,15,20”.
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        System.out.println(lista.toString());

        //Testar método de obtenção de tamanho da lista.
        // Criar uma lista. Adicionar os dados 5, 10, 15 e 20. 
        // -> getTamanho() deve resultar em 4.
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        System.out.println(lista.getTamanho());
        
        // Testar método buscar() com elemento existente.
        // Criar uma lista. Adicionar os dados 5, 10, 15 e 20.
        // -> buscar(15) deve resultar em 2.
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        System.out.println(lista.buscar(15));

        // Testar método buscar() com elemento inexistente.
        // Criar uma lista. Adicionar os dados 5, 10, 15 e 20.
        // -> buscar(30) deve resultar em -1.
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        System.out.println(lista.buscar(30));

        // Testar método retirar().
        // Criar uma lista. Adicionar os dados 5, 10, 15 e 20, nesta ordem. Em seguida, retirar o elemento 10 – retirar(10).
        // -> toString() deve resultar em “5 15 20”. getTamanho() deve resultar em 3.
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        System.out.println(lista.toString());
        System.out.println(lista.getTamanho());

        // Testar inclusão que provoque redimensionamento.
        // Criar uma lista. Adicionar 15 números na lista (de 1 à 15).
        // -> toString() deve resultar em “1 2 3 4 5 6 7 8 9 10 11 12 13 14 15”. getTamanho() deve resultar em 15.
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(7);
        lista.inserir(8);
        lista.inserir(9);
        lista.inserir(10);
        lista.inserir(11);
        lista.inserir(12);
        lista.inserir(13);
        lista.inserir(14);
        lista.inserir(15);
        System.out.println(lista.toString());
        System.out.println(lista.getTamanho());

        // Testar método obterElemento().
        // Criar uma lista. Adicionar os dados 5, 10, 15 e 20.
        // -> obterElemento(3) deverá resultar em 20.
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        System.out.println(lista.obterElemento(3));

        // Testar lançamento de exceção no método obterElemento().
        // Criar uma lista. Adicionar os dados 5, 10, 15 e 20.
        // -> obterElemento(5) deverá lançar uma exceção.
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        System.out.println(lista.obterElemento(5));

        // Certificar que liberar() remove todos os elementos -> estaVazia() deverá resultar em true.
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();
        System.out.println(lista.estaVazia());
    }
}