package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
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
	private JLabel lblNewLabel;
	private JLabel ln_Nome_Servidor;
	private JLabel lb_Siape_Servidor;
	private JLabel lb_Email_Servidor;
	private JLabel lb_Senha_Conf;
	private JButton btn_Salvar;
	private JLabel lb_Senha;
	private JRadioButton confirme_Servidor_Admin;
	private JButton btn_Limpar;
	private JButton btn_Voltar;
	private JButton btn_Sair;

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

	// Verifica se Existe Servidor cadastrado com o Siape informado
	public Servidor buscaServSiapeCadastro(long siape) {
		Servidor servidor = new Servidor();
		servidor = sDao.buscarPorSiape(siape);
		return servidor;
	}

	/**
	 * Create the application.
	 */
	public Cadastro_Servidor() {
		initialize();
		txt_Siape_Servidor.setDocument(new Numeros());
		frmCasdastroServidor.getContentPane().setLayout(null);
		frmCasdastroServidor.getContentPane().add(lblNewLabel);
		frmCasdastroServidor.getContentPane().add(ln_Nome_Servidor);
		frmCasdastroServidor.getContentPane().add(lb_Siape_Servidor);
		frmCasdastroServidor.getContentPane().add(txt_Nom_Servidor);
		frmCasdastroServidor.getContentPane().add(txt_Siape_Servidor);
		frmCasdastroServidor.getContentPane().add(lb_Email_Servidor);
		frmCasdastroServidor.getContentPane().add(txt_Email_Servidor);
		frmCasdastroServidor.getContentPane().add(lb_Senha_Conf);
		frmCasdastroServidor.getContentPane().add(btn_Salvar);
		frmCasdastroServidor.getContentPane().add(lb_Senha);
		frmCasdastroServidor.getContentPane().add(confirme_Servidor_Admin);
		frmCasdastroServidor.getContentPane().add(btn_Limpar);
		frmCasdastroServidor.getContentPane().add(btn_Voltar);
		frmCasdastroServidor.getContentPane().add(btn_Sair);
		frmCasdastroServidor.getContentPane().add(txt_Senha);
		frmCasdastroServidor.getContentPane().add(txt_Senha_conf);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCasdastroServidor = new JFrame();
		frmCasdastroServidor.setTitle("Cadastro de Servidor");
		frmCasdastroServidor.setBounds(100, 100, 600, 450);
		frmCasdastroServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblNewLabel = new JLabel("Cadastro de Servidor");
		lblNewLabel.setBounds(94, 39, 414, 55);
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));

		ln_Nome_Servidor = new JLabel("Nome *");
		ln_Nome_Servidor.setBounds(94, 124, 48, 17);
		ln_Nome_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Siape_Servidor = new JLabel("Siape *");
		lb_Siape_Servidor.setBounds(94, 168, 56, 17);
		lb_Siape_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Email_Servidor = new JLabel("Email *");
		lb_Email_Servidor.setBounds(94, 209, 56, 17);
		lb_Email_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Senha = new JLabel("Senha");
		lb_Senha.setBounds(94, 284, 56, 17);
		lb_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_Senha.setVisible(false);

		lb_Senha_Conf = new JLabel("Confirma\u00E7\u00E3o");
		lb_Senha_Conf.setBounds(94, 322, 145, 17);
		lb_Senha_Conf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_Senha_Conf.setVisible(false);

		confirme_Servidor_Admin = new JRadioButton("O servidor \u00E9 usu\u00E1rio do sistema?");
		confirme_Servidor_Admin.setBounds(243, 240, 265, 25);
		confirme_Servidor_Admin.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Nom_Servidor = new JTextField();
		txt_Nom_Servidor.setBounds(154, 121, 354, 23);
		txt_Nom_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Nom_Servidor.setColumns(10);

		txt_Siape_Servidor = new JTextField();
		txt_Siape_Servidor.setBounds(154, 162, 354, 23);
		txt_Siape_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Siape_Servidor.setColumns(10);

		txt_Email_Servidor = new JTextField();
		txt_Email_Servidor.setBounds(154, 203, 354, 23);
		txt_Email_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Email_Servidor.setColumns(10);

		txt_Senha = new JPasswordField();
		txt_Senha.setBounds(243, 278, 265, 23);
		txt_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Senha.setVisible(false);

		txt_Senha_conf = new JPasswordField();
		txt_Senha_conf.setBounds(243, 319, 265, 23);
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

		btn_Salvar = new JButton("Salvar");
		btn_Salvar.setBounds(94, 360, 129, 25);
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

				if (buscaServSiapeCadastro(Integer.parseInt(txt_Siape_Servidor.getText())) != null) {
					JOptionPane.showMessageDialog(null,
							"Já existe um Administrador/Servidor cadastrado com este Siape");
					return;
				}

				if (confirme_Servidor_Admin.isSelected()) {

					String senha = new String(txt_Senha.getPassword());
					String senhaConf = new String(txt_Senha_conf.getPassword());
					if (senha.equals("") && senhaConf.equals("")) {
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

		btn_Limpar = new JButton("Limpar");
		btn_Limpar.setBounds(243, 360, 81, 25);
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

		btn_Voltar = new JButton("Voltar");
		btn_Voltar.setBounds(334, 360, 73, 25);
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaServidor();
				getFrmCasdastroServidor().dispose();

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(417, 360, 91, 25);
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.fecharSistema();
				getFrmCasdastroServidor().dispose();

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
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
