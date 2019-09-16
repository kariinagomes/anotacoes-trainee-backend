import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("Toyota", "azul", 1995));
        carros.add(new Carro("Sandero", "preto", 1997));
        carros.add(new Carro("Corola", "prata", 2000));

        Loja loja = new Loja("Loja de Carros", "123456-6", "Nome de logradouro", 320, "3333-3333", carros);

        System.out.println(loja);
        System.out.println(carros);

        List<Carro> carrosFiltrados = new ArrayList<>();
        for (Carro carro : loja.getCarros()) {
            if (carro.getCor().equals("azul")) {
                carrosFiltrados.add(carro);
            }          
        }
        
        loja.getCarros().removeAll(carrosFiltrados);

        System.out.println(loja.getCarros());

        FileWriter fw = null;
        
        try {
            File file = new File("carros.txt");
            fw = new FileWriter(file);

            fw.write("################################################################\n");
            fw.write(loja.toString() + "\n");
            fw.write("################################################################\n");
            fw.write("\n");

            for (Carro carro : loja.getCarros()) {
                fw.write(carro.toString() + "\n");
            }
        } catch(Exception exc) {
            System.out.println("Tratamento de erro");
            exc.printStackTrace();
        } finally {
            fw.close();
        }

        System.out.println("\nLendo arquivo txt - jeito google\n"); 

        FileReader fr = null;

        try {
            
            String nomeArquivo = "carros.txt";
            fr = new FileReader(nomeArquivo);
            
            int caracter = fr.read();

            while (caracter != -1) {
                System.out.print((char)caracter);    
                caracter = fr.read();
            }            
        } catch(Exception exc) {
            System.out.println("Tratamento de erro");
            exc.printStackTrace();
        } finally {
            fr.close();
            System.out.println("Passou no finally");
        }

        System.out.println("\nLendo arquivo txt\n");

        Scanner sc = null;

        try {
            
            sc = new Scanner(new File("carros.txt"));

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine()); 
            }            
        } catch(Exception exc) {
            System.out.println("Tratamento de erro");
            exc.printStackTrace();
        } finally {
            System.out.println("Passou no finally");
            sc.close();
        }

    }
}

class Loja {
    private String nome;
    private String cnpj;
    private String logradouro;
    private int numero;
    private String telefone; 
    private List<Carro> carros;

    public Loja(String nome, String cnpj, String logradouro, 
                    int numero, String telefone, List<Carro> carro) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.logradouro = logradouro;
        this.numero = numero;
        this.telefone = telefone;
        this.carros = carro;
        //this.carros = new ArrayList<>(carro);
    }

    public String getNome() {
        return this.nome;
    }

    // public String getCnpj() {
    //     return this.cnpj;
    // }

    // public String getLogradouro() {
    //     return this.logradouro;
    // }

    // public int getNumero() {
    //     return this.numero;
    // }

    // public String getTelefone() {
    //     return this.telefone;
    // }

    public List<Carro> getCarros() {
        return this.carros;
    }

    public String toString() {
        return this.nome + " - " + this.cnpj + " - " + this.logradouro + " - " + this.numero + " - " + this.telefone;
    }
}

class Carro {
    private String marca;
    private String cor;
    private int ano;

    public Carro(String marca, String cor, int ano) {
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
    }

    public String getMarca() {
        return this.marca;
    }
    
    public String getCor() {
        return this.cor;
    }

    public int getAno() {
        return this.ano;
    }

    public String toString() {
        return this.marca + " - " + this.cor + " - " + this.ano;
    }
}