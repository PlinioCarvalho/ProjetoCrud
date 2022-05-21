package model.entidadesDao;

import java.util.List;

import javax.persistence.EntityManager;

import model.entidades.Cargo;

public class CargoDao {

	private EntityManager manager;
	
	public CargoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void save(Cargo cargo) {
		this.manager.getTransaction().begin();
		this.manager.persist(cargo);
		this.manager.getTransaction().commit();
	}
	
	public void update(Cargo cargo) {
		this.manager.getTransaction().begin();
		this.manager.merge(cargo);
		this.manager.persist(cargo);
		this.manager.getTransaction().commit();
	}
	
	public Cargo findById(Integer id) {
		this.manager.getTransaction().begin();
		Cargo cargo = this.manager.find(Cargo.class, id);
		this.manager.getTransaction().commit();
		return cargo;
	}
	
	public List<Cargo> findAll(){
		this.manager.getTransaction().begin();
		List<Cargo> cargos = this.manager.createQuery("select c from Cargo c", Cargo.class).getResultList();
		this.manager.getTransaction().commit();
		return cargos;
	}
	
	public void deleteById(Integer id) {
		this.manager.getTransaction().begin();
		Cargo cargo = this.manager.find(Cargo.class, id);
		this.manager.remove(cargo);
		this.manager.getTransaction().commit();
	}
	
	public void delete(Cargo cargo) {
		this.manager.getTransaction().begin();
		this.manager.merge(cargo);
		this.manager.remove(cargo);
		this.manager.getTransaction().commit();
	}
	
	public void closeTransaction() {
		this.manager.close();
	}
	
}
