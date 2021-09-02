package dao;

import entity.Material;

public class MaterialDao {
	
	GenericoDao gDao = new GenericoDao();
	
	public boolean Salvar (Material material) {
		return gDao.salvar(material);
		
	}

}
