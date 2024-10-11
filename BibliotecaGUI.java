import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaGUI {
    private Biblioteca biblioteca;
    private JFrame frame;

    //COMPONENTES DE INTEFACE
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtNomeUsuario;
    // ALUNO - PROFESSOR
    private JComboBox<String> cbTipoUsuario;

    public BibliotecaGUI() {
        biblioteca = new Biblioteca();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Gerenciamento de Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(0, 2));

        //CAMPO P/ ADD LIVRO
        frame.add(new JLabel("Titulo do Livro:"));
        txtTitulo = new JTextField();
        frame.add(txtTitulo);

        frame.add(new JLabel("Autor do Livro:"));
        txtAutor = new JTextField();
        frame.add(txtAutor);

        JButton btnAdicionarLivro = new JButton("Adicionar Livro");
        btnAdicionarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarLivro();
            }
        });
        frame.add(btnAdicionarLivro);

        //CAMPO P/ ADD USER
        frame.add(new JLabel("Nome do Usuário:"));
        txtNomeUsuario = new JTextField();
        frame.add(txtNomeUsuario);

        frame.add(new JLabel("Tipo de Usuário:"));
        cbTipoUsuario = new JComboBox<>(new String[]{"Aluno", "Professor"});
        frame.add(cbTipoUsuario);

        JButton btnAdicionarUsuario = new JButton("Adicionar Usuario");
        btnAdicionarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarUsuario();
            }
        });
        frame.add(btnAdicionarUsuario);

        //BOTAO P/ MOSDTRAR LIVROS DISPONIVEIS
        JButton btnListarLivros = new JButton("Listar Livros Disponiveis");
        btnListarLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLivrosDisponiveis();
            }
        });
        frame.add(btnListarLivros);

        frame.setVisible(true);
    }

    private void adicionarLivro() {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        if (!titulo.isEmpty() && !autor.isEmpty()) {
            Livro livro = new Livro(titulo, autor);
            biblioteca.adicionarLivro(livro);
            JOptionPane.showMessageDialog(frame, "Livro adicionado com sucesso!");
            txtTitulo.setText("");
            txtAutor.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
        }
    }

    private void adicionarUsuario() {
        String nome = txtNomeUsuario.getText();
        String tipo = (String) cbTipoUsuario.getSelectedItem();
        if (!nome.isEmpty()) {
            Usuario usuario;
            if (tipo.equals("Aluno")) {
                usuario = new Aluno(nome, biblioteca.getUsuarios().size() + 1, "Curso Exemplo"); 
            } else {
                usuario = new Professor(nome, biblioteca.getUsuarios().size() + 1, "Departamento Exemplo"); 
            }
            biblioteca.adicionarUsuario(usuario);
            JOptionPane.showMessageDialog(frame, "Usuario adicionado com sucesso!");
            txtNomeUsuario.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha o nome do usuario.");
        }
    }

    private void listarLivrosDisponiveis() {
        StringBuilder livrosDisponiveis = new StringBuilder("Livros disponiveis:\n");
        for (Livro livro : biblioteca.getLivros()) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.append(livro).append("\n");
            }
        }
        JOptionPane.showMessageDialog(frame, livrosDisponiveis.toString());
    }
}
