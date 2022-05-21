package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaEntityManager {

	private String nomeBanco;
	private EntityManagerFactory factory;
	private EntityManager manager; 
	
	public CriaEntityManager(String nomeBanco) {
		this.nomeBanco = nomeBanco;
		this.factory = Persistence.createEntityManagerFactory(this.nomeBanco);
		this.manager = factory.createEntityManager();
	}
	
	public EntityManager retornaEntityManager() {
		return this.manager;
	}
}
