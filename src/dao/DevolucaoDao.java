package dao;

import entity.Devolucao;

public class DevolucaoDao {

	GenericoDao gDao = new GenericoDao();

	public boolean salvar(Devolucao devolucao) {
		return gDao.salvar(devolucao);
	}

	public boolean atualizarDevolucao(Devolucao devolucao) {
		return gDao.atualizar(devolucao);
	}
	
	
	
	
	
}
