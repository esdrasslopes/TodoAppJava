package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefa;

import java.util.ArrayList;

import java.util.List;

public class TarefaServico {
    private final List<Tarefa> tarefas = new ArrayList<Tarefa>();

    public Tarefa criar(String titulo){
        Tarefa tarefa = new Tarefa(titulo);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criar(String titulo, String descricao){
        Tarefa tarefa = new Tarefa(titulo, descricao);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criar(String titulo, String descricao, int completa){
        Tarefa tarefa = new Tarefa(titulo, descricao, completa);
        tarefas.add(tarefa);
        return tarefa;
    }
}
