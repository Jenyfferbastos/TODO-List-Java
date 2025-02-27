package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import models.Tarefa;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TarefaRepositorio {
    private static final String FILE_PATH = "tarefas.json";
    private List<Tarefa> tarefas;
    private ObjectMapper objectMapper;

    public TarefaRepositorio() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.tarefas = carregarTarefas();
    }

    private List<Tarefa> carregarTarefas() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists() && file.length() > 0) {
                return objectMapper.readValue(file, TypeFactory.defaultInstance().constructCollectionType(List.class, Tarefa.class));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar tarefas.");
        }
        return new ArrayList<>();
    }

    private void salvarTarefas() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), tarefas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas.");
        }
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        salvarTarefas();
        System.out.println("✅ Tarefa adicionada com sucesso!");
    }

    public void removerTarefa(int index) {
        if (index >= 0 && index < tarefas.size()) {
            tarefas.remove(index);
            salvarTarefas();
            System.out.println("✅ Tarefa removida com sucesso!");
        } else {
            System.out.println("❌ Índice inválido.");
        }
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }
}
