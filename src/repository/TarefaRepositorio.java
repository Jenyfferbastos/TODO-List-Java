package repository;

import models.Tarefa;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaRepositorio {
    private static final String ARQUIVO = "tarefas.dat";
    private List<Tarefa> tarefas;

    public TarefaRepositorio() {
        this.tarefas = carregarTarefas();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        tarefas.sort(Comparator.comparingInt(Tarefa::getPrioridade));
        salvarTarefas();
        System.out.println("\nTarefa adicionada com sucesso!");
    }

    public void removerTarefa(String nome) {
        if (tarefas.removeIf(t -> t.getNome().equalsIgnoreCase(nome))) {
            salvarTarefas();
            System.out.println("\nTarefa removida com sucesso!");
        } else {
            System.out.println("\nTarefa não encontrada.");
        }
    }

    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }

    public List<Tarefa> listarPorData(String data) {
        return tarefas.stream()
                .filter(t -> t.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(data))
                .collect(Collectors.toList());
    }

    private void salvarTarefas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(tarefas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar as tarefas.");
        }
    }

    private List<Tarefa> carregarTarefas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (List<Tarefa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
