package classes;

public class Pedido {

    double total = 0;

    void fazerPedido(Produto produto, int quantidade, double porcentagemDesconto) {
        // lancar erro se quantidade < 0 ou se produto nao tiver disponivel
        produto.aplicaDesconto(porcentagemDesconto);
        total += produto.getValor() * quantidade;
    }

    public static void main(String[] args) {

    }
}
