package ui;

import service.TarefaService;
import models.Tarefa;
import java.util.List;
import java.util.Scanner;

public class TodoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TarefaService service = new TarefaService();

        while (true) {
            System.out.println("\n=== TODO LIST ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Data de término (dd/MM/yyyy): ");
                    String data = scanner.nextLine();
                    System.out.print("Prioridade (1-5): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Status (ToDo, Doing, Done): ");
                    String status = scanner.nextLine();

                    service.adicionarTarefa(nome, descricao, data, prioridade, categoria, status);
                    break;

                case 2:
                    List<Tarefa> tarefas = service.listarTarefas();
                    tarefas.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Índice da tarefa para remover: ");
                    int index = scanner.nextInt();
                    service.removerTarefa(index);
                    break;

                case 4:
                    System.out.println(" Saindo...");
                    return;

                default:
                    System.out.println("❌ Opção inválida.");
            }
        }
    }
}
