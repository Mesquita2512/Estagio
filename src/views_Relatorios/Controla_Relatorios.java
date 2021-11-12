package views_Relatorios;

public class Controla_Relatorios {

	public void abretelaRelatorios() {
		try {
			Relatorios windowRel = new Relatorios();
			windowRel.getFrmTelaRelatorios().setVisible(true);
			windowRel.getFrmTelaRelatorios().setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abretelaRelatoriosServidores(String filtroServ) {
		try {
			Servidores_Relatorios windowRelServ = new Servidores_Relatorios(filtroServ);
			windowRelServ.getFrmTelaServidores_Relatorios().setVisible(true);
			windowRelServ.getFrmTelaServidores_Relatorios().setLocationRelativeTo(null);
			windowRelServ.carregaRelatorio(filtroServ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abretelaRelatoriosMateriais(String filtroMate) {
		try {
			Materiais_Relatorios windowRelMate = new Materiais_Relatorios(filtroMate);
			windowRelMate.getFrmTelaMateriais_Relatorios().setVisible(true);
			windowRelMate.getFrmTelaMateriais_Relatorios().setLocationRelativeTo(null);
			windowRelMate.carregaRelatorio(filtroMate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abretelaRelatoriosEmprestimos(String filtroEmp) {
		try {
			Emprestimo_Relatorios windowRelEmp = new Emprestimo_Relatorios(filtroEmp);
			windowRelEmp.getFrmTelaRelatorioEmprestimo().setVisible(true);
			windowRelEmp.getFrmTelaRelatorioEmprestimo().setLocationRelativeTo(null);
			windowRelEmp.carregaRelatorio(filtroEmp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
