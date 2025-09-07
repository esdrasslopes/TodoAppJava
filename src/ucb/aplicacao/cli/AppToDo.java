package ucb.aplicacao.cli;
import ucb.aplicacao.model.Tarefa;
import ucb.aplicacao.service.TarefaServico;
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
            System.out.println("4 - Pesquisar tarefa");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();

            System.out.println();

            switch (opcao){
                case 1:
                    System.out.println("Como você quer criar sua tarefa?");
                    System.out.println("1 - Título");
                    System.out.println("2 - Título e descrição");
                    System.out.println("3 - Título, descrição e status da tarefa");

                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao){
                        case 1:
                            System.out.println("Digite o titulo");
                            titulo = scanner.nextLine();
                            tarefaCriada = tarefas.criar(titulo);
                            System.out.println("A sua tarefa foi criada com sucesso:\nTítulo: "+ tarefaCriada.getTitulo() + "\n");

                            break;

                        case 2:
                            System.out.println("Digite o titulo");
                            titulo = scanner.nextLine();
                            System.out.println("Digite a descrição");
                            descricao = scanner.nextLine();
                            tarefaCriada = tarefas.criar(titulo, descricao);
                            System.out.println("A sua tarefa foi criada com sucesso:\nTítulo: "+ tarefaCriada.getTitulo() + "\nDescrição : " + tarefaCriada.getDescricao() + "\n");
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

                case 5:
                    System.out.println("Operação das tarefas finaliza");
                    controle = false;
                    break;
            }
        }
    }
}
