package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro_Servidor {

	private JFrame frmCasdastroServidor;
	private JTextField nom_sServidodr;
	private JTextField siape_Servidor;
	private JTextField email_Servidor;
	private JTextField senhaAdmin;
	private JTextField confirme_Senha;

	Controla_views control_View = new Controla_views();
	Login login = new Login();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Servidor window = new Cadastro_Servidor();
					window.frmCasdastroServidor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro_Servidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCasdastroServidor = new JFrame();
		frmCasdastroServidor.setTitle("Cadastro de Servidor");
		frmCasdastroServidor.setBounds(100, 100, 600, 450);
		frmCasdastroServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Cadastro de Servidor");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_1 = new JLabel("Siape");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_3 = new JLabel("Senha");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_4 = new JLabel("Confirma\u00E7\u00E3o");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JRadioButton Confirme_Servidor_Admin = new JRadioButton("O servidor \u00E9 usu\u00E1rio do sistema?");
		Confirme_Servidor_Admin.setFont(new Font("Tahoma", Font.PLAIN, 16));

		nom_sServidodr = new JTextField();
		nom_sServidodr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nom_sServidodr.setColumns(10);

		siape_Servidor = new JTextField();
		siape_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		siape_Servidor.setColumns(10);

		email_Servidor = new JTextField();
		email_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email_Servidor.setColumns(10);

		senhaAdmin = new JTextField();
		senhaAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		senhaAdmin.setColumns(10);

		confirme_Senha = new JTextField();
		confirme_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirme_Senha.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(34, 139, 34));

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBackground(new Color(0, 191, 255));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				control_View.abreTelaPrincipal();
				getFrmCasdastroServidor().setVisible(false);
				
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBackground(new Color(240, 230, 140));

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				control_View.fecharSistema();
				getFrmCasdastroServidor().setVisible(false);
				
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBackground(new Color(255, 69, 0));
		GroupLayout groupLayout = new GroupLayout(frmCasdastroServidor.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(94)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 56,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(nom_sServidodr, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
										.addComponent(siape_Servidor, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(
										lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(Confirme_Servidor_Admin, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(email_Servidor)))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_1_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
												56, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_4, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING,
												groupLayout.createSequentialGroup()
														.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 129,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)))
								.addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 81,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 69,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
												.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 69,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(confirme_Senha, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
										.addComponent(senhaAdmin, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
				.addGap(79)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(39).addComponent(lblNewLabel).addGap(27)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						nom_sServidodr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(siape_Servidor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(email_Servidor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(14).addComponent(Confirme_Servidor_Admin).addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(senhaAdmin, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirme_Senha, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(28, Short.MAX_VALUE)));
		frmCasdastroServidor.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmCasdastroServidor() {
		return frmCasdastroServidor;
	}

	public void setFrmCasdastroServidor(JFrame frmCasdastroServidor) {
		this.frmCasdastroServidor = frmCasdastroServidor;
	}

	public JTextField getNom_sServidodr() {
		return nom_sServidodr;
	}

	public void setNom_sServidodr(JTextField nom_sServidodr) {
		this.nom_sServidodr = nom_sServidodr;
	}

	public JTextField getSiape_Servidor() {
		return siape_Servidor;
	}

	public void setSiape_Servidor(JTextField siape_Servidor) {
		this.siape_Servidor = siape_Servidor;
	}

	public JTextField getEmail_Servidor() {
		return email_Servidor;
	}

	public void setEmail_Servidor(JTextField email_Servidor) {
		this.email_Servidor = email_Servidor;
	}

	public JTextField getSenhaAdmin() {
		return senhaAdmin;
	}

	public void setSenhaAdmin(JTextField senhaAdmin) {
		this.senhaAdmin = senhaAdmin;
	}

	public JTextField getConfirme_Senha() {
		return confirme_Senha;
	}

	public void setConfirme_Senha(JTextField confirme_Senha) {
		this.confirme_Senha = confirme_Senha;
	}

}
