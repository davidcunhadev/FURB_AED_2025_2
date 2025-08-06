public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10];
        tamanho = 0;
    }

    public void inserir(int valor) {
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        for (int i : info) {
            if (i == 0) {
                break;
            }
            System.out.println(i);
        }
    }

    public void buscar(int numero) {
        for (int i : info) {
            if (i == numero) {
                System.out.println("Número encontrado:" + i);
                break;
            } else {
                System.out.println("Número não encontrado");
            }
        }
    }
}