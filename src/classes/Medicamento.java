public class Medicamento extends Produto {

    enum Tarja {
        PRETA,
        VERMELHA,
        NENHUM
    }

    private Tarja tarja = Tarja.NENHUM;
    private String laboratorio;
    private boolean generico = true;

    Medicamento(int codigo, String item, int quantidade, double valor, String laboratorio) {
        super(codigo, item, quantidade, valor);
        this.laboratorio = laboratorio;
    }

    public void setTarja(Tarja tarja) {
        this.tarja = tarja;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Tarja getTarja() {
        return tarja;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public boolean isGenerico() {
        return generico;
    }

    public void setGenerico(boolean generico) {
        this.generico = generico;
    }

    void mostrarInfo() {
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Nome: " + this.getItem());
        System.out.println("Valor: " + this.getValor());
        System.out.println("Tarja: " + tarja);
        System.out.println("Laboratorio: " + laboratorio);
        System.out.println("Generico: " + generico);
    }

    public static void main(String[] args) {
        Tarja t = Tarja.NENHUM;
        System.out.println(t);
    }
}
