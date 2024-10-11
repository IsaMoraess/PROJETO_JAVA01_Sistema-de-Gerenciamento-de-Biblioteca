import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //ATRIBUTOS
    private List<Livro> livros;
    private List<Usuario> usuarios;

    //CONSTRUTOR
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    //METODOS PARA ADICIONAR LIVROS E USUARIOS
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    //GETTERS
    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
