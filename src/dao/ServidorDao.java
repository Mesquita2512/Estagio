package dao;

import entity.Servidor;

public class ServidorDao {
	GenericoDao daoG = new GenericoDao();

	public boolean salvar(Servidor servidor) {
		return daoG.salvar(servidor);

	}

}
