public class Livro {
    //ATRIBUTOS
    private String titulo;
    private String autor;
    private boolean disponivel;

    //CONSTRUTORES
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;  //livro está disponivel
    }

    // GETTERS E SETTERS
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Disponivel: " + disponivel;
    }
}
