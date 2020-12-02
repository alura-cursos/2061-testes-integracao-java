package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.alura.leilao.model.Usuario;

@Repository
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public Usuario buscarPorUsername(String username) {
		return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :username", Usuario.class)
				.setParameter("username", username)
				.getSingleResult();
	}

	public void deletar(Usuario usuario) {
		em.remove(usuario);
	}

}
