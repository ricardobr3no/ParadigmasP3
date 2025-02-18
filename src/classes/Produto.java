public class Produto{
    private int codigo;
    private String item;
    private double valor;
    private int quantidade;

    public Produto(int codigo, String item, int quantidade, double valor) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigo = codigo;
        this.item = item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getItem() {
        return item;
    }


    public int getCodigo() {
        return codigo;
    }

    public void aplicaDesconto(double porcentagemDesconto) {
        this.valor *= (1 - porcentagemDesconto / 100);
    }
}
