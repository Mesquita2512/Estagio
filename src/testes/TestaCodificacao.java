package testes;

import entity.Admin;

public class TestaCodificacao {

	public static void main(String[] args) {

		Admin adm = new Admin();
		String retorno = adm.gerarCodificacao("2");

		System.out.println("O codigo gerado é:" + retorno);

	}

}
