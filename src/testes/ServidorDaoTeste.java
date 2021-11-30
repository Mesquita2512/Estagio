package testes;

import dao.ServidorDao;
import entity.Servidor;

public class ServidorDaoTeste {

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		ServidorDao sDao = new ServidorDao();

	//Teste Salvar Servidor, Aten��o com o Siape que � a chave Prim�rio...
		
		servidor = new Servidor(2323, "Esther Mesquita", "ureadossecas@kbckbc.com", true);
		sDao.salvar(servidor);
		System.out.println(servidor);
		
		
		
		//Teste para Buscar Servidor pelo Siape
		//servidor = sDao.buscarPorSiape(123125);
		//System.out.println("-----" + servidor.toString() + "-----");
		

	}

}
