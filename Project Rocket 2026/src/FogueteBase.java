import java.util.Scanner;

public class FogueteBase {
    private String nome;
    private float combustivelRestante;
    private float cargaMaxima;
    private String status;
    private SateliteBase sateliteCarregado;

    public FogueteBase(String nome, float cargaMaxima, float combustivelRestante) {
        this.nome = nome;
        this.combustivelRestante = combustivelRestante;
        this.cargaMaxima = cargaMaxima;
        this.status = "Pronto";
        this.sateliteCarregado = null;
    }

    public void abastecer (float Quantidade){
        if (Quantidade > 0){
            IO.println("\n+---Abastecimento---+");
            this.combustivelRestante += Quantidade;
            IO.println(nome + " foi abastecido com " + Quantidade + " toneladas de combustível.");
        }
    }

    public void lancar(){
        if (combustivelRestante > 50){
            this.status = "Lançando";
            IO.println(nome + " está pronto para lançamento!!");
        }else{
            IO.println(this.nome + " não possui combustivel para lançamento, abasteça ele!!");
        }
    }

    public void relatorioFoguete(){
        System.out.println("+---Relatório do Foguete " + this.nome + "---+");
        System.out.println("Combustível restante: " + this.combustivelRestante + " toneladas");
        System.out.println("Carga máxima: " + this.cargaMaxima + " kg");
        System.out.println("Status: " + this.status);

    }

   static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando o objeto foguete
        FogueteBase foguete1 = new FogueteBase("Apollo", 25000, 0);

        // Exibindo o relatório inicial
        foguete1.relatorioFoguete();

        // Quantidade de combustivel
        IO.print("\nDigite a quantide de combustivel será abastecido: ");
        float combustivel = scanner.nextFloat();

        // Abastecendo o foguete com quantidade desejada
        foguete1.abastecer(combustivel);

        // Tentando lançar o foguete
        foguete1.lancar();
        IO.println();

        // Exibindo o relatório após as atualizações
        foguete1.relatorioFoguete();
    }
}