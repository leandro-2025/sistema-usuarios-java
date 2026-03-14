import model.Usuario;
import service.UsuarioService;
import java.util.Scanner;

public class Main {

    public static void mostrarMenu() {

        System.out.println("\n===== MENU =====");
        System.out.println("1 - Cadastar usuário");
        System.out.println("2 - Listar usuários");
        System.out.println("3 - Buscar usuário");
        System.out.println("4 - Remover usuário");
        System.out.println("5 - Sair");
        System.out.println("Escolha: ");
    }

    public static void main (String[] args) {

        UsuarioService service = new UsuarioService();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 5) {

            mostrarMenu();

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Digite apenas números!");
                scanner.next();
                continue;
            }

            switch (opcao) {

                case 1:
                    scanner.nextLine();

                    Usuario usuario = new Usuario();

                    System.out.println("Digite seu nome: ");
                    usuario.setNome(scanner.nextLine());

                    System.out.println("Digite seu email: ");
                    usuario.setEmail(scanner.nextLine());

                    System.out.println("Digite sua idade: ");
                    usuario.setIdade(scanner.nextInt());

                    service.cadastrarUsuario(usuario);
                    break;

                case 2:
                    service.listarUsuarios();
                    break;

                case 3:
                    scanner.nextLine();

                    System.out.println("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();

                    Usuario encontrado = service.buscarUsuarioPorNome(nome);

                    if (encontrado != null) {
                        System.out.println("Usuário encontrado: ");
                        System.out.println(encontrado.getNome() +  "|"  + encontrado.getEmail() +  "| Idade:"  + encontrado.getIdade());
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
                    break;


                case 4:

                    scanner.nextLine();

                    System.out.println("Digite o nome do usuário que deseja remover: ");
                    String remover = scanner.nextLine();

                    boolean removido = service.removerUsuario(remover);

                    if (removido) {
                        System.out.println("Usuário removido com sucesso!");
                    }else {
                        System.out.println("Usuário não encontrado!");
                    }
                    break;


                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }


        }

    }
}