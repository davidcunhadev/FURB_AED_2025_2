package com.trabalhofinal;

import java.io.BufferedReader;
import java.io.IOException;

public class VerificadorDeTag {

    private PilhaLista<String> pilha = new PilhaLista<>();
    private String[] singletonTags = {"<meta>", "<base>", "<br>", "<col>", "<command>", "<embed>", "<hr>", "<img>", "<input>", "<link>", "<param>", "<source>", "<!DOCTYPE>"};
    private ContadorTags contadorTags = new ContadorTags();

    public void verificarArquivo(BufferedReader reader) throws IOException, Error {
        String tag = "";
        String linha;
        Boolean fechar = false;
        Boolean ignorarChar = false;
        Boolean singleton = false;
        Boolean existeTag = false;
        int numeroLinha = 0;
        
        while ((linha = reader.readLine()) != null) {
            numeroLinha++;

            for (int i = 0; i < linha.length(); i++) {
                if (linha.charAt(i) == '<') {
                    existeTag = true;
                    tag = "<";
                    fechar = false;
                    ignorarChar = false;
                    singleton = false;
        
                    i++;
                    while (i < linha.length() && linha.charAt(i) != '>') {
                        char c = Character.toLowerCase(linha.charAt(i));
        
                        if (c == ' ') {
                            ignorarChar = true;
                        }
        
                        if (!ignorarChar) {
                            tag += c;
                            if (c == '/' && linha.charAt(i - 1) == '<') {
                                if (linha.charAt(i + 1) == '>') {
                                    throw new Error("Arquivo HTML inválido.\n" +"Motivo: Tag de fechamento vazia '</>' encontrada na linha " + numeroLinha);
                                }
                                fechar = true;
                            }
                        }
                        i++;
                    }
        
                    if (i >= linha.length()) {
                        throw new Error("Arquivo HTML inválido.\n" + "Motivo: Tag '" + tag + "' não foi fechada com '>' na linha " + numeroLinha);
                    }
        
                    tag += ">";

                    if (!fechar) {
                        TagHTML tagHTML = new TagHTML(tag);
                        contadorTags.adicionarTag(tagHTML);
                    }
        
                    for (int j = 0; j < singletonTags.length; j++) {
                        if (singletonTags[j].equals(tag)) {
                            singleton = true;
                            break;
                        }
                    }
        
                    if (!singleton) {
                        if (!fechar) {
                            pilha.push(tag);
                        } else {
                            tag = tag.replace("/", "");

                            if (pilha.estaVazia()) {
                                throw new Error("Arquivo HTML inválido.\n" + "Motivo: Tag de fechamento '" + tag + "' encontrada na linha " + numeroLinha + " sem uma tag de abertura correspondente.");
                            }

                            String tagPilha = pilha.pop();
                            if (!tagPilha.equals(tag)) {
                                throw new Error("Arquivo HTML inválido.\n" + "Motivo: Incompatibilidade de tags na linha " + numeroLinha + ".\n" + "Esperado: " + tagPilha.replace("<", "</") + "\n" + "Encontrado: " + tag.replace("<", "</"));
                            }
                        }
                    }
        
                    tag = "";
                }

                if (!existeTag) {
                    throw new Error("Arquivo HTML inválido.\n" + "Motivo: Nenhuma tag HTML foi encontrada no arquivo.\n" +"Um arquivo HTML válido deve conter pelo menos uma tag.");
                }
            }
        }
        
        if (!pilha.estaVazia()) {
          throw new Error("Arquivo HTML inválido.");
        }
    }

    public ContadorTags getContadorTags() {
        return contadorTags;
    }    

}