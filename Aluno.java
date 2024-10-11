public class Aluno extends Usuario {
    // ATRIBUTOS
    private String curso;

    // CONSTRUTORES
    public Aluno(String nome, int id, String curso) {
        super(nome, id);
        this.curso = curso;
    }

    @Override
    public String getTipoUsuario() {
        return "Aluno";
    }

    public String getCurso() {
        return curso;
    }
}
