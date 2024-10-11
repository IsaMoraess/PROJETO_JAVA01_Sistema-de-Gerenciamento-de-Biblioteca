public class Usuario {
    //ATRIBUTOS
    private String nome;
    private int id;

    //CONSTRUTORES
    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    //GETTERS
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getTipoUsuario() {
        return "Usuario Geral"; // Metodo a ser sobrescrito nas subclasses
    }
}
