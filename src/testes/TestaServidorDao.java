package testes;

import dao.ServidorDao;
import entity.Servidor;

public class TestaServidorDao {
	public static void main(String[] args) {
	Servidor servidor1 = new Servidor(123123,"joao da silva","ureadossecas@kbckbc.com");
	ServidorDao sDao = new ServidorDao();
	sDao.salvar(servidor1);

}
}
