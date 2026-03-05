public class Foguete {

    private String nome;
    private float combustivelRestante;
    private float cargaMaxima;
    private String status;
    private Satelite sateliteCarregado;

    public Foguete(String nome, float cargaMaxima, float combustivelRestante) {
        this.nome = nome;
        this.cargaMaxima = cargaMaxima;
        this.combustivelRestante = combustivelRestante;
        this.status = "Pronto";
        this.sateliteCarregado = null;
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public double getCombustivelRestante() {
        return combustivelRestante;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public String getStatus() {
        return status;
    }

    public Satelite getSateliteCarregado() {
        return sateliteCarregado;
    }

    // SETTERS
    public void setCombustivelRestante(float combustivelRestante) {
        this.combustivelRestante = combustivelRestante;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSateliteCarregado(Satelite sateliteCarregado) {
        this.sateliteCarregado = sateliteCarregado;
    }

    // MÉTODOS
    public void abastecer(float quantidade) {
        if (quantidade > 0) {
            IO.println("\n+--- Abastecimento ---+");
            combustivelRestante += quantidade;
            IO.println(nome + " foi abastecido com " + quantidade + " toneladas de combustível.");
        }
    }

    public void lancar() {
        if (combustivelRestante > 50) {
            status = "Lançando";
            IO.println("🚀 " + nome + " está pronto para lançamento!");
        } else {
            IO.println("⚠ " + nome + " não possui combustível suficiente!");
        }
    }

    public void relatorioFoguete() {
        IO.println("+--- Relatório do Foguete " + nome + " ---+");
        IO.println("Combustível restante: " + combustivelRestante + " toneladas");
        IO.println("Carga máxima: " + cargaMaxima + " kg");
        IO.println("Status: " + status);

        if (sateliteCarregado != null) {
            IO.println("Satélite carregado: " + sateliteCarregado.getNome());
        } else {
            IO.println("Satélite carregado: Nenhum");
        }

        IO.println("+------------------------------+");
    }
}