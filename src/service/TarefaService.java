package service;

import models.Tarefa;
import repository.TarefaRepositorio;
import java.time.LocalDate;
import java.util.List;

public class TarefaService {
    private TarefaRepositorio repositorio;

    public TarefaService() {
        this.repositorio = new TarefaRepositorio();
    }

    public void adicionarTarefa(String nome, String descricao, String dataTerminoStr, int prioridade, String categoria, String status) {
        LocalDate dataTermino = LocalDate.parse(dataTerminoStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Tarefa tarefa = new Tarefa(nome, descricao, dataTermino, prioridade, categoria, status);
        repositorio.adicionarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repositorio.listarTarefas();
    }

    public void removerTarefa(int index) {
        repositorio.removerTarefa(index);
    }
}
