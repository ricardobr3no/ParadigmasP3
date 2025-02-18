package mercado2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private List<ItemPedido> itens;
    private double total;
    private String dataHora;

    public Pedido(int id, List<ItemPedido> itens) {
        this.id = id;
        this.itens = itens;
        this.total = calcularTotal();
        this.dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
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
