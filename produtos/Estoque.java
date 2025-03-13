package produtos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(int codigo, String nome, int quantidade) {
        produtos.add(new Produto(codigo, nome, quantidade));
    }

    public void removerProduto(int codigo) {
        produtos.removeIf(p -> p.codigo == codigo);
    }

    public Produto buscarPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.codigo == codigo) {
                return p;
            }
        }
        return null;
    }

    public Produto buscarPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.nome.equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}
