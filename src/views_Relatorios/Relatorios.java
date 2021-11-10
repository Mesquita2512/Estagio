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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Relatorios {

	private JFrame frmTelaRelatorios;
	JComboBox<String> cbServidores = new JComboBox<String>();
	JComboBox<String> cbMateriais = new JComboBox<String>();

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
		btn_Sair.setBounds(460, 311, 104, 25);
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
		btn_Voltar.setBounds(228, 311, 128, 25);
		frmTelaRelatorios.getContentPane().add(btn_Voltar);

		JLabel lblRelatrios = new JLabel("Relatórios");
		lblRelatrios.setForeground(new Color(30, 144, 255));
		lblRelatrios.setBackground(new Color(100, 149, 237));
		lblRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRelatrios.setBounds(35, 11, 128, 43);
		frmTelaRelatorios.getContentPane().add(lblRelatrios);

		JLabel lblNewLabel = new JLabel("Servidores");

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 65, 135, 31);
		frmTelaRelatorios.getContentPane().add(lblNewLabel);

		JLabel lblMateriais = new JLabel("Materiais");

		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMateriais.setBounds(35, 107, 135, 31);
		frmTelaRelatorios.getContentPane().add(lblMateriais);

		JLabel lblEmprestimo = new JLabel("Emprestimos");
		lblEmprestimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lblEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmprestimo.setBounds(35, 149, 135, 31);
		frmTelaRelatorios.getContentPane().add(lblEmprestimo);

		JButton btn_GerarRelServ = new JButton("Gerar");
		btn_GerarRelServ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int indice = cbServidores.getSelectedIndex();
				if (indice == 0) {
					control_Rel.abretelaRelatoriosServidores("todos");
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 1) {
					control_Rel.abretelaRelatoriosServidores("ativos");
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 2) {
					control_Rel.abretelaRelatoriosServidores("inativos");
					getFrmTelaRelatorios().dispose();
				}
			}
		});
		btn_GerarRelServ.setForeground(Color.BLACK);
		btn_GerarRelServ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_GerarRelServ.setBackground(new Color(0, 128, 128));
		btn_GerarRelServ.setBounds(460, 70, 104, 25);
		frmTelaRelatorios.getContentPane().add(btn_GerarRelServ);

		JButton btn_GerarRelMate = new JButton("Gerar");
		btn_GerarRelMate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int indice = cbMateriais.getSelectedIndex();
				if (indice == 0) {
					control_Rel.abretelaRelatoriosMateriais("todos");
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 1) {
					control_Rel.abretelaRelatoriosMateriais("ativos");
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 2) {
					control_Rel.abretelaRelatoriosMateriais("inativos");
					getFrmTelaRelatorios().dispose();
				}
			}
		});
		btn_GerarRelMate.setForeground(Color.BLACK);
		btn_GerarRelMate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_GerarRelMate.setBackground(new Color(0, 128, 128));
		btn_GerarRelMate.setBounds(460, 112, 104, 25);
		frmTelaRelatorios.getContentPane().add(btn_GerarRelMate);

		cbServidores.setBackground(new Color(224, 255, 255));
		cbServidores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbServidores.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Ativos", "Inativos" }));
		cbServidores.setBounds(228, 72, 128, 20);
		frmTelaRelatorios.getContentPane().add(cbServidores);

		cbMateriais.setBackground(new Color(224, 255, 255));
		cbMateriais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbMateriais.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Ativos", "Inativos" }));
		cbMateriais.setBounds(228, 114, 128, 20);
		frmTelaRelatorios.getContentPane().add(cbMateriais);

		JButton btn_GerarRelEmp = new JButton("Gerar");
		btn_GerarRelEmp.setForeground(Color.BLACK);
		btn_GerarRelEmp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_GerarRelEmp.setBackground(new Color(0, 128, 128));
		btn_GerarRelEmp.setBounds(460, 154, 104, 25);
		frmTelaRelatorios.getContentPane().add(btn_GerarRelEmp);
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
