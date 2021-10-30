package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionalException;
import entity.Devolucao;
import fabricaConexao.FabricaJpa;

public class DevolucaoDao {

	GenericoDao gDao = new GenericoDao();

	public boolean salvar(Devolucao devolucao) {
		return gDao.salvar(devolucao);
	}

	public boolean atualizarDevolucao(Devolucao devolucao) {
		return gDao.atualizar(devolucao);
	}
	
	
	//traz todas as devoluções do Emprestimo passando o codigo do emprestimo
	@SuppressWarnings("unchecked")
	public List<Devolucao> listarTodasDevolucoes(long Id_Emprestimo) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Devolucao> lista;
		try {
			
			String jpql = "from Devolucao where Id_Emprestimo = " + Id_Emprestimo;
			TypedQuery<Devolucao> q = (TypedQuery<Devolucao>) entityManager.createQuery(jpql);
			lista = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			lista = null;
			FabricaJpa.shutdown();
		}

		return lista;
	}
	
	
	
}
