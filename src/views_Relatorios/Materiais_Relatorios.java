package views_Relatorios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import view.Controla_views;
import java.awt.Color;

public class Materiais_Relatorios {

	private JFrame frmTelaMateriais_Relatorios;

	Controla_views control_View = new Controla_views();

	int siape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Materiais_Relatorios windowMateRel = new Materiais_Relatorios();
					windowMateRel.frmTelaMateriais_Relatorios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Materiais_Relatorios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaMateriais_Relatorios = new JFrame();
		frmTelaMateriais_Relatorios.setResizable(false);
		frmTelaMateriais_Relatorios.setBackground(Color.PINK);
		frmTelaMateriais_Relatorios.setTitle("Relatório Materiais");
		frmTelaMateriais_Relatorios.setBounds(100, 100, 600, 400);
		frmTelaMateriais_Relatorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaMateriais_Relatorios.getContentPane().setLayout(null);
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public JFrame getFrmTelaMateriais_Relatorios() {
		return frmTelaMateriais_Relatorios;
	}

	public void setFrmTelaMateriais_Relatorios(JFrame frmTelaMateriais_Relatorios) {
		this.frmTelaMateriais_Relatorios = frmTelaMateriais_Relatorios;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}

}
