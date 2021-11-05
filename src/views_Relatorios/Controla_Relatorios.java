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

	public void abretelaRelatoriosServidores() {
		try {
			Servidores_Relatorios windowRelServ = new Servidores_Relatorios();
			windowRelServ.getFrmTelaServidores_Relatorios().setVisible(true);
			windowRelServ.getFrmTelaServidores_Relatorios().setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abretelaRelatorioMateriais() {
		try {
			Materiais_Relatorios windowRelMate = new Materiais_Relatorios();
			windowRelMate.getFrmTelaMateriais_Relatorios().setVisible(true);
			windowRelMate.getFrmTelaMateriais_Relatorios().setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
