package View;

import javax.swing.JDialog;

public class Controla_views {

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaServidor() {
		try {
			Cadastro_Servidor windowServidor = new Cadastro_Servidor();
			windowServidor.getFrmCasdastroServidor().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaMateriais() {
		try {
			Cadastro_Materiais windowMateriais = new Cadastro_Materiais();
			windowMateriais.getFrmCadastroDeMateriais().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaBuscaMateriais() {

		try {
			BuscarMatrial dialog = new BuscarMatrial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fecharSistema() {
		System.setProperty("siape", "0");
		abreTelaLogin();
	}

}
