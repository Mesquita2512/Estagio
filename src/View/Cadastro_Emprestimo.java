package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import config.Numeros;
import dao.MaterialDao;
import dao.ServidorDao;
import entity.Material;
import entity.Servidor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cadastro_Emprestimo {

	private JFrame frmNovoEmprestimo;
	private JTextField txt_Material;
	private JTextField txt_Quantidade;
	private JTextField txt_EntregueA;

	private List<Material> listaDeMateriais;
	private List<Servidor> listaDeServidores;
	MaterialDao mDao = new MaterialDao();
	Material mat = new Material();
	Servidor serv = new Servidor();
	ServidorDao sDao = new ServidorDao();

	Controla_views control_View = new Controla_views();
	private JTextField txt_Observacoes;
	Material material = new Material();
	private JTable tb_Material;
	private JTable tb_Servidor;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmNovoEmprestimo = new JFrame();
		frmNovoEmprestimo.setResizable(false);
		frmNovoEmprestimo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 45));
		frmNovoEmprestimo.setTitle("Novo Emprestimo");
		frmNovoEmprestimo.setBounds(100, 100, 800, 500);
		frmNovoEmprestimo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblCadastrarEmprstimo = new JLabel("Cadastrar Empr\u00E9stimo");
		lblCadastrarEmprstimo.setForeground(new Color(0, 0, 139));
		lblCadastrarEmprstimo.setFont(new Font("Tahoma", Font.PLAIN, 45));

		JLabel lblNewLabel = new JLabel("\u00CDtem/Material");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_1 = new JLabel("Entregue a");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_2 = new JLabel("Data");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_3 = new JLabel("Obs");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Material = new JTextField();
		txt_Material.setEnabled(true);
		txt_Material.setEditable(true);
		txt_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Material.setColumns(10);

		txt_Quantidade = new JTextField();
		txt_Quantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Quantidade.setColumns(10);

		txt_EntregueA = new JTextField();
		txt_EntregueA.setEditable(true);
		txt_EntregueA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_EntregueA.setColumns(10);

		JScrollPane sp_Material = new JScrollPane();
		sp_Material.setVisible(false);

		JScrollPane sp_Servidor = new JScrollPane();
		sp_Servidor.setVisible(false);

		JButton btn_ConfimarMaterial = new JButton("Confirmar");
		btn_ConfimarMaterial.setVisible(false);
		btn_ConfimarMaterial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_ConfimarMaterial.setBackground(new Color(240, 230, 140));

		JButton btn_ConfirmarServidor = new JButton("Confirmar");
		btn_ConfirmarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String capta = "";
				capta = tb_Servidor.getValueAt(tb_Servidor.getSelectedRow(), 0).toString();
				if (capta.equals("")) {
					JOptionPane.showMessageDialog(null, "veo");
				} else {

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

		JButton btn_Salvar = new JButton("SALVAR");
		btn_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Salvar.setBackground(new Color(34, 139, 34));
		btn_Salvar.setForeground(Color.BLACK);

		JButton btn_Limpar = new JButton("Limpar");
		btn_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getTxt_EntregueA().setText("");
				getTxt_Material().setText("");
				getTxt_Quantidade().setText("");
				getTxt_Observacoes().setText("");

			}
		});
		btn_Limpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Limpar.setBackground(new Color(0, 191, 255));
		btn_Limpar.setForeground(new Color(0, 0, 0));

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaPrincipal();
				getFrmNovoEmprestimo().setVisible(false);

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		JButton btn_Sair = new JButton("Sair");
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.fecharSistema();
				getFrmNovoEmprestimo().setVisible(false);

			}
		});
		btn_Sair.setBackground(new Color(255, 69, 0));

		JButton btn_BuscarTodos = new JButton("buscar");
		btn_BuscarTodos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_BuscarTodos.setBackground(new Color(240, 230, 140));

		btn_BuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// control_View.abreTelaBuscaMateriais();

				if (txt_Material.getText().equals("")) {

					setListaDeMateriais(mDao.getListaMaterial());

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

					}

				} else {
					JOptionPane.showMessageDialog(null, "Vamos Buscar alguma coisa?");
					txt_Material.setEditable(true);

				}

			}
		});

		JButton btnBuscarServidores = new JButton("buscar");
		btnBuscarServidores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				

				if (txt_EntregueA.getText().equals("")) {

					setListaDeServidores(sDao.getListaServidor());

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

					}

				} else {
					JOptionPane.showMessageDialog(null, "Vamos Buscar alguma coisa?");
					txt_EntregueA.setEditable(true);

				}

			}
		});

		btnBuscarServidores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarServidores.setBackground(new Color(240, 230, 140));

		JFormattedTextField txt_Data = new JFormattedTextField(new Date());
		txt_Data.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Observacoes = new JTextField();
		txt_Observacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Observacoes.setColumns(10);

		btn_ConfimarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String capta = "";
				capta = tb_Material.getValueAt(tb_Material.getSelectedRow(), 0).toString();
				if (capta.equals("")) {
					JOptionPane.showMessageDialog(null, "veo");
				} else {

					int captaId = Integer.parseInt(capta);

					mat = mDao.buscarPorId(captaId);
					txt_Material.setText(mat.getDescricao());

					sp_Material.setVisible(false);
					btn_ConfimarMaterial.setVisible(false);

					txt_Material.setEditable(false);

				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(frmNovoEmprestimo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(433)
							.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(btn_ConfirmarServidor, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(43)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblCadastrarEmprstimo, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1)
												.addComponent(lblNewLabel_1_3)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel)
														.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_1_2))
													.addGap(18)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(txt_Observacoes, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
															.addComponent(txt_Quantidade, Alignment.TRAILING)
															.addComponent(txt_Material, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
															.addComponent(txt_EntregueA, Alignment.TRAILING)
															.addComponent(txt_Data, Alignment.TRAILING)))))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btn_Salvar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
												.addGap(18)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(btnBuscarServidores, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
													.addComponent(btn_BuscarTodos, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
													.addComponent(btn_ConfimarMaterial, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
													.addComponent(sp_Material, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(btn_Limpar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
													.addComponent(sp_Servidor, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)))))))))
					.addGap(45))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCadastrarEmprstimo)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btn_BuscarTodos)
						.addComponent(txt_Material, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(txt_Quantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_Data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(sp_Material, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_ConfimarMaterial, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBuscarServidores)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_1)
							.addComponent(txt_EntregueA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3)
						.addComponent(txt_Observacoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sp_Servidor, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_ConfirmarServidor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Sair)
						.addComponent(btn_Voltar)
						.addComponent(btn_Limpar)
						.addComponent(btn_Salvar))
					.addContainerGap(40, Short.MAX_VALUE))
		);

		tb_Servidor = new JTable();
		tb_Servidor.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Siape", "Nome", "Email" }) {
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
		tb_Material.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Descri\u00E7\u00E3o", "Qtd Est", "Qtd Emp" }));
		tb_Material.getColumnModel().getColumn(0).setResizable(false);
		tb_Material.getColumnModel().getColumn(0).setPreferredWidth(60);
		tb_Material.getColumnModel().getColumn(1).setResizable(false);
		tb_Material.getColumnModel().getColumn(1).setPreferredWidth(248);
		tb_Material.getColumnModel().getColumn(2).setResizable(false);
		tb_Material.getColumnModel().getColumn(2).setPreferredWidth(72);
		tb_Material.getColumnModel().getColumn(3).setResizable(false);
		sp_Material.setViewportView(tb_Material);
		frmNovoEmprestimo.getContentPane().setLayout(groupLayout);

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
