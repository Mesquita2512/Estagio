package testes;

import dao.AdminDao;
import entity.Admin;

public class AdminDaoTeste {

	public static void main(String[] args) {
		Admin admin1 = new Admin();
		AdminDao aDao = new AdminDao();
	//Teste para Salvar um Administrador, aten��o para o Siape
		
		
		   admin1 = new Admin(123123, "joao da silva", "ureadossecas@kbckbc.com",
		  "1234");
		   
		   aDao.salvar(admin1);
		

		// Teste para buscar um servidor pelo Siape
		admin1 = aDao.buscarPorSiape(123120);

		System.out.println("-----" + admin1 + "-----");

	}

}
