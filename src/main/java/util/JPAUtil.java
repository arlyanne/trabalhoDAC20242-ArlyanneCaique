package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//O entityManagerFactory serve para criar entityManager -  e para criar entityManagerFactory preciso de um Persistence
public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dac20242");
	
	//Metodo para criar entityManager
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
}
