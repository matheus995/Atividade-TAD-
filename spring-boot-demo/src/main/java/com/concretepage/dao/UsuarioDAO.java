package com.concretepage.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Usuario;
@Transactional
@Repository
public class UsuarioDAO implements IUsuarioDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Usuario getUsuarioById(int id) {
		return entityManager.find(Usuario.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getAllUsuarios() {
		String hql = "FROM Usuario as user ORDER BY user.id";
		return (List<Usuario>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addUsuario(Usuario usuario) {
		entityManager.persist(usuario);
	}
	@Override
	public void updateUsuario(Usuario usuario) {
		Usuario user = getUsuarioById(usuario.getId());
		user.setNome(usuario.getNome());
		user.setEmail(usuario.getEmail());
		entityManager.flush();
	}
	@Override
	public void deleteUsuario(int Id) {
		entityManager.remove(getUsuarioById(Id));
	}
	@Override
	public boolean usuarioExists(String nome, String email) {
		String hql = "FROM Usuario as user WHERE user.nome = ? and user.email = ?";
		int count = entityManager.createQuery(hql).setParameter(1, nome)
		              .setParameter(2, email).getResultList().size();
		return count > 0 ? true : false;
	}
}
