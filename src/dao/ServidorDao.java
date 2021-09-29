package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;

import entity.Material;
import entity.Servidor;
import fabricaConexao.FabricaJpa;

public class ServidorDao {
	GenericoDao daoG = new GenericoDao();

	// Salvando um Servidor
	public boolean salvar(Servidor servidor) {
		return daoG.salvar(servidor);

	}

	// Buscando um Servidor Pelo Siape
	public Servidor buscarPorSiape(long siape) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		Servidor resultado;
		try {
			entityManager.getTransaction().begin();

			resultado = entityManager.find(Servidor.class, siape);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FabricaJpa.shutdown();
		}

		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public List<Servidor> getListaServidor() {
		return (List<Servidor>) daoG.listarTodos(Servidor.class);
	}

}
