package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;

import entity.Emprestimo;
import entity.Material;
import fabricaConexao.FabricaJpa;

public class EmprestimoDao {

	GenericoDao gDao = new GenericoDao();

	public boolean salvar(Emprestimo emprestimo) {
		return gDao.salvar(emprestimo);
	}

	public boolean atualizarEmprestimo(Emprestimo emprestimo) {
		return gDao.atualizar(emprestimo);
	}
	
	//Buscar toda a lista de Emprestimos do banco de dados
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

}
