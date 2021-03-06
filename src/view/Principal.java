package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import dao.AdminDao;
import dao.DevolucaoDao;
import dao.EmprestimoDao;
import dao.MaterialDao;
import entity.Admin;
import entity.Devolucao;
import entity.Emprestimo;
import entity.Material;
import views_Relatorios.Controla_Relatorios;

import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal {

	private JFrame frmTelaPrincipal;
	private JTextField txt_Material_Busca;
	private JTextField txt_Servidor_Busca;

	Controla_views control_View = new Controla_views();
	Controla_Relatorios control_Rel = new Controla_Relatorios();
	Login login = new Login();

	Emprestimo emp = new Emprestimo();
	EmprestimoDao eDao = new EmprestimoDao();

	Material mat = new Material();
	MaterialDao mDao = new MaterialDao();

	Admin adm = new Admin();
	AdminDao aDao = new AdminDao();

	Devolucao devolucao = new Devolucao();
	DevolucaoDao dDao = new DevolucaoDao();

	private List<Emprestimo> listaEmprestimo;

	private JTable tb_Emprestimos;
	private JTable table;
	JButton btn_Detalhar = new JButton("Detalhar Emprestimo");
	JButton btnBuscar = new JButton("Buscar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmTelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	public void listarEmprestimos() {
		int val = getListaEmprestimo().size();
		int inc = 0;

		DefaultTableModel tabelaBd = (DefaultTableModel) tb_Emprestimos.getModel();
		tabelaBd.setNumRows(0);
		// Mostra os Emprestimos na tela
		while (val > 0) {
			// pegando o emprestimo do indice
			emp = getListaEmprestimo().get(inc);

			// formatando a data do emprestimo
			Date DataFormatada = emp.getDataEntrega();
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			String data = formatador.format(DataFormatada);

			// Adinando o emprestimo na tabela
			tabelaBd.addRow(new Object[] { emp.getId(), emp.getMaterial().getDescricao(), emp.getQtdEmprestado(),
					emp.getQtdTotalDevolvida(), emp.getServidor().getNome(), data });

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
		frmTelaPrincipal = new JFrame();
		frmTelaPrincipal.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaPrincipal.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagens/Icon_Fundo.jpg")));
		frmTelaPrincipal.setResizable(false);
		frmTelaPrincipal.setForeground(new Color(169, 169, 169));
		frmTelaPrincipal.setBackground(new Color(169, 169, 169));
		frmTelaPrincipal.setTitle("Tela Principal");
		frmTelaPrincipal.setBounds(100, 100, 810, 480);

		frmTelaPrincipal.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmTelaPrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});

		JLabel lblMaterialservidor = new JLabel("Material");
		lblMaterialservidor.setBounds(53, 49, 61, 21);
		lblMaterialservidor.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txt_Material_Busca = new JTextField();
		txt_Material_Busca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btnBuscar.doClick();
				}
			}
		});
		txt_Material_Busca.setBounds(125, 48, 106, 23);
		txt_Material_Busca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Material_Busca.setColumns(10);

		btnBuscar.setBounds(517, 47, 88, 25);
		btnBuscar.setBackground(new Color(0, 206, 209));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txt_Material = txt_Material_Busca.getText().trim();
				String txt_Servidor = txt_Servidor_Busca.getText().trim();
				// Busca todos os emprestimos em andamento
				setListaEmprestimo(eDao.listarEmprestimoEmAndamento());
				// Mostra todos os emprestimo sem filtros
				if (txt_Material.equals("") && txt_Servidor.equals("")) {

					listarEmprestimos();
					// Verifica se foi Preenchido algum campo de busca
				} else {
					int cont = listaEmprestimo.size();
					// Verfica se o campo de Servidor foi preenchido
					if (txt_Material.equals("")) {

						while (cont > 0) {
							String nome = getListaEmprestimo().get(cont - 1).getServidor().getNome().toUpperCase();
							if (nome.contains(txt_Servidor.toUpperCase())) {
								// Remove os emprestimos que nao foram encontrados na busca pelo nome do
								// servidor
							} else {
								listaEmprestimo.remove(cont - 1);
							}

							cont--;

						}
						// Mostra somente os Emprestimos buscados pelo nome do Servidor
						if (getListaEmprestimo().isEmpty()) {
							listarEmprestimos();
							JOptionPane.showMessageDialog(null, "N??o foi localizado nenhum empr??stimo");
						} else {
							listarEmprestimos();
						}

						// Verfica se campo de Material foi preenchido
					} else if (txt_Servidor_Busca.getText().equals("")) {

						while (cont > 0) {
							String nome = getListaEmprestimo().get(cont - 1).getMaterial().getDescricao().toUpperCase();
							if (nome.contains(txt_Material.toUpperCase())) {
								// Remove os emprestimos que nao foram encontrados na busca pela descri????o do
								// material
							} else {
								listaEmprestimo.remove(cont - 1);
							}

							cont--;

						}
						// Mostra somente os Emprestimos buscados pela descri????o do Material
						if (getListaEmprestimo().isEmpty()) {
							listarEmprestimos();
							JOptionPane.showMessageDialog(null, "N??o foi localizado nenhum empr??stimo");
						} else {
							listarEmprestimos();
						}

						// Caso os dois campos forem preenchidos
					} else {

						while (cont > 0) {
							String nome = getListaEmprestimo().get(cont - 1).getServidor().getNome().toUpperCase();
							String nome1 = getListaEmprestimo().get(cont - 1).getMaterial().getDescricao()
									.toUpperCase();

							if (nome1.contains(txt_Material.toUpperCase())
									&& nome.contains(txt_Servidor.toUpperCase())) {
								// Remove os emprestimos que nao foram encontrados na busca pela descri??????o do
								// material
							} else {
								listaEmprestimo.remove(cont - 1);
							}

							cont--;

						}

						// Mostra somente os Emprestimos buscados pela descri??????o do Material e pelo nome
						// do Servidor
						if (getListaEmprestimo().isEmpty()) {
							listarEmprestimos();
							JOptionPane.showMessageDialog(null, "N??o foi localizado nenhum empr??stimo");
						} else {
							listarEmprestimos();
						}

					}

				}

				String siape = "";
				siape = System.getProperty("siape", siape);

			}
		});

		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(295, 49, 61, 21);
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txt_Servidor_Busca = new JTextField();
		txt_Servidor_Busca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnBuscar.doClick();
				}
			}
		});
		txt_Servidor_Busca.setBounds(368, 48, 106, 23);
		txt_Servidor_Busca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Servidor_Busca.setColumns(10);

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(673, 333, 88, 25);
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (control_View.fecharSistema() == true) {
					getFrmTelaPrincipal().dispose();
				}

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));

		JScrollPane sp_Empretimos = new JScrollPane();
		sp_Empretimos.setBounds(53, 92, 708, 219);

		JButton btn_Editar = new JButton("Editar Emprestimo");
		btn_Editar.setBounds(274, 333, 177, 25);
		btn_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String capta = "";
				if (tb_Emprestimos.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um Emprestimo da lista");
				} else {
					capta = tb_Emprestimos.getValueAt(tb_Emprestimos.getSelectedRow(), 0).toString();

					String siape = System.getProperty("siape");
					int captaId = Integer.parseInt(capta);

					emp = eDao.buscarPorId(captaId);
					adm = aDao.buscarPorSiape(Integer.parseInt(siape));

					if (emp.getQtdTotalDevolvida() > 0) {
						JOptionPane.showMessageDialog(null,
								"J?? foi realizada devolu????o parcial deste emprestimo, n??o ?? mais aceito fazer altera????es neste empr??stimo");
					} else if (emp.getAdminEntrega().equals(adm)) {
						control_View.abreTelaEditarEmprestimo(emp);
						getFrmTelaPrincipal().dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"A edi????o ?? permitida somente pelo usu??rio que realizou o empr??stimo: "
										+ emp.getAdminEntrega().getNome());
					}

				}

			}
		});
		btn_Editar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Editar.setBackground(new Color(189, 183, 107));

		JButton btn_Devolver = new JButton("Devolver Material");
		btn_Devolver.setBounds(58, 333, 191, 25);
		btn_Devolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String capta = "";
				if (tb_Emprestimos.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um Emprestimo da lista");
				} else if (tb_Emprestimos.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Selecione apenas um Emprestimo da lista");
				} else {
					capta = tb_Emprestimos.getValueAt(tb_Emprestimos.getSelectedRow(), 0).toString();
					String siape = System.getProperty("siape");
					int captaId = Integer.parseInt(capta);

					emp = eDao.buscarPorId(captaId);
					mat = mDao.buscarPorId(emp.getMaterial().getId());
					adm = aDao.buscarPorSiape(Integer.parseInt(siape));

					if (emp.getQtdEmprestado() - emp.getQtdTotalDevolvida() == 1) {
						String obs = JOptionPane.showInputDialog("Obseva????es").trim();
						while (obs.equals("")) {
							JOptionPane.showMessageDialog(null, "O campo de observ????es ?? obrigat??rio");
							obs = JOptionPane.showInputDialog("Obseva????es").trim();
						}

						int confirma = JOptionPane.showConfirmDialog(null, "Confirme a devolu????o do material");
						if (confirma == JOptionPane.YES_OPTION) {
							mat.setQtd(mat.getQtd() + 1);

							emp.setQtdTotalDevolvida(emp.getQtdEmprestado());
							mat.setQtd_emprestado(mat.getQtd_emprestado() - 1);
							// Pegando hora atual do sistema
							Calendar c = Calendar.getInstance();
							// atribuindo os atributos da devolu????o
							devolucao.setEmprestimo(emp);
							devolucao.setAdminRecebe(adm);
							devolucao.setDataDevolucao(new Date());
							devolucao.setLocalDate(c);
							devolucao.setQtdDevolvida(1);
							devolucao.setObsDevolucao(obs);

							dDao.salvar(devolucao);
							mDao.atualizar(mat);
							eDao.atualizarEmprestimo(emp);

							emp = new Emprestimo();
							mat = new Material();
							adm = new Admin();
							devolucao = new Devolucao();

							JOptionPane.showMessageDialog(null, "Material devolvido com sucesso!!!");
							btnBuscar.doClick();
						} else {
							return;
						}

					} else {

						String confrima_Qtd = JOptionPane.showInputDialog("Informe a quantidade a ser devolvida");
						int confirma_int = 0;
						try {
							confirma_int = Integer.parseInt(confrima_Qtd);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null,
									"Informe um valor inteiro para realizar a devolu????o do material");
							return;
						}

						if (confirma_int > emp.getQtdEmprestado() - emp.getQtdTotalDevolvida()) {
							JOptionPane.showMessageDialog(null,
									"A quantidade informada ?? maior do que a quantidade a ser devolvida neste emprestimo");
						} else if (confirma_int <= 0) {
							JOptionPane.showMessageDialog(null,
									"informe um valor maior que zero para devolver o material");
						} else {

							String obs = JOptionPane.showInputDialog("Observa????es").trim();
							while (obs.equals("")) {
								JOptionPane.showMessageDialog(null, "O campo de observ????es ?? obrigat??rio");
								obs = JOptionPane.showInputDialog("Obseva????es").trim();
							}
							emp.setQtdTotalDevolvida(emp.getQtdTotalDevolvida() + confirma_int);

							mat.setQtd(confirma_int + mat.getQtd());
							mat.setQtd_emprestado(mat.getQtd_emprestado() - confirma_int);
							// Pegando hora atual do sistema
							Calendar c = Calendar.getInstance();
							// atribuindo os atributos da devolu????o
							devolucao.setEmprestimo(emp);
							devolucao.setAdminRecebe(adm);
							devolucao.setDataDevolucao(new Date());
							devolucao.setLocalDate(c);
							devolucao.setQtdDevolvida(confirma_int);
							devolucao.setObsDevolucao(obs);

							dDao.salvar(devolucao);
							mDao.atualizar(mat);
							eDao.atualizarEmprestimo(emp);

							emp = new Emprestimo();
							mat = new Material();
							adm = new Admin();
							devolucao = new Devolucao();

							JOptionPane.showMessageDialog(null, "Material devolvido com sucesso!!!");
							btnBuscar.doClick();
						}

					}

				}

			}
		});
		btn_Devolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Devolver.setBackground(new Color(0, 255, 127));

		tb_Emprestimos = new JTable();
		tb_Emprestimos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					btn_Detalhar.doClick();
				}
			}
		});
		tb_Emprestimos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_Emprestimos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tb_Emprestimos.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "C\u00F3digo", "Material", "Qtd ent", "Qtd dev", "Servidor", "Data" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tb_Emprestimos.getColumnModel().getColumn(0).setResizable(false);
		tb_Emprestimos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tb_Emprestimos.getColumnModel().getColumn(1).setResizable(false);
		tb_Emprestimos.getColumnModel().getColumn(1).setPreferredWidth(218);
		tb_Emprestimos.getColumnModel().getColumn(2).setResizable(false);
		tb_Emprestimos.getColumnModel().getColumn(2).setPreferredWidth(55);
		tb_Emprestimos.getColumnModel().getColumn(3).setResizable(false);
		tb_Emprestimos.getColumnModel().getColumn(3).setPreferredWidth(55);
		tb_Emprestimos.getColumnModel().getColumn(4).setResizable(false);
		tb_Emprestimos.getColumnModel().getColumn(4).setPreferredWidth(170);
		tb_Emprestimos.getColumnModel().getColumn(5).setResizable(false);
		tb_Emprestimos.getColumnModel().getColumn(5).setPreferredWidth(73);
		sp_Empretimos.setViewportView(tb_Emprestimos);
		frmTelaPrincipal.getContentPane().setLayout(null);
		frmTelaPrincipal.getContentPane().add(sp_Empretimos);
		frmTelaPrincipal.getContentPane().add(btn_Devolver);
		frmTelaPrincipal.getContentPane().add(btn_Editar);
		frmTelaPrincipal.getContentPane().add(btn_Sair);
		frmTelaPrincipal.getContentPane().add(lblMaterialservidor);
		frmTelaPrincipal.getContentPane().add(txt_Material_Busca);
		frmTelaPrincipal.getContentPane().add(lblServidor);
		frmTelaPrincipal.getContentPane().add(txt_Servidor_Busca);
		frmTelaPrincipal.getContentPane().add(btnBuscar);

		btn_Detalhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String capta = "";
				if (tb_Emprestimos.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um Emprestimo da lista");
				} else if (tb_Emprestimos.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Selecione apenas um Emprestimo da lista");
				} else {
					capta = tb_Emprestimos.getValueAt(tb_Emprestimos.getSelectedRow(), 0).toString();
					int captaId = Integer.parseInt(capta);

					emp = eDao.buscarPorId(captaId);
					control_View.abreTelaDetalharEmprestimo(emp, "principal");
					getFrmTelaPrincipal().dispose();
				}

			}
		});
		btn_Detalhar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Detalhar.setBackground(new Color(143, 188, 143));
		btn_Detalhar.setBounds(473, 333, 177, 25);
		frmTelaPrincipal.getContentPane().add(btn_Detalhar);

		JLabel lblConsultarEmprstimos = new JLabel("Consultar Empr??stimos");
		lblConsultarEmprstimos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultarEmprstimos.setBounds(53, 11, 541, 21);
		frmTelaPrincipal.getContentPane().add(lblConsultarEmprstimos);

		JMenuBar menuBar = new JMenuBar();
		frmTelaPrincipal.setJMenuBar(menuBar);

		JButton btn_Servidor = new JButton("Servidores");
		btn_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Servidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaServidor();
				getFrmTelaPrincipal().dispose();

			}
		});

		JButton btnNewButton = new JButton("Empr??stimos");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.abreTelaCadastroEmprestimo();
				getFrmTelaPrincipal().dispose();

			}
		});
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_AdicionarPQ.png")));
		btn_Servidor.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_ServidorPQ.png")));
		menuBar.add(btn_Servidor);

		JButton btn_Materiais = new JButton("Materiais");
		btn_Materiais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.abreTelaMateriais();
				getFrmTelaPrincipal().setVisible(false);

			}
		});
		btn_Materiais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Materiais.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_MateriaisPQ.png")));
		menuBar.add(btn_Materiais);

		JButton btn_Relatorios = new JButton("Relat??rios");
		btn_Relatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_Rel.abretelaRelatorios();
				getFrmTelaPrincipal().dispose();

			}
		});
		btn_Relatorios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Relatorios.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_Relatorios.png")));
		menuBar.add(btn_Relatorios);

		JButton btn_Sobre = new JButton("Sobre    ");
		btn_Sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control_View.abreTelaSobre();
				getFrmTelaPrincipal().dispose();
			}
		});
		btn_Sobre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Sobre.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_SobrePQ.png")));
		menuBar.add(btn_Sobre);
	}

	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public JFrame getFrmTelaPrincipal() {
		return frmTelaPrincipal;
	}

	public void setFrmTelaPrincipal(JFrame frmTelaPrincipal) {
		this.frmTelaPrincipal = frmTelaPrincipal;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextField() {
		return txt_Material_Busca;
	}

	public void setTextField(JTextField textField) {
		this.txt_Material_Busca = textField;
	}

	public List<Emprestimo> getListaEmprestimo() {
		return listaEmprestimo;
	}

	public void setListaEmprestimo(List<Emprestimo> listaEmprestimo) {
		this.listaEmprestimo = listaEmprestimo;
	}
}
