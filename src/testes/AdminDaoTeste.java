package testes;

import dao.AdminDao;
import entity.Admin;

public class AdminDaoTeste {

	public static void main(String[] args) {
		Admin admin1 = new Admin(123120, "joao da silva", "ureadossecas@kbckbc.com", "1234");
		AdminDao aDao = new AdminDao();
		aDao.salvar(admin1);
		
		System.out.println(admin1);


	}

}
