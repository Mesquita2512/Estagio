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
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import dao.ServidorDao;
import entity.Servidor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Relatorios {

	private JFrame frmTelaRelatorios;
	JComboBox<String> cbServidores = new JComboBox<String>();
	JComboBox<String> cbMateriais = new JComboBox<String>();
	JComboBox<String> cbEmpStatus = new JComboBox<String>();
	JComboBox<String> cbEmpData = new JComboBox<String>();
	JComboBox<String> cbEmpServ = new JComboBox<String>();

	JScrollPane spServidor = new JScrollPane();
	JButton btn_Confirmar = new JButton("Confirmar");
	JButton btnBuscarServidores = new JButton("buscar");

	JDateChooser dcInicio = new JDateChooser(new Date());
	JDateChooser dcFinal = new JDateChooser(new Date());

	Controla_views control_View = new Controla_views();
	Controla_Relatorios control_Rel = new Controla_Relatorios();

	int siape;
	private JTextField txt_NomeServ;
	private JTable tbServidor;

	Servidor serv = new Servidor();
	ServidorDao sDao = new ServidorDao();
	private List<Servidor> listaServidores;

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

	public void carregar() {
		int val = getListaServidores().size();
		int inc = 0;

		DefaultTableModel tabelaBd = (DefaultTableModel) tbServidor.getModel();
		tabelaBd.setNumRows(0);

		spServidor.setVisible(true);
		btn_Confirmar.setVisible(true);

		while (val > 0) {
			serv = getListaServidores().get(inc);

			tabelaBd.addRow(new Object[] { serv.getSiape(), serv.getNome() });

			val--;
			inc++;
			serv = new Servidor();

		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmTelaRelatorios = new JFrame();
		frmTelaRelatorios.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Relatorios.class.getResource("/imagens/Icon_Relatorios.png")));
		frmTelaRelatorios.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaRelatorios.setResizable(false);
		frmTelaRelatorios.setBackground(Color.PINK);
		frmTelaRelatorios.setTitle("Relatórios");
		frmTelaRelatorios.setBounds(100, 100, 800, 450);
		frmTelaRelatorios.getContentPane().setLayout(null);

		frmTelaRelatorios.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					frmTelaRelatorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmTelaRelatorios.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (control_View.fecharSistema() == true) {
					getFrmTelaRelatorios().dispose();
				}
			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setBounds(664, 370, 104, 25);
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
		btn_Voltar.setBounds(526, 370, 128, 25);
		frmTelaRelatorios.getContentPane().add(btn_Voltar);

		JLabel lblRelatrios = new JLabel("Relatórios");
		lblRelatrios.setForeground(new Color(30, 144, 255));
		lblRelatrios.setBackground(new Color(100, 149, 237));
		lblRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRelatrios.setBounds(35, 11, 128, 43);
		frmTelaRelatorios.getContentPane().add(lblRelatrios);

		JLabel lblNewLabel = new JLabel("Servidores por status");

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 65, 193, 31);
		frmTelaRelatorios.getContentPane().add(lblNewLabel);

		JLabel lblMateriais = new JLabel("Materiais por status");

		lblMateriais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMateriais.setBounds(35, 107, 193, 31);
		frmTelaRelatorios.getContentPane().add(lblMateriais);

		JLabel lblEmprestimo = new JLabel("Empréstimos por status");
		lblEmprestimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lblEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmprestimo.setBounds(35, 149, 193, 31);
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
		btn_GerarRelServ.setBounds(393, 68, 123, 25);
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
		btn_GerarRelMate.setBounds(393, 110, 123, 25);
		frmTelaRelatorios.getContentPane().add(btn_GerarRelMate);

		cbServidores.setBackground(new Color(224, 255, 255));
		cbServidores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbServidores.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Ativos", "Inativos" }));
		cbServidores.setBounds(252, 70, 121, 20);
		frmTelaRelatorios.getContentPane().add(cbServidores);

		cbMateriais.setBackground(new Color(224, 255, 255));
		cbMateriais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbMateriais.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Ativos", "Inativos" }));
		cbMateriais.setBounds(252, 112, 121, 20);
		frmTelaRelatorios.getContentPane().add(cbMateriais);

		JButton btn_GerarRelEmpStatus = new JButton("Gerar");
		btn_GerarRelEmpStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = cbEmpStatus.getSelectedIndex();
				if (indice == 0) {
					control_Rel.abretelaRelatoriosEmprestimos("status todos");
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 1) {
					control_Rel.abretelaRelatoriosEmprestimos("status em andamento");
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 2) {
					control_Rel.abretelaRelatoriosEmprestimos("status concluidos");
					getFrmTelaRelatorios().dispose();
				}

			}
		});
		btn_GerarRelEmpStatus.setForeground(Color.BLACK);
		btn_GerarRelEmpStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_GerarRelEmpStatus.setBackground(new Color(0, 128, 128));
		btn_GerarRelEmpStatus.setBounds(393, 152, 123, 25);
		frmTelaRelatorios.getContentPane().add(btn_GerarRelEmpStatus);

		cbEmpStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Em Andamento", "Concluidos" }));
		cbEmpStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbEmpStatus.setBackground(new Color(224, 255, 255));
		cbEmpStatus.setBounds(252, 156, 121, 20);
		frmTelaRelatorios.getContentPane().add(cbEmpStatus);

		JLabel lblEmprestimosPorData = new JLabel("Empréstimos por data");
		lblEmprestimosPorData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmprestimosPorData.setBounds(35, 201, 193, 31);
		frmTelaRelatorios.getContentPane().add(lblEmprestimosPorData);

		JLabel lblEmprestimosPorServidor = new JLabel("Empréstimos por servidor");
		lblEmprestimosPorServidor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmprestimosPorServidor.setBounds(35, 252, 193, 31);
		frmTelaRelatorios.getContentPane().add(lblEmprestimosPorServidor);

		cbEmpData.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Em Andamento", "Concluidos" }));
		cbEmpData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbEmpData.setBackground(new Color(224, 255, 255));
		cbEmpData.setBounds(526, 206, 128, 20);
		frmTelaRelatorios.getContentPane().add(cbEmpData);
		cbEmpServ.setModel(new DefaultComboBoxModel<String>(new String[] { "Todos", "Em Andamento", "Concluidos" }));

		cbEmpServ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbEmpServ.setBackground(new Color(224, 255, 255));
		cbEmpServ.setBounds(526, 252, 128, 25);
		frmTelaRelatorios.getContentPane().add(cbEmpServ);

		JButton btn_GerarRelEmpData = new JButton("Gerar");
		btn_GerarRelEmpData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// formatando a data de inicio
				Date DataFormatada = dcInicio.getDate();
				SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
				String dataInicio = formatador.format(DataFormatada);

				// formatando a data final
				Date DataFormatad = dcFinal.getDate();
				SimpleDateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
				String dataFinal = formatado.format(DataFormatad);

				Date hoje = new Date();

				if (dataInicio.equals(dataFinal)) {
					JOptionPane.showMessageDialog(null, "Data inicial e data final devem ser diferentes!!!");
					return;
				}
				if (dcFinal.getDate().compareTo(hoje) > 0 || dcInicio.getDate().compareTo(hoje) > 0) {
					JOptionPane.showMessageDialog(null, "Data Inválida, por favor informe outra data");
					return;
				}

				int indice = cbEmpData.getSelectedIndex();
				if (indice == 0) {
					control_Rel.abretelaRelatoriosEmprestimos("status todos" + "-" + dataInicio + "." + dataFinal);
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 1) {
					control_Rel
							.abretelaRelatoriosEmprestimos("status em andamento" + "-" + dataInicio + "." + dataFinal);
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 2) {
					control_Rel.abretelaRelatoriosEmprestimos("status concluidos" + "-" + dataInicio + "." + dataFinal);
					getFrmTelaRelatorios().dispose();
				}
			}
		});
		btn_GerarRelEmpData.setForeground(Color.BLACK);
		btn_GerarRelEmpData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_GerarRelEmpData.setBackground(new Color(0, 128, 128));
		btn_GerarRelEmpData.setBounds(664, 204, 104, 25);
		frmTelaRelatorios.getContentPane().add(btn_GerarRelEmpData);

		JButton btn_GerarRelEmpServ = new JButton("Gerar");
		btn_GerarRelEmpServ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (serv.getSiape() == 0) {
					JOptionPane.showMessageDialog(null, "Realize a busca de um servidor");
					return;
				}
				int indice = cbEmpServ.getSelectedIndex();
				if (indice == 0) {
					control_Rel.abretelaRelatoriosEmprestimos("status todos" + ":" + serv.getSiape());
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 1) {
					control_Rel.abretelaRelatoriosEmprestimos("status em andamento" + ":" + serv.getSiape());
					getFrmTelaRelatorios().dispose();
				}
				if (indice == 2) {
					control_Rel.abretelaRelatoriosEmprestimos("status concluidos" + ":" + serv.getSiape());
					getFrmTelaRelatorios().dispose();
				}

			}
		});
		btn_GerarRelEmpServ.setForeground(Color.BLACK);
		btn_GerarRelEmpServ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_GerarRelEmpServ.setBackground(new Color(0, 128, 128));
		btn_GerarRelEmpServ.setBounds(664, 252, 104, 25);
		frmTelaRelatorios.getContentPane().add(btn_GerarRelEmpServ);

		JLabel lblNewLabel_1 = new JLabel("de");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(252, 209, 22, 14);
		frmTelaRelatorios.getContentPane().add(lblNewLabel_1);

		dcInicio.setBackground(new Color(240, 255, 255));
		dcInicio.setBounds(272, 205, 101, 20);
		frmTelaRelatorios.getContentPane().add(dcInicio);

		JLabel lblNewLabel_1_1 = new JLabel("até");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(393, 208, 25, 14);
		frmTelaRelatorios.getContentPane().add(lblNewLabel_1_1);

		dcFinal.setBackground(new Color(240, 255, 255));
		dcFinal.setBounds(417, 206, 99, 20);
		frmTelaRelatorios.getContentPane().add(dcFinal);

		txt_NomeServ = new JTextField();
		txt_NomeServ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btnBuscarServidores.doClick();
				}
			}
		});
		txt_NomeServ.setBackground(new Color(240, 255, 255));
		txt_NomeServ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_NomeServ.setEditable(true);
		txt_NomeServ.setColumns(10);
		txt_NomeServ.setBounds(252, 252, 121, 23);
		frmTelaRelatorios.getContentPane().add(txt_NomeServ);

		btnBuscarServidores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String txt_Servidor = txt_NomeServ.getText().trim();
				setListaServidores(sDao.listarServidorPorStatus());

				if (txt_Servidor.equals("")) {

					carregar();

				} else {

					txt_Servidor = "'%" + txt_Servidor + "%'";
					setListaServidores(sDao.listarServidorPorNome(txt_Servidor));

					if (getListaServidores().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Não foi localizado nenhum servidor com a descrição informada");
					} else {

						carregar();
						txt_NomeServ.setEditable(true);

					}
				}

			}
		});
		btnBuscarServidores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarServidores.setBackground(new Color(173, 216, 230));
		btnBuscarServidores.setBounds(393, 253, 123, 23);
		frmTelaRelatorios.getContentPane().add(btnBuscarServidores);

		spServidor.setBounds(252, 282, 264, 80);
		spServidor.setVisible(false);
		frmTelaRelatorios.getContentPane().add(spServidor);

		tbServidor = new JTable();
		tbServidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					btn_Confirmar.doClick();
				}
			}
		});
		tbServidor.setBackground(new Color(240, 255, 255));
		tbServidor.setRowSelectionAllowed(false);
		tbServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbServidor
				.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Siape", "Nome" }) {
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tbServidor.getColumnModel().getColumn(0).setResizable(false);
		tbServidor.getColumnModel().getColumn(1).setPreferredWidth(245);
		spServidor.setViewportView(tbServidor);
		btn_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String capta = "";

				if (tbServidor.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um servidor da lista");
				} else if (tbServidor.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Selecione apenas um servidor da lista");
				} else {
					capta = tbServidor.getValueAt(tbServidor.getSelectedRow(), 0).toString();
					int captaId = Integer.parseInt(capta);

					serv = sDao.buscarPorSiape(captaId);
					txt_NomeServ.setText(serv.getNome());

					spServidor.setVisible(false);
					btn_Confirmar.setVisible(false);

					txt_NomeServ.setEditable(false);

				}

			}
		});

		btn_Confirmar.setForeground(Color.BLACK);
		btn_Confirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Confirmar.setBackground(new Color(34, 139, 34));
		btn_Confirmar.setBounds(393, 370, 123, 25);
		btn_Confirmar.setVisible(false);
		frmTelaRelatorios.getContentPane().add(btn_Confirmar);
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

	public List<Servidor> getListaServidores() {
		return listaServidores;
	}

	public void setListaServidores(List<Servidor> listaServidores) {
		this.listaServidores = listaServidores;
	}

}
