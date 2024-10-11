public class Professor extends Usuario {
    //ATRIBUTOS
    private String departamento;

    //CONSTRUTORES
    public Professor(String nome, int id, String departamento) {
        super(nome, id);
        this.departamento = departamento;
    }

    @Override
    public String getTipoUsuario() {
        return "Professor";
    }

    public String getDepartamento() {
        return departamento;
    }
}
