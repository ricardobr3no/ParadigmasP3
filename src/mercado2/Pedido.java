package mercado2;

import java.util.List;

public class Pedido {
    private int id;
    private List<ItemPedido> itens;
    private double total;

    public Pedido(int id, List<ItemPedido> itens) {
        this.id = id;
        this.itens = itens;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        return itens.stream().mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
    }

    public int getId() {
        return id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }
}
