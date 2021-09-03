package dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;
import entity.Admin;
import fabricaConexao.FabricaJpa;

public class AdminDao {

	GenericoDao daoG = new GenericoDao();

	// Salvar Administrador, atenção ao Siape
	public boolean salvar(Admin admin) {
		return daoG.salvar(admin);

	}

	// Busca o Administrador pelo Siape
	public Admin buscarPorSiape(long siape) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		Admin resultado;
		try {
			entityManager.getTransaction().begin();

			resultado = entityManager.find(Admin.class, siape);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FabricaJpa.shutdown();
		}

		return resultado;
	}
}
