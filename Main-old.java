class Main {
    public static void main(String[] args) {
        System.out.println("Meu primeiro projeto");
        String mensagem = "oi";
        
        char sexo = 'F';
        int idade = 0; // não aceita null (apenas primitivos)
        float peso = 8.6f;
        //double salario = 20.000;
        String salario = "20.000";
        boolean comeMuito = true;
        Integer idaderapper = null;

        String tamanhoCalcado = "38";
        int tamanhoCalcadoInt = Integer.parseInt(tamanhoCalcado);
        System.out.println(tamanhoCalcadoInt);

        Double salarioDouble = Double.parseDouble(salario);
        System.out.println(salarioDouble);

        if (38 == tamanhoCalcadoInt) {
            System.out.println("vc tem o pé pequeno");
        } else if (tamanhoCalcadoInt > 38 && tamanhoCalcadoInt <= 43) {
            System.out.println("vc tem o pé grande");
        } else {
            System.out.println("vc tem o pé gigantesco");
        }


        // == compara endereço de memória
        // equals comparando valores

        // avalia a referência da memória
        if (tamanhoCalcado == "45") {
            System.out.println("passou aqui");
        }

        // Aqui estão com endereços de memória diferentes...
        String igual = new String("45");
        if (tamanhoCalcado == "45") {
            System.out.println("não passa aqui");
        }
        //...por isso que utilizamos equals
        if (tamanhoCalcado.equals(igual)) {
            System.out.println("passou aqui");
        }


        // se for comparar os dois rappers (objeto), use equals! pq tem endereços de memória diferentes
        Integer idadeAvo = new Integer(70);
        int idadeAvoInt = 70;
        Integer idadeAvoInteger = new Integer(70);

        // compara o valor do inteiro com o valor de memória
        if (idade == idadeAvoInt) {
            System.out.println("idade do meu avô");
        }

        switch(idadeAvo) {
            case 70: System.out.println("não é tão velho");
            case 80: System.out.println("é mais ou menos velho");
            default: System.out.println("avo muito velho");
        }

        //System.out.println(mensagem);


        // class Teste {
        //     public String getString() {
        //         return "oi";
        //     }
        // }

        // P compilar e executar de uma só vez:
        //  javac Main.java && java Main
    }
}

