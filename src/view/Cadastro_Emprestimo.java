package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import config.Numeros;
import dao.AdminDao;
import dao.EmprestimoDao;
import dao.MaterialDao;
import dao.ServidorDao;
import entity.Admin;
import entity.Emprestimo;
import entity.Material;
import entity.Servidor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ListSelectionModel;

public class Cadastro_Emprestimo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JFrame frmNovoEmprestimo;
	private JTextField txt_Material;
	private JTextField txt_Quantidade;
	private JTextField txt_EntregueA;

	private List<Material> listaDeMateriais;
	private List<Servidor> listaDeServidores;
	Date date = new Date();

	MaterialDao mDao = new MaterialDao();
	Material mat = new Material();

	Servidor serv = new Servidor();
	ServidorDao sDao = new ServidorDao();

	Admin adm = new Admin();
	AdminDao aDao = new AdminDao();

	Emprestimo emp = new Emprestimo();
	EmprestimoDao eDao = new EmprestimoDao();

	Controla_views control_View = new Controla_views();
	private JTextField txt_Observacoes;

	private JTable tb_Material;
	private JTable tb_Servidor;
	private JButton btn_Voltar;
	private JButton btn_Sair;
	private JButton btn_ConfirmarServidor;
	private JLabel lblCadastrarEmprstimo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JButton btn_Salvar;
	private JButton btnBuscarServidores;
	private JButton btn_BuscarTodos;
	private JButton btn_ConfimarMaterial;
	private JScrollPane sp_Material;
	private JButton btn_Limpar;
	private JScrollPane sp_Servidor;

	JDateChooser dc_dataEntrega = new JDateChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Emprestimo window = new Cadastro_Emprestimo();
					window.frmNovoEmprestimo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro_Emprestimo() {
		initialize();
		txt_Quantidade.setDocument(new Numeros());
		frmNovoEmprestimo.getContentPane().setLayout(null);
		frmNovoEmprestimo.getContentPane().add(btn_Voltar);
		frmNovoEmprestimo.getContentPane().add(btn_Sair);
		frmNovoEmprestimo.getContentPane().add(btn_ConfirmarServidor);
		frmNovoEmprestimo.getContentPane().add(lblCadastrarEmprstimo);
		frmNovoEmprestimo.getContentPane().add(lblNewLabel_1);
		frmNovoEmprestimo.getContentPane().add(lblNewLabel_1_3);
		frmNovoEmprestimo.getContentPane().add(lblNewLabel);
		frmNovoEmprestimo.getContentPane().add(lblNewLabel_1_1);
		frmNovoEmprestimo.getContentPane().add(lblNewLabel_1_2);
		frmNovoEmprestimo.getContentPane().add(txt_Observacoes);
		frmNovoEmprestimo.getContentPane().add(txt_Quantidade);
		frmNovoEmprestimo.getContentPane().add(txt_Material);
		frmNovoEmprestimo.getContentPane().add(txt_EntregueA);
		frmNovoEmprestimo.getContentPane().add(btn_Salvar);
		frmNovoEmprestimo.getContentPane().add(btnBuscarServidores);
		frmNovoEmprestimo.getContentPane().add(btn_BuscarTodos);
		frmNovoEmprestimo.getContentPane().add(btn_ConfimarMaterial);
		frmNovoEmprestimo.getContentPane().add(sp_Material);
		frmNovoEmprestimo.getContentPane().add(btn_Limpar);
		frmNovoEmprestimo.getContentPane().add(sp_Servidor);

		dc_dataEntrega.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dc_dataEntrega.setBounds(139, 194, 127, 25);
		dc_dataEntrega.setDate(new Date());
		frmNovoEmprestimo.getContentPane().add(dc_dataEntrega);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmNovoEmprestimo = new JFrame();
		frmNovoEmprestimo.getContentPane().setBackground(new Color(240, 255, 255));
		frmNovoEmprestimo.setResizable(false);
		frmNovoEmprestimo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 45));
		frmNovoEmprestimo.setTitle("Novo Emprestimo");
		frmNovoEmprestimo.setBounds(100, 100, 800, 500);
		frmNovoEmprestimo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblCadastrarEmprstimo = new JLabel("Cadastrar Empr\u00E9stimo");
		lblCadastrarEmprstimo.setBounds(43, 20, 706, 55);
		lblCadastrarEmprstimo.setForeground(new Color(0, 0, 139));
		lblCadastrarEmprstimo.setFont(new Font("Tahoma", Font.PLAIN, 45));

		lblNewLabel = new JLabel("Material *");
		lblNewLabel.setBounds(43, 106, 78, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1 = new JLabel("Quantidade *");
		lblNewLabel_1.setBounds(43, 151, 86, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_1 = new JLabel("Entregue a *");
		lblNewLabel_1_1.setBounds(43, 246, 86, 17);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_2 = new JLabel("Data *");
		lblNewLabel_1_2.setBounds(43, 202, 86, 17);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_3 = new JLabel("Observações");
		lblNewLabel_1_3.setBounds(43, 301, 86, 17);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Material = new JTextField();
		txt_Material.setBounds(139, 103, 129, 23);
		txt_Material.setEnabled(true);
		txt_Material.setEditable(true);
		txt_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Material.setColumns(10);

		txt_Quantidade = new JTextField();
		txt_Quantidade.setBounds(139, 148, 129, 23);
		txt_Quantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Quantidade.setColumns(10);

		txt_EntregueA = new JTextField();
		txt_EntregueA.setBounds(139, 243, 129, 23);
		txt_EntregueA.setEditable(true);
		txt_EntregueA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_EntregueA.setColumns(10);

		sp_Material = new JScrollPane();
		sp_Material.setBounds(286, 148, 463, 71);
		sp_Material.setVisible(false);

		sp_Servidor = new JScrollPane();
		sp_Servidor.setBounds(286, 297, 463, 67);
		sp_Servidor.setVisible(false);

		btn_ConfimarMaterial = new JButton("Confirmar");
		btn_ConfimarMaterial.setBounds(645, 225, 104, 25);
		btn_ConfimarMaterial.setVisible(false);
		btn_ConfimarMaterial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ConfimarMaterial.setBackground(new Color(240, 230, 140));

		btn_ConfirmarServidor = new JButton("Confirmar");
		btn_ConfirmarServidor.setBounds(645, 370, 104, 23);
		btn_ConfirmarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String capta = "";

				if (tb_Servidor.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um servidor da lista");
				} else if (tb_Servidor.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Selecione apenas um servidor da lista");
				} else {
					capta = tb_Servidor.getValueAt(tb_Servidor.getSelectedRow(), 0).toString();
					int captaId = Integer.parseInt(capta);

					serv = sDao.buscarPorSiape(captaId);
					txt_EntregueA.setText(serv.getNome());

					sp_Servidor.setVisible(false);
					btn_ConfirmarServidor.setVisible(false);

					txt_EntregueA.setEditable(false);

				}
			}
		});
		btn_ConfirmarServidor.setBackground(new Color(240, 230, 140));
		btn_ConfirmarServidor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ConfirmarServidor.setVisible(false);

		btn_Salvar = new JButton("SALVAR");
		btn_Salvar.setBounds(139, 404, 123, 25);
		btn_Salvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Date dataAtual = new Date();
				Date dataRemota = null;

				try {
					dataRemota = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021");
				} catch (ParseException e) {

					e.printStackTrace();
				}

				if (mat.getId() == 0) {
					JOptionPane.showMessageDialog(null, "Realize a busca de um material para anexar ao emprestimo!!!");

				} else if (txt_Quantidade.getText().equals("") || Integer.parseInt(txt_Quantidade.getText()) == 0) {
					JOptionPane.showMessageDialog(null, "Informe um valor válido!!!");
				} else if (mat.getQtd() < Integer.parseInt(txt_Quantidade.getText())) {
					JOptionPane.showMessageDialog(null, "Não temos a quantidade informada desse material em estoque,"
							+ " informe um Valor menor!!!");
				} else if (dc_dataEntrega.getDate() == null || dc_dataEntrega.getDate().compareTo(dataAtual) > 0
						|| dc_dataEntrega.getDate().compareTo(dataRemota) < 0) {
					JOptionPane.showMessageDialog(null, "Date inválida, favor verifique a data informada");

				} else if (serv.getSiape() == 0) {
					JOptionPane.showMessageDialog(null,
							"Realize a busca de de um servidor para anexar ao emprestimo!!!");

				} else {
					//busca o Adim logado para anexar ao emprestimo
					String siape = System.getProperty("siape");
					adm = aDao.buscarPorSiape(Integer.parseInt(siape));

					//Pega a hora atual
					Calendar c = Calendar.getInstance();
					//Atribui os Valores no emprestimo
					emp.setServidor(serv);
					emp.setMaterial(mat);
					emp.setQtdEmprestado(Integer.parseInt(txt_Quantidade.getText()));
					emp.setObsEntrega(txt_Observacoes.getText());
					emp.setDataEntrega(dc_dataEntrega.getDate());
					emp.setHoraEntrega(c);
					emp.setAdminEntrega(adm);

					mat.setQtd(mat.getQtd() - Integer.parseInt(txt_Quantidade.getText()));
					mat.setQtd_emprestado(mat.getQtd_emprestado() + Integer.parseInt(txt_Quantidade.getText()));
					mDao.atualizar(mat);
					eDao.salvar(emp);

					getTxt_EntregueA().setText("");
					getTxt_Material().setText("");
					getTxt_Quantidade().setText("");
					getTxt_Observacoes().setText("");

					txt_EntregueA.setEditable(true);
					txt_Material.setEditable(true);

					serv = new Servidor();
					mat = new Material();
					emp = new Emprestimo();

					JOptionPane.showMessageDialog(null, "Material emprestado com sucesso!!!");

				}

			}
		});
		btn_Salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Salvar.setBackground(new Color(34, 139, 34));
		btn_Salvar.setForeground(Color.BLACK);

		btn_Limpar = new JButton("Limpar");
		btn_Limpar.setBounds(286, 404, 118, 25);
		btn_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getTxt_EntregueA().setText("");
				getTxt_Material().setText("");
				getTxt_Quantidade().setText("");
				getTxt_Observacoes().setText("");

				txt_EntregueA.setEditable(true);
				txt_Material.setEditable(true);

				serv = new Servidor();
				mat = new Material();

			}
		});
		btn_Limpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Limpar.setBackground(new Color(0, 191, 255));
		btn_Limpar.setForeground(new Color(0, 0, 0));

		btn_Voltar = new JButton("Voltar");
		btn_Voltar.setBounds(433, 404, 135, 25);
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaPrincipal();
				getFrmNovoEmprestimo().dispose();

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(598, 404, 151, 25);
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.fecharSistema();
				getFrmNovoEmprestimo().dispose();

			}
		});
		btn_Sair.setBackground(new Color(255, 69, 0));

		btn_BuscarTodos = new JButton("buscar");
		btn_BuscarTodos.setBounds(286, 104, 110, 23);
		btn_BuscarTodos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_BuscarTodos.setBackground(new Color(240, 230, 140));

		btn_BuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String txt_material = txt_Material.getText().trim();

				if (txt_material.equals("")) {

					setListaDeMateriais(mDao.listarMaterialPorStatus());

					int val = getListaDeMateriais().size();
					int inc = 0;

					DefaultTableModel tabelaBd = (DefaultTableModel) tb_Material.getModel();
					tabelaBd.setNumRows(0);

					sp_Material.setVisible(true);
					btn_ConfimarMaterial.setVisible(true);

					while (val > 0) {
						mat = getListaDeMateriais().get(inc);

						tabelaBd.addRow(new Object[] { mat.getId(), mat.getDescricao(), mat.getQtd(),
								mat.getQtd_emprestado() });

						val--;
						inc++;
						mat = new Material();

					}

				} else {

					txt_material = "'%" + txt_material + "%'";
					setListaDeMateriais(mDao.listarMaterialPorNome(txt_material));

					if (getListaDeMateriais().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Não foi localizado nenhum material com a descrição informada");
					} else {

						int val = getListaDeMateriais().size();
						int inc = 0;

						DefaultTableModel tabelaBd = (DefaultTableModel) tb_Material.getModel();
						tabelaBd.setNumRows(0);

						sp_Material.setVisible(true);
						btn_ConfimarMaterial.setVisible(true);

						while (val > 0) {
							mat = getListaDeMateriais().get(inc);

							tabelaBd.addRow(new Object[] { mat.getId(), mat.getDescricao(), mat.getQtd(),
									mat.getQtd_emprestado() });

							val--;
							inc++;
							mat = new Material();
						}
						txt_Material.setEditable(true);

					}
				}
			}
		});

		btnBuscarServidores = new JButton("buscar");
		btnBuscarServidores.setBounds(284, 244, 112, 23);
		btnBuscarServidores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String txt_Servidor = txt_EntregueA.getText().trim();
				setListaDeServidores(sDao.listarServidorPorStatus());

				if (txt_Servidor.equals("")) {

					int val = getListaDeServidores().size();
					int inc = 0;

					DefaultTableModel tabelaBd = (DefaultTableModel) tb_Servidor.getModel();
					tabelaBd.setNumRows(0);

					sp_Servidor.setVisible(true);
					btn_ConfirmarServidor.setVisible(true);

					sp_Servidor.setVisible(true);
					btn_ConfirmarServidor.setVisible(true);

					while (val > 0) {
						serv = getListaDeServidores().get(inc);

						tabelaBd.addRow(new Object[] { serv.getSiape(), serv.getNome(), serv.getEmail() });

						val--;
						inc++;
						serv = new Servidor();

					}

				} else {

					txt_Servidor = "'%" + txt_Servidor + "%'";
					setListaDeServidores(sDao.listarServidorPorNome(txt_Servidor));

					if (getListaDeServidores().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Não foi localizado nenhum servidor com a descrição informada");
					} else {

						int val = getListaDeServidores().size();
						int inc = 0;

						DefaultTableModel tabelaBd = (DefaultTableModel) tb_Servidor.getModel();
						tabelaBd.setNumRows(0);

						sp_Servidor.setVisible(true);
						btn_ConfirmarServidor.setVisible(true);

						while (val > 0) {
							serv = getListaDeServidores().get(inc);

							tabelaBd.addRow(new Object[] { serv.getSiape(), serv.getNome(), serv.getEmail() });

							val--;
							inc++;
							serv = new Servidor();

						}
						txt_EntregueA.setEditable(true);

					}
				}
			}
		});

		btnBuscarServidores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarServidores.setBackground(new Color(240, 230, 140));

		txt_Observacoes = new JTextField();
		txt_Observacoes.setBounds(139, 298, 127, 61);
		txt_Observacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Observacoes.setColumns(10);

		btn_ConfimarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String capta = "";
				if (tb_Material.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um Material da lista");
				} else if (tb_Material.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Selecione apenas um material da lista");
				} else {
					capta = tb_Material.getValueAt(tb_Material.getSelectedRow(), 0).toString();
					int captaId = Integer.parseInt(capta);

					mat = mDao.buscarPorId(captaId);
					txt_Material.setText(mat.getDescricao());

					sp_Material.setVisible(false);
					btn_ConfimarMaterial.setVisible(false);

					txt_Material.setEditable(false);

				}

			}
		});

		tb_Servidor = new JTable();
		tb_Servidor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_Servidor.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Siape", "Nome", "Email" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tb_Servidor.getColumnModel().getColumn(0).setPreferredWidth(48);
		tb_Servidor.getColumnModel().getColumn(1).setPreferredWidth(136);
		tb_Servidor.getColumnModel().getColumn(2).setPreferredWidth(162);
		sp_Servidor.setViewportView(tb_Servidor);

		tb_Material = new JTable();
		tb_Material.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_Material.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Qtd Est", "Qtd Emp"
			}
		));
		tb_Material.getColumnModel().getColumn(0).setResizable(false);
		tb_Material.getColumnModel().getColumn(0).setPreferredWidth(60);
		tb_Material.getColumnModel().getColumn(1).setResizable(false);
		tb_Material.getColumnModel().getColumn(1).setPreferredWidth(248);
		tb_Material.getColumnModel().getColumn(2).setResizable(false);
		tb_Material.getColumnModel().getColumn(2).setPreferredWidth(72);
		tb_Material.getColumnModel().getColumn(3).setResizable(false);
		sp_Material.setViewportView(tb_Material);

	}

	public JFrame getFrmNovoEmprestimo() {
		return frmNovoEmprestimo;
	}

	public void setFrmNovoEmprestimo(JFrame frmNovoEmprestimo) {
		this.frmNovoEmprestimo = frmNovoEmprestimo;
	}

	public JTextField getTxt_Material() {
		return txt_Material;
	}

	public void setTxt_Material(JTextField txt_Material) {
		this.txt_Material = txt_Material;
	}

	public JTextField getTxt_Quantidade() {
		return txt_Quantidade;
	}

	public void setTxt_Quantidade(JTextField txt_Quantidade) {
		this.txt_Quantidade = txt_Quantidade;
	}

	public JTextField getTxt_EntregueA() {
		return txt_EntregueA;
	}

	public void setTxt_EntregueA(JTextField txt_EntregueA) {
		this.txt_EntregueA = txt_EntregueA;
	}

	public JTextField getTxt_Observacoes() {
		return txt_Observacoes;
	}

	public void setTxt_Observacoes(JTextField txt_Observacoes) {
		this.txt_Observacoes = txt_Observacoes;
	}

	public List<Material> getListaDeMateriais() {
		return listaDeMateriais;
	}

	public void setListaDeMateriais(List<Material> listaDeMateriais) {
		this.listaDeMateriais = listaDeMateriais;
	}

	public List<Servidor> getListaDeServidores() {
		return listaDeServidores;
	}

	public void setListaDeServidores(List<Servidor> listaDeServidores) {
		this.listaDeServidores = listaDeServidores;
	}
}
