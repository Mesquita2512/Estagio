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
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Principal {

	private JFrame frmTelaPrincipal;
	private JTable table;
	private JTextField textField;

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
		frmTelaPrincipal.setResizable(false);
		frmTelaPrincipal.setForeground(new Color(169, 169, 169));
		frmTelaPrincipal.setBackground(new Color(169, 169, 169));
		frmTelaPrincipal.setTitle("Tela Principal");
		frmTelaPrincipal.setBounds(100, 100, 600, 450);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		
		JLabel lblMaterialservidor = new JLabel("Material/Servidor");
		lblMaterialservidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMateriaisEmprestados = new JLabel("Materiais Emprestados");
		lblMateriaisEmprestados.setForeground(new Color(0, 0, 139));
		lblMateriaisEmprestados.setFont(new Font("Tahoma", Font.PLAIN, 45));
		GroupLayout groupLayout = new GroupLayout(frmTelaPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMateriaisEmprestados)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMaterialservidor)
									.addGap(26)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnBuscar)))))
					.addContainerGap(409, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMateriaisEmprestados)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaterialservidor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(428, Short.MAX_VALUE))
		);
		frmTelaPrincipal.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmTelaPrincipal.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Empr\u00E9stimos");
		mnMenu.setForeground(new Color(0, 102, 51));
		mnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnMenu.setBackground(new Color(240, 240, 240));
		menuBar.add(mnMenu);
		
		JMenuItem mntmEmprestimo = new JMenuItem("Novo");
		mntmEmprestimo.setForeground(new Color(0, 102, 51));
		mntmEmprestimo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnMenu.add(mntmEmprestimo);
		
		JMenuItem mntmItemmaterial_3 = new JMenuItem("Editar/excluir");
		mntmItemmaterial_3.setForeground(new Color(0, 102, 51));
		mntmItemmaterial_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnMenu.add(mntmItemmaterial_3);
		
		JMenuItem mntmAdministrador_1 = new JMenuItem("Listar");
		mntmAdministrador_1.setForeground(new Color(0, 102, 51));
		mntmAdministrador_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnMenu.add(mntmAdministrador_1);
		
		JMenu mnNewMenu = new JMenu("Servidores");
		mnNewMenu.setForeground(new Color(0, 0, 255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmEmprestimo_1 = new JMenuItem("Novo");
		mntmEmprestimo_1.setForeground(new Color(0, 0, 255));
		mntmEmprestimo_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmEmprestimo_1);
		
		JMenuItem mntmItemmaterial_2 = new JMenuItem("Editar/Excluir");
		mntmItemmaterial_2.setForeground(new Color(0, 0, 255));
		mntmItemmaterial_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmItemmaterial_2);
		
		JMenuItem mntmAdministrador_1_1 = new JMenuItem("Listar");
		mntmAdministrador_1_1.setForeground(new Color(0, 0, 255));
		mntmAdministrador_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmAdministrador_1_1);
		
		JMenu mnNewMenu_1 = new JMenu("Materiais");
		mnNewMenu_1.setForeground(new Color(255, 0, 0));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmEmprestimo_2 = new JMenuItem("Cadastrar");
		mntmEmprestimo_2.setForeground(new Color(255, 0, 0));
		mntmEmprestimo_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmEmprestimo_2);
		
		JMenuItem mntmItemmaterial_1 = new JMenuItem("Editar/Excluir");
		mntmItemmaterial_1.setForeground(new Color(255, 0, 0));
		mntmItemmaterial_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmItemmaterial_1);
		
		JMenuItem mntmAdministrador_1_2 = new JMenuItem("Listar");
		mntmAdministrador_1_2.setForeground(new Color(255, 0, 0));
		mntmAdministrador_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmAdministrador_1_2);
		
		JMenu mnListar = new JMenu("Contas");
		mnListar.setForeground(new Color(255, 153, 51));
		mnListar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnListar);
		
		JMenuItem mntmEmprestimos = new JMenuItem("Novo Usu\u00E1rio");
		mntmEmprestimos.setForeground(new Color(255, 153, 51));
		mntmEmprestimos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnListar.add(mntmEmprestimos);
		
		JMenuItem mntmItensmateriasi = new JMenuItem("Editar/Excluir Usu\u00E1rio");
		mntmItensmateriasi.setForeground(new Color(255, 153, 51));
		mntmItensmateriasi.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnListar.add(mntmItensmateriasi);
		
		JMenuItem mntmAdministrador_1_3 = new JMenuItem("Listar");
		mntmAdministrador_1_3.setForeground(new Color(255, 153, 51));
		mntmAdministrador_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnListar.add(mntmAdministrador_1_3);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		mnRelatrios.setForeground(new Color(204, 51, 0));
		mnRelatrios.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmMateriaisEmprestados = new JMenuItem("Materiais Emprestados");
		mntmMateriaisEmprestados.setForeground(new Color(204, 51, 0));
		mntmMateriaisEmprestados.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnRelatrios.add(mntmMateriaisEmprestados);
		
		JMenuItem mntmMateriasEmEstoque = new JMenuItem("Materias em estoque");
		mntmMateriasEmEstoque.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmMateriasEmEstoque.setForeground(new Color(204, 51, 0));
		mnRelatrios.add(mntmMateriasEmEstoque);
		
		JMenuItem mntmMateriaisDevolvidos = new JMenuItem("Materiais Devolvidos");
		mntmMateriaisDevolvidos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmMateriaisDevolvidos.setForeground(new Color(204, 51, 0));
		mnRelatrios.add(mntmMateriaisDevolvidos);
		
		JMenuItem mntmServidores_1 = new JMenuItem("Servidores");
		mntmServidores_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmServidores_1.setForeground(new Color(204, 51, 0));
		mnRelatrios.add(mntmServidores_1);
		
		JMenuItem mntmAdministardores = new JMenuItem("Administardores");
		mntmAdministardores.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mntmAdministardores.setForeground(new Color(204, 51, 0));
		mnRelatrios.add(mntmAdministardores);
		
		JMenu mnNewMenu_2 = new JMenu("Sobre");
		mnNewMenu_2.setForeground(new Color(204, 51, 255));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmSistema = new JMenuItem("Sistema");
		mntmSistema.setForeground(new Color(204, 51, 255));
		mntmSistema.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_2.add(mntmSistema);
		
		JMenuItem mntmDesenvolvedor = new JMenuItem("Desenvolvedor");
		mntmDesenvolvedor.setForeground(new Color(204, 51, 255));
		mnNewMenu_2.add(mntmDesenvolvedor);
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
}
