public abstract class Produto {
    private String Codigo;
    private String nome;
    private double valor;

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

    public String getCodigo() {
        return codigo;
    }

    public void aplicaDesconto(double porcentagemDesconto) {
        this.valor *= (1 - porcentagemDesconto / 100);
    }
}
