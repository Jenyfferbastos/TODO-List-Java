package service;

import models.Tarefa;
import repository.TarefaRepositorio;

import java.util.List;

public class TarefaService {
    private TarefaRepositorio repositorio;

    public TarefaService() {
        this.repositorio = new TarefaRepositorio();
    }

    public void adicionarTarefa(String nome, String descricao, String dataTermino, int prioridade, String categoria, String status) {
        Tarefa tarefa = new Tarefa(nome, descricao, dataTermino, prioridade, categoria, status);
        repositorio.adicionarTarefa(tarefa);
    }

    public void removerTarefa(String nome) {
        repositorio.removerTarefa(nome);
    }

    public List<Tarefa> listarTarefas() {
        return repositorio.listarTarefas();
    }

    public List<Tarefa> listarPorData(String data) {
        return repositorio.listarPorData(data);
    }
}
