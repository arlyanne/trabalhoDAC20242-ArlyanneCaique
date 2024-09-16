package dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Usuario;
import util.JPAUtil;

public class UsuarioDao {

	//Metodo SALVAR
	public static void save(Usuario user) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin(); //Iniciando transacao
		em.persist(user);
		em.getTransaction().commit(); //faz commit da persistencia
		em.close(); //
	}
	
	//Metodo Atualizar
	public static void update(Usuario user) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}
	
	//Metodo para buscar usuario por ID
	public static Usuario find(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Usuario us = em.find(Usuario.class, id);
		em.close();
		return us;
	}
	
	//Metodo DELETAR
	public static void delete(Usuario user) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		user = em.find(Usuario.class, user.getId());
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}
	
	//Metodo Listar Usuario
	public static List<Usuario> listAll(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select a from Usuario a");
		List<Usuario> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	//Metodo para Contar
	public static Integer count() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select count(id) from usuario");
		int count = ((BigInteger) q.getSingleResult()).intValue();
		return count;
	}
}
