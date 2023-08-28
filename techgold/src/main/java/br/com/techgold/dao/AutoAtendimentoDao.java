package br.com.techgold.dao;

import javax.persistence.EntityManager;

import br.com.techgold.entitymanager.EntityFactory;
import br.com.techgold.modelo.Solicitacao;

public class AutoAtendimentoDao {
	EntityManager manager;

	public AutoAtendimentoDao() {
		new EntityFactory();
		manager = EntityFactory.getEntityManager();
	}
	
	
	
	public void salvaSuporte(Solicitacao solicitacao) {
		manager.getTransaction().begin();
		manager.persist(solicitacao);
		manager.getTransaction().commit();
		manager.close();
	}
}