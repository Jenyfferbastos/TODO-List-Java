package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String descricao;
    private LocalDate dataTermino;
    private int prioridade;
    private String categoria;
    private String status; // ToDo, Doing, Done

    public Tarefa(String nome, String descricao, String dataTermino, int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = LocalDate.parse(dataTermino, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = LocalDate.parse(dataTermino, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nDescrição: " + descricao +
                "\nData de Término: " + dataTermino.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "\nPrioridade: " + prioridade +
                "\nCategoria: " + categoria +
                "\nStatus: " + status +
                "\n---------------------------";
    }
}
