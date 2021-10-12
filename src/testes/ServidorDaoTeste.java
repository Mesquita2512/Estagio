package testes;

import dao.ServidorDao;
import entity.Servidor;

public class ServidorDaoTeste {

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		ServidorDao sDao = new ServidorDao();

	//Teste Salvar Servidor, Atenção com o Siape que é a chave Primário...
		
		servidor = new Servidor(2323, "Esther Mesquita", "ureadossecas@kbckbc.com");
		sDao.salvar(servidor);
		System.out.println(servidor);
		
		
		
		//Teste para Buscar Servidor pelo Siape
		//servidor = sDao.buscarPorSiape(123125);
		//System.out.println("-----" + servidor.toString() + "-----");
		

	}

}
