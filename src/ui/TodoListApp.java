package ui;

import service.TarefaService;
import models.Tarefa;

import java.util.List;
import java.util.Scanner;

public class TodoListApp {
    private static final TarefaService service = new TarefaService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarTarefa();
                case 2 -> listarTarefas();
                case 3 -> removerTarefa();
                case 4 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== TODO LIST ===");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Remover Tarefa");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarTarefa() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Data de término (dd/MM/yyyy): ");
        String dataTermino = scanner.nextLine();
        System.out.print("Prioridade (1-5): ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Status (ToDo, Doing, Done): ");
        String status = scanner.nextLine();

        service.adicionarTarefa(nome, descricao, dataTermino, prioridade, categoria, status);
        exibirOpcaoContinuar();
    }

    private static void listarTarefas() {
        System.out.println("\n1. Listar todas as tarefas");
        System.out.println("2. Listar por data");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == 1) {
            List<Tarefa> tarefas = service.listarTarefas();
            if (tarefas.isEmpty()) {
                System.out.println("Nenhuma tarefa encontrada.");
            } else {
                tarefas.forEach(System.out::println);
            }
        } else if (escolha == 2) {
            while (true) {
                System.out.print("Digite a data (dd/MM/yyyy): ");
                String data = scanner.nextLine();
                List<Tarefa> tarefas = service.listarPorData(data);
                if (tarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa encontrada para essa data.");
                } else {
                    tarefas.forEach(System.out::println);
                }

                System.out.println("\n1. Filtrar outra data");
                System.out.println("2. Voltar ao menu");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 2) {
                    return;
                } else if (opcao == 3) {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Opção inválida.");
        }
        exibirOpcaoContinuar();
    }

    private static void removerTarefa() {
        System.out.print("Nome da tarefa a remover: ");
        String nome = scanner.nextLine();
        service.removerTarefa(nome);
        exibirOpcaoContinuar();
    }

    private static void exibirOpcaoContinuar() {
        while (true) {
            System.out.println("\n1. Voltar ao menu");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                return;
            } else if (opcao == 2) {
                System.out.println("Saindo...");
                System.exit(0);
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
