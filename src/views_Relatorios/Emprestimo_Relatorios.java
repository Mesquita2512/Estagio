package views_Relatorios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import view.Controla_views;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import dao.DevolucaoDao;
import dao.EmprestimoDao;
import dao.ServidorDao;
import entity.Devolucao;
import entity.Emprestimo;
import entity.Servidor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class Emprestimo_Relatorios {

	private JFrame frmTelaRelatorioEmprestimo;

	Controla_views control_View = new Controla_views();
	Controla_Relatorios control_rel = new Controla_Relatorios();

	String filtro = "";
	Servidor serv = new Servidor();
	ServidorDao sDao = new ServidorDao();

	Emprestimo emp = new Emprestimo();
	EmprestimoDao eDao = new EmprestimoDao();
	private List<Emprestimo> listaEmprestimo;

	Devolucao dev = new Devolucao();
	DevolucaoDao dDao = new DevolucaoDao();
	private List<Devolucao> listaDevolucao;
	private JTable tbEmprestimo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emprestimo_Relatorios windowEmpRel = new Emprestimo_Relatorios("");
					windowEmpRel.frmTelaRelatorioEmprestimo.setVisible(true);
					windowEmpRel.frmTelaRelatorioEmprestimo.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Emprestimo_Relatorios(String filtroEmp) {
		if (filtroEmp == "status todos") {
			filtro = "Relatório de todos os Empréstismos realizados";
		}
		if (filtroEmp == "status em andamento") {
			filtro = "Relatório de todos os Empréstismos em andamento";
		}
		if (filtroEmp == "status concluidos") {
			filtro = "Relatório de todos os Empréstismos concluidos";
		} else {
			carregarFiltroPorServidor(filtroEmp);
		}

		initialize();
	}

	public void carregarFiltroPorServidor(String filtroEmp) {
		if (filtroEmp.contains(":")) {
			int position = filtroEmp.indexOf(":");
			int tamString = filtroEmp.length();
			String siape = filtroEmp.substring(position + 1, tamString);
			String status = filtroEmp.substring(0, position);

			serv = sDao.buscarPorSiape(Integer.parseInt(siape));

			if (status.equals("status todos")) {
				filtro = "Relatório de todos os Empréstismos realizados por " + serv.getNome().toLowerCase();
			}
			if (status.equals("status em andamento")) {
				filtro = "Relatório de todos os Empréstismos em andamento de " + serv.getNome().toLowerCase();
			}
			if (status.equals("status concluidos")) {
				filtro = "Relatório de todos os Empréstismos concluidos de " + serv.getNome().toLowerCase();
			}

		} else {
			//////////
		}
	}

	public void carregarTabelaServidor(String filtroEmp) {
		if (filtroEmp.contains(":")) {
			int position = filtroEmp.indexOf(":");
			int tamString = filtroEmp.length();
			String siape = filtroEmp.substring(position + 1, tamString);
			String status = filtroEmp.substring(0, position);

			int siap = Integer.parseInt(siape);

			if (status.equals("status todos")) {
				String filtro = "from Emprestimo where siape_Servidor = " + siap;
				setListaEmprestimo(eDao.listarEmprestimoPorServidor(filtro));
				carregar();

			}
			if (status.equals("status em andamento")) {
				String filtro = "from Emprestimo where Qtd_Emprestada > Qtd_Tot_Devolvida AND siape_servidor = " + siap;
				setListaEmprestimo(eDao.listarEmprestimoPorServidor(filtro));
				carregar();

			}
			if (status.equals("status concluidos")) {
				String filtro = "from Emprestimo where Qtd_Emprestada = Qtd_Tot_Devolvida AND siape_servidor = " + siap;
				setListaEmprestimo(eDao.listarEmprestimoPorServidor(filtro));
				carregar();
			}

		} else {
			//////////
		}
	}

	public void carregaRelatorio(String filtroEmp) {
		if (filtroEmp == "status todos") {
			setListaEmprestimo(eDao.getListaEmprestimo());
			carregar();
		}
		if (filtroEmp == "status em andamento") {
			setListaEmprestimo(eDao.listarEmprestimoEmAndamento());
			carregar();
		}
		if (filtroEmp == "status concluidos") {
			setListaEmprestimo(eDao.listarEmprestimoConcluidos());
			carregar();
		}

	}

	public void carregar() {
		int val = getListaEmprestimo().size();
		int inc = 0;

		DefaultTableModel tabelaBd = (DefaultTableModel) tbEmprestimo.getModel();
		tabelaBd.setNumRows(0);
		// Mostra os Emprestmos na tela
		while (val > 0) {
			// pegando os emprestimos do indice
			emp = getListaEmprestimo().get(inc);
			// formatando a data do emprestimo
			Date DataFormatada = emp.getDataEntrega();
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			String data = formatador.format(DataFormatada);

			// formatando a hora da devolução
			int hora = emp.getHoraEntrega().get(Calendar.HOUR_OF_DAY);
			int minutos = emp.getHoraEntrega().get(Calendar.MINUTE);
			String min = minutos + "";
			String horaformatada;
			if (min.length() == 1) {
				horaformatada = hora + ":0" + minutos;
			} else {
				horaformatada = hora + ":" + minutos;
			}
			if (hora < 12) {
				horaformatada = horaformatada + " AM";
			}

			// Adicinando o emprestimos na tabela
			tabelaBd.addRow(new Object[] { emp.getId(), emp.getAdminEntrega().getNome(), emp.getServidor().getNome(),
					emp.getMaterial().getDescricao(), emp.getQtdEmprestado(), data, horaformatada,
					emp.getObsEntrega() });

			val--;
			inc++;
			emp = new Emprestimo();

		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmTelaRelatorioEmprestimo = new JFrame();
		frmTelaRelatorioEmprestimo.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Emprestimo_Relatorios.class.getResource("/imagens/Icon_Relatorios.png")));
		frmTelaRelatorioEmprestimo.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaRelatorioEmprestimo.setBackground(new Color(224, 255, 255));
		frmTelaRelatorioEmprestimo.getContentPane().setLayout(null);
		frmTelaRelatorioEmprestimo.setResizable(false);
		frmTelaRelatorioEmprestimo.setBackground(Color.PINK);
		frmTelaRelatorioEmprestimo.setTitle("Relatatórios de Empréstimos");
		frmTelaRelatorioEmprestimo.setBounds(100, 100, 800, 700);

		frmTelaRelatorioEmprestimo.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					frmTelaRelatorioEmprestimo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmTelaRelatorioEmprestimo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control_rel.abretelaRelatorios();
				getFrmTelaRelatorioEmprestimo().dispose();
			}
		});
		btn_Voltar.setForeground(Color.BLACK);
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (control_View.fecharSistema() == true) {
					getFrmTelaRelatorioEmprestimo().dispose();
				}

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));

		JScrollPane scrollPane = new JScrollPane();

		JButton btn_Detalhar = new JButton("Detalhar Emprestimo");
		btn_Detalhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String capta = "";
				if (tbEmprestimo.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um Emprestimo da lista");
				} else if (tbEmprestimo.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Selecione apenas um Emprestimo da lista");
				} else {
					capta = tbEmprestimo.getValueAt(tbEmprestimo.getSelectedRow(), 0).toString();
					int captaId = Integer.parseInt(capta);

					emp = eDao.buscarPorId(captaId);
					control_View.abreTelaDetalharEmprestimo(emp, "relatorio");
				}

			}
		});
		btn_Detalhar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Detalhar.setBackground(new Color(143, 188, 143));

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textPane.setText(filtro);
		textPane.setBackground(new Color(240, 255, 255));

		GroupLayout groupLayout = new GroupLayout(frmTelaRelatorioEmprestimo.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap(347, Short.MAX_VALUE)
								.addComponent(btn_Detalhar, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(25)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE))))
				.addGap(18)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(21)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Detalhar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		tbEmprestimo = new JTable();
		tbEmprestimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					btn_Detalhar.doClick();
				}
			}
		});
		tbEmprestimo.setBackground(new Color(240, 255, 255));
		tbEmprestimo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbEmprestimo.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null }, }, new String[] { "C\u00F3digo",
						"Entregue por", "Entregue a", "Material", "Qtd", "Data", "Hora", "Observa\u00E7\u00F5es" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbEmprestimo.getColumnModel().getColumn(0).setResizable(false);
		tbEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(45);
		tbEmprestimo.getColumnModel().getColumn(1).setPreferredWidth(110);
		tbEmprestimo.getColumnModel().getColumn(2).setPreferredWidth(110);
		tbEmprestimo.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbEmprestimo.getColumnModel().getColumn(4).setResizable(false);
		tbEmprestimo.getColumnModel().getColumn(4).setPreferredWidth(30);
		tbEmprestimo.getColumnModel().getColumn(5).setResizable(false);
		tbEmprestimo.getColumnModel().getColumn(5).setPreferredWidth(60);
		tbEmprestimo.getColumnModel().getColumn(6).setResizable(false);
		tbEmprestimo.getColumnModel().getColumn(6).setPreferredWidth(35);
		tbEmprestimo.getColumnModel().getColumn(7).setPreferredWidth(110);
		scrollPane.setViewportView(tbEmprestimo);
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

	public List<Emprestimo> getListaEmprestimo() {
		return listaEmprestimo;
	}

	public void setListaEmprestimo(List<Emprestimo> listaEmprestimo) {
		this.listaEmprestimo = listaEmprestimo;
	}

	public List<Devolucao> getListaDevolucao() {
		return listaDevolucao;
	}

	public void setListaDevolucao(List<Devolucao> listaDevolucao) {
		this.listaDevolucao = listaDevolucao;
	}
}
