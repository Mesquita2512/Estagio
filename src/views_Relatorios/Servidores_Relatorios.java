package views_Relatorios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import view.Controla_views;
import java.awt.Color;

public class Servidores_Relatorios {

	private JFrame frmTelaServidores_Relatorios;

	Controla_views control_View = new Controla_views();
	

	int siape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidores_Relatorios windowServRel = new Servidores_Relatorios();
					windowServRel.frmTelaServidores_Relatorios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Servidores_Relatorios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaServidores_Relatorios = new JFrame();
		frmTelaServidores_Relatorios.setResizable(false);
		frmTelaServidores_Relatorios.setBackground(Color.PINK);
		frmTelaServidores_Relatorios.setTitle("Relatório Servidores");
		frmTelaServidores_Relatorios.setBounds(100, 100, 600, 400);
		frmTelaServidores_Relatorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaServidores_Relatorios.getContentPane().setLayout(null);
	}


	public JFrame getFrmTelaServidores_Relatorios() {
		return frmTelaServidores_Relatorios;
	}

	public void setFrmTelaServidores_Relatorios(JFrame frmTelaServidores_Relatorios) {
		this.frmTelaServidores_Relatorios = frmTelaServidores_Relatorios;
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}

}
