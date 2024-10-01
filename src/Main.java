import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetShopController controller = new PetShopController();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Menu em loop
        while (opcao != 5) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1 - Cadastrar Proprietário");
            System.out.println("2 - Cadastrar Pet");
            System.out.println("3 - Cadastrar Vacina");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha do nextInt()

            switch (opcao) {
                case 1:
                    // Cadastrar Proprietário
                    System.out.println("=== Cadastrar Proprietário ===");
                    System.out.print("Nome: ");
                    String nomeProprietario = scanner.nextLine();
                    System.out.print("Sexo: ");
                    String sexoProprietario = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfProprietario = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailProprietario = scanner.nextLine();
                    System.out.print("Celular: ");
                    String celularProprietario = scanner.nextLine();
                    controller.cadastrarProprietario(nomeProprietario, sexoProprietario, cpfProprietario, emailProprietario, celularProprietario);
                    break;

                case 2:
                    // Cadastrar Pet
                    System.out.println("=== Cadastrar Pet ===");
                    System.out.print("Nome do Pet: ");
                    String nomePet = scanner.nextLine();
                    System.out.print("Idade: ");
                    String idadePet = scanner.nextLine();
                    System.out.print("Sexo: ");
                    String sexoPet = scanner.nextLine();
                    System.out.print("Espécie: ");
                    String especiePet = scanner.nextLine();
                    System.out.print("Raça: ");
                    String racaPet = scanner.nextLine();
                    System.out.print("ID do Proprietário: ");
                    int proprietarioId = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    controller.cadastrarPet(nomePet, idadePet, sexoPet, especiePet, racaPet, proprietarioId);
                    break;

                case 3:
                    // Cadastrar Vacina
                    System.out.println("=== Cadastrar Vacina ===");
                    System.out.print("ID do Pet: ");
                    int petId = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    System.out.print("Nome da Vacina: ");
                    String nomeVacina = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricaoVacina = scanner.nextLine();
                    System.out.print("Data de Aplicação (YYYY-MM-DD): ");
                    String dataAplicacao = scanner.nextLine();
                    controller.cadastrarVacina(petId, nomeVacina, descricaoVacina, dataAplicacao);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
