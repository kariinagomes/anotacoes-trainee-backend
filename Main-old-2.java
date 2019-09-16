import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        List<Filho> filhos = new ArrayList<>();
        filhos.add(new Filho("filho 1"));
        filhos.add(new Filho("filho 2"));
        filhos.add(new Filho("filho 3"));
        
        Familia familia = new Familia("Sciensa Pai", filhos);
        System.out.println(familia.getPai());
    }
}

class Familia {
    private String pai;
    private List<Filho> filhos = new ArrayList<>();
    public Double salario = 90d; // NÃO É UMA BOA PRÁTICA pq é mais difícil de rastrear

    // neste caso a familia só existe se tiver um pai
    public Familia (String pai, List<Filho> filhos) {
        this.pai = pai;
        this.filhos = filhos;
    }

    public String getPai() {
        return this.pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public List<Filho> getFilhos() {
        return this.filhos;
    }
}

class Filho {
    String nome;

    public Filho(String x) {
        this.nome = x;
    }

    public String getNome() {
        return this.nome;
    }
    

}