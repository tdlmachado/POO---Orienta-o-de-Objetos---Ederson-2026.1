import java.util.Scanner;

public class SateliteBase {
    private String nome;
    private float massaKg;
    private float energia;
    private String orbitaAlvo;
    private String status; // Em solo, Em órbita, Ativo
    private String mensagem;
    private boolean paineisAtivos = false;

    public SateliteBase(String nome, float massaKg, float energia, String orbitaAlvo) {
        this.nome = nome;
        this.massaKg = massaKg;
        this.energia = energia;
        this.orbitaAlvo = orbitaAlvo;
        this.status = "Em solo";
    }

    public void ativarPaineis() {
        if (energia >= 100) {
            IO.println("⚠ Energia do satélite está no máximo!");
        } else {
            if (!paineisAtivos) {
                IO.println("Iniciando abertura dos painéis...");
                IO.println("☀ Painéis solares ativados!");
                paineisAtivos = true;
                energia = Math.min(100, energia + 20);
                IO.println("Energia atual: " + energia);
            }
        }
    }

    public void MenuOrbita() {
        IO.println("+--- Orbitas ---+");
        IO.println("| 1 - LEO");
        IO.println("| 2 - GEO");
        IO.println("| 3 - Órbita Lunar");
        IO.println("Digite qual a órbita desejada: ");
    }


    public void definirOrbita(String escolha) {
        switch (escolha) {
            case "1":
                orbitaAlvo = "LEO";
                status = "Em órbita";
                break;
            case "2":
                orbitaAlvo = "GEO";
                status = "Em órbita";
                break;
            case "3":
                orbitaAlvo = "Órbita Lunar";
                status = "Em órbita";
                break;
            default:
                IO.println("Órbita invalida");
                break;
        }
    }

    public void ativarSatelite(){
        if(status.equals("Em órbita")){
            status = "Ativo";
            IO.println("🛰 Satélite " + nome + " agora está ATIVO!");
        }else{
            IO.println("⚠ Satélite ainda não está em órbita.");
        }
    }

    public void definirMensagem(String msg){
        this.mensagem = msg;
    }

    public void enviarDados() {
        if (status.equals("Ativo")) {
            IO.println("+--- Mensagem Enviada ---+");
            IO.println("Satélite " + nome + " enviando: " + mensagem);
        } else if (mensagem != null) {
            IO.println("⚠ Mensagem inválida para envio.");
        }else{
            IO.println("⚠ Satélite não está ativo para enviar dados.");
        }
    }

    //
    public void relatorioSatelite() {
        IO.println("+---Relatório do Satélite " + this.nome + "---+");
        IO.println("| Massa atual: " + this.massaKg + "kg");
        IO.println("| energia atual: " + this.energia);
        IO.println("| Orbita alvo: " + this.orbitaAlvo);
        IO.println("| Status: " + this.status);
        IO.println("+-----------------------------------+");
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SateliteBase satelite1 = new SateliteBase("Sputnik", 2000, 50, "LEO");

        // Relatório Inicial
        satelite1.relatorioSatelite();
        IO.println();

        // Paineis de energia
        satelite1.ativarPaineis();
        IO.println();

        // Menu de órbitas e escolha de alvo
        satelite1.MenuOrbita();
        String escolha = scanner.nextLine();
        satelite1.definirOrbita(escolha);
        IO.println();

        // Ativando Satélite para enviar mensagem
        satelite1.ativarSatelite();
        IO.println();

        // Envio de dados
        IO.println("Digite a mensagem que o satélite irá enviar:");
        String msg = scanner.nextLine();
        satelite1.definirMensagem(msg);
        satelite1.enviarDados();
        IO.println();

        // Relatório atualizado
        satelite1.relatorioSatelite();
    }
}
