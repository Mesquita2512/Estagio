package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import dao.EmprestimoDao;
import entity.Emprestimo;

public class Principal {

	private JFrame frmTelaPrincipal;
	private JTextField txt_Material_Busca;
	private JTextField txt_Servidor_Busca;

	Controla_views control_View = new Controla_views();
	Login login = new Login();

	Emprestimo emp = new Emprestimo();
	EmprestimoDao eDao = new EmprestimoDao();

	private List<Emprestimo> listaEmprestimo;

	private JTable tb_Emprestimos;
	private JTable table;

	JButton btnDevolver = new JButton("Devolver");
	JButton btnEditar = new JButton("Editar");
	JButton btnExcluir = new JButton("Excluir");
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

				if (txt_Material_Busca.getText().equals("")) {

					setListaEmprestimo(eDao.getListaEmprestimo());

					int val = getListaEmprestimo().size();
					int inc = 0;

					DefaultTableModel tabelaBd = (DefaultTableModel) tb_Emprestimos.getModel();
					tabelaBd.setNumRows(0);

					while (val > 0) {
						emp = getListaEmprestimo().get(inc);

						tabelaBd.addRow(new Object[] { emp.getMaterial().getDescricao(), emp.getQtd_devolvida(),
								emp.getQtd_emprestado(), emp.getServidor().getNome(), emp.getData_Entrega(), btnDevolver,
								btnEditar, btnExcluir});

						val--;
						inc++;
						emp = new Emprestimo();

					}

				}

				String siape = "";
				siape = System.getProperty("siape", siape);
				System.out.println("Testa Buscar Siape Admin" + siape);

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
		GroupLayout groupLayout = new GroupLayout(frmTelaPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btn_Sair))
						.addGroup(groupLayout.createSequentialGroup().addGap(25).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(49)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
										.addComponent(lblMaterialservidor).addGap(18)
										.addComponent(txt_Material_Busca, GroupLayout.PREFERRED_SIZE, 106,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblServidor, GroupLayout.PREFERRED_SIZE, 61,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(txt_Servidor_Busca, GroupLayout.PREFERRED_SIZE, 106,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(sp_Empretimos, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))))
				.addGap(33)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btn_Sair).addGap(28)));

		tb_Emprestimos = new JTable();
		tb_Emprestimos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tb_Emprestimos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Material", "Qtd Dev", "Qtd ent", "Servidor", "Data", "Devolver", "Editar", "Excluir"
			}
		));
		tb_Emprestimos.getColumnModel().getColumn(0).setPreferredWidth(175);
		tb_Emprestimos.getColumnModel().getColumn(1).setPreferredWidth(55);
		tb_Emprestimos.getColumnModel().getColumn(2).setPreferredWidth(55);
		tb_Emprestimos.getColumnModel().getColumn(3).setPreferredWidth(150);
		tb_Emprestimos.getColumnModel().getColumn(4).setPreferredWidth(100);
		tb_Emprestimos.getColumnModel().getColumn(5).setPreferredWidth(60);
		tb_Emprestimos.getColumnModel().getColumn(6).setPreferredWidth(60);
		tb_Emprestimos.getColumnModel().getColumn(7).setPreferredWidth(60);
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
