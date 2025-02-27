package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private String nome;
    private String descricao;

    @JsonIgnore
    private LocalDate dataTermino;

    private String dataTerminoStr; // Campo que será salvo no JSON

    private int prioridade;
    private String categoria;
    private String status;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Tarefa() {}

    public Tarefa(String nome, String descricao, LocalDate dataTermino, int prioridade, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.dataTerminoStr = dataTermino.format(formatter); // Converte LocalDate para String
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }

    public String getDataTerminoStr() { return dataTerminoStr; }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public void setDataTerminoStr(String dataTerminoStr) {
        this.dataTerminoStr = dataTerminoStr;
        this.dataTermino = LocalDate.parse(dataTerminoStr, formatter); // Converte String para LocalDate
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
        this.dataTerminoStr = dataTermino.format(formatter);
    }

    public int getPrioridade() { return prioridade; }
    public String getCategoria() { return categoria; }
    public String getStatus() { return status; }

    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Descrição: " + descricao + "\n" +
                "Data de Término: " + dataTerminoStr + "\n" +
                "Prioridade: " + prioridade + "\n" +
                "Categoria: " + categoria + "\n" +
                "Status: " + status + "\n";
    }
}
