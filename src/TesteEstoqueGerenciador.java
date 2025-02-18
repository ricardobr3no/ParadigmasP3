public class TesteEstoqueGerenciador {
    public static void main(String[] args) {
        Estoque estoque = Estoque.getInstance(); // Obtém a instância única do estoque
        GerenciadorPedidos gerenciador = GerenciadorPedidos.getInstance(); // Obtém a instância única do gerenciador

        // Cadastrando produtos
        System.out.println("\n---- Teste de Cadastro de Produtos ----");
        estoque.cadastrarProduto("Paracetamol", 10, 5.0, "Eurofarma");
        estoque.cadastrarProduto("Dipirona", 15, 4.5, "Neo Quimica");
        estoque.cadastrarProduto("Paracetamol", 5, 5.5, "Neo Quimica"); // Deve falhar (repetido)

        // Listando produtos
        System.out.println("\n---- Estoque Atual ----");
        estoque.listarProdutos();

        // Realizando pedidos
        System.out.println("\n---- Teste de Pedidos ----");
        gerenciador.adicionarPedido(1, 2); // Pedido válido (reduz estoque de Paracetamol para 8)
        gerenciador.adicionarPedido(2, 5); // Pedido válido (reduz estoque de Dipirona para 10)
        gerenciador.adicionarPedido(1, 10); // Deve falhar (estoque insuficiente)

        // Listando produtos novamente para ver as alterações
        System.out.println("\n---- Estoque Atualizado ----");
        estoque.listarProdutos();

        // Listando pedidos cadastrados
        System.out.println("\n---- Pedidos Realizados ----");
        gerenciador.listarPedidos();
    }
}
