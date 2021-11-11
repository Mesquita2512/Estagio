package views_Relatorios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import view.Controla_views;
import javax.swing.JLabel;
import java.awt.Color;

public class Emprestimo_Relatorios {

	private JFrame frmTelaRelatorioEmprestimo;

	Controla_views control_View = new Controla_views();
	Controla_Relatorios control_rel = new Controla_Relatorios();
	
	String filtro = "Relatório de Empréstimo";
	

	int siape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emprestimo_Relatorios windowEmpRel = new Emprestimo_Relatorios();
					windowEmpRel.frmTelaRelatorioEmprestimo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Emprestimo_Relatorios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaRelatorioEmprestimo = new JFrame();
		frmTelaRelatorioEmprestimo.setBackground(new Color(224, 255, 255));
		frmTelaRelatorioEmprestimo.getContentPane().setLayout(null);
		frmTelaRelatorioEmprestimo.setResizable(false);
		frmTelaRelatorioEmprestimo.setBackground(Color.PINK);
		frmTelaRelatorioEmprestimo.setTitle("Relatatórios de Empréstimos");
		frmTelaRelatorioEmprestimo.setBounds(100, 100, 600, 400);
		frmTelaRelatorioEmprestimo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel(filtro);
		
	
		GroupLayout groupLayout = new GroupLayout(frmTelaRelatorioEmprestimo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel)
					.addContainerGap(523, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addContainerGap(335, Short.MAX_VALUE))
		);
		frmTelaRelatorioEmprestimo.getContentPane().setLayout(groupLayout);
	}

	
	public JFrame getFrmTelaRelatorioEmprestimo() {
		return frmTelaRelatorioEmprestimo;
	}

	public void setFrmTelaRelatorioEmprestimo(JFrame frmTelaRelatorioEmprestimo) {
		this.frmTelaRelatorioEmprestimo = frmTelaRelatorioEmprestimo;
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}

}
