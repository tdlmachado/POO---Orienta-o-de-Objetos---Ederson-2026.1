import java.util.ArrayList;
import java.util.List;

public class CentroControle {
    private List<Foguete> foguetes;
    private List<Satelite> satelites;

    public CentroControle(){
        this.foguetes = new ArrayList<>();
        this.satelites = new ArrayList<>();
    }

    // Método para adicionar foguetes
    public void adicionarFoguete(Foguete foguete){
        foguetes.add(foguete);
    }

    // Método para adicionar satelites
    public void adicionarSatelite(Satelite satelite) {
        satelites.add(satelite);
    }

    // Método para iniciar missão espacial
    public void iniciarMissao(String nomeFoguete, String nomeSatelite){
        Foguete foguete = buscarFoguetePorNome (nomeFoguete);
        Satelite satelite = buscarSatelitePorNome (nomeSatelite);

        if (foguete == null || satelite == null){
        IO.println("Foguete ou Satélite não encotrado!");
        return;
        }
        if (foguete.getStatus().equals("Em órbita") || foguete.getStatus().equals("Falha")){
            IO.println("Foguete " + nomeFoguete + " já foi lançado ou falhou!");
        return;
        }
        foguete.setSateliteCarregado(satelite);
        IO.println("Missão espacial iniciada:"+ nomeFoguete +" Carregando:"+nomeSatelite);
        foguete.lancar();
    }

    public void statusMissao(){
        IO.println("+--- Status Missão ---+");
        for (Foguete f: foguetes){
            f.relatorioFoguete();
        }
        for (Satelite s: satelites) {
            s.relatorioSatelite();
        }
    }

    private Foguete buscarFoguetePorNome(String nome){
        for (Foguete f: foguetes){
            if (f.getNome().equals(nome)){
                return f;
            }
        }
        return null;
    }

    private Satelite buscarSatelitePorNome(String nome){
        for (Satelite s: satelites){
            if (s.getNome().equals(nome)){
                return s;
            }
        }
        return null;
    }
}
