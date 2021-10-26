package view;


import entity.Material;

public class Controla_views {

	Material material = new Material();

	public void abreTelaLogin() {
		try {
			Login windowLogin = new Login();
			windowLogin.getFrmTelaLogin().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaPrincipal() {
		try {

			Principal windowPrincipal = new Principal();
			windowPrincipal.getFrmTelaPrincipal().setVisible(true);
			windowPrincipal.setListaEmprestimo(windowPrincipal.eDao.listarEmprestimoComMaterial());
			windowPrincipal.listarEmprestimos();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaMateriais() {

		try {
			Materiais mateView = new Materiais();
			mateView.getFrmTelaMaterias().setVisible(true);
			mateView.setListaMaterial(mateView.mDao.getListaMaterial());
			mateView.listarMateriais();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abreTelaServidor() {

		try {
			Servidor servView = new Servidor();
			servView.getFrmTelaServidor().setVisible(true);
			servView.setListaServidor(servView.sDao.getListaServidor());
			servView.listarServidores();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaCadastroEmprestimo() {

		try {
			Cadastro_Emprestimo cadEmp = new Cadastro_Emprestimo();
			cadEmp.getFrmNovoEmprestimo().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaCadastroServidor() {
		try {
			Cadastro_Servidor windowServidor = new Cadastro_Servidor();
			windowServidor.getFrmCasdastroServidor().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaCadatroMateriais() {
		try {
			Cadastro_Materiais windowMateriais = new Cadastro_Materiais();
			windowMateriais.getFrmCadastroDeMateriais().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void abreTelaEditarMaterial(Material material) {
		try {
			
			EditarMaterial EdtMaterial= new EditarMaterial();
			EdtMaterial.pegaMaterial(material);
			EdtMaterial.getFrmEditarMaterial().setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fecharSistema() {
		System.setProperty("siape", "0");
		abreTelaLogin();
	}

}
