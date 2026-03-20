package clinicaveterinaria;

import model.*;
import model.enums.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    
    private static List<Tutor> tutores = new ArrayList<>();
    private static List<Animal> animais = new ArrayList<>();
    private static List<Consulta> consultas = new ArrayList<>();
    private static List<Veterinario> veterinarios = new ArrayList<>();
    private static Usuario usuarioLogado;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = Conexao.conectar();

if (conn != null) {
    System.out.println("Conectado ao banco de dados!");
} else {
    System.out.println("Erro ao conectar com o banco.");
}
        
        inicializarDados();
        
        System.out.println("=== SISTEMA CLÍNICA VETERINÁRIA ===");
        System.out.println();
        
        if (realizarLogin(scanner)) {
            System.out.println("\nBem-vindo(a), " + usuarioLogado.getNome() + "!");
            System.out.println("Tipo de usuário: " + usuarioLogado.getTipo());
            System.out.println();
            
            boolean continuar = true;
            while (continuar) {
                exibirMenu();
                
                int opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1:
                        cadastrarAnimal(scanner);
                        break;
                    case 2:
                        cadastrarTutor(scanner);
                        break;
                    case 3:
                        buscarInformacoes(scanner);
                        break;
                    case 4:
                        listarAnimaisCadastrados();
                        break;
                    case 0:
                        continuar = false;
                        System.out.println("Encerrando sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                System.out.println();
            }
        } else {
            System.out.println("Falha na autenticação. Sistema encerrado.");
        }
        
        scanner.close();
    }
    
    private static void inicializarDados() {
        usuarioLogado = new Usuario("atendente", "123", "Maria Silva", TipoUsuario.ATENDENTE);
        
        Veterinario vet = new Veterinario("Dr. João Santos", "CRMV-SP 12345");
        veterinarios.add(vet);
        
        Tutor tutor1 = new Tutor("Carlos Oliveira", "12345678900", "(13) 98765-4321", "Rua das Flores, 123");
        tutores.add(tutor1);
    }
    
    private static boolean realizarLogin(Scanner scanner) {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        return usuarioLogado.autenticar(login, senha);
    }
    
    private static void exibirMenu() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Cadastrar Tutor");
        System.out.println("3 - Buscar Informações");
        System.out.println("4 - Listar Animais Cadastrados");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static void cadastrarAnimal(Scanner scanner) {
        System.out.println("\n=== CADASTRO DE ANIMAL ===");
        
        System.out.print("Nome do animal: ");
        String nome = scanner.nextLine();
        
        System.out.print("Tipo (cachorro, gato, etc.): ");
        String tipo = scanner.nextLine();
        
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        
        Animal animal = new Animal(nome, tipo, raca, idade);
        
        System.out.print("\nCPF do tutor (sem pontos e traços): ");
        String cpf = scanner.nextLine();
        
        Tutor tutorEncontrado = buscarTutorPorCpf(cpf);
        
        if (tutorEncontrado != null) {
            animal.vincularTutor(tutorEncontrado);
            animais.add(animal);
            System.out.println("\n✓ Animal cadastrado com sucesso!");
            System.out.println(animal);
        } else {
            System.out.println("\n✗ Tutor não encontrado. Cadastro não finalizado.");
        }
    }
    
   private static void cadastrarTutor(Scanner scanner) {
        
    System.out.println("\n=== CADASTRO DE TUTOR ===");
        
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
        
    System.out.print("CPF: ");
    String cpf = scanner.nextLine();
        
    System.out.print("Telefone: ");
    String telefone = scanner.nextLine();
        
    System.out.print("Endereço: ");
    String endereco = scanner.nextLine();
        
   try {
    java.sql.Connection conn = Conexao.conectar();

    String sql = "INSERT INTO tutor (nome, cpf, telefone, endereco) VALUES (?, ?, ?, ?)";

    java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nome);
    stmt.setString(2, cpf);
    stmt.setString(3, telefone);
    stmt.setString(4, endereco);

    stmt.executeUpdate();

    System.out.println("\nTutor salvo no banco com sucesso!");
    Tutor tutor = new Tutor(nome, cpf, telefone, endereco);
tutores.add(tutor);

} catch (Exception e) {
    System.out.println("Erro ao salvar tutor: " + e.getMessage());
}
}
    
    private static void buscarInformacoes(Scanner scanner) {
        System.out.println("\n=== BUSCA ===");
        System.out.println("1 - Buscar por nome do animal");
        System.out.println("2 - Buscar por CPF do tutor");
        System.out.print("Escolha: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        if (opcao == 1) {
            System.out.print("Nome do animal: ");
            String nome = scanner.nextLine();
            buscarAnimalPorNome(nome);
        } else if (opcao == 2) {
            System.out.print("CPF do tutor: ");
            String cpf = scanner.nextLine();
            Tutor tutor = buscarTutorPorCpf(cpf);
            if (tutor != null) {
                System.out.println("\n" + tutor);
                System.out.println("Animais vinculados: " + tutor.getAnimais().size());
                for (Animal a : tutor.getAnimais()) {
                    System.out.println("  - " + a.getNome() + " (" + a.getTipo() + ")");
                }
            } else {
                System.out.println("Tutor não encontrado.");
            }
        }
    }
    
    private static Tutor buscarTutorPorCpf(String cpf) {
        for (Tutor t : tutores) {
            if (t.getCpf().equals(cpf)) {
                return t;
            }
        }
        return null;
    }
    
    private static void buscarAnimalPorNome(String nome) {
        boolean encontrou = false;
        for (Animal a : animais) {
            if (a.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.println("\n" + a);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum animal encontrado com esse nome.");
        }
    }
    
    private static void listarAnimaisCadastrados() {
        System.out.println("\n=== ANIMAIS CADASTRADOS ===");
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado ainda.");
        } else {
            for (Animal a : animais) {
                System.out.println(a);
            }
        }
    }
}