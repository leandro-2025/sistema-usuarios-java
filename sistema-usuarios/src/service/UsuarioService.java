package service;

import model.Usuario;
import java.util.ArrayList;

public class UsuarioService {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {

        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");

    }

    public void listarUsuarios() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
        } else {

            System.out.println("----- LISTA DE USUÁRIOS -----");

            int i = 1;

            for (Usuario u : usuarios) {
                System.out.println(i +  "-" + u.getNome() + "|" +  u.getEmail() +  "| Idade" + u.getIdade());
                i++;
            }
        }
    }

    public Usuario buscarUsuarioPorNome(String nome) {

        for (Usuario u : usuarios) {

            if (u.getNome().equalsIgnoreCase(nome)) {
                return u;
            }

        }

        return null;
    }

    public boolean removerUsuario(String nome) {

        for (Usuario u : usuarios) {

            if (u.getNome().equalsIgnoreCase(nome)) {
                usuarios.remove(u);
                return true;
            }
        }

        return false;
    }


}
