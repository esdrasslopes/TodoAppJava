package ucb.aplicacao.model;
import java.time.LocalDateTime;
import java.util.UUID;

public class Tarefa {
    private String id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private LocalDateTime dataAgora;

    public Tarefa(){
        this.completa = false;
        this.id = UUID.randomUUID().toString();
        this.dataAgora = LocalDateTime.now();
    }

    public Tarefa(String titulo){
        this();
        this.titulo = titulo;
    }

    public Tarefa(String titulo, String descricao){
        this(titulo);
        this.descricao = descricao;
    }

    public Tarefa(String titulo, String descricao, int completa){
        this(titulo, descricao);
        this.completa = completa == 1;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public LocalDateTime getDataAgora() {
        return dataAgora;
    }

    public void setDataAgora(LocalDateTime dataAgora) {
        this.dataAgora = dataAgora;
    }
}


