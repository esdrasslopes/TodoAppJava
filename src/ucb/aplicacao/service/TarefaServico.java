package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaServico {
    private final ArrayList<Tarefa> tarefas = new ArrayList<>();

    public Tarefa criar(String titulo) {
        Tarefa tarefa = new Tarefa(titulo);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criar(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(titulo, descricao);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa criar(String titulo, String descricao, int completa) {
        Tarefa tarefa = new Tarefa(titulo, descricao, completa);
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa buscarPorId(long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
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



    public ArrayList<Tarefa> listar() {
        return new ArrayList<>(tarefas);
    }

    public Tarefa atualizar(long id, String novoTitulo, String novaDescricao, Boolean completa) {
        Tarefa tarefa = buscarPorId(id);

        if(tarefa != null){
            if (novoTitulo != null && !novoTitulo.isEmpty()) {
                tarefa.setTitulo(novoTitulo);
            }
            if (novaDescricao != null && !novaDescricao.isEmpty()) {
                tarefa.setDescricao(novaDescricao);
            }
            if (completa != null) {
                tarefa.setCompleta(completa);
            }

            return tarefa;
        }

        return null;
    }

    public Tarefa marcarTarefaComoConcluida(long id){
        Tarefa tarefa = buscarPorId(id);

        if(tarefa != null){
            tarefa.setCompleta(true);

            return tarefa;
        }

        return null;
    }
}
