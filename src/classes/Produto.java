package classes;

public class Produto {
    private String codigo;
    private String nome;
    private double valor; private int quantidade;

    public Produto() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getCodigo() {return codigo;
    }

    public void mostrarInfo() {
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Valor: " + this.getValor());
    }


    public void aplicaDesconto(double porcentagemDesconto) {
        this.valor *= (1 - porcentagemDesconto / 100);
    }
}
