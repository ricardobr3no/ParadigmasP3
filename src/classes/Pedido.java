public class Pedido{
    private int codigoPedido;
    private int codigoProduto;
    private double valor;
    private int quantidade;
    private double total;

    public Pedido(int codigoPedido, int codigoProduto, int quantidade, double valor) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigoPedido = codigoPedido;
        this.codigoProduto = codigoProduto;
        this.total = valor * quantidade;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTotal() {
        return total;
    }


    @Override
    public String toString() {
        return "Pedido: " + this.codigoPedido +
                " | Produto: " + this.codigoProduto +
                " | Quantidade: " + this.quantidade +
                " | Preço unitário: R$" + this.valor +
                " | Total: R$" + total;
    }
}
