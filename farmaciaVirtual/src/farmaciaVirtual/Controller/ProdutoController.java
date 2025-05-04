package farmaciaVirtual.Controller;

import java.util.ArrayList;
import java.util.List;

import farmaciaVirtual.Repository.ProdutoRepository;
import farmaciaVirtual.model.Produto;

public class ProdutoController implements ProdutoRepository {

    private List<Produto> listaProdutos = new ArrayList<>(); 
    @Override
    public void criarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return listaProdutos;
    }

    @Override
    public Produto consultarProdutoPorId(int id) {
        for (Produto produto : listaProdutos) { 
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void atualizarProduto(Produto produto) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == produto.getId()) {
                listaProdutos.set(i, produto); 
                System.out.println("🔄 Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    @Override
    public void deletarProduto(int id) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == id) {
                listaProdutos.remove(i); 
                System.out.println("Produto deletado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
}

