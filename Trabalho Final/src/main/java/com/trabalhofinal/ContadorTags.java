package com.trabalhofinal;

public class ContadorTags {
    private ListaEstatica<TagHTML> listaDeTags = new ListaEstatica<>();

    public void adicionarTag(TagHTML tag){
        int index = listaDeTags.buscar(tag);

        if (index == -1) {
            listaDeTags.inserir(tag);
        } else {
            TagHTML tagExistente = listaDeTags.obterElemento(index);
            tagExistente.setQtd(tagExistente.getQtd() + 1);
        }
    }

    public void ordenar() {
        int tamanho = listaDeTags.getTamanho();
        if (tamanho == 0) return;

        TagHTML[] tags = new TagHTML[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tags[i] = listaDeTags.obterElemento(i);
        }

        OrdenacaoMergeSort<TagHTML> ordenador = new OrdenacaoMergeSort<>();
        ordenador.setInfo(tags);
        ordenador.ordenar();

        listaDeTags.setInfo(ordenador.getInfo());
    }

    public TagHTML[] getLista() {
        int tamanho = listaDeTags.getTamanho();
        TagHTML[] resultado = new TagHTML[tamanho];
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = listaDeTags.obterElemento(i);
        }
        return resultado;
    }
}
