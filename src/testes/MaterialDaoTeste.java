package testes;

import dao.MaterialDao;
import entity.Material;

public class MaterialDaoTeste {

	public static void main(String[] args) {

		Material material = new Material();
		MaterialDao mDao = new MaterialDao();
		
		
		// Teste para salvar um material no Banco de dados
		/*
		 * Material material = new Material("Fone de Ouvido", 4, 1, 149.90, "Novo");
		 * MaterialDao mDao = new MaterialDao(); mDao.Salvar(material);
		 * 
		 */

		
		//Teste para buscra um material pelo Id
		material = mDao.buscarPorId(1);
		System.out.println(material);

	}

}
