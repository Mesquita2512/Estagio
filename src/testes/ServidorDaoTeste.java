package testes;

import dao.ServidorDao;
import entity.Servidor;

public class ServidorDaoTeste {

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		ServidorDao sDao = new ServidorDao();

		//Teste Salvar Servidor, Atenção com o Siape que é a chave Primário...
		/*
		Servidor servidor = new Servidor(123125, "joao da silva", "ureadossecas@kbckbc.com");
		ServidorDao aDao = new ServidorDao();
		aDao.salvar(servidor);
		System.out.println(servidor);
		*/
		
		
		//Teste para Buscar Servidor pelo Siape
		servidor = sDao.buscarPorSiape(123125);
		System.out.println("-----" + servidor.toString() + "-----");
		

	}

}
