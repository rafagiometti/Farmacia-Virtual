package farmaciaVirtual.Repository;

import farmaciaVirtual.model.Produto;
import java.util.List;

public interface ProdutoRepository {

    void criarProduto(Produto produto);

    List<Produto> listarTodosProdutos();

    Produto consultarProdutoPorId(int id);

    void atualizarProduto(Produto produto);

    void deletarProduto(int id);
}
