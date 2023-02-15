package Exercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Precisamos fazer um programa para gerenciar um estacionamento.
Podemos ter até 269 carros estacionados. Cada carro tem um
modelo, ano de fabricação e placa. Precisamos registrar a vaga
selecionada, a hora de entrada e a hora de saída do
estacionamento. O valor pago é calculado a partir da
diferença entre os horários (o valor unitário da hora deve ser
um atributo também). Não esqueça de criar os métodos padrões
(toString, equals e cada classe deve ter dois construtores).

As ações que um usuário do sistema de estacionamento pode fazer são:

- registrar a entrada de um novo carro no estacionamento. A hora deve ser obtida do sistema operacional (pesquise sobre as classes DateTimeFormatter e LocalDateTime).

- Registrar a saída de um carro do estacionamento. Deve-se mostrar ao usuário quanto ele deve pagar pela estadia no estacionamento.

- Mostrar o valor total recebido com os pagamentos no dia corrente.

- Mostrar quais carros ainda estão no estacionamento (todos os seus dados devem aparecer, inclusive a hora de entrada).

- Mostrar quais carros são de um determinado modelo ou ano de fabricação.

- Pesquisar se um carro com uma determinada placa ainda está estacionado.

- Fechar o sistema.
 */
public class Exerc2 {
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Estacionado[] vagas = inicializaEstacionamento();
        int opcao;

        do {
            opcao = menu();

            switch (opcao) {
                case 1:
                    Carro carro = criaCarro();
                    int i = encontraVaga(vagas);

                    registraEntrada(carro, vagas[i]);
                    break;
                case 2:
                    String placa = lerTexto("Qual a placa?");

                    i = encontraCarro(vagas, placa);
                    registraHoraSaida(vagas, i, placa);
                    break;
                case 3:
                    double valorTotal = obtemValorPago(vagas);
                    System.out.println("O total obtido até o momento hoje é: " + valorTotal);
                    break;
                case 4:
                    mostraCarrosEstacionados(vagas);
                    break;
                case 5:
                    System.out.println("A - Pesquisar por ano | B - Pesquisar por modelo");
                    String opcaoPesquisa = in.readLine().toLowerCase();

                    if (opcaoPesquisa.equals("a") || opcaoPesquisa.equals("b")) {
                        if ("a".equals(opcaoPesquisa)) {
                            int ano = lerNumero("Qual ano gostarias de ver?");

                            pesquisaPorAno(vagas, ano);
                        } else {
                            String modelo = lerTexto("Qual o modelo?");

                            pesquisaPorModelo(vagas, modelo);
                        }
                    } else {
                        System.err.println("Opção inválida (a ou b).");
                    }
                    break;
                case 6:
                    placa = lerTexto("Qual a placa?");
                    Estacionado x = pesquisaCarro(vagas, placa);

                    if (x == null) {
                        System.out.println("Carro " + placa +  " não encontrado no estacionamento");
                    } else {
                        System.out.println(x);
                    }
            }
        } while (opcao != 7);
    }

    private static Estacionado pesquisaCarro(Estacionado[] vagas, String placa) {
        for (Estacionado estacionado : vagas) {
            if (!estacionado.estaLivre()
                    && estacionado.getCarro().getPlaca().equalsIgnoreCase(placa)
                    && estacionado.getValorPago() != 0) {
                return estacionado;
            }
        }
        return null;
    }

    private static void pesquisaPorModelo(Estacionado[] vagas, String modelo) {
        for (Estacionado estacionado : vagas) {
            if (!estacionado.estaLivre() && estacionado.getCarro().getModelo().equalsIgnoreCase(modelo)) {
                System.out.println(estacionado);
            }
        }
    }

    private static void pesquisaPorAno(Estacionado[] vagas, int ano) {
        for (Estacionado value : vagas) {
            if (!value.estaLivre() && value.getCarro().getAno() == ano) {
                System.out.println(value);
            }
        }
    }

    private static void mostraCarrosEstacionados(Estacionado[] vagas) {
        for (Estacionado item : vagas) {
            if (!item.estaLivre() && item.getValorPago() == 0) {
                System.out.println(item);
            }
        }
    }

    private static double obtemValorPago(Estacionado[] vagas) {
        double valorTotal = 0;

        for (Estacionado element : vagas) {
            if (!element.estaLivre() && element.getValorPago() != 0) {
                valorTotal += element.getValorPago();
            }
        }
        return valorTotal;
    }

    private static void registraHoraSaida(Estacionado[] vagas, int i, String placa) {
        if (i < vagas.length) {
            vagas[i].setHoraSaida();
            vagas[i].setValorPago();
            System.out.println(vagas[i]);
        } else {
            System.err.println("Carro não encontrado nas vagas: placa " + placa);
        }
    }

    private static int encontraCarro(Estacionado[] vagas, String placa) {
        int i;
        i = 0;
        while (i < vagas.length && !vagas[i].getCarro().getPlaca().equals(placa)) {
            i++;
        }
        return i;
    }

    private static int menu() throws IOException {
        int opcao;
        System.out.println("1 - registrar a entrada de um novo carro no estacionamento. A hora deve ser obtida do sistema operacional (pesquise sobre as classes DateTimeFormatter e LocalDateTime).\n" + "\n" +
                "2 - Registrar a saída de um carro do estacionamento. Deve-se mostrar ao usuário quanto ele deve pagar pela estadia no estacionamento.\n" + "\n" +
                "3 - Mostrar o valor total recebido com os pagamentos no dia corrente.\n" + "\n" +
                "4 - Mostrar quais carros ainda estão no estacionamento (todos os seus dados devem aparecer, inclusive a hora de entrada).\n" + "\n" +
                "5 - Mostrar quais carros são de um determinado modelo ou ano de fabricação.\n" + "\n" +
                "6 - Pesquisar se um carro com uma determinada placa ainda está estacionado.\n" + "\n" +
                "7 - Fechar o sistema.");
        System.out.println("Escolha uma opção:");
        opcao = Integer.parseInt(in.readLine());
        return opcao;
    }

    private static Estacionado[] inicializaEstacionamento() {
        Estacionado[] vagas = new Estacionado[269];

        for (int i = 0; i < vagas.length; i++) {
            vagas[i] = new Estacionado(String.valueOf(i));
        }
        return vagas;
    }

    private static void registraEntrada(Carro carro, Estacionado vagas) {
        vagas.setCarro(carro);
        vagas.setHoraEntrada();
    }

    private static int encontraVaga(Estacionado[] vagas) {
        int i = 0;

        while (!vagas[i].estaLivre()) {
            i++;
        }
        return i;
    }

    private static Carro criaCarro() throws IOException {
        String placa = lerTexto("Qual a placa?");
        int ano = lerNumero("Qual o ano?");
        String modelo = lerTexto("Qual o modelo?");
        Carro carro = new Carro(placa, ano, modelo);
        return carro;
    }

    public static String lerTexto(String texto) throws IOException {
        System.out.println(texto);

        return in.readLine();
    }

    public static int lerNumero(String texto) throws IOException {
        return Integer.parseInt(lerTexto(texto));
    }
}
