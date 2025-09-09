package ucb.aplicacao.cli;

import ucb.aplicacao.model.Tarefa;
import ucb.aplicacao.service.TarefaServico;

import java.util.List;
import java.util.Scanner;

public class AppToDo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean controle = true;
        int opcao;

        String titulo;
        String descricao;
        int completa;
        TarefaServico tarefas = new TarefaServico();
        Tarefa tarefaCriada;

        while (controle){
            System.out.println("Gerenciamento de tarefas");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Deletar tarefa");
            System.out.println("3 - Atualizar tarefa");
            System.out.println("4 - Listar tarefas");
            System.out.println("5 - Pesquisar uma tarefa");
            System.out.println("6 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("Como você quer criar sua tarefa?");
                    System.out.println("1 - Título");
                    System.out.println("2 - Título e descrição");
                    System.out.println("3 - Título, descrição e status da tarefa");

                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o titulo");
                            titulo = scanner.nextLine();
                            tarefaCriada = tarefas.criar(titulo);
                            System.out.println("A sua tarefa foi criada com sucesso:\nTítulo: " + tarefaCriada.getTitulo() + "\n");
                            break;

                        case 2:
                            System.out.println("Digite o titulo");
                            titulo = scanner.nextLine();
                            System.out.println("Digite a descrição");
                            descricao = scanner.nextLine();
                            tarefaCriada = tarefas.criar(titulo, descricao);
                            System.out.println("A sua tarefa foi criada com sucesso:\nTítulo: " + tarefaCriada.getTitulo() + "\nDescrição : " + tarefaCriada.getDescricao() + "\n");
                            break;

                        case 3:
                            System.out.println("Digite o titulo");
                            titulo = scanner.nextLine();
                            System.out.println("Digite a descrição");
                            descricao = scanner.nextLine();
                            System.out.println("Digite o status da tarefa. 1 - Completa 2 - Incompleta");
                            completa = scanner.nextInt();
                            tarefaCriada = tarefas.criar(titulo, descricao, completa);
                            System.out.println(
                                    "A sua tarefa foi criada com sucesso:\n" +
                                            "Título: " + tarefaCriada.getTitulo() + "\n" +
                                            "Descrição: " + tarefaCriada.getDescricao() + "\n" +
                                            "Status: " + (tarefaCriada.isCompleta() ? "Completa" : "Incompleta\n")
                            );
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Digite o id da tarefa que quer deletar: ");
                    long id = scanner.nextLong();
                    Tarefa tarefaDeletada = tarefas.deletar(id);
                    if (tarefaDeletada != null) {
                        System.out.println(
                                "A sua tarefa foi deletada com sucesso:\n" +
                                        "Título: " + tarefaDeletada.getTitulo() + "\n" +
                                        "Descrição: " + tarefaDeletada.getDescricao() + "\n" +
                                        "Status: " + (tarefaDeletada.isCompleta() ? "Completa" : "Incompleta\n")
                        );
                    } else {
                        System.out.println("Tarefa não encontrada!\n");
                    }
                    break;

                case 3: // 🔹 Atualizar tarefa
                    System.out.println("Digite o id da tarefa que deseja atualizar:");
                    long idAtualizar = scanner.nextLong();
                    scanner.nextLine(); // consumir quebra de linha

                    System.out.println("Digite o novo título (ou deixe vazio para não alterar):");
                    String novoTitulo = scanner.nextLine();

                    System.out.println("Digite a nova descrição (ou deixe vazio para não alterar):");
                    String novaDescricao = scanner.nextLine();

                    System.out.println("Digite o novo status da tarefa (1 - Completa / 2 - Incompleta / 0 - não alterar):");
                    int status = scanner.nextInt();
                    scanner.nextLine();
                    Boolean completaAtualizada = null;
                    if (status == 1) completaAtualizada = true;
                    else if (status == 2) completaAtualizada = false;

                    Tarefa tarefaAtualizada = tarefas.atualizar(idAtualizar, novoTitulo, novaDescricao, completaAtualizada);

                    if (tarefaAtualizada != null) {
                        System.out.println("Tarefa atualizada com sucesso:");
                        System.out.println("ID: " + tarefaAtualizada.getId());
                        System.out.println("Título: " + tarefaAtualizada.getTitulo());
                        System.out.println("Descrição: " + (tarefaAtualizada.getDescricao() != null ? tarefaAtualizada.getDescricao() : "Nenhuma"));
                        System.out.println("Status: " + (tarefaAtualizada.isCompleta() ? "Completa" : "Incompleta"));
                        System.out.println("---------------");
                    } else {
                        System.out.println("Tarefa com ID " + idAtualizar + " não encontrada!");
                    }
                    break;

                case 4:
                    System.out.println("Lista de todas as tarefas:");
                    List<Tarefa> todasTarefas = tarefas.listar();

                    if (todasTarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.\n");
                    } else {
                        for (Tarefa t : todasTarefas) {
                            System.out.println("ID: " + t.getId());
                            System.out.println("Título: " + t.getTitulo());
                            System.out.println("Descrição: " + (t.getDescricao() != null ? t.getDescricao() : "Nenhuma"));
                            System.out.println("Status: " + (t.isCompleta() ? "Completa" : "Incompleta"));
                            System.out.println("---------------");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Operação das tarefas finalizada");
                    controle = false;
                    break;
            }
        }
    }
}