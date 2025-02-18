import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos {
    private static GerenciadorPedidos instancia; // Instância única
    private List <Pedido> listaPedidos;
    private Estoque estoque; // Referência ao estoque
    private int contador = 1;

    private GerenciadorPedidos() {
        this.listaPedidos = new ArrayList<>();
        this.estoque = Estoque.getInstance(); // Obtém a instância única do estoque
    }

    public static GerenciadorPedidos getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorPedidos();
        }
        return instancia;
    }

    public void adicionarPedido(int codigoProduto, int quantidade) {
        Produto produto = estoque.buscarProduto(codigoProduto);

        if (produto == null) {
            System.out.println("Erro: Produto não encontrado no estoque.");
            return;
        }

        if (produto.getQuantidade() < quantidade) {
            System.out.println("Erro: Estoque insuficiente para o produto " + produto.getItem());
            return;
        }

        // Atualiza o estoque (diminui a quantidade)
        produto.setQuantidade( (produto.getQuantidade() - quantidade));


        // Cria o pedido com o preço atual do produto
        Pedido pedido = new Pedido(contador, codigoProduto, quantidade, produto.getValor());
        listaPedidos.add(pedido);

        System.out.println("Pedido " + contador + " cadastrado com sucesso!");
        contador++;
    }

    public void listarPedidos() {
        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }
        System.out.println("Lista de Pedidos:");
        for (Pedido p : listaPedidos) {
            System.out.println(p);
        }
    }
}
