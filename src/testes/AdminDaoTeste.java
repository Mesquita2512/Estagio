package testes;

import dao.AdminDao;
import entity.Admin;

public class AdminDaoTeste {

	public static void main(String[] args) {
		Admin admin1 = new Admin();
		AdminDao aDao = new AdminDao();
	//Teste para Salvar um Administrador, atenção para o Siape
		char [] charPassword = new char [] {1,2,3,4}; 
		
		   admin1 = new Admin(123120, "joao da silva", "ureadossecas@kbckbc.com",
		  charPassword);
		   aDao = new AdminDao(); aDao.salvar(admin1);
		

		// Teste para buscar um servidor pelo Siape
		admin1 = aDao.buscarPorSiape(123120);

		System.out.println("-----" + admin1 + "-----");

	}

}
