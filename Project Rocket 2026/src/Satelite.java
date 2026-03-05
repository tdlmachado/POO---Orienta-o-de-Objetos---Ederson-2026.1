public class Satelite {
    private String nome;
    private String orbitaAlvo;
    private String status;
    private String mensagem;
    private float massaKg;
    private float energia;

    private boolean paineisAtivos;

    public Satelite(String nome, float massaKg, float energia, String orbitaAlvo) {
        this.nome = nome;
        this.massaKg = massaKg;
        this.energia = energia;
        this.orbitaAlvo = orbitaAlvo;
        this.status = "Em solo";
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public float getMassaKg() {
        return massaKg;
    }

    public float getEnergia() {
        return energia;
    }

    public String getOrbitaAlvo() {
        return orbitaAlvo;
    }

    public String getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isPaineisAtivos() {
        return paineisAtivos;
    }

    // SETTERS
    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public void setOrbitaAlvo(String orbitaAlvo) {
        this.orbitaAlvo = orbitaAlvo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaineisAtivos(boolean paineisAtivos) {
        this.paineisAtivos = paineisAtivos;
    }

    // MÉTODOS

    public void ativarPaineis() {
        if (energia >= 100) {
            IO.println("⚠ Energia do satélite está no máximo!");
            return;
        }

        if (!paineisAtivos) {
            IO.println("Iniciando abertura dos painéis...");
            IO.println("☀ Painéis solares ativados!");
            paineisAtivos = true;
            energia = Math.min(100, energia + 20);
            IO.println("Energia atual: " + energia);
        }
    }

//    public void MenuOrbita() {
//        IO.println("+--- Orbitas ---+");
//        IO.println("| 1 - LEO");
//        IO.println("| 2 - GEO");
//        IO.println("| 3 - Órbita Lunar");
//        IO.println("Digite qual a órbita desejada: ");
//    }

    public void definirOrbita(String escolha) {
        switch (escolha) {
            case "1":
                orbitaAlvo = "LEO";
                break;
            case "2":
                orbitaAlvo = "GEO";
                break;
            case "3":
                orbitaAlvo = "Órbita Lunar";
                break;
            default:
                IO.println("Órbita inválida");
                return;
        }
        status = "Em órbita";
    }

    public void ativarSatelite() {
        if (status.equals("Em órbita")) {
            status = "Ativo";
            IO.println("🛰 Satélite " + nome + " agora está ATIVO!");
        } else {
            IO.println("⚠ Satélite ainda não está em órbita.");
        }
    }

    public void enviarDados() {
        if (status.equals("Ativo")) {
            IO.println("+--- Mensagem Enviada ---+");
            IO.println("Satélite " + nome + " enviando: " + mensagem);
        } else {
            IO.println("⚠ Satélite não está ativo para enviar dados.");
        }
    }

    public void relatorioSatelite() {

        IO.println("+---Relatório do Satélite " + nome + "---+");
        IO.println("| Massa: " + massaKg + " kg");
        IO.println("| Energia: " + energia);
        IO.println("| Órbita: " + orbitaAlvo);
        IO.println("| Status: " + status);
        IO.println("+--------------------------------+");
    }
}
