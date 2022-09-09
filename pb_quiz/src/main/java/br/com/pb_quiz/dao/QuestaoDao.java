package br.com.pb_quiz.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.pb_quiz.modelo.Questao;

public class QuestaoDao {

	private EntityManager em;
	
	public QuestaoDao(EntityManager em) {
		this.em = em;
	}
	
	  public List<Questao> questoesAtivas() {
	        String jpql = "SELECT q FROM Questao q WHERE q.ativa = true";
	        return em.createQuery(jpql, Questao.class).getResultList();
	    }
	
}
