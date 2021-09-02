package testes;

import entity.Admin;
import entity.Emprestimo;
import entity.Material;
import entity.Servidor;

public class EmprestimoTeste {

	public static void main(String[] args) {
		Servidor servidor = new Servidor(103125, "joao da silva", "ureadossecas@kbckbc.com");
		Admin admin = new Admin(120120, "joao da silva", "ureadossecas@kbckbc.com", "1234");
		Material material = new Material("Fone de Ouvido", 4, 1, 149.90, "Novo");
		Emprestimo emprestimo = new Emprestimo();

	}

}
