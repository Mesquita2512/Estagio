package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;
import entity.Material;
import fabricaConexao.FabricaJpa;

public class MaterialDao {

	GenericoDao gDao = new GenericoDao();

	// Salva um material.
	public boolean Salvar(Material material) {
		return gDao.salvar(material);

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

	@SuppressWarnings("unchecked")
	public List<Material> getListaMaterial() {
		return (List<Material>) gDao.listarTodos(Material.class);
	}

}
