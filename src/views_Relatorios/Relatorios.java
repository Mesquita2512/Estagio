package views_Relatorios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import view.Controla_views;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Relatorios {

	private JFrame frmTelaRelatorios;

	Controla_views control_View = new Controla_views();
	Controla_Relatorios control_Rel = new Controla_Relatorios();

	int siape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios windowRel = new Relatorios();
					windowRel.frmTelaRelatorios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Relatorios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaRelatorios = new JFrame();
		frmTelaRelatorios.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaRelatorios.setResizable(false);
		frmTelaRelatorios.setBackground(Color.PINK);
		frmTelaRelatorios.setTitle("Relatórios");
		frmTelaRelatorios.setBounds(100, 100, 600, 400);
		frmTelaRelatorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaRelatorios.getContentPane().setLayout(null);

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaLogin();
				getFrmTelaRelatorios().dispose();
			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setBounds(472, 311, 92, 25);
		frmTelaRelatorios.getContentPane().add(btn_Sair);

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaPrincipal();
				getFrmTelaRelatorios().dispose();

			}
		});
		btn_Voltar.setForeground(Color.BLACK);
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setBounds(345, 311, 104, 25);
		frmTelaRelatorios.getContentPane().add(btn_Voltar);
		
		JLabel lblRelatrios = new JLabel("Relatórios");
		lblRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblRelatrios.setBounds(52, 30, 512, 43);
		frmTelaRelatorios.getContentPane().add(lblRelatrios);
		
		JLabel lblNewLabel = new JLabel("Servidores");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				control_Rel.abretelaRelatoriosServidores();
				getFrmTelaRelatorios().dispose();
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(52, 107, 166, 31);
		frmTelaRelatorios.getContentPane().add(lblNewLabel);
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				control_Rel.abretelaRelatorioMateriais();
				getFrmTelaRelatorios().dispose();
			}
		});
		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMateriais.setBounds(52, 149, 166, 31);
		frmTelaRelatorios.getContentPane().add(lblMateriais);
		
		JLabel lblEmprestimo = new JLabel("Emprestimos");
		lblEmprestimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmprestimo.setBounds(52, 191, 166, 31);
		frmTelaRelatorios.getContentPane().add(lblEmprestimo);
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public JFrame getFrmTelaRelatorios() {
		return frmTelaRelatorios;
	}

	public void setFrmTelaRelatorios(JFrame frmTelaRelatorios) {
		this.frmTelaRelatorios = frmTelaRelatorios;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}
}
