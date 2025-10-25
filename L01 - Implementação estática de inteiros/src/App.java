public class App {
    public static void main(String[] args) throws Exception {
        ListaEstatica lista = new ListaEstatica();

        lista.inserir(50);
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(20);
        lista.exibir();

        lista.buscar(50);
    }
}