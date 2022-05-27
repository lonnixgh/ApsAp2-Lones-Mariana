package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;

//Código referente ao item C

public class JogoDAO {

		public static void salvar (Jogo j) {
			EntityManager jg = JPAUtil.criarEntityManager();
			jg.getTransaction().begin();
			jg.persist(j);
			jg.getTransaction().commit();
			jg.close();
		}
		
		public static void editar(Jogo j) {
			EntityManager jg = JPAUtil.criarEntityManager();
			jg.getTransaction().begin();
			jg.merge(j);
			jg.getTransaction().commit();
			jg.close();
		}
		
	
		public static void excluir(Jogo j) {
			EntityManager jg = JPAUtil.criarEntityManager();
			jg.getTransaction().begin();
			j = jg.find(Jogo.class, j.getId());
			jg.remove(j);
			jg.getTransaction().commit();
			jg.close();
		}
		
		

		public static List<Jogo> listar() {
			EntityManager jg = JPAUtil.criarEntityManager();
			Query q = jg.createQuery("select j1 from Jogo j1");
			List<Jogo> resultado = q.getResultList();
			jg.close();
			return resultado;
		}
	}

	
	


