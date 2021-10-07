package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
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
import dao.EmprestimoDao;
import dao.MaterialDao;
import entity.Admin;
import entity.Emprestimo;
import entity.Material;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaPrincipal = new JFrame();
		frmTelaPrincipal.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagens/Icon_Fundo.jpg")));
		frmTelaPrincipal.setResizable(false);
		frmTelaPrincipal.setForeground(new Color(169, 169, 169));
		frmTelaPrincipal.setBackground(new Color(169, 169, 169));
		frmTelaPrincipal.setTitle("Tela Principal");
		frmTelaPrincipal.setBounds(100, 100, 750, 480);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblMaterialservidor = new JLabel("Material");
		lblMaterialservidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Material_Busca = new JTextField();
		txt_Material_Busca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Material_Busca.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(0, 206, 209));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txt_Material_Busca.getText().equals("") && txt_Servidor_Busca.getText().equals("")) {

					setListaEmprestimo(eDao.getListaEmprestimo());

					int val = getListaEmprestimo().size();
					int inc = 0;

					DefaultTableModel tabelaBd = (DefaultTableModel) tb_Emprestimos.getModel();
					tabelaBd.setNumRows(0);

					while (val > 0) {
						emp = getListaEmprestimo().get(inc);

						tabelaBd.addRow(new Object[] {emp.getId(), emp.getMaterial().getDescricao(), emp.getQtd_emprestado(),
								emp.getQtd_devolvida(), emp.getServidor().getNome(), emp.getData_Entrega() });

						val--;
						inc++;
						emp = new Emprestimo();

					}

				}

				String siape = "";
				siape = System.getProperty("siape", siape);

			}
		});

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.abreTelaCadastroEmprestimo();
				getFrmTelaPrincipal().dispose();

			}
		});
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_AdicionarPQ.png")));

		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Servidor_Busca = new JTextField();
		txt_Servidor_Busca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Servidor_Busca.setColumns(10);

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.fecharSistema();
				getFrmTelaPrincipal().dispose();

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));

		JScrollPane sp_Empretimos = new JScrollPane();

		JButton btn_Sair_1 = new JButton("Excluir Emprestimo");
		btn_Sair_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair_1.setBackground(new Color(222, 184, 135));

		JButton btn_Editar = new JButton("Editar Emprestimo");
		btn_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Editar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Editar.setBackground(new Color(189, 183, 107));

		JButton btn_Devolver = new JButton("Devolver Material");
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
					
					mat.setQtd(emp.getQtd_emprestado() + mat.getQtd());
					

					
					emp.setAdminRecebe(adm);
					emp.setQtd_devolvida(emp.getQtd_emprestado());
					mat.setQtd_emprestado(mat.getQtd_emprestado() - emp.getQtd_devolvida());
					emp.setData_Devolução(new Date());
					
					mDao.atualizar(mat);
					eDao.atualizarEmprestimo(emp);

					emp = new Emprestimo();
					mat = new Material();
					adm = new Admin();
					
					JOptionPane.showMessageDialog(null, "Material devolvido com sucesso!!!");

				}

			}
		});
		btn_Devolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Devolver.setBackground(new Color(0, 255, 127));
		GroupLayout groupLayout = new GroupLayout(frmTelaPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(25)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btn_Devolver, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_Editar, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_Sair_1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
								.addComponent(btn_Sair))
						.addGroup(groupLayout.createSequentialGroup().addGap(49)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
								.addComponent(lblMaterialservidor).addGap(18)
								.addComponent(txt_Material_Busca, GroupLayout.PREFERRED_SIZE, 106,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblServidor, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txt_Servidor_Busca, GroupLayout.PREFERRED_SIZE, 106,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addComponent(sp_Empretimos, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
				.addGap(33)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(24, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnBuscar)
								.addComponent(txt_Servidor_Busca, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblServidor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Material_Busca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaterialservidor, GroupLayout.PREFERRED_SIZE, 21,
										GroupLayout.PREFERRED_SIZE))
						.addGap(31))
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnNewButton).addGap(18)))
				.addComponent(sp_Empretimos, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btn_Sair)
						.addComponent(btn_Devolver, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Editar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Sair_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(28)));

		tb_Emprestimos = new JTable();
		tb_Emprestimos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tb_Emprestimos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Material", "Qtd ent", "Qtd dev", "Servidor", "Data"
			}
		));
		tb_Emprestimos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tb_Emprestimos.getColumnModel().getColumn(1).setPreferredWidth(175);
		tb_Emprestimos.getColumnModel().getColumn(2).setPreferredWidth(55);
		tb_Emprestimos.getColumnModel().getColumn(3).setPreferredWidth(55);
		tb_Emprestimos.getColumnModel().getColumn(4).setPreferredWidth(150);
		tb_Emprestimos.getColumnModel().getColumn(5).setPreferredWidth(100);
		sp_Empretimos.setViewportView(tb_Emprestimos);
		frmTelaPrincipal.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frmTelaPrincipal.setJMenuBar(menuBar);

		JButton btn_Servidor = new JButton("Servidores");
		btn_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Servidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaServidor();
				getFrmTelaPrincipal().dispose();

			}
		});
		btn_Servidor.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_ServidorPQ.png")));
		menuBar.add(btn_Servidor);

		JButton btn_Materiais = new JButton("Materiais");
		btn_Materiais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.abreTelaMateriais();
				getFrmTelaPrincipal().setVisible(false);

			}
		});
		btn_Materiais.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Materiais.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_MateriaisPQ.png")));
		menuBar.add(btn_Materiais);

		JButton btn_Relatorios = new JButton("Relat\u00F3rios");
		btn_Relatorios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Relatorios.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_Relatorios.png")));
		menuBar.add(btn_Relatorios);

		JButton btnNewButton_1 = new JButton("Sobre");
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
