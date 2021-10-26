package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionalException;
import entity.Material;
import fabricaConexao.FabricaJpa;

public class MaterialDao {

	GenericoDao gDao = new GenericoDao();

	// Salva um material.
	public boolean Salvar(Material material) {
		return gDao.salvar(material);

	}
	
	// Atualiza um material no banco de dados
	public boolean atualizar(Material material) {
		return gDao.atualizar(material);
	}

	// Buscar um material pelo Id
	public Material buscarPorId(long id) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		Material resultado;
		try {
			entityManager.getTransaction().begin();

			resultado = entityManager.find(Material.class, id);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FabricaJpa.shutdown();
		}

		return resultado;
	}

	//Buscar toda a lista de material do banco de dados
	@SuppressWarnings("unchecked")
	public List<Material> getListaMaterial() {
		return (List<Material>) gDao.listarTodos(Material.class);
	}
	
	//Buscar os material com descrição informada e ativo
	@SuppressWarnings("unchecked")
	public List<Material> listarMaterialPorNome( String descricao) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Material> lista;
		try {
			
			String jpql = "from Material where upper(descricao) like upper(" + descricao + ") and Status = 1";
			TypedQuery<Material> q = (TypedQuery<Material>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}
	
	
	//Buscar todos os material com descrição informada
	@SuppressWarnings("unchecked")
	public List<Material> listarTodosMaterialPorNome( String descricao) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Material> lista;
		try {
			
			String jpql = "from Material where upper(descricao) like upper(" + descricao + ")";
			TypedQuery<Material> q = (TypedQuery<Material>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}
	
	//Buscar os material com descri��o informada
	@SuppressWarnings("unchecked")
	public List<Material> listarMaterialPorStatus() {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Material> lista;
		try {
			
			String jpql = "from Material where Status = 1";
			TypedQuery<Material> q = (TypedQuery<Material>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}

}
