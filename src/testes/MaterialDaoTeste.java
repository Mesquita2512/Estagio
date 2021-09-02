package testes;

import dao.MaterialDao;
import entity.Material;

public class MaterialDaoTeste {

	public static void main(String[] args) {
		Material material1 = new Material("Fone de Ouvido", 4, 1, 149.90, "Novo");
		MaterialDao mDao = new MaterialDao();
		mDao.Salvar(material1);
		
		System.out.println(material1);
		

	}

}
