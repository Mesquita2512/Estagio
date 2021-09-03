package dao;

import entity.Emprestimo;

public class EmprestimoDao {

	GenericoDao gDao = new GenericoDao();

	public boolean salvar(Emprestimo emprestimo) {
		return gDao.salvar(emprestimo);
	}

}
