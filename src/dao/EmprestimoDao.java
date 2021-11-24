package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionalException;

import entity.Emprestimo;
import fabricaConexao.FabricaJpa;

public class EmprestimoDao {

	GenericoDao gDao = new GenericoDao();

	public boolean salvar(Emprestimo emprestimo) {
		return gDao.salvar(emprestimo);
	}

	public boolean atualizarEmprestimo(Emprestimo emprestimo) {
		return gDao.atualizar(emprestimo);
	}

	// Buscar toda a lista de Emprestimos do banco de dados
	@SuppressWarnings("unchecked")
	public List<Emprestimo> getListaEmprestimo() {
		return (List<Emprestimo>) gDao.listarTodos(Emprestimo.class);
	}

	// Buscar um Emprestimo pelo Id
	public Emprestimo buscarPorId(long id) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		Emprestimo resultado;
		try {
			entityManager.getTransaction().begin();

			resultado = entityManager.find(Emprestimo.class, id);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FabricaJpa.shutdown();
		}

		return resultado;
	}

	// Buscar todos os emprestimo em andamento
	@SuppressWarnings("unchecked")
	public List<Emprestimo> listarEmprestimoEmAndamento() {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Emprestimo> lista;
		try {

			String jpql = "from Emprestimo where Qtd_Emprestada > Qtd_Tot_Devolvida ";
			TypedQuery<Emprestimo> q = (TypedQuery<Emprestimo>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}

	// Buscar os Emprestimos com material pra devoluão com Filtros
	@SuppressWarnings("unchecked")
	public List<Emprestimo> listarEmprestimoComFiltros(String filtros) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Emprestimo> lista;
		try {

			String jpql = "from Emprestimo where Qtd_Emprestada > Qtd_Tot_Devolvida " + filtros;
			TypedQuery<Emprestimo> q = (TypedQuery<Emprestimo>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}
	
	// Buscar todos os emprestimos concluidos
	@SuppressWarnings("unchecked")
	public List<Emprestimo> listarEmprestimoConcluidos() {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Emprestimo> lista;
		try {

			String jpql = "from Emprestimo where Qtd_Emprestada = Qtd_Tot_Devolvida ";
			TypedQuery<Emprestimo> q = (TypedQuery<Emprestimo>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}
	
	// buscar todos os emprestimos por servidor com base num filtro, esta sendo usado na tela de emprestimos relatorios 
	@SuppressWarnings("unchecked")
	public List<Emprestimo> listarEmprestimoPorServidor(String filtro) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Emprestimo> lista;
		try {

			String jpql = filtro;
			TypedQuery<Emprestimo> q = (TypedQuery<Emprestimo>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}

}
