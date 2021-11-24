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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class EditarAdmin {

	private JFrame frmEditarAdmin;
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
					EditarAdmin window = new EditarAdmin();
					window.frmEditarAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditarAdmin() {
		initialize();
		txt_Siape_Servidor.setDocument(new Numeros());
		frmEditarAdmin.getContentPane().setLayout(null);
		frmEditarAdmin.getContentPane().add(lblNewLabel);
		frmEditarAdmin.getContentPane().add(ln_Nome_Servidor);
		frmEditarAdmin.getContentPane().add(lb_Siape_Servidor);
		frmEditarAdmin.getContentPane().add(txt_Nom_Servidor);
		frmEditarAdmin.getContentPane().add(txt_Siape_Servidor);
		frmEditarAdmin.getContentPane().add(lb_Email_Servidor);
		frmEditarAdmin.getContentPane().add(txt_Email_Servidor);
		frmEditarAdmin.getContentPane().add(lb_Senha_Conf);
		frmEditarAdmin.getContentPane().add(btn_Salvar);
		frmEditarAdmin.getContentPane().add(lb_Senha);
		frmEditarAdmin.getContentPane().add(confirme_Servidor_Admin);
		frmEditarAdmin.getContentPane().add(btn_Limpar);
		frmEditarAdmin.getContentPane().add(btn_Voltar);
		frmEditarAdmin.getContentPane().add(btn_Sair);
		frmEditarAdmin.getContentPane().add(txt_Senha);
		frmEditarAdmin.getContentPane().add(txt_Senha_conf);
	}

	// Verifica se Existe Servidor cadastrado com o Siape informado
	public Servidor buscaServSiapeCadastro(long siape) {
		Servidor servidor = new Servidor();
		servidor = sDao.buscarPorSiape(siape);
		return servidor;
	}

	public void pegaAdmin(Admin admin) {

		txt_Siape_Servidor.setText(admin.getSiape() + "");
		txt_Nom_Servidor.setText(admin.getNome());
		txt_Email_Servidor.setText(admin.getEmail());

		this.admin = admin;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditarAdmin = new JFrame();
		frmEditarAdmin.setIconImage(
				Toolkit.getDefaultToolkit().getImage(EditarAdmin.class.getResource("/imagens/Icon_AdminPQ.png")));
		frmEditarAdmin.getContentPane().setBackground(new Color(240, 255, 255));
		frmEditarAdmin.setTitle("Editar Administradores");
		frmEditarAdmin.setBounds(100, 100, 600, 450);

		frmEditarAdmin.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					frmEditarAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmEditarAdmin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});

		lblNewLabel = new JLabel("Editar Administradores");
		lblNewLabel.setBounds(94, 39, 414, 55);
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));

		ln_Nome_Servidor = new JLabel("Nome *");
		ln_Nome_Servidor.setBounds(94, 165, 48, 17);
		ln_Nome_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Siape_Servidor = new JLabel("Siape *");
		lb_Siape_Servidor.setBounds(94, 124, 56, 17);
		lb_Siape_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Email_Servidor = new JLabel("Email *");
		lb_Email_Servidor.setBounds(94, 209, 56, 17);
		lb_Email_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Senha = new JLabel("Senha *");
		lb_Senha.setBounds(94, 284, 56, 17);
		lb_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_Senha.setVisible(false);

		lb_Senha_Conf = new JLabel("Confirmação *");
		lb_Senha_Conf.setBounds(94, 322, 145, 17);
		lb_Senha_Conf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_Senha_Conf.setVisible(false);

		confirme_Servidor_Admin = new JRadioButton("Deseja alterar a senha?");
		confirme_Servidor_Admin.setBounds(243, 240, 265, 25);
		confirme_Servidor_Admin.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Nom_Servidor = new JTextField();
		txt_Nom_Servidor.setBounds(154, 162, 354, 23);
		txt_Nom_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Nom_Servidor.setColumns(10);

		txt_Siape_Servidor = new JTextField();
		txt_Siape_Servidor.setEditable(false);
		txt_Siape_Servidor.setBounds(154, 121, 354, 23);
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

		btn_Salvar = new JButton("Atualizar");
		btn_Salvar.setBounds(94, 360, 129, 25);
		btn_Salvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// verica o nome do servidor
				String nome = getTxt_Nom_Servidodr().getText().trim();
				if (nome.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o nome do Servidor");
					txt_Nom_Servidor.setText("");
					return;
				}

				// verifica o email do Servidor
				String email = getTxt_Email_Servidor().getText().trim();
				int position = email.indexOf("@");
				// Verifica se o email tem texto antes e depois do "@" considera 3 caracteres
				// antes e 5 depois
				try {
					email.substring(position + 1, position + 6);
					email.substring(position - 3, position - 1);

				} catch (Exception r) {
					JOptionPane.showMessageDialog(null, "Informe o Email do Servidor no formato Maria@maria.com");
					return;
				}

				if (confirme_Servidor_Admin.isSelected()) {

					String senha = new String(txt_Senha.getPassword());
					String senhaConf = new String(txt_Senha_conf.getPassword());
					if (senha.equals("") && senhaConf.equals("")) {
						JOptionPane.showMessageDialog(null, "As senhas não podem ser nulas!!!");
						return;
					}

					if (senha.length() < 4) {
						JOptionPane.showMessageDialog(null, "Sua senha deve ter pelos menos 4 caracteres!!!");
						return;
					}

					if (senha.equals(senhaConf)) {
						admin.setNome(txt_Nom_Servidor.getText().trim().toUpperCase());
						admin.setEmail(txt_Email_Servidor.getText().toUpperCase().trim());

						// trata a senha para nao conter espaço
						String senhaf = new String(txt_Senha.getPassword());
						if (senha.contains(" ")) {
							JOptionPane.showMessageDialog(null, "Sua senha não pode conter espaços em branco");
							return;
						}

						String resultado = admin.gerarCodificacao(senhaf);
						admin.setSenha(resultado);

						aDao.atualizar(admin);

						control_View.abreTelaAdministrador();
						getFrmEditarAdmin().dispose();

						JOptionPane.showMessageDialog(null, "Administrador atualizado com sucesso!!!");

					}

					else {

						JOptionPane.showMessageDialog(null, "As senhas não conferem!!!");
						txt_Senha.setText("");
						txt_Senha_conf.setText("");
						return;
					}

				} else {
					admin.setNome(txt_Nom_Servidor.getText().trim().toUpperCase());
					admin.setEmail(txt_Email_Servidor.getText().toUpperCase().trim());

					aDao.atualizar(admin);

					control_View.abreTelaAdministrador();
					getFrmEditarAdmin().dispose();

					JOptionPane.showMessageDialog(null, "Administrador atualizado com sucesso!!!");

				}

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

				control_View.abreTelaAdministrador();
				getFrmEditarAdmin().dispose();

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(417, 360, 91, 25);
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (control_View.fecharSistema() == true) {
					getFrmEditarAdmin().dispose();
				}

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
	}

	public JFrame getFrmEditarAdmin() {
		return frmEditarAdmin;
	}

	public void setFrmEditarAdmin(JFrame frmEditarAdmin) {
		this.frmEditarAdmin = frmEditarAdmin;
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
