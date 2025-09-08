package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefa;

import java.util.ArrayList;

import java.util.List;

public class TarefaServico {
    private final ArrayList <Tarefa> tarefas = new ArrayList<Tarefa>();

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

    public Tarefa deletar(long id) {
        for (int i = 0; i < this.tarefas.size(); i++) {
            Tarefa tarefa = this.tarefas.get(i);
            if (tarefa.getId() == id) {
                this.tarefas.remove(i);
                return tarefa;
            }
        }
        return null;
    }




}

