package com.concretepage.dao;
import java.util.List;
import com.concretepage.entity.Usuario;
public interface IUsuarioDAO {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int Id);
    void addUsuario(Usuario usuario);
    void updateUsuario(Usuario usuario);
    void deleteUsuario(int Id);
    boolean usuarioExists(String nome, String email);
}