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

public class Principal {

	private JFrame frmTelaPrincipal;
	private JTable table;
	private JTextField txt_Matrial_Busca;
	private JTextField txt_Servidor_Busca;

	Controla_views control_View = new Controla_views();
	Login login = new Login();

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
		frmTelaPrincipal.setBounds(100, 100, 600, 450);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table = new JTable();
		table.setColumnSelectionAllowed(true);

		JLabel lblMaterialservidor = new JLabel("Material");
		lblMaterialservidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Matrial_Busca = new JTextField();
		txt_Matrial_Busca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Matrial_Busca.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String siape = "";
				siape = System.getProperty("siape", siape);
				System.out.println("Testa Buscar Siape Admin" + siape);

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Cadastro_Emprestimo window = new Cadastro_Emprestimo();
					window.getFrmNovoEmprestimo().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_AdicionarPQ.png")));

		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Servidor_Busca = new JTextField();
		txt_Servidor_Busca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Servidor_Busca.setColumns(10);

		JButton btn_Sair = new JButton("Sair");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.fecharSistema();
				getFrmTelaPrincipal().setVisible(false);

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Sair.setBackground(new Color(255, 69, 0));
		GroupLayout groupLayout = new GroupLayout(frmTelaPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(59)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(397).addComponent(table,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblMaterialservidor).addGap(18)
								.addComponent(txt_Matrial_Busca, GroupLayout.PREFERRED_SIZE, 106,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblServidor, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(
										txt_Servidor_Busca, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btn_Sair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))))
				.addContainerGap(64, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19).addComponent(btnNewButton).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaterialservidor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_Matrial_Busca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblServidor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_Servidor_Busca, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
				.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
				.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(btn_Sair).addGap(60)));
		frmTelaPrincipal.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frmTelaPrincipal.setJMenuBar(menuBar);

		JButton btn_Servidor = new JButton("Servidor");
		btn_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Servidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaServidor();
				getFrmTelaPrincipal().setVisible(false);

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
		btn_Materiais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Materiais.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_MateriaisPQ.png")));
		menuBar.add(btn_Materiais);

		JButton btn_Relatorios = new JButton("Relat\u00F3rios");
		btn_Relatorios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Relatorios.setIcon(new ImageIcon(Principal.class.getResource("/imagens/Icon_Relatorios.png")));
		menuBar.add(btn_Relatorios);

		JButton btnNewButton_1 = new JButton("Sobre");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		return txt_Matrial_Busca;
	}

	public void setTextField(JTextField textField) {
		this.txt_Matrial_Busca = textField;
	}
}
