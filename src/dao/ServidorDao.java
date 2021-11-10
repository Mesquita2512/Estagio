package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionalException;
import entity.Servidor;
import fabricaConexao.FabricaJpa;

public class ServidorDao {
	GenericoDao daoG = new GenericoDao();

	// Salvando um Servidor
	public boolean salvar(Servidor servidor) {
		return daoG.salvar(servidor);

	}

	// Atualizando um Servidor
	public boolean atualizar(Servidor servidor) {
		return daoG.atualizar(servidor);

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

	// Buscra os servidor ativos com descrição informada
	@SuppressWarnings("unchecked")
	public List<Servidor> listarServidorPorNome(String nome) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Servidor> lista;
		try {

			String jpql = "from Servidor where upper(nome) like upper(" + nome + ") and Status = 1";
			TypedQuery<Servidor> q = (TypedQuery<Servidor>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}
	
	
	// Buscra todos os servidores com a descrição informada
		@SuppressWarnings("unchecked")
		public List<Servidor> listarTodosServidoresPorNome(String nome) {
			EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
			List<Servidor> lista;
			try {

				String jpql = "from Servidor where upper(nome) like upper(" + nome + ")";
				TypedQuery<Servidor> q = (TypedQuery<Servidor>) entityManager.createQuery(jpql);
				lista = q.getResultList();
			} catch (EntityExistsException | TransactionalException e) {
				lista = null;
				FabricaJpa.shutdown();
			}

			return lista;
		}

	// Buscra os servidores ativos
	@SuppressWarnings("unchecked")
	public List<Servidor> listarServidorPorStatus() {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Servidor> lista;
		try {

			String jpql = "from Servidor where Status = 1";
			TypedQuery<Servidor> q = (TypedQuery<Servidor>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}
	
	// Buscra os servidores inativos
		@SuppressWarnings("unchecked")
		public List<Servidor> listarServidorPorStatusInativos() {
			EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
			List<Servidor> lista;
			try {

				String jpql = "from Servidor where Status = 0";
				TypedQuery<Servidor> q = (TypedQuery<Servidor>) entityManager.createQuery(jpql);
				lista = q.getResultList();
			} catch (EntityExistsException | TransactionalException e) {
				lista = null;
				FabricaJpa.shutdown();
			}

			return lista;
		}

}
