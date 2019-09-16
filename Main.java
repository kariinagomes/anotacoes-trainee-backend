import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Main {
    public static void main(String[] args) throws Exception {
        List<Filho> filhos = new ArrayList<>();
        filhos.add(new Filho("filho 1")); //filhos.get(0)
        filhos.add(new Filho("filho 2"));
        filhos.add(new Filho("filho 3"));

        Pai pai = new Pai("Sciensa pai");
        
        Familia familia = new Familia(pai, filhos);
        System.out.println(familia.getPai().getNome());
        System.out.println(familia.getPai().getSalario());

        List<Filho> filhosList = familia.getFilhos().stream().filter(filtro = !filho.getNome().equals("filho 1")).collect(Collectors.toList());
   
        FileWriter fw = null;

        // nao consegue trabalhar com variaveis q nao seja final
        try {
            File file = new File("filhos.txt");
            fw = new FileWriter(file);

            for (Filho filho : filhosList) {
                fw.write(filho.toString() + "\n");
            }

            // filhosList.forEach(filho -> 
            //     fw.write(filho.toString())
            // );
            throw new Exception("Exception de Teste");
        } catch(Exception exc) {
            System.out.println("estou tratando a exceção");
            exc.printStackTrace();
        } finally {
            fw.close();
        }
        
        // try {     
        //     File file = new File("filhos.txt");
        //     fw = new FileWriter(file);

        //     for (Filho filho : filhosList) {
        //         fw.write(filho.toString() + "\n");
        //     }

        //     throw new Exception("Exception de Teste");

        // } catch(Exception exc) {
        //     System.out.println("Estou tratando a exceção");
        //     exc.printStackTrace();
        // } finally {
        //     fw.close();
        // }


        // FINAL NÃO PODE SER ALTERADA

        // for (int indice = 0; indice < familia.getFilhos().size(); indice++) {
        //     Filho filho = familia.getFilhos().get(indice);
        //     System.out.println(filho.getNome());
        // }

        // Nesse cara, vc não pode remover diretamente o filho pq
        // mantém uma referência pra ele
        // for (Filho filho : familia.getFilhos()) {
        //     System.out.println(filho.getNome());
        // 

        // java 8
        //familia.getFilhos().forEach(filho -> System.out.println(filho.getNome()));
        
        //Stream<Filho> stream = familia.getFilhos().stream().filter(filtro = !filho.getNome().equals("filho 1"));
        //stream.forEach(filho -> System.out.println(filho.getNome()));

        // é melhor trabalhar com lista
        //List<Filho> stream = familia.getFilhos().stream().filter(filtro = !filho.getNome().equals("filho 1")).collect(Collectors.toList());
        // List<Filho> filhosList = familia.getFilhos().stream().filter(filtro = !filho.getNome().equals("filho 1")).collect(Collectors.toList());
        // filhosList.forEach((filho -> System.out.println(filho)));

        // o toSet não permite valores duplicados em uma lista
        //List<Filho> stream = familia.getFilhos().stream().filter(filtro = !filho.getNome().equals("filho 1")).collect(Collectors.toList());
    }
}

class Familia {
    private Pai pai;
    private List<Filho> filhos = new ArrayList<>();
    public Double salario = 90d; // NÃO É UMA BOA PRÁTICA pq é mais difícil de rastrear

    // neste caso a familia só existe se tiver um pai
    public Familia (Pai pai, List<Filho> filhos) {
        this.pai = pai;
        this.filhos = filhos;
    }

    // o get e set do pai está aqui pq quero pegar o pai da família
    public Pai getPai() {
        return this.pai;
    }

    public void setPai(Pai pai) {
        this.pai = pai;
    }

    public List<Filho> getFilhos() {
        return this.filhos;
    }
}

class Pessoa {
    String nome;
    int idade;

    public String getNome(){
        return this.nome;
    }
}

class Filho extends Pessoa {

    public Filho(String x) {
        this.nome = x;
    }

    public String toString() {
        return this.nome + " - " + this.idade;
    }

}

class Pai extends Pessoa {
    double salario = 60d;

    public Pai(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public String toString() {
        return this.nome + " - " + this.idade + " - " + this.salario;
    }

}