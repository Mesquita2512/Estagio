package testes;

import java.util.Date;

import dao.AdminDao;
import dao.EmprestimoDao;
import dao.MaterialDao;
import dao.ServidorDao;
import entity.Admin;
import entity.Emprestimo;
import entity.Material;
import entity.Servidor;

public class EmprestimoTeste {

	public static void main(String[] args) {

		// * Este Teste só funciona se os dados de servidor, administrador e Material
		// especificados no código abaixo estiverem salvos no banco de dados.
		// * Caso o código seja execultado mais de uma vez, será salvo o mesmo
		// emprestimo com um id diferente.
		ServidorDao sDao = new ServidorDao();
		Servidor servidor = sDao.buscarPorSiape(123125);

		AdminDao aDao = new AdminDao();
		Admin admin = aDao.buscarPorSiape(123120);

		MaterialDao mDao = new MaterialDao();
		Material material = mDao.buscarPorId(1);

		EmprestimoDao eDao = new EmprestimoDao();
		Emprestimo emprestimo = new Emprestimo(servidor, admin, material, 2, 0, new Date(), new Date(), "NADA A COMENTAR");

		eDao.salvar(emprestimo);

		System.out.println(emprestimo.toString());

	}

}
