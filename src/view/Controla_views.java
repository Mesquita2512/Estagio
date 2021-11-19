package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import entity.Admin;
import entity.Emprestimo;
import entity.Material;

public class Controla_views {

	public void abreTelaLogin() {
		try {
			Login windowLogin = new Login();
			windowLogin.getFrmTelaLogin().setVisible(true);
			windowLogin.getFrmTelaLogin().setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaConfirmerSenha() {
		try {
			ConfirmerSenha windowSenha = new ConfirmerSenha();
			windowSenha.getFrmTelaAtualizarSenha().setVisible(true);
			windowSenha.getFrmTelaAtualizarSenha().setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaPrincipal() {
		try {

			Principal windowPrincipal = new Principal();
			windowPrincipal.getFrmTelaPrincipal().setVisible(true);
			windowPrincipal.getFrmTelaPrincipal().setLocationRelativeTo(null);
			windowPrincipal.setListaEmprestimo(windowPrincipal.eDao.listarEmprestimoEmAndamento());
			windowPrincipal.listarEmprestimos();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaMateriais() {

		try {
			Materiais mateView = new Materiais();
			mateView.getFrmTelaMaterias().setVisible(true);
			mateView.getFrmTelaMaterias().setLocationRelativeTo(null);
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
			servView.getFrmTelaServidor().setLocationRelativeTo(null);
			servView.setListaServidor(servView.sDao.getListaServidor());
			servView.listarServidores();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abreTelaAdministrador() {

		try {
			Administrador servView = new Administrador();
			servView.getFrmTelaServidor().setVisible(true);
			servView.getFrmTelaServidor().setLocationRelativeTo(null);
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
			cadEmp.getFrmNovoEmprestimo().setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaCadastroServidor() {
		try {
			Cadastro_Servidor windowServidor = new Cadastro_Servidor();
			windowServidor.getFrmCasdastroServidor().setVisible(true);
			windowServidor.getFrmCasdastroServidor().setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaCadatroMateriais() {
		try {
			Cadastro_Materiais windowMateriais = new Cadastro_Materiais();
			windowMateriais.getFrmCadastroDeMateriais().setVisible(true);
			windowMateriais.getFrmCadastroDeMateriais().setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaEditarEmprestimo(Emprestimo emprestimo) {
		try {

			EditarEmprestimo EdtEmprestimo = new EditarEmprestimo();
			EdtEmprestimo.pegaEmprestimo(emprestimo);
			EdtEmprestimo.getFrmEditarEmprestimo().setVisible(true);
			EdtEmprestimo.getFrmEditarEmprestimo().setLocationRelativeTo(null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaEditarMaterial(Material material) {
		try {

			EditarMaterial EdtMaterial = new EditarMaterial();
			EdtMaterial.pegaMaterial(material);
			EdtMaterial.getFrmEditarMaterial().setVisible(true);
			EdtMaterial.getFrmEditarMaterial().setLocationRelativeTo(null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaEditarServidor(entity.Servidor servidor) {
		try {

			EditarServidor EdtServidor = new EditarServidor();
			EdtServidor.pegaServidor(servidor);
			EdtServidor.getFrmEditarServidor().setVisible(true);
			EdtServidor.getFrmEditarServidor().setLocationRelativeTo(null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abreTelaEditarAdmin(Admin admin) {
		try {

			EditarAdmin EdtAdm = new EditarAdmin();
			EdtAdm.pegaAdmin(admin);
			EdtAdm.getFrmEditarAdmin().setVisible(true);
			EdtAdm.getFrmEditarAdmin().setLocationRelativeTo(null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abreTelaDetalharEmprestimo(Emprestimo emprestimo, String quemChamou) {
		try {
			DetalharEmprestimo windowDetalhar = new DetalharEmprestimo();
			windowDetalhar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			windowDetalhar.pegaEmprestimo(emprestimo);
			windowDetalhar.setVisible(true);
			windowDetalhar.setLocationRelativeTo(null);
			windowDetalhar.quemchamou = quemChamou;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean fecharSistema() {

		int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente fazer LOGOUT?");
		if (confirma == JOptionPane.YES_OPTION) {
			System.setProperty("siape", "0");
			abreTelaLogin();
			return true;
		}else {
			return false;
		}

	}

	public void fecharTudo() {

	}

}
