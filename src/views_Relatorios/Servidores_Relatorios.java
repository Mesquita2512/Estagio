package views_Relatorios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import view.Controla_views;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.ServidorDao;
import entity.Servidor;

public class Servidores_Relatorios {

	private JFrame frmTelaServidores_Relatorios;
	String filtro = "Lista de todos os servidores";

	Controla_views control_View = new Controla_views();
	Controla_Relatorios control_rel = new Controla_Relatorios();

	ServidorDao sDao = new ServidorDao();
	private List<Servidor> listaServidores;
	Servidor serv = new Servidor();

	int siape;
	private JTable tb_Servidores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidores_Relatorios windowServRel = new Servidores_Relatorios("todos");
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
	public Servidores_Relatorios(String filtroServ) {
		if (filtroServ == "ativos") {
			filtro = filtro + " ativos";
		}
		if (filtroServ == "inativos") {
			filtro = filtro + " inativos";
		}
		
		initialize();
	}

	public void carregaRelatorio(String filtroServ) {
		if (filtroServ == "todos") {
			setListaServidores(sDao.getListaServidor());
			carregar();

		}
		if (filtroServ == "ativos") {
			setListaServidores(sDao.listarServidorPorStatus());
			carregar();

		}
		if (filtroServ == "inativos") {
			setListaServidores(sDao.listarServidorPorStatusInativos());
			carregar();
		}
	}

	public void carregar() {
		int val = getListaServidores().size();
		int inc = 0;

		DefaultTableModel tabelaBd = (DefaultTableModel) tb_Servidores.getModel();
		tabelaBd.setNumRows(0);
		// Mostra os Servidores na tela
		while (val > 0) {
			// pegando o Servidores do indice
			serv = getListaServidores().get(inc);

			// Adicinando o Servidor na tabela
			tabelaBd.addRow(new Object[] { serv.getSiape(), serv.getNome(), serv.getEmail(), serv.isStatusAtivo() });

			val--;
			inc++;
			serv = new Servidor();

		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaServidores_Relatorios = new JFrame();
		frmTelaServidores_Relatorios.setResizable(false);
		frmTelaServidores_Relatorios.setBackground(Color.PINK);
		frmTelaServidores_Relatorios.setTitle("Relatório Servidores");
		frmTelaServidores_Relatorios.setBounds(100, 100, 600, 600);
		frmTelaServidores_Relatorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaServidores_Relatorios.getContentPane().setLayout(null);
		frmTelaServidores_Relatorios.setLocationRelativeTo(null);

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaLogin();
				getFrmTelaServidores_Relatorios().dispose();
			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setBounds(479, 515, 91, 25);
		frmTelaServidores_Relatorios.getContentPane().add(btn_Sair);

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_rel.abretelaRelatorios();
				getFrmTelaServidores_Relatorios().dispose();
			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setBounds(397, 515, 73, 25);
		frmTelaServidores_Relatorios.getContentPane().add(btn_Voltar);

		JLabel lblListaDeTodos = new JLabel(filtro);
		lblListaDeTodos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListaDeTodos.setBounds(50, 20, 453, 36);
		frmTelaServidores_Relatorios.getContentPane().add(lblListaDeTodos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 74, 520, 419);
		frmTelaServidores_Relatorios.getContentPane().add(scrollPane);

		tb_Servidores = new JTable();
		tb_Servidores
				.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Email", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tb_Servidores.getColumnModel().getColumn(0).setResizable(false);
		tb_Servidores.getColumnModel().getColumn(1).setResizable(false);
		tb_Servidores.getColumnModel().getColumn(1).setPreferredWidth(270);
		tb_Servidores.getColumnModel().getColumn(2).setResizable(false);
		tb_Servidores.getColumnModel().getColumn(2).setPreferredWidth(193);
		tb_Servidores.getColumnModel().getColumn(3).setResizable(false);
		tb_Servidores.setRowSelectionAllowed(false);
		tb_Servidores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tb_Servidores);
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

	public List<Servidor> getListaServidores() {
		return listaServidores;
	}

	public void setListaServidores(List<Servidor> listaServidores) {
		this.listaServidores = listaServidores;
	}

}
