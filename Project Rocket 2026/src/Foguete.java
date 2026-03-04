public class Foguete {
    private String nome;
    private float combustivelRestante;
    private float cargaMaxima;
    private String status;
    private Satelite sateliteCarregado;

    // Construtor
    public Foguete(String nome, float combustivelRestante, float cargaMaxima) {
        this.nome = nome;
        this.combustivelRestante = combustivelRestante;
        this.cargaMaxima = cargaMaxima;
        this.status = "Pronto";
        this.sateliteCarregado = null;
    }

    public void Abastecer (float Quantidade){
        if (Quantidade > 0){
            IO.println("\n+---Abastecimento---+");
            this.combustivelRestante += Quantidade;
            IO.println(nome + " foi abastecido com " + Quantidade + " toneladas de combustível.");
        }
    }

    public void Lancar (){
        if (combustivelRestante > 50){
            this.status = "Lançando";
            IO.println(nome + " está pronto para lançamento!!");
        }else{
            IO.println(this.nome + " não possui combustivel para lançamento, abasteça ele!!");
        }
    }

    public void Relatorio(){
        System.out.println("+---Relatório do Foguete " + this.nome + "---+");
        System.out.println("Combustível restante: " + this.combustivelRestante + " toneladas");
        System.out.println("Carga máxima: " + this.cargaMaxima + " kg");
        System.out.println("Status: " + this.status);

    }

    public static void main(String[] args) {
        // Criando o objeto foguete
        Foguete foguete1 = new Foguete("Apollo", 10, 25000);

        // Exibindo o relatório inicial
        foguete1.Relatorio();

        // Abastecendo o foguete com 30 toneladas
        foguete1.Abastecer(30);

        // Tentando lançar o foguete
        foguete1.Lancar();
        IO.println();

        // Exibindo o relatório após as atualizações
        foguete1.Relatorio();

    }
}