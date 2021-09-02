package dao;

import entity.Admin;

public class AdminDao {

	GenericoDao daoG = new GenericoDao();

	public boolean salvar(Admin admin) {
		return daoG.salvar(admin);

	}
}
