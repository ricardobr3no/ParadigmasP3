import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private static Estoque instancia; // Instância única (Singleton)
    private Map<Integer, Produto> produtos;
    private int contador = 1;

    Estoque() {
        this.produtos = new HashMap<>();
    }

    // Aplicação do Singleton
    public static Estoque getInstance() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public void cadastrarProduto(String nome, int quantidade, double valor, String lab) {
        for(Produto p : produtos.values()){
            if(p.getItem().equalsIgnoreCase(nome)){
                System.out.println("Erro: Poduto já cadastrado");
                return;
            }
        }
        Produto novoProduto = new Medicamento(contador, nome, quantidade, valor, lab);
        produtos.put(contador, novoProduto);
        contador++;
    }

    public void alterarProduto(int codigo, String novoNome, double novoValor, int novaQuantidade) {
        if (produtos.containsKey(codigo)) {
            Produto produto = produtos.get(codigo);
            produto.setItem(novoNome);
            produto.setValor(novoValor);
            produto.setQuantidade(novaQuantidade);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado.");
        }
    }

    public Produto buscarProduto(int codigo) {
        return produtos.get(codigo);
    }

    public void removerProduto(int codigo) {
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
                System.out.println("Codigo: " + produto.getCodigo() + "\t Nome: " + produto.getItem() + "\t Valor: " + produto.getValor() + "\t Quantidade: " + produto.getQuantidade());
            }
        }
    }

public static void main(String[] args) {

        /*
        Scanner input = new Scanner(System.in);

        System.out.print("nome do produto: ");
        String nomeProduto = input.nextLine();

        System.out.print("codigo do produto: ");
        String codigoProduto = input.nextLine();

        System.out.print("valor do produto: ");
        double valorProduto = input.nextDouble();

        Produto produto1 = new Produto();
        produto1.setItem(nomeProduto);
        produto1.setCodigo(codigoProduto);
        produto1.setValor(valorProduto);

        Estoque estoque = new Estoque();
        estoque.cadastrarProduto(produto1);
        estoque.listarProdutos();
         */
    }
}
