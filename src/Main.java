import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String codigo = "123";
        String nome = "paracetamol";
        double preco = 13.40;

        Produto p = new Medicamento();
        p.setCodigo(codigo);
        p.setNome(nome);
        p.setValor(preco);

        String codigo2 = "1333";
        String nome2 = "buscopan";
        double preco2 = 8.80;

        Produto p2 = new Medicamento();
        p2.setCodigo(codigo2);
        p2.setNome(nome2);
        p2.setValor(preco2);

        Estoque e = new Estoque();
        e.cadastrarProduto(p);
        e.cadastrarProduto(p2);
        e.listarProdutos();
        e.alterarProduto("1333", "vitamina c", 8.80);
        e.listarProdutos();
        e.removerProduto("123");
        e.listarProdutos();
    }
}
