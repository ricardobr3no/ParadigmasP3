import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Estoque {
    private Map<String, Produto> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public void cadastrarProduto(Produto produto) {
        if (!produtos.containsKey(produto.getCodigo())) {
            produtos.put(produto.getCodigo(), produto);
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Erro: Já existe um produto com esse código.");
        }
    }

    public void alterarProduto(String codigo, String novoNome, double novoValor) {
        if (produtos.containsKey(codigo)) {
            Produto produto = produtos.get(codigo);
            produto.setNome(novoNome);
            produto.setValor(novoValor);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado.");
        }
    }

    public void removerProduto(String codigo) {
        if (produtos.remove(codigo) != null) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado.");
        }
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Lista de produtos no estoque:");
            for (Produto produto : produtos.values()) {
                System.out.println("Codigo: " + produto.getCodigo() + "\t Nome: " + produto.getNome() + "\t Valor: " + produto.getValor());
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("nome do produto: ");
        String nomeProduto = input.nextLine();

        System.out.print("codigo do produto: ");
        String codigoProduto = input.nextLine();

        System.out.print("valor do produto: ");
        double valorProduto = input.nextDouble();

        Produto produto1 = new Produto();
        produto1.setNome(nomeProduto);
        produto1.setCodigo(codigoProduto);
        produto1.setValor(valorProduto);

        Estoque estoque = new Estoque();
        estoque.cadastrarProduto(produto1);
        estoque.listarProdutos();
    }
}
