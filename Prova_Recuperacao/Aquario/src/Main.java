import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Aquarium aquarium = new Aquarium();

    public static void main(String[] args) throws IOException {
        cria_Aquario();
        mostraMenu();

    }

    public static void mostraMenu() throws IOException {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar peixe");
            System.out.println("2 - Buscar peixe");
            System.out.println("3 - Atualizar peixe");
            System.out.println("4 - Remover peixe");
            System.out.println("5 - Mostrar lista de alimentos");
            System.out.println("0 - Sair");
            int option = Integer.parseInt(br.readLine());
            switch (option) {
                case 1:
                    cria_Peixe();
                    break;
                case 2:
                    busca_Peixe();
                    break;
                case 3:
                    atualiza_Peixe();
                    break;
                case 4:
                    remove_Peixe();
                    break;
                case 5:
                    mostrar_Lista_Alimentos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void cria_Aquario() throws IOException {
        System.out.println("Comprimento:");
        Double compriemeto = Double.parseDouble(br.readLine());
        System.out.println("Largura:");
        Double largura = Double.parseDouble(br.readLine());
        System.out.println("Altura:");
        Double altura = Double.parseDouble(br.readLine());
        Aquarium aquario = new Aquarium(compriemeto, largura, altura);
    }

    public static void cria_Peixe() throws IOException {
        System.out.println("Digite o nome do peixe:");
        String nome = br.readLine();
        System.out.println("Digite a espécie do peixe:");
        String especie = br.readLine();
        System.out.println("Digite a cor do peixe:");
        String cor = br.readLine();
        Fish fish = new Fish(nome, especie, cor);
        if (aquarium.adiciona_Peixe(fish)) {
            System.out.println("Peixe adicionado com sucesso");
        } else {
            System.out.println("O aquário já está cheio ou já existe um peixe com este nome");
        }
    }

    private static void remove_Peixe() throws IOException {
        System.out.println("Digite o nome do peixe a ser removido:");
        String name = br.readLine();
        if (aquarium.remove_Peixe(name)) {
            System.out.println("Peixe removido com sucesso");
        } else {
            System.out.println("Peixe não encontrado");
        }
    }

    private static void busca_Peixe() throws IOException {
        System.out.println("Digite o nome do peixe a ser buscado:");
        String nome = br.readLine();
        for (Fish f : aquarium.getLista_Peixes()) {
            if (f.getNome().equals(nome)) {
                System.out.println("Peixe encontrado:");
                System.out.println("Nome: " + f.getNome());
                System.out.println("Espécie: " + f.getEspecie());
                System.out.println("Cor: " + f.getCor());
                return;
            }
        }
        System.out.println("Peixe não encontrado");
    }

    private static void atualiza_Peixe() throws IOException {
        System.out.println("Digite o nome do peixe a ser atualizado:");
        String nome = br.readLine();
        Fish fish = null;
        for (Fish f : aquarium.getLista_Peixes()) {
            if (f.getNome().equals(nome)) {
                fish = f;
                break;
            }
        }
        if (fish == null) {
            System.out.println("Peixe nao encontrado");
            return;
        }
        System.out.println("Digite o novo nome do peixe:");
        String newName = br.readLine();
        fish.setNome(newName);
        System.out.println("Peixe atualizado com sucesso");
    }

    private static void mostrar_Lista_Alimentos() {
        ArrayList<String> lista_Alimentos = aquarium.pega_lista_Alimento();
        if (lista_Alimentos.isEmpty()) {
            System.out.println("Não há peixes no aquário");
        } else {
            System.out.println("Lista de alimentos:");
            for (String food : lista_Alimentos) {
                System.out.println(food);
            }
        }
    }
}