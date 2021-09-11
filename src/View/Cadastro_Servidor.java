package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import config.Numeros;
import dao.AdminDao;
import dao.ServidorDao;
import entity.Admin;
import entity.Servidor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Cadastro_Servidor {

	private JFrame frmCasdastroServidor;
	private JTextField txt_Nom_Servidor;
	private JTextField txt_Siape_Servidor;
	private JTextField txt_Email_Servidor;
	private JPasswordField txt_Senha;
	private JPasswordField txt_Senha_conf;

	Controla_views control_View = new Controla_views();
	Login login = new Login();
	Admin admin = new Admin();
	AdminDao aDao = new AdminDao();
	Servidor servidor = new Servidor();
	ServidorDao sDao = new ServidorDao();

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
		txt_Siape_Servidor.setDocument(new Numeros());
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

		JLabel ln_Nome_Servidor = new JLabel("Nome *");
		ln_Nome_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lb_Siape_Servidor = new JLabel("Siape *");
		lb_Siape_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lb_Email_Servidor = new JLabel("Email *");
		lb_Email_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lb_Senha = new JLabel("Senha");
		lb_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_Senha.setVisible(false);

		JLabel lb_Senha_Conf = new JLabel("Confirma\u00E7\u00E3o");
		lb_Senha_Conf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_Senha_Conf.setVisible(false);

		JRadioButton confirme_Servidor_Admin = new JRadioButton("O servidor \u00E9 usu\u00E1rio do sistema?");
		confirme_Servidor_Admin.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Nom_Servidor = new JTextField();
		txt_Nom_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Nom_Servidor.setColumns(10);

		txt_Siape_Servidor = new JTextField();
		txt_Siape_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Siape_Servidor.setColumns(10);

		txt_Email_Servidor = new JTextField();
		txt_Email_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Email_Servidor.setColumns(10);

		txt_Senha = new JPasswordField();
		txt_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Senha.setVisible(false);

		txt_Senha_conf = new JPasswordField();
		txt_Senha_conf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Senha_conf.setVisible(false);

		confirme_Servidor_Admin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (confirme_Servidor_Admin.isSelected()) {
					txt_Senha.setVisible(true);
					txt_Senha_conf.setVisible(true);
					lb_Senha.setVisible(true);
					lb_Senha_Conf.setVisible(true);
				} else {
					txt_Senha.setVisible(false);
					txt_Senha_conf.setVisible(false);
					lb_Senha.setVisible(false);
					lb_Senha_Conf.setVisible(false);

					txt_Senha.setText("");
					txt_Senha_conf.setText("");

				}

			}
		});

		JButton btn_Salvar = new JButton("Salvar");
		btn_Salvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (getTxt_Nom_Servidodr().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o nome do Servidor");
					return;

				}
				if (getTxt_Siape_Servidor().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o Siape do Servidor");
					return;
				}
				if (getTxt_Email_Servidor().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o Email do Servidor");
					return;
				}

				if (confirme_Servidor_Admin.isSelected()) {

					String senha = new String(txt_Senha.getPassword());
					String senhaConf = new String(txt_Senha_conf.getPassword());
					if(senha.equals("") && senhaConf.equals("")) {
						JOptionPane.showMessageDialog(null, "As senhas não podem serem nulas!!!");
						return;
					}
					
					if (senha.equals(senhaConf)) {
						admin.setNome(txt_Nom_Servidor.getText().trim());
						admin.setSiape(Integer.parseInt(txt_Siape_Servidor.getText()));
						admin.setEmail(txt_Email_Servidor.getText());
						admin.setSenha(new String(txt_Senha.getPassword()).trim());

						sDao.salvar(admin);

						JOptionPane.showMessageDialog(null, "Novo Administrador salvo com sucesso!!!");

						txt_Nom_Servidor.setText("");
						txt_Siape_Servidor.setText("");
						txt_Email_Servidor.setText("");
						txt_Senha.setText("");
						txt_Senha_conf.setText("");

						txt_Senha.setVisible(false);
						txt_Senha_conf.setVisible(false);
						lb_Senha.setVisible(false);
						lb_Senha_Conf.setVisible(false);
						
						confirme_Servidor_Admin.setSelected(false);
						return;

					} 
					
					else {
						System.out.println(senha);
						System.out.println(senhaConf);
						JOptionPane.showMessageDialog(null, "As senhas não conferem!!!");
						txt_Senha.setText("");
						txt_Senha_conf.setText("");
						return;
					}

				} else {
					servidor.setNome(txt_Nom_Servidor.getText().trim());
					servidor.setSiape(Integer.parseInt(txt_Siape_Servidor.getText().trim()));
					servidor.setEmail(txt_Email_Servidor.getText().trim());

					sDao.salvar(servidor);

					JOptionPane.showMessageDialog(null, "Servidor salvo com sucesso!!!");

					txt_Nom_Servidor.setText("");
					txt_Siape_Servidor.setText("");
					txt_Email_Servidor.setText("");

				}
				txt_Senha.setVisible(false);
				txt_Senha_conf.setVisible(false);
				lb_Senha.setVisible(false);
				lb_Senha_Conf.setVisible(false);

			}
		});
		btn_Salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Salvar.setBackground(new Color(34, 139, 34));

		JButton btn_Limpar = new JButton("Limpar");
		btn_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txt_Nom_Servidor.setText("");
				txt_Siape_Servidor.setText("");
				txt_Email_Servidor.setText("");
				txt_Senha.setText("");
				txt_Senha_conf.setText("");
				confirme_Servidor_Admin.setSelected(false);
				txt_Senha.setVisible(false);
				txt_Senha_conf.setVisible(false);
				lb_Senha.setVisible(false);
				lb_Senha_Conf.setVisible(false);

			}
		});
		btn_Limpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Limpar.setBackground(new Color(0, 191, 255));

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaPrincipal();
				getFrmCasdastroServidor().setVisible(false);

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.fecharSistema();
				getFrmCasdastroServidor().setVisible(false);

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));

		GroupLayout groupLayout = new GroupLayout(frmCasdastroServidor.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(94)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(ln_Nome_Servidor).addComponent(lb_Siape_Servidor,
												GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED).addGroup(
										groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(txt_Nom_Servidor, GroupLayout.DEFAULT_SIZE, 354,
														Short.MAX_VALUE)
												.addComponent(txt_Siape_Servidor, GroupLayout.DEFAULT_SIZE, 354,
														Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lb_Email_Servidor, GroupLayout.PREFERRED_SIZE, 56,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txt_Email_Servidor, 354, 354, 354))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lb_Senha_Conf, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
										.addComponent(btn_Salvar, GroupLayout.PREFERRED_SIZE, 129,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lb_Senha, GroupLayout.PREFERRED_SIZE, 56,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(confirme_Servidor_Admin, Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btn_Limpar, GroupLayout.PREFERRED_SIZE, 81,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 73,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btn_Sair, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(txt_Senha, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
										.addComponent(txt_Senha_conf, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))))
				.addGap(79)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(39).addComponent(lblNewLabel).addGap(27)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(ln_Nome_Servidor)
								.addComponent(txt_Nom_Servidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lb_Siape_Servidor, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Siape_Servidor, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lb_Email_Servidor, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Email_Servidor, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))
						.addGap(14).addComponent(confirme_Servidor_Admin).addGap(13)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txt_Senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lb_Senha, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_Senha_Conf, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Senha_conf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btn_Salvar)
								.addComponent(btn_Limpar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(23)));
		frmCasdastroServidor.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmCasdastroServidor() {
		return frmCasdastroServidor;
	}

	public void setFrmCasdastroServidor(JFrame frmCasdastroServidor) {
		this.frmCasdastroServidor = frmCasdastroServidor;
	}

	public JTextField getTxt_Nom_Servidodr() {
		return txt_Nom_Servidor;
	}

	public void setTxt_Nom_Servidodr(JTextField txt_Nom_Servidodr) {
		this.txt_Nom_Servidor = txt_Nom_Servidodr;
	}

	public JTextField getTxt_Siape_Servidor() {
		return txt_Siape_Servidor;
	}

	public void setTxt_Siape_Servidor(JTextField txt_Siape_Servidor) {
		this.txt_Siape_Servidor = txt_Siape_Servidor;
	}

	public JTextField getTxt_Email_Servidor() {
		return txt_Email_Servidor;
	}

	public void setTxt_Email_Servidor(JTextField txt_Email_Servidor) {
		this.txt_Email_Servidor = txt_Email_Servidor;
	}

	public JPasswordField getTxt_Senha() {
		return txt_Senha;
	}

	public void setTxt_Senha(JPasswordField txt_Senha) {
		this.txt_Senha = txt_Senha;
	}

	public JPasswordField getTxt_Senha_conf() {
		return txt_Senha_conf;
	}

	public void setTxt_Senha_conf(JPasswordField txt_Senha_conf) {
		this.txt_Senha_conf = txt_Senha_conf;
	}

}
