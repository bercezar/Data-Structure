package produtos;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        estoque.adicionarProduto(1, "Teclado", 10);
        estoque.adicionarProduto(2, "Mouse", 5);

        Produto p1 = estoque.buscarPorCodigo(1);
        if (p1 != null) {
            System.out.println("Produto encontrado: " + p1.nome);
        }

        estoque.removerProduto(2);

        Produto p2 = estoque.buscarPorNome("Mouse");
        System.out.println(p2 == null ? "Produto não encontrado" : "Produto encontrado: " + p2.nome);
    }
}
