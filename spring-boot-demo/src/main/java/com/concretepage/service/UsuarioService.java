package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IUsuarioDAO;
import com.concretepage.entity.Usuario;
@Service
public class UsuarioService implements IUsuarioService {
	@Autowired
	private IUsuarioDAO usuarioDAO;
	@Override
	public Usuario getUsuarioById(int Id) {
		Usuario obj = usuarioDAO.getUsuarioById(Id);
		return obj;
	}	
	@Override
	public List<Usuario> getAllUsuarios(){
		return usuarioDAO.getAllUsuarios();
	}
	@Override
	public synchronized boolean addUsuario(Usuario usuario){
       if (usuarioDAO.usuarioExists(usuario.getNome(), usuario.getEmail())) {
    	   return false;
       } else {
    	   usuarioDAO.addUsuario(usuario);
    	   return true;
       }
	}
	@Override
	public void updateUsuario(Usuario usuario) {
		usuarioDAO.updateUsuario(usuario);
	}
	@Override
	public void deleteUsuario(int Id) {
		usuarioDAO.deleteUsuario(Id);
	}
}
