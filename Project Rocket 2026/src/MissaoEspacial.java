public class MissaoEspacial{
    public static void main(String[] args){
        CentroControle controle = new CentroControle();

        Foguete Falcon = new Foguete("Falcon XII", 80,80);
        Foguete Apollo = new Foguete("Apollo XI", 120,0);

        Satelite Sputnik = new Satelite("Sputnik",40, 50, "LEO");
        Satelite Hubble = new Satelite("Hubble",40, 50, "LEO");
        Satelite JamesWebb = new Satelite("JamesWebb",40, 50, "LEO");

        controle.adicionarFoguete(Falcon);
        controle.adicionarFoguete(Apollo);
        controle.adicionarSatelite(Sputnik);
        controle.adicionarSatelite(Hubble);
        controle.adicionarSatelite(JamesWebb);

        controle.statusMissao();
        IO.println();

        // Abastecendo e iniciando a Missão
        Falcon.abastecer(50);
        controle.iniciarMissao("Falcon XII","Sputnik");

        // Satelite em órbita
        Sputnik.ativarPaineis();
        Sputnik.enviarDados();

    }
}