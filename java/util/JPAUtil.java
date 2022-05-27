package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Código referente ao item D


public class JPAUtil {

private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("APSAP2PU");

	public static EntityManager criarEntityManager() {
		
	return emf.createEntityManager();
	
	}

}
