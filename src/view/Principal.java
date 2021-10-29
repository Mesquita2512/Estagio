package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.ListSelectionModel;

public class Principal {

	private JFrame frmTelaPrincipal;
	private JTextField txt_Material_Busca;
	private JTextField txt_Servidor_Busca;

	Controla_views control_View = new Controla_views();
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
			emp = getListaEmprestimo().get(inc);

			tabelaBd.addRow(new Object[] { emp.getId(), emp.getMaterial().getDescricao(), emp.getQtdEmprestado(),
					emp.getQtdTotalDevolvida(), emp.getServidor().getNome(), emp.getDataEntrega() });

			val--;
			inc++;
			emp = new Emprestimo();

		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaPrincipal = new JFrame();
		frmTelaPrincipal.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaPrincipal.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagens/Icon_Fundo.jpg")));
		frmTelaPrincipal.setResizable(false);
		frmTelaPrincipal.setForeground(new Color(169, 169, 169));
		frmTelaPrincipal.setBackground(new Color(169, 169, 169));
		frmTelaPrincipal.setTitle("Tela Principal");
		frmTelaPrincipal.setBounds(100, 100, 750, 480);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblMaterialservidor = new JLabel("Material");
		lblMaterialservidor.setBounds(233, 49, 45, 21);
		lblMaterialservidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Material_Busca = new JTextField();
		txt_Material_Busca.setBounds(296, 48, 106, 23);
		txt_Material_Busca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Material_Busca.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(623, 47, 88, 25);
		btnBuscar.setBackground(new Color(0, 206, 209));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txt_Material = txt_Material_Busca.getText().trim();
				String txt_Servidor = txt_Servidor_Busca.getText().trim();
				// Busca todos os emprestimos
				setListaEmprestimo(eDao.listarEmprestimoComMaterial());
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
							JOptionPane.showMessageDialog(null, "Não foi localizado nenhum empréstimo");
						} else {
							listarEmprestimos();
						}

						// Verfica se campo de Material foi preenchido
					} else if (txt_Servidor_Busca.getText().equals("")) {

						while (cont > 0) {
							String nome = getListaEmprestimo().get(cont - 1).getMaterial().getDescricao().toUpperCase();
							if (nome.contains(txt_Material.toUpperCase())) {
								// Remove os emprestimos que nao foram encontrados na busca pela descri��o do
								// material
							} else {
								listaEmprestimo.remove(cont - 1);
							}

							cont--;

						}
						// Mostra somente os Emprestimos buscados pela descri��o do Material
						if (getListaEmprestimo().isEmpty()) {
							listarEmprestimos();
							JOptionPane.showMessageDialog(null, "Não foi localizado nenhum empréstimo");
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
								// Remove os emprestimos que nao foram encontrados na busca pela descri��o do
								// material
							} else {
								listaEmprestimo.remove(cont - 1);
							}

							cont--;

						}

						// Mostra somente os Emprestimos buscados pela descri��o do Material e pelo nome
						// do Servidor
						if (getListaEmprestimo().isEmpty()) {
							listarEmprestimos();
							JOptionPane.showMessageDialog(null, "Não foi localizado nenhum empréstimo");
						} else {
							listarEmprestimos();
						}

					}

				}

				String siape = "";
				siape = System.getProperty("siape", siape);

			}
		});

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(74, 24, 54, 61);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.abreTelaCadastroEmprestimo();
				getFrmTelaPrincipal().dispose();

			}
		});
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_AdicionarPQ.png")));

		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(428, 49, 61, 21);
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Servidor_Busca = new JTextField();
		txt_Servidor_Busca.setBounds(499, 48, 106, 23);
		txt_Servidor_Busca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Servidor_Busca.setColumns(10);

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(623, 333, 88, 25);
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.fecharSistema();
				getFrmTelaPrincipal().dispose();

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));

		JScrollPane sp_Empretimos = new JScrollPane();
		sp_Empretimos.setBounds(25, 103, 686, 208);

		JButton btn_Editar = new JButton("Editar Emprestimo");
		btn_Editar.setBounds(234, 333, 177, 25);
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
								"Já foi realizada devolução parcial deste emprestimo, não é mais aceito fazer alterações neste empréstimo");
					} else if (emp.getAdminEntrega().equals(adm)) {
						control_View.abreTelaEditarEmprestimo(emp);
						getFrmTelaPrincipal().dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"A edição é permitida somente pelo usuário que realizou o empréstimo: "
										+ emp.getAdminEntrega().getNome());
					}

				}

			}
		});
		btn_Editar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Editar.setBackground(new Color(189, 183, 107));

		JButton btn_Devolver = new JButton("Devolver Material");
		btn_Devolver.setBounds(25, 333, 191, 25);
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
						String obs = JOptionPane.showInputDialog("Obsevações");
						int confirma = JOptionPane.showConfirmDialog(null, "Confirme a devolução do material");
						if (confirma == JOptionPane.YES_OPTION) {
							mat.setQtd(mat.getQtd() + 1);

							emp.setQtdTotalDevolvida(emp.getQtdEmprestado());
							mat.setQtd_emprestado(mat.getQtd_emprestado() - 1);

							devolucao.setEmprestimo(emp);
							devolucao.setAdminRecebe(adm);
							devolucao.setDataDevolucao(new Date());
							devolucao.setQtdDevolvida(emp.getQtdEmprestado());
							devolucao.setObsDevolucao(obs);

							dDao.salvar(devolucao);
							mDao.atualizar(mat);
							eDao.atualizarEmprestimo(emp);

							emp = new Emprestimo();
							mat = new Material();
							adm = new Admin();
							devolucao = new Devolucao();

							JOptionPane.showMessageDialog(null, "Material devolvido com sucesso!!!");
							getFrmTelaPrincipal().dispose();
							control_View.abreTelaPrincipal();

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
									"Informe um valor inteiro para realizar a devolução do material");
							return;
						}

						if (confirma_int > emp.getQtdEmprestado() - emp.getQtdTotalDevolvida()) {
							JOptionPane.showMessageDialog(null,
									"A quantidade informada é maior do que a quantidade a ser devolvida neste emprestimo");
						} else if (confirma_int <= 0) {
							JOptionPane.showMessageDialog(null,
									"informe um valor maior que zero para devolver o material");
						} else {

							String obs = JOptionPane.showInputDialog("Observaçães");
							emp.setQtdTotalDevolvida(emp.getQtdTotalDevolvida() + confirma_int);

							mat.setQtd(confirma_int + mat.getQtd());
							mat.setQtd_emprestado(mat.getQtd_emprestado() - confirma_int);

							devolucao.setEmprestimo(emp);
							devolucao.setAdminRecebe(adm);
							devolucao.setDataDevolucao(new Date());
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
							getFrmTelaPrincipal().dispose();
							control_View.abreTelaPrincipal();
						}

					}

				}

			}
		});
		btn_Devolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Devolver.setBackground(new Color(0, 255, 127));

		tb_Emprestimos = new JTable();
		tb_Emprestimos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_Emprestimos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tb_Emprestimos.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Id", "Material", "Qtd ent", "Qtd dev", "Servidor", "Data" }));
		tb_Emprestimos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tb_Emprestimos.getColumnModel().getColumn(1).setPreferredWidth(218);
		tb_Emprestimos.getColumnModel().getColumn(2).setPreferredWidth(55);
		tb_Emprestimos.getColumnModel().getColumn(3).setPreferredWidth(55);
		tb_Emprestimos.getColumnModel().getColumn(4).setPreferredWidth(170);
		tb_Emprestimos.getColumnModel().getColumn(5).setPreferredWidth(73);
		sp_Empretimos.setViewportView(tb_Emprestimos);
		frmTelaPrincipal.getContentPane().setLayout(null);
		frmTelaPrincipal.getContentPane().add(sp_Empretimos);
		frmTelaPrincipal.getContentPane().add(btn_Devolver);
		frmTelaPrincipal.getContentPane().add(btn_Editar);
		frmTelaPrincipal.getContentPane().add(btn_Sair);
		frmTelaPrincipal.getContentPane().add(btnNewButton);
		frmTelaPrincipal.getContentPane().add(lblMaterialservidor);
		frmTelaPrincipal.getContentPane().add(txt_Material_Busca);
		frmTelaPrincipal.getContentPane().add(lblServidor);
		frmTelaPrincipal.getContentPane().add(txt_Servidor_Busca);
		frmTelaPrincipal.getContentPane().add(btnBuscar);

		JButton btn_Detalhar = new JButton("Detalhar Emprestimo");
		btn_Detalhar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Detalhar.setBackground(new Color(143, 188, 143));
		btn_Detalhar.setBounds(428, 333, 177, 25);
		frmTelaPrincipal.getContentPane().add(btn_Detalhar);

		JMenuBar menuBar = new JMenuBar();
		frmTelaPrincipal.setJMenuBar(menuBar);

		JButton btn_Servidor = new JButton("  Servidores");
		btn_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Servidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaServidor();
				getFrmTelaPrincipal().dispose();

			}
		});
		btn_Servidor.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_ServidorPQ.png")));
		menuBar.add(btn_Servidor);

		JButton btn_Materiais = new JButton("  Materiais");
		btn_Materiais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.abreTelaMateriais();
				getFrmTelaPrincipal().setVisible(false);

			}
		});
		btn_Materiais.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Materiais.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_MateriaisPQ.png")));
		menuBar.add(btn_Materiais);

		JButton btn_Relatorios = new JButton("  Relatórios");
		btn_Relatorios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Relatorios.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_Relatorios.png")));
		menuBar.add(btn_Relatorios);

		JButton btnNewButton_1 = new JButton("  Sobre    ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_SobrePQ.png")));
		menuBar.add(btnNewButton_1);
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
