package dao;

import java.util.List;
import entity.Emprestimo;

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

}
