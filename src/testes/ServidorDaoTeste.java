package testes;

import dao.ServidorDao;
import entity.Servidor;

public class ServidorDaoTeste {

	public static void main(String[] args) {

		Servidor servidor = new Servidor(123125, "joao da silva", "ureadossecas@kbckbc.com");
		ServidorDao aDao = new ServidorDao();
		aDao.salvar(servidor);

		System.out.println(servidor);

	}

}
