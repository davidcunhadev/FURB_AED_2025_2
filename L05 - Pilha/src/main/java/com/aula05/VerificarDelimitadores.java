package com.aula05;

import java.util.Scanner;

public class VerificarDelimitadores {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma expressão: ");
        String expressao = scanner.nextLine();
        scanner.close();

        if (delimitadoresCorretos(expressao)) {
            System.out.println("Delimitadores corretos.");
        } else {
            System.out.println("Delimitadores incorretos.");
        }
    }

    public static boolean delimitadoresCorretos(String expr) {
        PilhaVetor<Character> pilha = new PilhaVetor<>(expr.length());

        for (char c : expr.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pilha.estaVazia()) {
                    return false;
                }
                char topo = pilha.pop();
                if (!correspondem(topo, c)) {
                    return false;
                }
            }
        }

        return pilha.estaVazia();
    }

    private static boolean correspondem(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
               (abertura == '[' && fechamento == ']') ||
               (abertura == '{' && fechamento == '}');
    }
}
