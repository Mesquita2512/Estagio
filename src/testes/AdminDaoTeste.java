package testes;

import dao.AdminDao;
import entity.Admin;

public class AdminDaoTeste {

	public static void main(String[] args) {
		Admin admin1 = new Admin();
		AdminDao aDao = new AdminDao();
	//Teste para Salvar um Administrador, aten��o para o Siape
		
		
		  // admin1 = new Admin(1212, "Lara Mesquita", "ureadossecas@kbckbc.com", true,"1234");
		   admin1.setNome("marcelokkkkk");
		   admin1.setSiape(8585);
		   //admin1.setSenha1(1a23);
		   aDao.salvar(admin1);
		

		// Teste para buscar um servidor pelo Siape
		admin1 = aDao.buscarPorSiape(2525);

		System.out.println("-----" + admin1 + "-----");

	}

}
