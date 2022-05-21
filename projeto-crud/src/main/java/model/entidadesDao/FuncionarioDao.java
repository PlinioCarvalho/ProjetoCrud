package model.entidadesDao;

import java.util.List;

import javax.persistence.EntityManager;
import model.entidades.Funcionario;

public class FuncionarioDao {

	private EntityManager manager;
	
	public FuncionarioDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void save(Funcionario funcionario) {
		this.manager.getTransaction().begin();
		this.manager.persist(funcionario);
		this.manager.getTransaction().commit();
	}
	
	public Funcionario findById(Integer id) {
		this.manager.getTransaction().begin();
		Funcionario funcionario = this.manager.find(Funcionario.class, id);
		this.manager.getTransaction().commit();
		return funcionario;
	}
	
	public Funcionario findByCargoNome(String nome) {
		this.manager.getTransaction().begin();
		Funcionario funcionario = this.manager.createQuery("select f from Funcionario f where f.cargo.nome = :nome", Funcionario.class).setParameter("nome", nome).getSingleResult();
		this.manager.getTransaction().commit();
		return funcionario;
	}
	
	public List<Funcionario> findAll(){
		this.manager.getTransaction().begin();
		List<Funcionario> funcionarios = this.manager.createQuery("select f from Funcionario f", Funcionario.class).getResultList();
		this.manager.getTransaction().commit();
		return funcionarios;
	}
	
	public void update(Funcionario funcionario) {
		this.manager.getTransaction().begin();
		this.manager.merge(funcionario);
		this.manager.persist(funcionario);
		this.manager.getTransaction().commit();
	}
	
	public void deleteById(Integer id) {
		this.manager.getTransaction().begin();
		Funcionario funcionario = this.manager.find(Funcionario.class, id);
		this.manager.remove(funcionario);
		this.manager.getTransaction().commit();
	}
	
	public void delete(Funcionario funcionario) {
		this.manager.getTransaction().begin();
		this.manager.merge(funcionario);
		this.manager.remove(funcionario);
		this.manager.getTransaction().commit();
	}
	
	public void closeTransaction() {
		this.manager.close();
	}
}
