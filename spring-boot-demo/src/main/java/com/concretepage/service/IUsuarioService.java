package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Usuario;

public interface IUsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int Id);
    boolean addUsuario(Usuario Usuario);
    void updateUsuario(Usuario Usuario);
    void deleteUsuario(int Id);
}
